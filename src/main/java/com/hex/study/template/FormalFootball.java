package com.hex.study.template;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author hui.zhu
 */
public class FormalFootball extends Game {

    void init() {
        System.out.println("正式足球比赛准备中。。。");
    }

    void start() {
        System.out.println("正式足球比赛开始");
    }

    Map<String, Object> end() {
        Map<String, Object> map = new HashMap<String, Object>(3);
        map.put("冠军队", "西班牙");
        map.put("亚军队", "荷兰");
        System.out.println("正式足球比赛结束");
        return map;
    }

    @Override
    void award(Map<String, Object> param) {
        super.award(param);
        System.out.println("下面进行颁奖典礼");
        Iterator<Map.Entry<String, Object>> iterator = param.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Object> entry = iterator.next();
            System.out.println("本届足球比赛：" + entry.getKey() + "是" + entry.getValue());
        }
        System.out.println("本届比赛正式圆满结束");
    }
}
