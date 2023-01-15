package clas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connecter {
	
	Connection conn;
	
	
	Connecter() {
		// TODO Auto-generated method stub
		try {
			String url = "jdbc:mariadb://localhost:3306/EtudiantDB";
			String user = "EtudiantAdmin";
			String passwd = "admin";
			conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("Connexion effective !");
			} catch (Exception e) {
			e.printStackTrace();
			System.out.println("the connection with the data base not correct make sure that url user and password are correct");
			}
	}
	
	
	Connecter(String user,String passwd) {
		try {
			String url = "jdbc:mariadb://localhost:3306/EtudiantDB";
			conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("Connexion effective !");
			} catch (Exception e) {
			e.printStackTrace();
			System.out.println("the connection with the data base not correct make sure that url user and password are correct");
			}
	}
	
	Connecter(String user,String passwd,String dataBaseName) {
		try {
			String url = "jdbc:mariadb://localhost:3306/"+dataBaseName;
			conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("Connexion effective !");
			} catch (Exception e) {
			e.printStackTrace();
			System.out.println("the connection with the data base not correct make sure that url user and password are correct");
			}
	}
	
	
	
	public Classe chercheByClassName(String classNameInput) {
		String query="select EtudiantId,LastName,FirstName,ClassName,FilierName from Etudiant e";
		query+=" inner join Class c on e.ClassId=c.ClassId";
		query+=" inner join  Filier f on c.FilierId=f.FilierId";
		query+=" where c.ClassName='"+classNameInput+"'";
		
		
		try {
			Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

			ResultSet result = state.executeQuery(query);
			
			result.next();
			
			Classe clas=new Classe(result.getString("ClassName"),result.getString("FilierName"));
			
			clas.addEtudian(result.getInt("EtudiantId"),result.getString("LastName"),result.getString("FirstName"),result.getString("ClassName"),result.getString("FilierName"));
			
			while(result.next()){
				clas.addEtudian(result.getInt("EtudiantId"),result.getString("LastName"),result.getString("FirstName"),result.getString("ClassName"),result.getString("FilierName"));
			}
			
			result.close();
			state.close();
			return clas;
		}catch(Exception e) {
			//e.printStackTrace();
			return null;
		}
	}
}


