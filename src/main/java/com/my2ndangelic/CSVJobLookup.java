package com.my2ndangelic;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVJobLookup {
    @Getter private String faction;
    @Getter private String archetype;
    @Getter private String job;
    private final List<List<String>> listOfFactionArchetypeJob = jobReaderFromCSV();
    private final ArrayList<String> leArchetype = new ArrayList<>();
    private final ArrayList<String> leFaction = new ArrayList<>();
    private final ArrayList<String> leJob = new ArrayList<>();

    CSVJobLookup(String job) {
        this.job = job;
        loadFactionAndArchetype();
        this.faction = leFaction.get(leJob.indexOf(job));
        this.archetype = leArchetype.get(leJob.indexOf(job));
    }

    CSVJobLookup() {
        loadFactionAndArchetype();
    }

    /***
     * Return the faction (
     * @param job
     * @return
     */
    public String getFaction(String job) {
        if (listOfFactionArchetypeJob.isEmpty()) loadFactionAndArchetype();
        return leFaction.get(leJob.indexOf(job));
    }

    public String getArchetype(String job) {
        if (listOfFactionArchetypeJob.isEmpty()) loadFactionAndArchetype();
        return leArchetype.get(leJob.indexOf(job));
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
    
    private void loadFactionAndArchetype() {
        for (List<String> record : listOfFactionArchetypeJob) {
            leFaction.add(record.get(0));
            leArchetype.add(record.get(1));
            leJob.add(record.get(2));
        }
    }
}
