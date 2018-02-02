package com.jackzhang.sandbox;

public class ClockRun {

    public static void main(String args[]) throws InterruptedException {
//        Clock normalClock = new Clock.NormalClock();
//        normalClock.loopReport();

        Clock brokenClock = new Clock.BrokenClock();
        brokenClock.loopReport("传入参数");
    }
}