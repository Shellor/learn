package com.hex.study.template;

import java.util.Map;

/**
 * 模板方法-行为型模式
 * 一个抽象类公开定义了执行它的方法的方式/模板。子类可以按需重写方法，调用以抽象类中定义的方式进行
 * 定义一个操作中的算法的骨架，子类可以不改变一个算法的结构，重定义该算法的某些特定步骤
 * 优点： 1、封装不变部分，扩展可变部分。 2、提取公共代码，便于维护。 3、行为由父类控制，子类实现。
 * 缺点：需求过多时，子类增多，使得系统更加庞大。
 *
 * @author hui.zhu
 */
public abstract class Game {

    /**
     * 模板
     * 模板方法设置为 final，这样它就不会被重写
     */
    public final void play() {
        init();
        start();
        Map<String, Object> result = end();
        award(result);
    }

    /**
     * 初始化游戏
     */
    abstract void init();

    /**
     * 开始游戏
     */
    abstract void start();

    /**
     * 结束游戏
     * @return
     */
    abstract Map<String, Object> end();

    /**
     * 颁奖
     * 钩子函数（初始业务可能没有用到，后续需求变更增加的函数，在适当的位置增加的预留函数）
     *
     * @param param
     */
    void award(Map<String, Object> param) {

    }
}
