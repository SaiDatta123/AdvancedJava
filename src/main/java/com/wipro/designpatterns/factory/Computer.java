package com.wipro.designpatterns.factory;

import lombok.ToString;

@ToString
public abstract class Computer {

    public abstract String getRAM();
    public abstract String getHDD();
    public abstract String getCPU();

}
