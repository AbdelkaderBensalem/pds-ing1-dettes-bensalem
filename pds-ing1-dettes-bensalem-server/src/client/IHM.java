package client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import org.json.simple.JSONObject;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Color;

public class IHM {

	JFrame frmSystmeDeCalcul;
	static JTextField textField;
	static JTextField textField_1;
	static JTextField textField_2;
	public static JTextField textField_3;
	public static JTextField textField_4;
	public static JTextField textField_5;
	public static JTextField textField_6;
	public static JTextField textField_7;
	public static JTextField textField_8;
	int resultat;
	int co2voiture;
	int co2tram;
	int co2pieton;
	int co2velo;
	private JTextField textField_9;
	private JTextField textField_10;
			
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IHM window = new IHM();
					window.frmSystmeDeCalcul.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	
	public IHM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSystmeDeCalcul = new JFrame();
		frmSystmeDeCalcul.setBackground(new Color(192, 192, 192));
		frmSystmeDeCalcul.setTitle("Syst\u00E8me de calcul de l'empreinte carbone");
		frmSystmeDeCalcul.setBounds(200, 200, 600, 400);
		frmSystmeDeCalcul.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSystmeDeCalcul.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(144, 238, 144));
		panel.setBounds(0, 0, 584, 361);
		frmSystmeDeCalcul.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Calculer l'empreinte carbone r\u00E9elle ");
		btnNewButton.setBackground(new Color(220, 220, 220));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						
				try {
					Main.recupData();
				} catch (IOException e) {
					 //TODO Auto-generated catch block
					e.printStackTrace();
				}
				/* RECUPERER DANS LA BASE LE NOMBRE D'UTILISATEURS (NBR DE LIGNE DE LA TABLE) DANS DES VARIABLES :
				NombreUserVelo , NombreUserVoiture, NombreUserTram, NombreUserPieton
				RECUPERER SOMME COLONNE DISTANCEMOY DANS DES VARIABLES :
				DistancMoyVelo, DistancMoyVoiture, DistancMoyTram, DistancMoyPieton
				LES PLACER DANS LES TEXTFIELD */
				
				textField_2.setText(Main.nbauto);
				textField.setText(Main.nbtram);
				textField_4.setText(Main.nbcycliste);
				textField_6.setText(Main.nbpieton);
				
				textField_1.setText(Main.distauto);
				textField_3.setText(Main.disttram);
				textField_5.setText(Main.distcycliste);
				textField_7.setText(Main.distpieton);
				
				co2tram = (Integer.parseInt(textField.getText()) * Integer.parseInt(textField_1.getText()) * 3) / 100;
				co2voiture = (Integer.parseInt(textField_2.getText()) * Integer.parseInt(textField_3.getText()) * 166);
				co2velo = (Integer.parseInt(textField_4.getText()) * Integer.parseInt(textField_5.getText()) * 15);
				co2pieton = (Integer.parseInt(textField_6.getText()) * Integer.parseInt(textField_7.getText()) * 10);
				
				resultat = co2tram+co2voiture+co2velo+co2pieton;
				textField_8.setText(String.valueOf(resultat/1000));
				
				//textField.setText(Main.);
				//textField_2.setText(Main.nbauto);
				//textField_4.setText(Main.nbcycliste);
				//textField_6.setText(Main.nbpieton);
				/*textField_1.setText(String.valueOf(13));
				textField_2.setText(String.valueOf(495));
				textField_3.setText(String.valueOf(27));
				textField_4.setText(String.valueOf(93));
				textField_5.setText(String.valueOf(9));
				textField_6.setText(String.valueOf(975));
				textField_7.setText(String.valueOf(3));
				
				co2tram = (Integer.parseInt(textField.getText()) * Integer.parseInt(textField_1.getText()) * 3) / 100;
				co2voiture = (Integer.parseInt(textField_2.getText()) * Integer.parseInt(textField_3.getText()) * 166);
				co2velo = (Integer.parseInt(textField_4.getText()) * Integer.parseInt(textField_5.getText()) * 15);
				co2pieton = (Integer.parseInt(textField_6.getText()) * Integer.parseInt(textField_7.getText()) * 10);
				
				resultat = co2tram+co2voiture+co2velo+co2pieton;
				textField_8.setText(String.valueOf(resultat/1000));*/
			}
		});
		btnNewButton.setBounds(64, 248, 210, 35);
		panel.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(193, 28, 60, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(431, 28, 72, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(166, 72, 87, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(431, 72, 72, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(141, 116, 112, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(431, 116, 72, 20);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(141, 158, 111, 20);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(431, 158, 72, 20);
		panel.add(textField_7);
		
		JButton btnNewButton_1 = new JButton("Lancer la Simulation");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				Main.insertData();
					
				co2tram = (Integer.parseInt(textField.getText()) * Integer.parseInt(textField_1.getText()) * 3) / 100;
				co2voiture = (Integer.parseInt(textField_2.getText()) * Integer.parseInt(textField_3.getText()) * 166);
				co2velo = (Integer.parseInt(textField_4.getText()) * Integer.parseInt(textField_5.getText()) * 15);
				co2pieton = (Integer.parseInt(textField_6.getText()) * Integer.parseInt(textField_7.getText()) * 10);
				
				resultat = co2tram+co2voiture+co2velo+co2pieton;
				textField_10.setText(String.valueOf(resultat/1000)); 
				
				int valreelle = Integer.parseInt(textField_8.getText());
				int valsimu = Integer.parseInt(textField_10.getText());
				
				if(valreelle<valsimu){
					textField_9.setText("Votre simulation ne permet pas de baisser le taux de pollution"); 
				}
				else {
					textField_9.setText("Votre simulation permet de baisser le taux de pollution"); 
				}
				}
				catch (Exception e) {
					Msgerreur window = new Msgerreur();
					window.frame.setVisible(true);
				}
			}
		});
		btnNewButton_1.setBounds(306, 248, 167, 35);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Nombre d'usagers \r\ndu tramway");
		lblNewLabel.setBounds(10, 28, 185, 20);
		panel.add(lblNewLabel);
		
		JLabel lblNombreDautomobilistes = new JLabel("Nombre d'automobilistes");
		lblNombreDautomobilistes.setBounds(10, 72, 158, 20);
		panel.add(lblNombreDautomobilistes);
		
		JLabel lblNombreDeCyclistes = new JLabel("Nombre de cyclistes");
		lblNombreDeCyclistes.setBounds(10, 116, 138, 20);
		panel.add(lblNombreDeCyclistes);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nombre de pi\u00E9tons");
		lblNewLabel_2_1.setBounds(12, 158, 136, 20);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblDistanceMoyennekm = new JLabel("Distance moyenne (km)");
		lblDistanceMoyennekm.setBounds(286, 158, 143, 20);
		panel.add(lblDistanceMoyennekm);
		
		JLabel lblDistanceMoyennekm_1 = new JLabel("Distance moyenne (km)");
		lblDistanceMoyennekm_1.setBounds(287, 116, 142, 20);
		panel.add(lblDistanceMoyennekm_1);
		
		JLabel lblDistanceMoyennekm_1_1 = new JLabel("Distance moyenne (km)");
		lblDistanceMoyennekm_1_1.setBounds(287, 72, 142, 20);
		panel.add(lblDistanceMoyennekm_1_1);
		
		JLabel lblDistanceMoyennekm_1_2 = new JLabel("Distance moyenne (km)");
		lblDistanceMoyennekm_1_2.setBounds(287, 28, 142, 20);
		panel.add(lblDistanceMoyennekm_1_2);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(142, 203, 111, 20);
		panel.add(textField_8);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Total r\u00E9el (en kg)");
		lblNewLabel_2_1_1.setBounds(44, 203, 138, 20);
		panel.add(lblNewLabel_2_1_1);
		
		textField_9 = new JTextField();
		textField_9.setBounds(96, 305, 355, 20);
		panel.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(417, 203, 86, 20);
		panel.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Estimation (en kg)");
		lblNewLabel_2_1_1_1.setBounds(315, 203, 92, 20);
		panel.add(lblNewLabel_2_1_1_1);
	}

		
}
