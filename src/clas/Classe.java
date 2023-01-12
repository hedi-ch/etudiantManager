package clas;

import java.util.ArrayList;
public class Classe {

	
private String className;
private ArrayList<Etudiant> etudiantList;
private Filier filier;


Classe(){
	this.className="";
	this.filier=null;
	this.etudiantList = new ArrayList<Etudiant>();
}
Classe(String className,Filier filier){
	this.className=className;
	this.filier=filier;
	this.etudiantList = new ArrayList<Etudiant>();
}
Classe(String className){
	this.className=className;
	this.filier=null;
	this.etudiantList = new ArrayList<Etudiant>();
}



public String getClassName() {
	return this.className;
}

public String getfilier() {
	return this.filier.getName();
}
}
