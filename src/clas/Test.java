package clas;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connecter c = new Connecter();
		try{
			c.chercheByClassName("cs03").showEtudiant();
		}
		catch(Exception e) {
			
		}
		System.out.println("pass valide");
	}

}
