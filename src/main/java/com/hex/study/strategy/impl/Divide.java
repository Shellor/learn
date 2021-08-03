package com.hex.study.strategy.impl;

import com.hex.study.strategy.Calculation;

/**
 * @author hui.zhu
 */
public class Divide implements Calculation {
    public int doCalculation(int a, int b) {
        if (b != 0) {
            return a / b;
        }
        return b;
    }
}
