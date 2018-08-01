package ru.job4j.professions;

public class Doctor extends Profession {
    public Diagnose heal(Patient patient) {
        Diagnose diagnose = new Diagnose();
        return diagnose;
    }
}
