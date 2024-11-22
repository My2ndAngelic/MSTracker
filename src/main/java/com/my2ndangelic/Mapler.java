package com.my2ndangelic;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Mapler {
    @Getter @Setter private String ign;
    @Getter @Setter private String job;
    @Getter @Setter private int level;
    @Getter private String faction;
    @Getter private String archetype;
    @Getter @Setter private List<Integer> arcane;
    @Getter @Setter private List<Integer> sacred;



    Mapler() {

    }

    Mapler(String ign, String job, int level) {
        this.ign = ign;
        this.job = job;
        this.level = level;
        setFaction(job);
        setArchetype(job);
    }

    // TODO: Set the faction based on classname, coming from a database
    private void setFaction(String job) {
        switch (job) {
            case "Aran", "Evan": {
                faction = "Hero";
            }
            default:
        }
    }

    // TODO: Set the Archetype based on classname, from database
    private void setArchetype(String job) {
        switch (job) {
            case "Aran", "Evan": {
                archetype = "Warrior";
            }
            default:
        }
    }
}
