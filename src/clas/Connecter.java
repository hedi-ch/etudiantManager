package clas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Connecter {
	
	Connection conn;
	
	
	public Connecter() {
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
		/*String query="select EtudiantId,LastName,FirstName,ClassName,FilierName from Etudiant e";
		query+=" inner join Class c on e.ClassId=c.ClassId";
		query+=" inner join  Filier f on c.FilierId=f.FilierId";
		query+=" where c.ClassName='"+classNameInput+"'";
		*/
		String query="select * from Class where ClassName= '"+classNameInput+"';";
		
		try {
			Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

			ResultSet result = state.executeQuery(query);
			
			result.next();
			
			Classe clas=new Classe(result.getInt("ClassId"),result.getString("ClassName"));
						
			result.close();
			state.close();
			return clas;
		}catch(Exception e) {
			return null;
		}
	}
	
	public boolean adminVerification(String adminUserName,String password) {
		String query="select AdminUserName,Password from Administration where AdminUserName='"+adminUserName+"';";
		try {
			Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		
			ResultSet result = state.executeQuery(query);
			
			result.next();
			
			Admin admin=new Admin(result.getString("AdminUserName"),result.getString("Password"));
			
			result.close();
			
			state.close();
			if (admin.getPassword().equals(password.toString())) {
				return true;
				}
			else {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
	}

	public Filier chercheFilier(String filierName) {
		
		String query="select FilierId ,FilierName from Filier where FilierName = '"+filierName+"';";
		

		try {
			Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

			ResultSet result = state.executeQuery(query);
			
			result.next();
			
			Filier fil=new Filier(result.getInt("FilierId"),result.getString("FilierName"));
			
			result.close();
			state.close();
			return fil;
		}catch(Exception e) {
			return null;
		}
		
	}
	
	public Matier chercheMatier(String matierName,int filierId){

String query="select  MatierId,MatierName,coefficient,FilierId from Matier ";
	   query+="where  FilierId = "+filierId+" and matierName = '"+matierName+"';";
		

		try {
			Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

			ResultSet result = state.executeQuery(query);
			
			result.next();
			
			Matier mat=new Matier(result.getInt("MatierId"),result.getString("MatierName"),result.getDouble("coefficient"),result.getInt("FilierId"));
			
			result.close();
			state.close();
			return mat;
		}catch(Exception e) {
			return null;
		}
		
		
	}
	
	
	public Matier chercheMatierByMatierName(String matierName){

		String query="select  MatierId,MatierName,coefficient,FilierId from Matier ";
			   query+="where matierName = '"+matierName+"';";
				

				try {
					Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

					ResultSet result = state.executeQuery(query);
					
					result.next();
					
					Matier mat=new Matier(result.getInt("MatierId"),result.getString("MatierName"),result.getDouble("coefficient"),result.getInt("FilierId"));
					
					result.close();
					state.close();
					return mat;
				}catch(Exception e) {
					return null;
				}
				
				
			}
	
	
	public ArrayList<Matier> chercheMatier(String etudiantId){

		String query="select MatierName,MatierId from Matier m ";
		query+="inner join Filier f on m.FilierId=f.FilierId "; 
		query+="inner join Class c on c.FilierId=f.FilierId "; 
		query+="inner join Etudiant e on e.ClassId= c.ClassId ";
		query+="where EtudiantId="+etudiantId+";";
			   
			   ArrayList<Matier> mat=new ArrayList<>();
			
				try {
					Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

					ResultSet result = state.executeQuery(query);
					
					while(result.next()) {
					
					mat.add(new Matier(result.getInt("MatierId"),result.getString("MatierName")));
					}
					result.close();
					state.close();
					return mat;
				}catch(Exception e) {
					return null;
				}
				
				
			}
	
	
	
	public boolean cherchNoteByMatierId(String etudiantId,String matierId) {
		String query="select * from Note where EtudiantId = "+etudiantId+" and MatierId ="+matierId+";";
		boolean res;
		try {
			Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet result = state.executeQuery(query);
			res=result.next(); 
			result.close();
			state.close();
		}catch(Exception e) {
			System.out.print("error in cherchNoteByMatierId");
			return false;
		}
		return res;
	}
	
	public boolean insertNote(String etudiantId,String matierId,String note){
		String query="insert into Note values ("+etudiantId+","+matierId+","+note+");";
		try {
			Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet result = state.executeQuery(query);
			result.close();
			state.close();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	
 	public boolean insertClass(String className,String filierName) {
		try {
			String query="insert into Class values (NEXTVAL(classSequence),'"+className+"','"+chercheFilier(filierName).getId()+"');";
			Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet result = state.executeQuery(query);
			result.close();
			state.close();
			return true;
		}catch(Exception e) {
			return false;
		}	
	}

	public boolean insertFilier(String filierName) {
		try {
			if(chercheFilier(filierName)==null) {
				String query="insert into Filier  values (NEXTVAL(filierSequence),'"+filierName+"');";
			Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet result = state.executeQuery(query);
			result.close();
			state.close();
			return true;
			}
			else return false;
		}catch(Exception e) {
			return false;
		}	
	}
	
	public boolean inserMatier(String matierName,String coefficient,int filierId) {
		try {
			if(chercheMatier(matierName,filierId)==null) {
				String query="insert into Matier  values (NEXTVAL(matierSequence),'"+matierName+"',"+filierId+","+coefficient+");";
			Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet result = state.executeQuery(query);
			result.close();
			state.close();
			return true;
			}
			else return false;
		}catch(Exception e) {
			return false;
		}
	}

	
	public boolean insertEtudiant(String firstName,String lastName,int classId) {
		try {
			String query="insert into Etudiant  values (NEXTVAL(etudiantSequence),'"+firstName+"','"+lastName+"',"+classId+");";
			Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet result = state.executeQuery(query);
			result.close();
			state.close();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	
	public ArrayList<Classe> allClass(){
		ArrayList<Classe> cla=new ArrayList<>();
		
		String query="select * from Class";
		try{Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet result = state.executeQuery(query);
		while(result.next()) {
			cla.add(new Classe(result.getInt("ClassId"),result.getString("ClassName")));
		}
		result.close();
		state.close();
		return cla;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Classe> allClass(int filierId){
		ArrayList<Classe> cla=new ArrayList<>();
		
		String query="select * from Class where FilierId = "+filierId+";";
		try{Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet result = state.executeQuery(query);
		while(result.next()) {
			cla.add(new Classe(result.getInt("ClassId"),result.getString("ClassName")));
		}
		result.close();
		state.close();
		return cla;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Filier> allFilier(){
ArrayList<Filier> fil=new ArrayList<>();
		
		String query="select * from Filier";
		try{Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet result = state.executeQuery(query);
		while(result.next()) {
			fil.add(new Filier(result.getInt("FilierId"),result.getString("FilierName")));
		}
		result.close();
		state.close();
		return fil;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
	
	public void updateEtudiant(String id,String lastName,String firstName,String className) throws SQLException {
		try {
		String query="UPDATE Etudiant set LastName = '"+lastName+"', FirstName = '"+firstName+"' , ClassId = "+this.chercheByClassName(className).getId();
		query+=" where EtudiantId = "+id+";";
		Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet result = state.executeQuery(query);
		result.close();
		state.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	} 
	
	
	public void updateNote(String  EtudiantId , String MatierName ,String note) throws SQLException {
		try {
		String query="UPDATE Note set note = "+note;
		query+=" where EtudiantId = "+EtudiantId+" and  MatierId = "+this.chercheMatierByMatierName(MatierName).getIdString()+";";
		Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet result = state.executeQuery(query);
		result.close();
		state.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	
	public Etudiant cherchEtudiant(String etudiantId) {
		
		String query="select EtudiantId,LastName,FirstName,ClassName,FilierName";
		query+=" from Etudiant e inner join Class c on e.ClassId=c.ClassId";
		query+=" inner join  Filier f on c.FilierId=f.FilierId";
		query+=" where e.EtudiantId = "+etudiantId+";";
		
		Etudiant etudiant;
		
		try{Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet result = state.executeQuery(query);
		result.next();
		etudiant=new Etudiant(result.getString("LastName"),result.getString("FirstName"),result.getString("FilierName"),result.getString("ClassName"));
		result.close();
		state.close();
		return etudiant;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
	}
	
}


