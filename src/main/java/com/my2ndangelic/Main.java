package com.my2ndangelic;

import org.yaml.snakeyaml.Yaml;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        CSVJobLookup csvJobLookup = new CSVJobLookup();

        String importedData;
        try {
            importedData = new BufferedReader(new FileReader("exampleYAML.yaml")).lines().collect(Collectors.joining("\n"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        List<Mapler> maplers = new ArrayList<>();

        for (Object characterData : new Yaml().loadAll(importedData)) {
            Mapler mapler = new Mapler();
            LinkedHashMap<String, Object> leMap = (LinkedHashMap<String, Object>) characterData;
            mapler.setIgn((String) leMap.get("ign"));
            mapler.setJob((String) leMap.get("job"));
            mapler.setLevel((Integer) leMap.get("level"));
            if (leMap.get("arcane") != null)
                mapler.setArcane(Arrays.stream(leMap.get("arcane").toString().split(",")).map(String::trim).map(Integer::parseInt).collect(Collectors.toList()));
            if (leMap.get("sacred") != null)
                mapler.setSacred(Arrays.stream(leMap.get("sacred").toString().split(",")).map(String::trim).map(Integer::parseInt).collect(Collectors.toList()));
            maplers.add(mapler);
        }

        // Now you have a list of Mapler objects
        for (Mapler mapler : maplers) {
            System.out.println(mapler.getIgn()); // Or use them as needed
        }

    }
}