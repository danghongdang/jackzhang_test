package com.jackzhang.spi;

public class Woman implements PeopleService {

    public void eat() {
        System.out.println("woman eat something!");
    }

    public void drink() {
        System.out.println("man eat something!");
    }
}
