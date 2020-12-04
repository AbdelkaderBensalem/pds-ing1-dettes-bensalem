package tests_technique;

import java.util.ArrayList;

import org.json.simple.JSONObject;

public class TestRecupdata {

	public static void main(String[] args) {
		
		JSONObject Data1 = new JSONObject();
	    Data1.put("id", 1);
	    Data1.put("nbusers", 500);
	    Data1.put("distmoy", 7);
	    
	    JSONObject Data2 = new JSONObject();
	    Data2.put("id", 2);
	    Data2.put("nbusers", 350);
	    Data2.put("distmoy", 5);
	    
	    JSONObject Data3 = new JSONObject();
	    Data3.put("id", 3);
	    Data3.put("nbusers", 425);
	    Data3.put("distmoy", 10);
	    
	    JSONObject Data4 = new JSONObject();
	    Data4.put("id", 4);
	    Data4.put("nbusers", 1000);
	    Data4.put("distmoy", 3);
	    
	    ArrayList<JSONObject> allData = new ArrayList<JSONObject>();
	    allData.add(Data1);
	    allData.add(Data2);
	    allData.add(Data3);
	    allData.add(Data4);
	    
	    System.out.println("Le fichier JSON est le suivant : " + allData);
	    
	   System.out.println("\n Les données suivantes sont récupérées : \n NbrUsersTram : " + Data1.get("nbusers")+ "\n DistMoyTram : " + Data1.get("distmoy"));
	   System.out.println(" NbrUsersAuto : " + Data2.get("nbusers")+ "\n DistMoyAuto : " + Data2.get("distmoy"));
	   System.out.println(" NbrUsersVelo : " + Data3.get("nbusers")+ "\n DistMoyVelo : " + Data3.get("distmoy"));
	   System.out.println(" NbrUsersPieton : " + Data4.get("nbusers")+ "\n DistMoyPieton : " + Data4.get("distmoy"));
	   
	    int co2tram = (500*7*3) / 100;
		int co2voiture = (350 * 5 * 166);
		int co2velo = (425 * 10 * 15);
		int co2pieton = (1000 * 3 * 10);
		
		int resultat = co2tram+co2voiture+co2velo+co2pieton;
		int dernierResultat = resultat/1000;
		
	   System.out.println("\n Après calcul, la valeur retournée est la suivante : " + dernierResultat +" kg de co2");
	   
	}

}
