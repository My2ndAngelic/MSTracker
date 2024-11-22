package com.my2ndangelic;

import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVJobReader {
    @Getter private String faction;
    @Getter private String archetype;
    @Getter @Setter private String job;
    private List<List<String>> listOfFactionArchetypeJob = jobReaderFromCSV();
    private ArrayList<String> leArchetype = new ArrayList<>();
    private ArrayList<String> leFaction = new ArrayList<>();
    private ArrayList<String> leJob = new ArrayList<>();

    CSVJobReader(String job) {
        this.job = job;
        setFactionAndArchetype();
        this.faction = leFaction.get(leJob.indexOf(job));
        this.archetype = leArchetype.get(leJob.indexOf(job));
    }

    private List<List<String>> jobReaderFromCSV() {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("JobList.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            System.out.printf("File not found in the directory: %s", System.getProperty("user.dir"));
        }
        return records;
    }
    
    private void setFactionAndArchetype() {
        for (List<String> record : listOfFactionArchetypeJob) {
            leFaction.add(record.get(0));
            leArchetype.add(record.get(1));
            leJob.add(record.get(2));
        }
    }
}
