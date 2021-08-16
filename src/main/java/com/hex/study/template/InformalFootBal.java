package com.hex.study.template;

import java.util.Map;

/**
 *
 * @author hui.zhu
 */
public class InformalFootBal extends Game {
    void init() {
        System.out.println("非正式足球比赛准备中。。。");
    }

    void start() {
        System.out.println("非正式足球比赛开始");
    }

    Map<String, Object> end() {
        System.out.println("非正式足球比赛结束");
        return null;
    }
}
