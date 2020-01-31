package com.anz.currency;

import java.io.Serializable;
import java.util.Objects;

public class Currency implements Serializable {

    private String name;

    private boolean isVisited;

    private double precision;

    public Currency(String name, boolean isVisited) {
        this.name = name;
        this.isVisited = isVisited;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsVisited() {
        return isVisited;
    }

    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public double getPrecision() {
        return precision;
    }

    public void setPrecision(double precision) {
        this.precision = precision;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Currency)) return false;
        Currency currency = (Currency) o;
        return Double.compare(currency.precision, precision) == 0 &&
                Objects.equals(name, currency.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, precision);
    }
}
