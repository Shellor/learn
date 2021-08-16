package com.hex.study.proxy;


/**
 * @author hui.zhu
 */
public class ImageImpl implements Image {
    private String fileName;
    public void disPlay() {
        System.out.println("disPlay:" + fileName);
    }

    public ImageImpl(String fileName) {
        this.fileName = fileName;
        this.loadImage(fileName);
    }
    public void loadImage(String fileName) {
        System.out.println("load:" + fileName);
    }
}
