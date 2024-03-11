package com.wipro.designpatterns.factory;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Desktop extends Computer {

    private String ram;
    private String hardDisk;
    private String cpu;

    @Override
    public String getRAM() {
        return this.ram;
    }
    @Override
    public String getHDD() {
        return this.hardDisk;
    }
    @Override
    public String getCPU() {
        return this.cpu;
    }
}
