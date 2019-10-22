/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;
import modelo.Client;
import modelo.DocumentType;
import modelo.Genus;

/**
 *
 * @author sebas
 */
public class Console {
    
    private Scanner scanner;
	
	public static final String SEPARATOR = "============================================================================================================";
	public static final Object[] HEADERS = { "TIPO DE DOCUMENTO", "NOMBRES", "APELLIDOS", "GENERO", "PESO", "ALTURA", "IMC" };
	public static final String FORMAT = "%1$-25s %2$-30s %3$-30s %4$-9s %5$-5s %6$-6s %7$-5s";
	public static final String NAME = "---- Ingrese el nombre del cliente ----";
	public static final String NUMBER_DOCUMENT = "---- Ingrese el numero de documento ----";
	public static final String TYPE_DOCUMENT = "---- Para seleccionar el tipo de documento, digite: \\n1. Cedula de Ciudadania \\n2. Tarjeta de identidad \\n3. Pasaporte ----";
	public static final String SURNAMES = "---- Ingrese los apellidos ----";
	public static final String GENDER = "---- Para seleccionar el genero, digite: \\n1. femenino \\n2. masculino ----";
	public static final String WEIGHT = "---- Ingrese el peso ----";
	public static final String HEIGHT = "---- Ingrese la altura ----";
	public static final String MESSAGE_MENU = "INGRESE UNA OPCION";
	public static final String MESSAGE_ERROR = "ERROR DE OPCION";
	public static final String NUMBER_DOCUMENT_DELETE = "---- Ingrese el numero de documento del cliente que desea borrar ----";
	public static final String NUMBER_DOCUMENT_EDIT = "---- Ingrese el numero de documento del cliente al que desea modificar la informacion----";
	public static final String BAR_GRAPHIC = "****";
	public static final String VOID_GRAPHIC = "    ";
	public static final String SEPARATOR_TWO = "====================================================================";
	public static final String GRAPHIC_FOR_MAN = "Grafico de barras para porcentaje de Hombres";
	public static final String GRAPHIC_FOR_WOMAN = "Grafico de barras para porcentaje de Mujeres";
	public static final Object[] FOOTER = { "%","PESO BAJO", "NORMAL", "SOBREPESO", "OBESIDAD"};
	public static final String FORMAT_TWO = "%1$-4s %2$-14s %3$-14s %4$-14s %5$-14s";
	
	public Console(){
		scanner = new Scanner(System.in);
	}
	
	public void showListDatas(Client[] clients) {
		generateHeader();
                 for(int i =0;i< clients.length;i++) {
                         System.out.print(clients[i].getDocumentNumber()+"  "+clients[i].getNames()+" "+ clients[i].getSurnames() +
                                 " " + clients[i].getGender()+" "+clients[i].getWeight()+" "+clients[i].getHeight()+" "+clients[i].calculateIMC());
                         System.out.println("");
		}
	}
	
	public void showListDatasTwo(Object[] datasList) {
		generateHeader();
		for(Object datasObject : datasList) {
			System.out.println(String.format( FORMAT, datasObject));
		}
	}
	
	public void generateHeader() {
		System.out.println(String.format(FORMAT, HEADERS));
		System.out.println(SEPARATOR);
	}
	
	public String getName(){
		System.out.println(NAME);
		return scanner.nextLine();
	}
	
	public String getSurName(){
		System.out.println(SURNAMES);
		return scanner.nextLine();
	}
	
	public String getNumberDocument(){
		System.out.println(NUMBER_DOCUMENT);
		return scanner.nextLine();
	}
	
	public String getNumberDocumentDelete(){
		System.out.println(NUMBER_DOCUMENT_DELETE);
		return scanner.nextLine();
	}
	
	public String getNumberDocumentEdit(){
		System.out.println(NUMBER_DOCUMENT_EDIT);
		return scanner.nextLine();
	}
	
	public DocumentType getTypeDocument() {
		System.out.println(TYPE_DOCUMENT);
		for (int i = 0; i < DocumentType.values().length; i++) {
			System.out.println(i + ". " + DocumentType.values()[i]);
		}
		return searchTypeDocument(Integer.parseInt(scanner.nextLine()));
	}

