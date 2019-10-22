/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author sebas
 */
public class Gym {

    private Client[] clients;
    private static int position;

    public Gym() {
        clients = new Client[0];
        position = 0;
    }

    public Client[] getClients() {
        return clients;
    }

    public static Client createClient(DocumentType documentType, String documentNumber, String names, String surnames, Genus gender,
            double weight, double height) {
        return new Client(documentType, documentNumber, names, surnames, gender, weight, height);
    }

    public void addClient(Client client) {
        resizeArray();
        if (position < clients.length && clients[position] == null) {
            clients[position] = client;
            position++;
        }
    }

    public void resizeArray() {
        Client[] auxClient = new Client[clients.length + 1];
        for (int i = 0; i < clients.length; i++) {
            auxClient[i] = clients[i];
        }
        clients = auxClient;
    }

    public void deleteClient(String documentNumber) {
        for (int i = 0; i < clients.length; i++) {
            System.out.println(clients[i].getDocumentNumber());
            try {
                if (clients[i].getDocumentNumber().equals(documentNumber)) {
                    clients[i] = new Client();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void editName(String documentNumber, String name) {
        for (int i = 0; i < clients.length; i++) {
            if (documentNumber.equals(clients[i].getDocumentNumber())) {
                clients[i].editName(name);
            }
        }
    }

    public void editLastnames(String documentNumber, String lastname) {
        for (int i = 0; i < clients.length; i++) {
            if (documentNumber.equals(clients[i].getDocumentNumber())) {
                clients[i].editLastnames(lastname);
            }
        }
    }

    public void editDocuementNumber(String documentNumber, String documentNumberTwo) {
        for (int i = 0; i < clients.length; i++) {
            if (documentNumber.equals(clients[i].getDocumentNumber())) {
                clients[i].editDocumentNumber(documentNumberTwo);
            }
        }
    }

    public double[] convertPercentageOfManToVector() {
        return new double[]{calculateAverageManMinorEighteen(), calculateAverageManMinorTwentyfive(),
            calculateAverageManMinorTwentysix(), calculateAverageManGreaterTwentyseven()};
    }

    public double[] convertPercentageOfWomanToVector() {
        return new double[]{calculateAverageWomanMinorEighteen(), calculateAverageWomanMinorTwentyfive(),
            calculateAverageWomanMinorTwentysix(), calculateAverageWomanGreaterTwentyseven()};
    }

    public void editHeight(String documentNumber, double height) {
        for (int i = 0; i < clients.length; i++) {
            if (documentNumber.equals(clients[i].getDocumentNumber())) {
                clients[i].editHeight(height);
            }
        }
    }

    public void editWeight(String documentNumber, double weight) {
        for (int i = 0; i < clients.length; i++) {
            if (documentNumber.equals(clients[i].getDocumentNumber())) {
                clients[i].editWeight(weight);
            }
        }
    }

    public void editGenus(String documentNumber, Genus genus) {
        for (int i = 0; i < clients.length; i++) {
            if (documentNumber.equals(clients[i].getDocumentNumber())) {
                clients[i].editGenus(genus);
            }
        }
    }

    public void editType(String documentNumber, DocumentType type) {
        for (int i = 0; i < clients.length; i++) {
            if (documentNumber.equals(clients[i].getDocumentNumber())) {
                clients[i].editType(type);
            }
        }
    }

    public double calculateAverageManMinorEighteen() {
        int quantity = 0;
        for (int i = 0; i < clients.length; i++) {
            if (clients[i].calculateIMC() < 18 && clients[i].getGender().equals(Genus.MALE)) {
                quantity++;
            }
        }
        double report = (quantity * 100) / calculateNumberOfMen();
        return report;
    }

    public double calculateAverageManMinorTwentyfive() {
        int quantity = 0;
        for (int i = 0; i < clients.length; i++) {
            if (clients[i].calculateIMC() >= 18 && clients[i].calculateIMC() <= 24.9 && clients[i].getGender().equals(Genus.MALE)) {
                quantity++;
            }
        }
        double report = (quantity * 100) / calculateNumberOfMen();
        return report;
    }

    public double calculateAverageManMinorTwentysix() {
        int quantity = 0;
        for (int i = 0; i < clients.length; i++) {
            if (clients[i].calculateIMC() >= 25 && clients[i].calculateIMC() <= 26.9 && clients[i].getGender().equals(Genus.MALE)) {
                quantity++;
            }
        }
        double report = (quantity * 100) / calculateNumberOfMen();
        return report;
    }

    public double calculateAverageManGreaterTwentyseven() {
        int quantity = 0;
        for (int i = 0; i < clients.length; i++) {
            if (clients[i].calculateIMC() >= 27 && clients[i].getGender().equals(Genus.MALE)) {
                quantity++;
            }
        }
        double report = (quantity * 100) / calculateNumberOfMen();
        return report;
    }

    public double calculateAverageWomanMinorEighteen() {
        int quantity = 0;
        for (int i = 0; i < clients.length; i++) {
            if (clients[i].calculateIMC() < 18 && clients[i].getGender().equals(Genus.FEMALE)) {
                quantity++;
            }
        }
        double report = (quantity * 100) / calculateNumberOfWomen();
        return report;
    }

    public double calculateAverageWomanMinorTwentyfive() {
        int quantity = 0;
        for (int i = 0; i < clients.length; i++) {
            if (clients[i].calculateIMC() >= 18 && clients[i].calculateIMC() <= 24.9 && clients[i].getGender().equals(Genus.FEMALE)) {
                quantity++;
            }
        }
        double report = (quantity * 100) / calculateNumberOfWomen();
        return report;
    }

    public double calculateAverageWomanMinorTwentysix() {
        int quantity = 0;
        for (int i = 0; i < clients.length; i++) {
            if (clients[i].calculateIMC() >= 25 && clients[i].calculateIMC() <= 26.9 && clients[i].getGender().equals(Genus.FEMALE)) {
                quantity++;
            }
        }
        double report = (quantity * 100) / calculateNumberOfWomen();
        return report;
    }

    public double calculateAverageWomanGreaterTwentyseven() {
        int quantity = 0;
        for (int i = 0; i < clients.length; i++) {
            if (clients[i].calculateIMC() >= 27 && clients[i].getGender().equals(Genus.FEMALE)) {
                quantity++;
            }
        }
        double report = (quantity * 100) / calculateNumberOfWomen();
        return report;
    }

    public int calculateNumberOfMen() {
        int quantity = 0;
        for (int i = 0; i < clients.length; i++) {
            if (clients[i].getGender().equals(Genus.MALE)) {
                quantity++;
            }
        }
        return quantity;
    }

    public int calculateNumberOfWomen() {
        int quantity = 0;
        for (int i = 0; i < clients.length; i++) {
            if (clients[i].getGender().equals(Genus.FEMALE)) {
                quantity++;
            }
        }
        return quantity;
    }

}
