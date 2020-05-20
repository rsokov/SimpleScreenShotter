package com.company;
public class Main {
    public static void main(String[] args) {
        Thread simpleScreenShotter = new SimpleScreenShotter();
        Thread screenShotSender = new ScreenShotSender();
        simpleScreenShotter.start();
        screenShotSender.start();
    }
}


