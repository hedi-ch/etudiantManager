package clas;

public class Matier {


private double noteDs;
private double noteCo;
private double noteEx;
private byte semester;
private String name;
private double cof=1;


Matier(){
noteDs=0.0;
noteEx=0.0;
noteCo=0.0;
semester=0;
name="";
}
Matier(String name,byte semester,double noteDs,double noteEx,double noteCo,double cof){
this.noteDs=noteDs;
this.noteEx=noteEx;
this.noteCo=noteCo;
this.semester=semester;
this.name=name;
this.cof=cof;
}
Matier(String name,byte semester,double noteDs,double noteEx,double noteCo){
this.noteDs=noteDs;
this.noteEx=noteEx;
this.noteCo=noteCo;
this.semester=semester;
this.name=name;
}


public String getName() {
	return this.name;
}

public byte getSemester() {
	return this.semester;
	}

public double getMoyen(){
	return this.noteCo*0.1+this.noteDs*0.1+this.noteEx*0.8;
}

public double getCof() {
	return this.cof;
}


public void setNoteEx(double noteEx){
	this.noteEx=noteEx;
}

public void setNoteDs(double noteDs){
	this.noteDs=noteDs;
}

public void setNoteCo(double noteCo){
	this.noteCo=noteCo;
}


public String toString() {
	return "name: "+this.name+" note de control contenue: "+this.noteCo+" note DS: "+this.noteDs+" note Exame: "+this.noteEx+" semester: "+this.semester+" note generale de marier: "+this.getMoyen();
}


}
