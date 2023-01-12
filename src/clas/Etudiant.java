package clas;

import java.util.ArrayList;
public class Etudiant {

private String name;
private ArrayList<Matier> matierList;
private Filier filier;
private Classe classe;
/*
--use this code if you add login and register 
private int id;
private String password;
*/

Etudiant(){
	this.name="";
	this.filier=null;
	this.classe=null;
}
Etudiant(String name,Filier filier){
	this.name=name;
	this.filier=filier;
	this.classe=null;
}
Etudiant(String name,Filier filier,Classe classe){
	this.name=name;
	this.filier=filier;
	this.classe=classe;
}


public String getName() {
	return this.name;
}

public String getClassName() {
	return this.classe.getClassName();
}

public double getMoyen() {
	double matierSomme=0;
	double cofSomme=0;
	for(Matier m:matierList) {
		matierSomme += m.getMoyen()*m.getCof();
		cofSomme += m.getCof();
	}
	return matierSomme/cofSomme;
}

public String getFilier() {
	return this.filier.getName();
}


public String toString() {
	return "etudiant name: "+this.name+" filier"+this.getFilier()+" classe :"+this.getClassName();
}

}