	private DocumentType searchTypeDocument(int position) {
		return DocumentType.values()[position];
	}

	public Genus getGender() {
		System.out.println(GENDER);
		for (int i = 0; i < Genus.values().length; i++) {
			System.out.println(i + ". " + Genus.values()[i]);
		}
		return searchGender(Integer.parseInt(scanner.nextLine()));
	}

	private Genus searchGender(int position) {
		return Genus.values()[position];
	}

	public double getWeight(){
		System.out.println(WEIGHT);
		return Double.parseDouble(scanner.nextLine());
	}
	
	public double getHeight(){
		System.out.println(HEIGHT);
		return Double.parseDouble(scanner.nextLine());
	}
	
	public String getMenuOption() {
		System.out.println(MESSAGE_MENU);
		return scanner.nextLine();
	}

	public void showError() {
		System.out.println(MESSAGE_ERROR);
	}
	

	public void printGraphicsForMan(double[] vectorOfAverages) {
		System.out.println(SEPARATOR_TWO);
		System.out.println(GRAPHIC_FOR_MAN);
		graphicGenerator(vectorOfAverages);
		generateFooter();
	}
	
	public void printGraphicsForWoman(double[] vectorOfAverages) {
		System.out.println(SEPARATOR_TWO);
		System.out.println(GRAPHIC_FOR_WOMAN);
		graphicGenerator(vectorOfAverages);
		generateFooter();
	}

	private void generateFooter() {
		System.out.println(SEPARATOR_TWO);
		System.out.println(String.format(FORMAT_TWO, FOOTER));
		System.out.println(SEPARATOR_TWO);
	}
	
	private void graphicGenerator(double[] vectorOfAverages) {
		int biggerAverage = getBiggerAverage(vectorOfAverages);
		for (int i = biggerAverage; i > 0; i--) {
			System.out.println(String.format(FORMAT_TWO, getRow(biggerAverage, vectorOfAverages)));
			biggerAverage--;
		}
		
	}

	private Object[] getRow(int biggerAverage, double[] vectorOfAverages) {
		Object[] row = new Object[FORMAT_TWO.length()];
		row[0] = biggerAverage;
		for (int i = 0; i < vectorOfAverages.length; i++) {
			if (vectorOfAverages[i] >= biggerAverage) {
				row[i + 1] = BAR_GRAPHIC;
			}else{
				row[i + 1] = VOID_GRAPHIC;
			}
		}
		return row;
	}

	private int getBiggerAverage(double[] vectorOfAverages) {
		int biggerAverage = 0;
		for (int i = 0; i < vectorOfAverages.length; i++) {
			if (biggerAverage < vectorOfAverages[i]) {
				biggerAverage = (int) vectorOfAverages[i];
			}
		}
		return biggerAverage + 2;
	}
	public void printTextMenu(){
		System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n");
		System.out.println("\t\t\t\t GYM S.A.S \n");
		System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n");
		System.out.println("1. CREAR CLIENTE\n");
		System.out.println("2. MOSTRAR DATOS DEL CLIENTE\n");
		System.out.println("3. MOSTRAR INFORMACION DE LOS CLIENTES\n");
		System.out.println("4. MODIFICAR INFORMACION DEL CLIENTE\n");
		System.out.println("5. BORRAR CLIENTE\n");
		System.out.println("6. GRAFICO DEL IMC EN HOMBRES\n");
		System.out.println("7. GRAFICO DEL IMC EN MUJERES\n");
		System.out.println("8. Salir\n");
	}
	
	public void printTextMenuTwo(){
		System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n");
		System.out.println("\t\t\t\t ELIJA UNA OPCIÓN \n");
		System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n");
		System.out.println("1. MODIFICAR NOMBRE DEL CLIENTE\n");
		System.out.println("2. MODIFICAR APELLIDOS DEL CLIENTE \n");
		System.out.println("3. MODIFICAR NUMERO DE DOCUMENTO DE IDENTIDAD\n");
		System.out.println("4. MODIFICAR TIPO DE DOCUMENTO\n");
		System.out.println("5. MODIFICAR PESO \n");
		System.out.println("6. MODIFICAR ALTURA\n");
		System.out.println("7. MODIFICAR GENERO\n");
		System.out.println("8. Salir\n");
	}
}
