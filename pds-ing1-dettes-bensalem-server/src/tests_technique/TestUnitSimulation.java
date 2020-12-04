package tests_technique;

public class TestUnitSimulation {

	public static void main(String[] args) {
		   System.out.println("\n Les données saisies par l'utilisateur sont : \n NbrUsersTram : " + 550 + "\n DistMoyTram : " + 8);
		   System.out.println(" NbrUsersAuto : " + 325+ "\n DistMoyAuto : " +3);
		   System.out.println(" NbrUsersVelo : " + 400+ "\n DistMoyVelo : " + 8);
		   System.out.println(" NbrUsersPieton : " + 1200 + "\n DistMoyPieton : " + 4);
		   
		    int co2tram = (550*8*3) / 100;
			int co2voiture = (325 * 3 * 166);
			int co2velo = (400 * 8 * 15);
			int co2pieton = (1200 * 4 * 10);
			
			int resultat = co2tram+co2voiture+co2velo+co2pieton;
			int dernierResultat = resultat/1000;
			
		   System.out.println("\n Après calcul, la valeur retournée est la suivante : " + dernierResultat +" kg de co2");

	}

}
