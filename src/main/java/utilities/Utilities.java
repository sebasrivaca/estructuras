/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import modelo.Genus;

/**
 *
 * @author sebas
 */
public class Utilities {

    public static final String[] MAN_NAMES = {"Jose", "Andres", "Pedro", "Pablo", "Mario", "Ernesto", "Camilo", "Joaquin"};
    public static final String[] WOMAN_NAMES = {"Maria", "Martha", "Paula", "Dayana", "Ana", "Sofia", "Camila", "Karen"};
    public static final String[] SURNAMES = {"Gonzalez", "Niño", "Castellanos", "Rodriguez", "Sanchez", "Casallas", "Perez", "Murcia"};

    public static Genus generateRandomGender() {
        return Genus.values()[(int) ((Math.random() * (1 - 0) + 1))];
    }

    public static String generateRandomNameMan() {
        return MAN_NAMES[(int) (Math.random() * (MAN_NAMES.length - 0) + 0)];
    }

    public static String generateRandomNameWoman() {
        return WOMAN_NAMES[(int) (Math.random() * (WOMAN_NAMES.length - 0) + 0)];
    }

    public static String generateRandomSurnames() {
        return SURNAMES[(int) (Math.random() * (SURNAMES.length - 0) + 0)];
    }
}
