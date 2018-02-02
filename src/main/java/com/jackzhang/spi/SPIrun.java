package com.jackzhang.spi;

import com.sun.tools.javac.util.ServiceLoader;

public class SPIrun {

    public static void main(String args[]) {
        ServiceLoader<PeopleService> loaderList = ServiceLoader.load(PeopleService.class);
        for (PeopleService loader : loaderList) {
            loader.eat();
        }
    }
}
