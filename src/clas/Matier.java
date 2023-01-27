package clas;

public class Matier {

private String matierName;
private double cof;
private int filierId,matierId;


Matier(int matierId,String name){
matierName=name;
this.matierId=matierId;
}
Matier(int matierId,String name,double cof,int filierId){
this.matierName=name;
this.cof=cof;
this.filierId=filierId;
this.matierId=matierId;
}

public String getIdString() {
	return ""+this.matierId;
}

public String getName() {
	return this.matierName;
}
public int getFilierId() {
	return this.filierId;
}
public int getMatier() {
	return this.matierId;
}

public double getCof() {
	return this.cof;
}


public String toString() {
	return "name: "+this.matierName+" filier name";
}


}
