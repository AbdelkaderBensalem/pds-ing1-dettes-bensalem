package server;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class ThreadServer extends Thread {
	private Socket clientSocket; 
	public PrintWriter outJson;
	private BufferedReader inJson;
	private Connection c; 
	
public ThreadServer (Socket socket,Connection connection){
	this.clientSocket = socket;
	this.c = connection; 
}
	public void run()  {
		try {
			outJson = new PrintWriter(clientSocket.getOutputStream(), true);
			inJson = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			do {
				
				InputStream inputStream = FileReader.class.getClassLoader().getSystemResourceAsStream("simulation.json"); 
				
				// processing part of Json 
				outJson = new PrintWriter(clientSocket.getOutputStream(), true);
				inJson = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				// PAS COMMENTAIRE this.bornes = new Borne(this.c);
				Object obj1 = new Object();
				String resp = inJson.readLine();
				System.out.println("----bonjour je viens de récuperer le JSON");
				System.out.println(resp);
				Object obj=JSONValue.parse(resp); 
				System.out.println("----bonjour je parse le JSON");
				System.out.println(resp);
				JSONObject jsonObject = (JSONObject) obj;  
				System.out.println("----bonjour je viens de parser le JSON");
				System.out.println(resp);
				
				obj = crud(jsonObject); 
				// Once the Json had been processed, closing the socket and releasing the connection

				outJson.println(obj);
			
				}while(!clientSocket.isClosed());

			}catch (Exception e) {
				System.out.println("--------Un client s'est déconnecté de manière précipitée !-------");
				System.out.println(e.getMessage());
			} 
		DBConnectController.clientsState(false);
}

	private JSONObject crud(JSONObject JsonRecu) {
	try {
			if(JsonRecu.get("demandType").equals("SELECT")) {
				long idcaste = Long.valueOf(JsonRecu.get("Id").toString());
				int idJson = (int) idcaste;
				System.out.println("bonjour voici le ID recu apres traitement");
				System.out.println(idJson);
				if(idJson == 0) {

					PreparedStatement stmt1 = c.prepareStatement("select * from utilisateur;");
					ResultSet rs2 = stmt1.executeQuery();

					JSONObject obj=new JSONObject();
					// creation of users list 
					ArrayList<JSONObject> listUsers = new ArrayList<JSONObject>();

					while (rs2.next()) {
						JSONObject user=new JSONObject();
						// recovery of each user's data (id/ name/ first name) 
						user.put("Id", rs2.getInt("id_user"));
						user.put("nom", rs2.getString("nom"));
						user.put("prenom", rs2.getString("prenom"));

						// adding each user to the list already created
						listUsers.add(user);


					}
					//System.out.println("voici l'arrayList : ");
					// displaying the list 
					//System.out.println(listUsers);

					obj.put("users", listUsers);
					System.out.println("voici le json envoyé avec le select All: ");
					// displaying the Json
					System.out.println(obj);
					Thread.sleep(3000); 
					return obj; 
				}
				else {
					PreparedStatement stmtJson = c.prepareStatement("select * from utilisateur where id_user = ?");
					stmtJson.setInt(1, idJson);
					ResultSet jsonResponse = stmtJson.executeQuery();
					JSONObject obj=new JSONObject(); 
					int cpt = 0;

					while (jsonResponse.next()) {
						//recovery of the data of the user in question 
						cpt++;
						obj.put("Id",jsonResponse.getInt("id_user"));
						obj.put("nom",jsonResponse.getString("nom"));
						obj.put("prenom",jsonResponse.getString("prenom"));
					}
					if(cpt == 0) {
						obj.put("reponse", "verifier l'id insere");
					}
					// displaying the json 
					System.out.println(obj);
					Thread.sleep(3000); 
					return obj; 
				}
			}

			if(JsonRecu.get("demandType").equals("INSERT")) {
				System.out.println("Je suis rentré dans la requête INSERT"); 
				// recovery of data that the client had completed (name / first name
				String nomInsert =(String) JsonRecu.get("nom");
				String prenomInsert =(String) JsonRecu.get("prenom");
				System.out.println("bonjour voici les donnees recu apres traitement");
				System.out.println(nomInsert +  " " + prenomInsert);

				PreparedStatement stmt3 = c.prepareStatement("insert into utilisateur(nom,prenom) values (?,?);");
				// the request takes name and first name already retrieved 
				stmt3.setString(1, nomInsert);
				stmt3.setString(2,prenomInsert);
				// query execution 


				JSONObject obj=new JSONObject(); 

				// if (insertion bien passé) => executer les lignes suivantes sinon dire erreur
				if(stmt3.executeUpdate()>=1) {
					obj.put("reponse",String.valueOf("insertion reussi"));
					obj.put("nom",String.valueOf(nomInsert));
					obj.put("prenom",String.valueOf(prenomInsert));
				}
				else {
					obj.put("reponse",String.valueOf("erreur lors de l'insertion"));
				}
				System.out.println(obj);
				return obj; 
			}
		}
			catch (Exception e) {
				e.printStackTrace();
			} 
			// Case where no if is checked 
			return new JSONObject();
			}
}