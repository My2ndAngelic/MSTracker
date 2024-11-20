package com.my2ndangelic;

import lombok.Getter;
import lombok.Setter;

public class Character {
    @Getter @Setter private String IGN;
    @Getter @Setter private String job;
    @Getter @Setter private int level;
    @Getter private String faction;
    @Getter private String archetype;

    Character() {

    }

    Character(String IGN, String job, int level) {
        this.IGN = IGN;
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
