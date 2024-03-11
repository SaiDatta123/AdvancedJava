package com.wipro.designpatterns.factory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class Laptop extends Computer {

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
