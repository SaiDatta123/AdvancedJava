package com.wipro.streams;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AggregationImpl {
    public static void main(String[] args) {

        Logger log = LoggerFactory.getLogger(AggregationImpl.class);

        List<SalesRecord> salesRecords = Arrays.asList(
                new SalesRecord("ProductA",10,25.0),
                new SalesRecord("ProductB",15,15.0),
                new SalesRecord("ProductB",8,30.0),
                new SalesRecord("ProductA",15,21.0),
                new SalesRecord("ProductC",23,18.0)
        );

        // aggregating total quantity sold for each product
        Map<String,Integer> quantityMap = salesRecords.stream()
                .collect(Collectors.groupingBy(SalesRecord::getProduct,
                        Collectors.summingInt(SalesRecord::getQuantity)));

        log.info("Total quantity sold by product : {}", quantityMap);

        // aggregating total revenue for each product
        Map<String,Double> revenueMap = salesRecords.stream()
                .collect(Collectors.groupingBy(SalesRecord::getProduct,
                        Collectors.summingDouble(prod -> prod.getQuantity() * prod.getPrice())));

        log.info("Total revenue generated by product : {}", revenueMap);
    }
}
