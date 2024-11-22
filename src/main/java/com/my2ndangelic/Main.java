package com.my2ndangelic;

import org.yaml.snakeyaml.Yaml;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
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

        Yaml yaml = new Yaml();
        List<Mapler> maplers = new ArrayList<>();

        for (Object characterData : yaml.loadAll(importedData)) {
            Mapler mapler = new Mapler();
            System.out.println(characterData.getClass()                   );
//            mapler.setIgn((String) map.get("ign"));
//            mapler.setJob((String) map.get("job"));
//            mapler.setLevel((Integer) map.get("level"));
//            mapler.setArcane((List<Integer>) map.get("arcane"));
//            mapler.setSacred((List<Integer>) map.get("sacred"));
//            maplers.add(mapler);
        }

        // Now you have a list of Mapler objects
        for (Mapler mapler : maplers) {
            System.out.println(mapler); // Or use them as needed
        }

    }
}