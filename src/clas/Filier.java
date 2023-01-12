package clas;

import java.util.ArrayList;
public class Filier {

private String name;
private ArrayList <Classe> classList;


Filier(){
	this.name="";
	this.classList = new ArrayList<Classe>();
}
Filier(String name){
	this.name=name;
	this.classList = new ArrayList<Classe>();
}


public String getName() {
	return this.name;
}

public void showClass() {
	for(Classe c:classList) {
		System.out.println(c.getClassName());
	}
}

}
