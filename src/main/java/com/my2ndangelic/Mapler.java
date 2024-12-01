package com.my2ndangelic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @NoArgsConstructor
public class Mapler {
    @Setter private String ign;
    @Setter private String job;
    @Setter private int level;
    private String faction;
    private String archetype;
    @Setter private List<Integer> arcane;
    @Setter private List<Integer> sacred;

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
            case "Aran", "Adele": {
                archetype = "Warrior";
            }
            default:
        }
    }
}
