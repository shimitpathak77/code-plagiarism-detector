"""
Phase 4: Train and evaluate Logistic Regression + Random Forest
on features.csv exported by Java FeatureExporter.
"""

import pandas as pd
import numpy as np
import joblib
from pathlib import Path
from sklearn.linear_model import LogisticRegression
from sklearn.ensemble import RandomForestClassifier
from sklearn.metrics import (
    precision_score, recall_score, f1_score,
    accuracy_score, confusion_matrix
)

# ── Paths ────────────────────────────────────────────────────────────────────
DATA_DIR  = Path(__file__).parent / "data"
CSV_PATH  = DATA_DIR / "features.csv"
MODEL_PATH = Path(__file__).parent / "model.joblib"

# ── Feature columns used for training ───────────────────────────────────────
FEATURES = ["token_sim", "ast_sim", "token_count_ratio", "line_count_ratio"]


def load_data():
    df = pd.read_csv(CSV_PATH)
    print(f"Loaded {len(df)} pairs  |  Label distribution: {dict(df['label'].value_counts())}")
    return df


def evaluate(name, model, X_test, y_test, diff_col):
    y_pred = model.predict(X_test)
    prec  = precision_score(y_test, y_pred, zero_division=0)
    rec   = recall_score(y_test, y_pred, zero_division=0)
    f1    = f1_score(y_test, y_pred, zero_division=0)
    acc   = accuracy_score(y_test, y_pred)
    cm    = confusion_matrix(y_test, y_pred)
    tn, fp, fn, tp = cm.ravel()

    print(f"\n── {name} (Test Split) ──")
    print(f"  Accuracy : {acc:.4f}")
    print(f"  Precision: {prec:.4f}")
    print(f"  Recall   : {rec:.4f}")
    print(f"  F1 Score : {f1:.4f}")
    print(f"  Confusion: TP={tp}  FP={fp}  TN={tn}  FN={fn}")

    # Recall per difficulty tier
    test_df = X_test.copy()
    test_df["label"] = y_test
    test_df["pred"]  = y_pred
    test_df["difficulty"] = diff_col.values

    for diff in ["light", "medium", "heavy", "same_problem", "none"]:
        sub = test_df[test_df["difficulty"] == diff]
        if len(sub) == 0:
            continue
        pos = sub[sub["label"] == 1]
        if len(pos) > 0:
            r = recall_score(pos["label"], pos["pred"], zero_division=0)
            print(f"  Recall [{diff:12s}]: {r:.4f}  ({len(pos)} pairs)")
        else:
            neg = sub[sub["label"] == 0]
            fp_count = (neg["pred"] == 1).sum()
            print(f"  FP rate [{diff:11s}]: {fp_count}/{len(neg)} false positives")

    return f1, model


def main():
    df = load_data()

    # ── Train / Test split (using the existing split column) ──────────────
    train_df = df[df["split"] == "dev"].reset_index(drop=True)
    test_df  = df[df["split"] == "test"].reset_index(drop=True)

    X_train = train_df[FEATURES]
    y_train = train_df["label"]
    X_test  = test_df[FEATURES]
    y_test  = test_df["label"]

    print(f"\nTrain: {len(train_df)} pairs  |  Test: {len(test_df)} pairs")
    print(f"Train positives: {y_train.sum()}  Train negatives: {(y_train==0).sum()}")
    print(f"Test  positives: {y_test.sum()}   Test  negatives: {(y_test==0).sum()}")

    # ── 1. Logistic Regression ────────────────────────────────────────────
    lr = LogisticRegression(max_iter=1000, class_weight="balanced")
    lr.fit(X_train, y_train)
    lr_f1, _ = evaluate("Logistic Regression", lr, X_test, y_test,
                         test_df["difficulty"])

    print("\n  Feature coefficients:")
    for feat, coef in zip(FEATURES, lr.coef_[0]):
        print(f"    {feat:22s}: {coef:+.4f}")

    # ── 2. Random Forest ──────────────────────────────────────────────────
    rf = RandomForestClassifier(n_estimators=200, max_depth=8,
                                class_weight="balanced", random_state=42)
    rf.fit(X_train, y_train)
    rf_f1, _ = evaluate("Random Forest", rf, X_test, y_test,
                         test_df["difficulty"])

    print("\n  Feature importances:")
    for feat, imp in zip(FEATURES, rf.feature_importances_):
        print(f"    {feat:22s}: {imp:.4f}")

    # ── Save the best model ───────────────────────────────────────────────
    best_model = rf if rf_f1 >= lr_f1 else lr
    best_name  = "Random Forest" if rf_f1 >= lr_f1 else "Logistic Regression"
    joblib.dump(best_model, MODEL_PATH)

    print(f"\n✓ Best model: {best_name} (F1={max(lr_f1, rf_f1):.4f})")
    print(f"✓ Saved to: {MODEL_PATH}")

    # ── Improvement over single detectors ─────────────────────────────────
    baseline_token = 0.8219
    baseline_ast   = 0.7945
    best_f1 = max(lr_f1, rf_f1)
    print(f"\n── Improvement over baselines ──")
    print(f"  Token-only F1  : {baseline_token:.4f}")
    print(f"  AST-only   F1  : {baseline_ast:.4f}")
    print(f"  ML Model   F1  : {best_f1:.4f}  "
          f"(+{(best_f1 - max(baseline_token, baseline_ast))*100:.1f} percentage points)")


if __name__ == "__main__":
    main()