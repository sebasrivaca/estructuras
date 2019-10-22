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
public class Client {
    
    private DocumentType documentType;
    private String documentNumber;
    private String names;
    private String lastnames;
    private Genus gender;
    private double weight;
    private double height;
	
    public Client(DocumentType documentType, String documentNumber, String names, String lastnames, Genus gender, double weight, double height) {
	this.documentType = documentType;
	this.documentNumber = documentNumber;
	this.names = names;
	this.lastnames = lastnames;
	this.gender = gender;
	this.height = height;
	this.weight = weight;
    }
	
    public DocumentType getDocumentType() {
	return documentType;
    }

    public String getDocumentNumber() {
	return documentNumber;
    }

    public String getNames() {
	return names;
    }

    public String getSurnames() {
	return lastnames;
    }

    public Genus getGender() {
	return gender;
    }

    public double getHeight() {
	return height;
    }

    public double getWeight() {
    	return weight;
    }
	
    public void editName(String nameOne) {
    	this.names = nameOne;
    }
	
    public void editLastnames(String lastnames) {
    	this.lastnames = lastnames;
    }
	
    public void editDocumentNumber(String document) {
    	this.documentNumber = document;
    }
	
    public void editWeight(double weight) {
	this.weight = weight;
    }
	
    public void editHeight(double height) {
	this.height = height;
    }
	
    public void editGenus(Genus gender) {
	this.gender = gender;
    }
	
    public void editType(DocumentType type) {
    	this.documentType = type;
    }
	
    public double calculateIMC() {
	double report = 0;
	report = weight / (height*height);
	return report;
    }
    
    public Object[] toObjectVector() {
	return new Object[] {documentType, documentNumber, names, lastnames, gender, height, weight, calculateIMC()};
    }
}
