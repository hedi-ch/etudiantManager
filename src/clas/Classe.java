package clas;

import java.util.ArrayList;
public class Classe {

	
private String className;
private ArrayList<Etudiant> etudiantList;
private String filierName;


Classe(){
	this.className="";
	this.filierName="";
	this.etudiantList = new ArrayList<Etudiant>();
}
Classe(String className,String filierName){
	this.className=className;
	this.filierName=filierName;
	this.etudiantList = new ArrayList<Etudiant>();
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

public void showEtudiant() {
	for(Etudiant e:etudiantList) {
		System.out.println(e);
		System.out.println("----------------------------------------------------------");
	}
}

}
