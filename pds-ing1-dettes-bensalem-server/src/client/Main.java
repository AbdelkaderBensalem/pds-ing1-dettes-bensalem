package client;

import java.io.IOException;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

import javax.swing.JTextField;

import org.json.simple.*;
//import socketClient.SocketClient;

public class Main {
	
	private static Connection c;
	private static String URL ="jdbc:postgresql://172.31.249.44:5432/NamaiDB";
	private static String login = "toto";
	private static String password = "toto";
	public static String nbtram;
	public static String nbauto;
	public static String nbcycliste;
	public static String nbpieton;
	public static String disttram;
	public static String distauto;
	public static String distcycliste;
	public static String distpieton;
	
public static Connection createConnection() throws SQLException {
	try {
		return DriverManager.getConnection(URL, login, password);
	} catch (SQLException e) {
		throw new SQLException("Can't create connection", e);
	}
}

	public static void main(String[] args) throws IOException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		SocketClient client = new SocketClient();	// Socket creation
		client.startConnection("172.31.249.89", 6666); // Start of connection with socket
		
		//LANCEMENT IHM
		IHM window = new IHM();
		window.frmSystmeDeCalcul.setVisible(true);
		
		
		while(true) { // Menu display
			/*System.out.println("########################### Menu Namai-city-client #########################");
			System.out.println("1: Afficher");
			System.out.println("2: Cr�er");
			System.out.println("3: Mettre � jour");
			System.out.println("4: Supprimer");
			System.out.println("5: Exit");
			//System.out.println("6: Tentative de connexion � la BDD depuis le client ");
			System.out.println("########################### Menu Namai-city-client #########################");*/
			JSONObject obj=new JSONObject();  //JSONObject creation
			String rep = sc.nextLine();

			
			switch (rep) {
			case "1": // Menu display
				System.out.println("########################### Menu Namai-city-client #########################");
				System.out.println("1: Afficher tous les utilisateurs");
				System.out.println("2: afficher un utilisateur en particulier");
				System.out.println("########################### Menu Namai-city-client #########################");	
				Scanner choice = new Scanner(System.in);
				rep = choice.nextLine(); 
				switch(rep) {
				case "1": // Request to display all users in the table "users"
					System.out.println("########################### SELECT #########################");
					obj.put("demandType",String.valueOf("SELECT"));
					obj.put("Id",Integer.valueOf(0)); 
					System.out.println(obj);
					JSONObject reponseAll = client.sendMessage(obj);
					ArrayList<JSONObject> allUsers = new ArrayList<JSONObject>();// Creation d'un tableau de type JSONObject
					allUsers = (ArrayList<JSONObject>) reponseAll.get("users");
					System.out.println(allUsers);		 
//					client.stopConnection();  // Exit cases
					break;


				case "2": // Request to display one user in the table "users"
					choice = new Scanner(System.in);
					System.out.println("########################### SELECT #########################");
					System.out.println("quel est l'id de l'utilisateur � afficher ? ");
					int repSelect = 0;
					try {
						repSelect = choice.nextInt();
					}
					catch(InputMismatchException e){
						System.out.println("probleme de saisi de l'id");
						break;
					}
					obj.put("demandType",String.valueOf("SELECT"));
					obj.put("Id",Integer.valueOf(repSelect)); 
					System.out.println(obj);

					JSONObject reponse = client.sendMessage(obj);
					if(reponse.containsKey("reponse")) {
						System.out.println(reponse.get("reponse"));
					}
					else {					
						String name = (String) reponse.get("nom");  
						String prenom = (String) reponse.get("prenom");  
						long idCaste = (long) reponse.get("Id");
						int id = (int) idCaste;
						System.out.println("voici les informations de l'utilisateur: \n" + name +"\n" + prenom + "\n "+id+ "\n");  
					}

	//				client.stopConnection();  
					break; // Exit cases
				}
				break;

			case "2":
				// Request to insert a user in the table "users"
				System.out.println("########################### INSERT #########################");
				System.out.println("saisissez les informations de l'utilisateur:");
				System.out.println("nom:");
				String nom = sc.nextLine(); // Recovery of the name
				System.out.println("pr�nom:");
				String prenom = sc.nextLine(); // Recovery of the first name
				obj.put("demandType",String.valueOf("INSERT"));
				obj.put("nom",String.valueOf(nom));
				obj.put("prenom",String.valueOf(prenom));
				System.out.println(obj);
				JSONObject reponse = client.sendMessage(obj); // Response server
				String repServer = (String) reponse.get("reponse");  

				if(repServer.equals("insertion r�ussi")) {
					String prenomInsert = (String) reponse.get("prenom");  
					String nomInsert = (String) reponse.get("nom");
					System.out.println(repServer +"\n voici les informations insere: \n" + prenomInsert + "\n " + nomInsert  + "\n");  
				}
				else {
					System.out.println(repServer +"\n");
				}

				String prenomInsert = (String) reponse.get("prenom");  
				String nomInsert = (String) reponse.get("nom");
				System.out.println(repServer +": \n" + prenomInsert + ": \n " + nomInsert  + ": \n");  // Display data
				//client.stopConnection();
				break; // Exit cases

			case "3": 
				// Request to update a user in the table "users"
				System.out.println("########################### UPDATE #########################");
				System.out.println("quel est l'id � modifier?"); 


				String id_update = sc.nextLine();
				Integer id_user_update = Integer.parseInt(id_update);

				System.out.print("le nom ? ");
				String nomUpdate = sc.nextLine(); // Recovery of the name
				System.out.print("le prenom ? ");
				String prenomUpdate = sc.nextLine(); // Recovery of the first name
				obj.put("demandType",String.valueOf("UPDATE"));
				obj.put("nom",String.valueOf(nomUpdate));
				obj.put("prenom",String.valueOf(prenomUpdate));
				obj.put("Id",id_user_update);
				System.out.println(obj);

				JSONObject reponseUdpade = client.sendMessage(obj); // Response server
				String repServerUpdate = (String) reponseUdpade.get("reponse"); 
				if(repServerUpdate.contentEquals("mise � jour reussie")) {
					String prenomUpdate2 = (String) reponseUdpade.get("prenom");  
					String nomupdate2 = (String) reponseUdpade.get("nom");
					long idCaste = (long) reponseUdpade.get("Id");
					int idUpdate = (int) idCaste;
					System.out.println(repServerUpdate +"\n voici les donnees mises a jour: \n" + prenomUpdate2 + "\n " + nomupdate2  + "\n" + idUpdate);
				}
				else {
					System.out.println(repServerUpdate);
				}

				System.out.println(repServerUpdate);

				break; // Exit cases

			case "4" : 
				// Request to delete a user in the table "users"
				System.out.println("########################### DELETE  #########################");
				System.out.println("quel est l'id de l'utilisateur � supprimer ?"); 
				String id_delete = sc.nextLine(); // Recovery of the id
				Integer id_user_delete = Integer.parseInt(id_delete);


				obj.put("demandType",String.valueOf("DELETE"));

				obj.put("Id",String.valueOf(id_user_delete));
				System.out.println(obj);
				JSONObject reponseDelete = client.sendMessage(obj);
				String repServerDelete = (String) reponseDelete.get("reponse");  

				if(repServerDelete.equals("suppression r�ussie")) {
					long idCasteDelete = (long) reponseDelete.get("Id");
					int idDelete = (int) idCasteDelete;
					System.out.println(repServerDelete + "\n Voici l'id de le l'utilisateur � supprimer : " + idDelete);  
				}
				else {
					System.out.println(repServerDelete);
				}

				break; // Exit cases


			case "5":
				// Close all connection and socket
				System.out.println("########################### EXIT #########################");
				System.out.println("Merci de votre visite, A bientot!");
				//client.stopConnection();
				System.exit(0);
				break; // Exit cases 

			case "6": 
				// This case is to show that cannot connect directly to the database 

				client.stopConnection();
		     	c = createConnection(); 
				System.out.println("nom:");
				String nomBDD = sc.nextLine();
				System.out.println("pr�nom:");
				String prenomBDD = sc.nextLine();

			    PreparedStatement stmt3 = c.prepareStatement("insert into utilisateur(nom,prenom) values (?,?);"); // Preparation of the request
				stmt3.setString(1, nomBDD); 
				stmt3.setString(2,prenomBDD);
				stmt3.execute(); // Execution of the request
				break; // Exit cases

			default:
				System.out.println("Unrocognized command"); // If none of the cases, message display "Unrocognized command"
				break; // Exit cases

			}

		}
	}
	
	public static void recupData() throws IOException {
		
		SocketClient client = new SocketClient();	// Socket creation
		client.startConnection("172.31.249.89", 6666); // Start of connection with socket
		
		JSONObject obj=new JSONObject();
		
		System.out.println("########################### SELECT #########################");
		obj.put("demandType",String.valueOf("SELECTT"));
		obj.put("Id",Integer.valueOf(0)); 
		System.out.println(obj);
		JSONObject reponseAll = client.sendMessage(obj);
		ArrayList<JSONObject> allUsers = new ArrayList<JSONObject>();// Creation d'un tableau de type JSONObject
		allUsers = (ArrayList<JSONObject>) reponseAll.get("users");
		System.out.println(allUsers);
		
		
		JSONObject val = allUsers.get(0);
		
		nbtram = (String) val.get("nom");
		System.out.println(nbtram);
		
        JSONObject val2 = allUsers.get(1);
		
		nbauto = (String) val2.get("nom");
		System.out.println(nbauto);
		
		JSONObject val3 = allUsers.get(2);
		
		nbcycliste = (String) val3.get("nom");
		System.out.println(nbcycliste);
		
		JSONObject val4 = allUsers.get(3);
		
		nbpieton = (String) val4.get("nom");
		System.out.println(nbpieton);
		
		disttram = (String) val.get("prenom");
		System.out.println(disttram);
		
		distauto = (String) val2.get("prenom");
		System.out.println(distauto);
		
		distcycliste = (String) val3.get("prenom");
		System.out.println(distcycliste);
		
		distpieton = (String) val4.get("prenom");
		System.out.println(distpieton);
		
		
		
	}
	
	public static void insertData() throws IOException {
		SocketClient client = new SocketClient();	// Socket creation
		client.startConnection("172.31.249.89", 6666); // Start of connection with socket
	
		JSONObject obj=new JSONObject();
		
			System.out.println("########################### INSERT #########################");
			String nom = IHM.textField.getText();// Recovery of the name
			String prenom = IHM.textField_1.getText(); // Recovery of the first name
			obj.put("demandType",String.valueOf("INSERT"));
			obj.put("nom",String.valueOf(nom));
			obj.put("prenom",String.valueOf(prenom));
			System.out.println(obj);
			JSONObject reponse = client.sendMessage(obj); // Response server
			String repServer = (String) reponse.get("reponse");  
			System.out.println("insertion r�ussie");
			
			System.out.println("########################### INSERT #########################");
			String nom2 = IHM.textField_2.getText(); // Recovery of the name
			String prenom2 = IHM.textField_3.getText(); // Recovery of the first name
			obj.put("demandType",String.valueOf("INSERT"));
			obj.put("nom",String.valueOf(nom2));
			obj.put("prenom",String.valueOf(prenom2));
			System.out.println(obj);
			JSONObject reponse2 = client.sendMessage(obj); // Response server
			String repServer2 = (String) reponse.get("reponse");  
			System.out.println("insertion r�ussie");
			
			System.out.println("########################### INSERT #########################");
			String nom3 = IHM.textField_4.getText();; // Recovery of the name
			String prenom3 = IHM.textField_5.getText();; // Recovery of the first name
			obj.put("demandType",String.valueOf("INSERT"));
			obj.put("nom",String.valueOf(nom3));
			obj.put("prenom",String.valueOf(prenom3));
			System.out.println(obj);
			JSONObject reponse3 = client.sendMessage(obj); // Response server
			String repServer3 = (String) reponse.get("reponse");  
			System.out.println("insertion r�ussie");
			
			System.out.println("########################### INSERT #########################");
			String nom4 = IHM.textField_6.getText();; // Recovery of the name
			String prenom4 = IHM.textField_7.getText();; // Recovery of the first name
			obj.put("demandType",String.valueOf("INSERT"));
			obj.put("nom",String.valueOf(nom4));
			obj.put("prenom",String.valueOf(prenom4));
			System.out.println(obj);
			JSONObject reponse4 = client.sendMessage(obj); // Response server
			String repServer4 = (String) reponse.get("reponse");  
			System.out.println("insertion r�ussie");
			
		}
		
	}
