# Code Plagiarism Detector

A research project comparing three approaches to source-code plagiarism detection on a hand-crafted Java dataset.

**Institution:** GITA Autonomous College, Bhubaneswar — CSE 7th Semester (2023–27)  
**Team:** Shimit Pathak · Khushi · Lovely · Varsha · Shruti

---

## Table of Contents

- [Overview](#overview)
- [Project Structure](#project-structure)
- [Dataset](#dataset)
- [Detection Approaches](#detection-approaches)
- [Results](#results)
- [How to Run](#how-to-run)
- [Future Enhancements](#future-enhancements)

---

## Overview

This project implements and compares three plagiarism detection techniques on Java source code:

| Phase | Technique | Language |
|---|---|---|
| Phase 1 | Token-based N-gram Similarity | Java |
| Phase 2 | AST Subtree Hashing | Java |
| Phase 3 | Evaluation Benchmark | Java |
| Phase 4 | ML Ensemble Classifier | Python |

The core research question: **Can combining token and AST similarity signals in an ML classifier outperform either detector alone?**

**Answer: Yes.** The Logistic Regression classifier achieves F1 = 0.8788, beating the best single detector (Token, F1 = 0.8219) by **+5.7 percentage points**.

---

## Project Structure

```
code-plagiarism-detector/
├── backend/                          # Java — detectors, preprocessing, evaluation
│   └── src/main/java/com/gita/plagiarism/
│       ├── preprocessing/
│       │   ├── Tokenizer.java        # Static N-gram tokenizer
│       │   ├── AstParser.java        # JavaParser-based AST builder
│       │   ├── DatasetLoader.java    # Sorted, reproducible CSV loader
│       │   └── LabeledPair.java      # Pair data model
│       ├── token/
│       │   └── TokenDetector.java    # Jaccard similarity on N-grams
│       ├── ast/
│       │   └── AstDetector.java      # Subtree hashing with operator/type awareness
│       ├── detector/
│       │   └── Detector.java         # Common interface
│       └── eval/
│           ├── EvalPair.java
│           ├── EvaluationMetrics.java
│           ├── EvaluationRunner.java  # Threshold tuning on dev, report on test
│           ├── NegativePairGenerator.java
│           └── FeatureExporter.java   # Exports features.csv for Phase 4
├── dataset/
│   ├── originals/                    # 40 original Java algorithms (P01–P40)
│   ├── plagiarized/
│   │   ├── light/                    # 40 light variants (variable rename)
│   │   ├── medium/                   # 40 medium variants (restructured logic)
│   │   └── heavy/                    # 40 heavy variants (algorithmic rewrite)
│   └── labels/                       # 5 CSVs (one per team member)
│       ├── shimit.csv
│       ├── khushi.csv
│       ├── Lovely.csv
│       ├── varsha.csv
│       └── shruti.csv
├── ml-service/                       # Python — ML classifier & FastAPI service
│   ├── data/
│   │   └── features.csv              # Exported by FeatureExporter.java (280 rows)
│   ├── train.py                      # Trains LR + RF, saves best model
│   ├── predict.py                    # FastAPI /predict endpoint
│   ├── model.joblib                  # Saved best model (Logistic Regression)
│   └── requirements.txt
├── docs/
│   └── results/
│       └── phase1_eval_results.md    # Benchmark results table
└── frontend/                         # Placeholder (future enhancement)
```

---

## Dataset

- **40 original Java algorithms** (P01–P40) covering arrays, sorting, searching, graphs, dynamic programming, and data structures
- **3 plagiarized variants per original** (light / medium / heavy disguise) → 120 positive pairs
- **20 hard negatives** — independent solutions to the same problem by different authors → 20 same-problem pairs with `label=0`
- **Total:** 280 labeled pairs | 200 dev + 80 test (no cross-contamination)

### Difficulty levels

| Level | Description |
|---|---|
| `light` | Variable/method rename, comment changes |
| `medium` | Loop restructuring, helper methods extracted |
| `heavy` | Different algorithm for same problem (e.g. iterative → recursive) |
| `same_problem` | Independent solution — same problem, genuinely different code |

---

## Detection Approaches

### 1. Token-Based Detector (`TokenDetector.java`)

Tokenizes Java source using `Tokenizer.java`, generates tri-grams (n=3), and computes Jaccard similarity:

$$J(A, B) = \frac{|A \cap B|}{|A \cup B|}$$

Threshold tuned on dev set: **0.35**

### 2. AST-Based Detector (`AstDetector.java`)

Parses Java source with JavaParser, hashes every subtree including:
- Node class names (structural shape)
- Operator types (`+`, `-`, `*`, `&&`, etc.)
- Primitive types (`int`, `long`, `boolean`, etc.)

Computes similarity as the ratio of matching subtree hashes. Threshold tuned on dev set: **0.45**

### 3. ML Ensemble Classifier (`train.py`)

Trains Logistic Regression and Random Forest on four features exported per pair:

| Feature | Description |
|---|---|
| `token_sim` | Jaccard similarity of tri-grams |
| `ast_sim` | Subtree hash overlap ratio |
| `token_count_ratio` | `min(tokens_A, tokens_B) / max(tokens_A, tokens_B)` |
| `line_count_ratio` | `min(lines_A, lines_B) / max(lines_A, lines_B)` |

Best model: **Logistic Regression** (F1 = 0.8788)

Feature coefficients (Logistic Regression):
- `token_sim`: +3.37 (strongest signal)
- `ast_sim`: +2.64
- `line_count_ratio`: +1.88
- `token_count_ratio`: +1.38

---

## Results

### Phase 1 & 2 — Single Detectors (Test set, 80 pairs)

| Detector | Threshold | Precision | Recall | F1 | Light | Medium | Heavy |
|---|---|---|---|---|---|---|---|
| Token (n=3) | 0.35 | 0.6977 | 1.0000 | 0.8219 | 1.00 | 1.00 | 1.00 |
| AST (Subtree Hashing) | 0.45 | 0.6744 | 0.9667 | 0.7945 | 1.00 | 1.00 | 0.90 |

### Phase 4 — ML Classifier (Test set, 80 pairs)

| Model | Precision | Recall | F1 | vs Token baseline |
|---|---|---|---|---|
| Logistic Regression | 0.8056 | 0.9667 | **0.8788** | **+5.7 pp** |
| Random Forest | 0.7632 | 0.9667 | 0.8529 | +3.1 pp |

### Key Findings

1. **Token detector matches or beats AST on heavily disguised code** (Token recall on heavy = 1.00 vs AST = 0.90). This is because heavy variants restructure control flow but preserve many token sequences, while AST hashing is sensitive to structural changes.

2. **Hard negatives are the main challenge.** Both single detectors misclassify ~5–7 of the 10 same-problem pairs as plagiarism, because independent solutions to the same algorithm naturally share similar tokens and structure.

3. **The ML classifier improves precision from ~70% → ~80%** by learning that true plagiarism has *both* token and AST scores elevated together, while same-problem pairs often have high token but lower AST scores (or vice versa).

4. **The token and AST detectors make different errors** (Token: 4 FP, 0 FN; AST: 2 FP, 1 FN), confirming they capture complementary information — exactly why an ensemble improves results.

---

## How to Run

### Prerequisites

- Java 21, Maven 3.9+
- Python 3.11+ (via `uv` or standard installer)

---

### Phase 1–3: Java Detectors & Evaluation

```bash
# From repo root
mvn -f backend/pom.xml test -Dtest=EvaluationRunnerTest
```

Results are written to `docs/results/phase1_eval_results.md`.

---

### Phase 4: ML Classifier

**Step 1 — Export features (run from repo root):**
```bash
mvn -f backend/pom.xml test -Dtest=FeatureExporterTest
```
This writes `ml-service/data/features.csv` (280 rows).

**Step 2 — Set up Python environment:**
```powershell
# Install Python 3.11 via uv (Windows)
C:\Users\<you>\.local\bin\uv.exe python install 3.11
C:\Users\<you>\.local\bin\uv.exe venv --python 3.11 .venv
C:\Users\<you>\.local\bin\uv.exe pip install --python .venv\Scripts\python.exe -r ml-service/requirements.txt
```

**Step 3 — Train the model:**
```powershell
cd ml-service
..\.venv\Scripts\python.exe train.py
```
Output: `ml-service/model.joblib`

**Step 4 — Start the prediction API:**
```powershell
cd ml-service
..\.venv\Scripts\uvicorn.exe predict:app --reload --port 8000
```

**Step 5 — Test the API:**

Open `http://127.0.0.1:8000/docs` for the interactive Swagger UI.

Or via PowerShell:
```powershell
Invoke-RestMethod -Uri "http://127.0.0.1:8000/predict" `
  -Method Post -ContentType "application/json" `
  -Body '{"token_sim":0.85,"ast_sim":0.80,"token_count_ratio":0.95,"line_count_ratio":0.98}'
```

Expected response:
```json
{
  "label": 1,
  "is_plagiarized": true,
  "probability": 0.9873,
  "confidence": "high"
}
```

---

## Future Enhancements

- **Spring Boot REST API** — `POST /api/compare` accepting two code snippets, running all three detectors and returning a unified JSON response
- **React Frontend** — UI with two code editors, a "Compare" button, and a results panel
- **Docker Compose** — containerise the Java backend and Python ML service
- **N-gram sweep** — evaluate Token detector for n = 2 to 8
- **Semantic features** — control-flow graph similarity, variable dependency analysis
- **Multi-language support** — extend beyond Java to Python, C++

---

## Tech Stack

| Component | Technology |
|---|---|
| Java detectors | Java 21, Spring Boot 4.1.2, JavaParser 3.26.2, Apache Commons CSV 1.12.0 |
| ML classifier | Python 3.11, scikit-learn, pandas, numpy, joblib |
| Prediction API | FastAPI, uvicorn, pydantic |
| Build | Maven 3.9 |
