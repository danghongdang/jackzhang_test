package com.jackzhang.design_pattern;

public class DoubleCheck {

    private volatile Helper helper;

    // note this result seems unnecessary. The effect of this is that in case where the "helper" initialized,
    // the volatile is only once access (due to "return result",instead of "return helper")
    public Helper getHelper() {
        Helper result = helper;
        if (result == null) {
            synchronized (this) {
                result = helper;
                if (result == null) {
                    result = helper = new Helper();
                }
            }
        }
        return result;
    }

    private class Helper {
        //

    }
}
