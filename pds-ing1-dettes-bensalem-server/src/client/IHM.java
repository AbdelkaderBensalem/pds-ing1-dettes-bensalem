package client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Color;

public class IHM {

	private JFrame frmSystmeDeCalcul;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

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
		frmSystmeDeCalcul.setBounds(100, 100, 469, 333);
		frmSystmeDeCalcul.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSystmeDeCalcul.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(144, 238, 144));
		panel.setBounds(0, 0, 453, 294);
		frmSystmeDeCalcul.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Calculer l'empreinte carbone r\u00E9elle");
		btnNewButton.setBackground(new Color(220, 220, 220));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(23, 248, 210, 35);
		panel.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(163, 28, 60, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(356, 28, 72, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(356, 158, 72, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(136, 72, 86, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(356, 72, 72, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(121, 116, 101, 20);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(111, 158, 111, 20);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(356, 116, 72, 20);
		panel.add(textField_7);
		
		JButton btnNewButton_1 = new JButton("Lancer la Simulation");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNewButton_1.setBounds(262, 248, 167, 35);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Nombre d'usagers \r\ndu tramway");
		lblNewLabel.setBounds(10, 28, 154, 20);
		panel.add(lblNewLabel);
		
		JLabel lblNombreDautomobilistes = new JLabel("Nombre d'automobilistes");
		lblNombreDautomobilistes.setBounds(10, 72, 116, 20);
		panel.add(lblNombreDautomobilistes);
		
		JLabel lblNombreDeCyclistes = new JLabel("Nombre de cyclistes");
		lblNombreDeCyclistes.setBounds(10, 116, 100, 20);
		panel.add(lblNombreDeCyclistes);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nombre de pi\u00E9tons");
		lblNewLabel_2_1.setBounds(12, 158, 100, 20);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblDistanceMoyennekm = new JLabel("Distance moyenne (km)");
		lblDistanceMoyennekm.setBounds(232, 161, 114, 20);
		panel.add(lblDistanceMoyennekm);
		
		JLabel lblDistanceMoyennekm_1 = new JLabel("Distance moyenne (km)");
		lblDistanceMoyennekm_1.setBounds(232, 116, 114, 20);
		panel.add(lblDistanceMoyennekm_1);
		
		JLabel lblDistanceMoyennekm_1_1 = new JLabel("Distance moyenne (km)");
		lblDistanceMoyennekm_1_1.setBounds(232, 72, 114, 20);
		panel.add(lblDistanceMoyennekm_1_1);
		
		JLabel lblDistanceMoyennekm_1_2 = new JLabel("Distance moyenne (km)");
		lblDistanceMoyennekm_1_2.setBounds(232, 28, 114, 20);
		panel.add(lblDistanceMoyennekm_1_2);
	}
}
