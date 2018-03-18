package no.hiof.larseknu.databasetest;

import java.time.LocalDate;

public class Dyr {
    private int id;
    private String animal, young, female, male, collectiveNoun;

    public Dyr(int id, String animal, String young, String female, String male, String collectiveNoun) {
        this.id = id;
        this.animal = animal;
        this.young = young;
        this.female = female;
        this.male = male;
        this.collectiveNoun = collectiveNoun;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getYoung() {
        return young;
    }

    public void setYoung(String young) {
        this.young = young;
    }

    public String getFemale() {
        return female;
    }

    public void setFemale(String female) {
        this.female = female;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public String getCollectiveNoun() {
        return collectiveNoun;
    }

    public void setCollectiveNoun(String collectiveNoun) {
        this.collectiveNoun = collectiveNoun;
    }

    @Override
    public String toString() {
        return "Dyr{" +
                "id=" + id +
                ", animal='" + animal + '\'' +
                ", young='" + young + '\'' +
                ", female='" + female + '\'' +
                ", male='" + male + '\'' +
                ", collectiveNoun='" + collectiveNoun + '\'' +
                '}';
    }
}
