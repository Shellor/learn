package com.hex.study.strategy.impl;

import com.hex.study.strategy.Calculation;

/**
 * @author hui.zhu
 */
public class Multiply implements Calculation {
    public int doCalculation(int a, int b) {
        return a * b;
    }
}
