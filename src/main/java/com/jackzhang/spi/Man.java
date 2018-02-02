package com.jackzhang.spi;

public class Man implements PeopleService {

    public void eat() {
        System.out.println("man eat something");
    }

    public void drink() {
        System.out.println("man drink something");
    }
}
