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
public enum Genus {
    
    FEMALE("Femenino"), MALE("Masculino");
	
	private String name;
		
	private Genus( String name ) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
