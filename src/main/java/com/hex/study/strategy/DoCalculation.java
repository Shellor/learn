package com.hex.study.strategy;

/**
 * @author hui.zhu
 */
public class DoCalculation {
    private Calculation calculation;
    public DoCalculation(Calculation calculation) {
        this.calculation = calculation;
    }

    public int excute(int a, int b) {
        return calculation.doCalculation(a, b);
    }
}
