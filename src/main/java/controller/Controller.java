/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import modelo.DocumentType;
import modelo.Genus;
import modelo.Gym;
import utilities.Utilities;
import view.Console;

/**
 *
 * @author sebas
 */
public class Controller {

    private Gym gymUptc;
    private Console console;

    public static final String FIRST_OPTION = "1";
    public static final String SECOND_OPTION = "2";
    public static final String THIRD_OPTION = "3";
    public static final String FOURTH_OPTION = "4";
    public static final String FIFTH_OPTION = "5";
    public static final String SIXTH_OPTION = "6";
    public static final String SEVENTH_OPTION = "7";
    public static final String EIGTH_OPTION = "8";

    public Controller() {
        gymUptc = new Gym();
        console = new Console();
        createClients();
        inIt();
    }

    private void inIt() {
        console.printTextMenu();
        String option = console.getMenuOption();
        switch (option) {
            case FIRST_OPTION:
                createClient();
                break;
            case SECOND_OPTION:
                showClient();
                break;
            case THIRD_OPTION:
                showClients();
                break;
            case FOURTH_OPTION:
                inItTwo();
                break;
            case FIFTH_OPTION:
                deleteClient();
                break;
            case SIXTH_OPTION:
                showGraphicMan();
                ;
                break;
            case SEVENTH_OPTION:
                showGraphicWoman();
                break;
            case EIGTH_OPTION:
                break;
            default:
                console.showError();
                break;
        }
        inIt();
    }

    private void inItTwo() {
        console.printTextMenuTwo();
        String option = console.getMenuOption();
        switch (option) {
            case FIRST_OPTION:
                editName();
                break;
            case SECOND_OPTION:
                editSurName();
                break;
            case THIRD_OPTION:
                editNumberDocument();
                break;
            case FOURTH_OPTION:
                editTypeDocument();
                break;
            case FIFTH_OPTION:
                editWeight();
                break;
            case SIXTH_OPTION:
                editHeight();
                break;
            case SEVENTH_OPTION:
                editGender();
                break;
            case EIGTH_OPTION:
                break;
            default:
                console.showError();
                break;
        }
    }

    private void createClients() {
        gymUptc.addClient(Gym.createClient(DocumentType.ID, "12412", Utilities.generateRandomNameMan(), Utilities.generateRandomSurnames(), Genus.MALE, 65, 1.80));
        gymUptc.addClient(Gym.createClient(DocumentType.ID, "189412", Utilities.generateRandomNameMan(), Utilities.generateRandomSurnames(), Genus.MALE, 60, 1.50));
        gymUptc.addClient(Gym.createClient(DocumentType.ID, "124177", Utilities.generateRandomNameMan(), Utilities.generateRandomSurnames(), Genus.FEMALE, 70, 1.70));
        gymUptc.addClient(Gym.createClient(DocumentType.ID, "124187", Utilities.generateRandomNameMan(), Utilities.generateRandomSurnames(), Genus.FEMALE, 95, 1.80));
        gymUptc.addClient(Gym.createClient(DocumentType.ID, "124177", Utilities.generateRandomNameMan(), Utilities.generateRandomSurnames(), Genus.FEMALE, 108, 1.78));
    }

    private void createClient() {
        gymUptc.addClient(
                Gym.createClient(console.getTypeDocument(), console.getNumberDocument(), console.getName(),
                        console.getSurName(), console.getGender(), console.getWeight(), console.getHeight()));
    }

    private void showClient() {
        
        console.showListDatas(gymUptc.getClients());
    }

    private void showClients() {
        console.showListDatasTwo(gymUptc.getClients());
    }

    private void editName() {
        gymUptc.editName(console.getNumberDocumentEdit(), console.getName());
    }

    private void editSurName() {
        gymUptc.editLastnames(console.getNumberDocumentEdit(), console.getSurName());
    }

    private void editNumberDocument() {
        gymUptc.editDocuementNumber(console.getNumberDocumentEdit(), console.getNumberDocument());
    }

    private void editTypeDocument() {
        gymUptc.editType(console.getNumberDocumentEdit(), console.getTypeDocument());
    }

    private void editWeight() {
        gymUptc.editWeight(console.getNumberDocumentEdit(), console.getWeight());
    }

    private void editHeight() {
        gymUptc.editHeight(console.getNumberDocumentEdit(), console.getHeight());
    }

    private void editGender() {
        gymUptc.editGenus(console.getNumberDocumentEdit(), console.getGender());
    }

    private void deleteClient() {
        gymUptc.deleteClient(console.getNumberDocumentDelete());
      
    }

    private void showGraphicMan() {
        console.printGraphicsForMan(gymUptc.convertPercentageOfManToVector());
    }

    private void showGraphicWoman() {
        console.printGraphicsForWoman(gymUptc.convertPercentageOfWomanToVector());
    }

    public static void main(String[] args) {
        new Controller();
    }
}
