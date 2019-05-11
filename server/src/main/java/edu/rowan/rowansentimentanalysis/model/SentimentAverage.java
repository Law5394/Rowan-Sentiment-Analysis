package edu.rowan.rowansentimentanalysis.model;

import edu.rowan.rowansentimentanalysis.SentimentKind;

import java.io.Serializable;

public class SentimentAverage implements Serializable {

    private SentimentKind kind;
    private  double positiveScore;
    private double negativeScore;
    private double neutralScore;

    public SentimentKind getKind() {
        return kind;
    }


    public void setKind(SentimentKind kind) {
        this.kind = kind;
    }

    public double getPositiveScore() {
        return positiveScore;
    }

    public void setPositiveScore(double positiveScore) {
        this.positiveScore = positiveScore;
    }

    public double getNegativeScore() {
        return negativeScore;
    }

    public void setNegativeScore(double negativeScore) {
        this.negativeScore = negativeScore;
    }

    public double getNeutralScore() {
        return neutralScore;
    }

    public void setNeutralScore(double neutralScore) {
        this.neutralScore = neutralScore;
    }
}
