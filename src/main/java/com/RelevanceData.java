package com;

/**
 * Created by apurvagu on 30/12/2016.
 */
public class RelevanceData {
    Double relevance;

    public RelevanceData(double relevance) {
        this.relevance = relevance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RelevanceData that = (RelevanceData) o;

        return Double.compare(that.relevance, relevance) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(relevance);
        return (int) (temp ^ (temp >>> 32));
    }


    public int compareTo(RelevanceData value) {
        return this.relevance.compareTo(value.relevance);
    }
}
