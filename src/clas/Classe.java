package clas;

import java.util.ArrayList;
public class Classe {


private int id;
private String className;
private ArrayList<Etudiant> etudiantList;
private String filierName;


Classe(int id,String className,String filierName){
	this.className=className;
	this.filierName=filierName;
	this.id=id;
}
Classe(String className,String filierName){
	this.className=className;
	this.filierName=filierName;
	this.etudiantList = new ArrayList<Etudiant>();
}
Classe(int id,String className){
	this.className=className;
	this.id=id;
}
Classe(String className){
	this.className=className;
	this.filierName="";
	this.etudiantList = new ArrayList<Etudiant>();
}

public void addEtudian(int id,String Lastname,String Firstname,String filier,String classe) {
	Etudiant e=new Etudiant(id,Lastname,Firstname,filier,classe);
	etudiantList.add(e);
}

public String getClassName() {
	return this.className;
}

public String getfilier() {
	return this.filierName;
}

public int getId() {
	return this.id;
}
public String getIdString() {
	return ""+this.id;
}

public void showEtudiant() {
	for(Etudiant e:etudiantList) {
		System.out.println(e);
		System.out.println("----------------------------------------------------------");
	}
}

}
