package com.hex.study.proxy;

/**
 * @author hui.zhu
 */
public class ProxyImage implements Image {
    private String fileName;
    private ImageImpl image;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    public void disPlay() {
        if(image == null){
            image = new ImageImpl(fileName);
        }
        image.disPlay();
    }
}
