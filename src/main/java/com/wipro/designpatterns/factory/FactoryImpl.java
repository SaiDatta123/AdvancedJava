package com.wipro.designpatterns.factory;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FactoryImpl {
    public static void main(String[] args) {

        Logger log = LoggerFactory.getLogger(FactoryImpl.class);

        Computer desktop = ComputerFactory.getComputer("desktop","2 GB","256 GB","2.4 GHz");
        Computer laptop = ComputerFactory.getComputer("laptop","16 GB","1 TB","2.9 GHz");

       log.info("Factory Desktop Config :: {}", desktop);
        log.info("Factory Laptop Config :: {}", laptop);
    }
}
