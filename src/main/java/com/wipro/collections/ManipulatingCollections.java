package com.wipro.collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class ManipulatingCollections {
    public static void main(String[] args) {

        Logger log = LoggerFactory.getLogger(ManipulatingCollections.class);

        List<Integer> list = Arrays.asList(5,3,8,1,9,2,4,7,6);

        // sorting using lambdas
        List<Integer> sortedList = list.stream().sorted(Comparator.reverseOrder()).toList();
        log.info("Sorted List : {}" , sortedList);
        // filtering using lambdas
        List<Integer> evenList = list.stream().filter(x -> x%2==0).toList();
        log.info("Even List : {}" , evenList);
        // mapping to squares
        List<Integer> squaresList = list.stream().map(x -> x*x).toList();
        log.info("Squares List : {}" , squaresList);
        // Creating a hashmap with numbers as keys and squares as its values
        HashMap<Integer,Integer> numSquareMap = list.stream().collect(HashMap::new, (map,x) -> map.put(x, x*x), HashMap::putAll);
        log.info("Number-Square Map : {}",numSquareMap);

        log.info("--------------------------------------------------");
        // printing same map with foreach loop
        numSquareMap.forEach((key, value) -> log.info("key= {} , value = {}" , key , value));
        log.info("--------------------------------------------------");

        List<HashMap<String,Integer>> marksList = new ManipulatingCollections().getList();

        List<String> studentList= marksList.stream().flatMap(map -> map.keySet().stream()).distinct().sorted().toList();

        Map<String,Integer> marksMap = new HashMap<>();
        studentList.forEach(x-> marksList.forEach(map -> {
            if(map.containsKey(x)) {
                if (marksMap.containsKey(x))
                    marksMap.put(x, marksMap.get(x) + map.get(x));
                else
                    marksMap.put(x, map.get(x));
            }
        }));

        log.info("MARKS MAP : {}" , marksMap );


    }


    public List<HashMap<String,Integer>> getList(){

        HashMap<String,Integer> marks1Map = new HashMap<>();
        marks1Map.put("a",34);
        marks1Map.put("b",47);
        marks1Map.put("c",68);
        marks1Map.put("d",23);
        marks1Map.put("e",58);

        HashMap<String,Integer> marks2Map = new HashMap<>();
        marks2Map.put("a",57);
        marks2Map.put("b",38);
        marks2Map.put("c",72);
        marks2Map.put("d",18);
        marks2Map.put("f",66);

        List<HashMap<String,Integer>> marksList = new ArrayList<>();
        marksList.add(marks1Map);
        marksList.add(marks2Map);

        return marksList;
    }
}
