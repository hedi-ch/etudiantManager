package clas;

//import java.util.ArrayList; line 8
public class Etudiant {

private int id;
private String Firstname;
private String Lastname;
//private ArrayList<Matier> matierList; line 37 and class Matier
private String filierName;
private String classeName;


Etudiant(){
	this.Lastname="";
	filierName="";
	classeName="";
}
Etudiant(int id,String Lastname,String Firstname,String filier){
	this.Lastname=Lastname;
	this.Firstname=Firstname;
	filierName=filier;
	this.classeName="";
}
Etudiant(int id,String Lastname,String Firstname,String filier,String classe){
	this.Firstname=Firstname;
	this.Lastname=Lastname;
	this.filierName=filier;
	this.classeName=classe;
}


public String getName() {
	return this.Lastname+" "+this.Firstname;
}

public String getClassName() {
	return this.classeName;
}
/*
public double getMoyen() {
	double matierSomme=0;
	double cofSomme=0;
	for(Matier m:matierList) {
		matierSomme += m.getMoyen()*m.getCof();
		cofSomme += m.getCof();
	}
	return matierSomme/cofSomme;
}
*/
public String getFilier() {
	return this.filierName;
}


public String toString() {
	return "id: "+this.id+" etudiant name: "+this.getName()+" filier :"+this.getFilier()+" classe : "+this.getClassName();
}

}
