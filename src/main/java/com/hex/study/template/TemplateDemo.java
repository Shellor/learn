package com.hex.study.template;

/**
 * @author hui.zhu
 */
public class TemplateDemo {
    public static void main(String[] args) {
        Game game = new InformalFootBal();
        game.play();
        System.out.println();
        game = new FormalFootball();
        game.play();
    }
}
