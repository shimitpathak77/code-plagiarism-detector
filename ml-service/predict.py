from fastapi import FastAPI
from pydantic import BaseModel
import joblib
import numpy as np
from pathlib import Path

app = FastAPI(title="Plagiarism ML Service", version="1.0")

MODEL_PATH = Path(__file__).parent / "model.joblib"
model = joblib.load(MODEL_PATH)

class Features(BaseModel):
    token_sim: float
    ast_sim: float
    token_count_ratio: float
    line_count_ratio: float

class Prediction(BaseModel):
    label: int
    is_plagiarized: bool
    probability: float
    confidence: str

@app.get("/health")
def health():
    return {"status": "ok", "model": "LogisticRegression"}

@app.post("/predict", response_model=Prediction)
def predict(f: Features):
    X = np.array([[f.token_sim, f.ast_sim, f.token_count_ratio, f.line_count_ratio]])
    prob = float(model.predict_proba(X)[0][1])
    label = int(model.predict(X)[0])
    confidence = "high" if prob > 0.8 or prob < 0.2 else "medium" if prob > 0.6 or prob < 0.4 else "low"
    return Prediction(
        label=label,
        is_plagiarized=label == 1,
        probability=round(prob, 4),
        confidence=confidence
    )