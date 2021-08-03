package com.hex.study.strategy;

import com.hex.study.strategy.impl.Add;
import com.hex.study.strategy.impl.Divide;
import com.hex.study.strategy.impl.Multiply;
import com.hex.study.strategy.impl.Subtract;

/**
 * @author hui.zhu
 */
public class StrategyDemo {
    public static void main(String[] args) {
        DoCalculation add = new DoCalculation(new Add());
        DoCalculation subtract = new DoCalculation(new Subtract());
        DoCalculation multiply = new DoCalculation(new Multiply());
        DoCalculation divide = new DoCalculation(new Divide());
        System.out.println("((1+3)-5*8)/(3+5)=" + divide.excute(subtract.excute(add.excute(1, 3), multiply.excute(5, 8)), add.excute(3, 5)));
    }
}
