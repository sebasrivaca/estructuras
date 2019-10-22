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
public enum DocumentType {
    
    ID("Cedula de Ciudadania"),IDENTITY_CARD("Tarjeta de identidad"),PASSPORT("Pasaporte"), OTHER("Otro");
	
	private final String name;
		
	private DocumentType( String name ) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
