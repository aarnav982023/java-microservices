package com.in28minutes.microservices.limitsservice.bean;

public class LimitsConfiguration {
    int maximum;
    int minimum;

    protected LimitsConfiguration(){}

    public int getMaximum() {
        return maximum;
    }

    public int getMinimum() {
        return minimum;
    }

    public LimitsConfiguration(int maximum, int minimum) {
        this.maximum = maximum;
        this.minimum = minimum;
    }
}
