package ui;

import javax.swing.*;
import javax.swing.border.Border;

import fc.CD;
import fc.ErreurRenduException;
import fc.FacadeNf;
import fc.Film;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtmMenu extends JPanel {
	private JButton connexionButton;
	private JButton rendreButton;
	
	private JButton creationDeCompteButton;
	private JButton histoBtn;
	private JButton filtreBtn;
	private FacadeNf out;

	public BtmMenu(JPanel panelAff, FacadeNf out) {
		super();

		setLayout(new FlowLayout());
		this.out = out;
		connexionButton = new JButton("Connexion");
		rendreButton = new JButton("Rendre");
		creationDeCompteButton = new JButton("Créer");

		//Bouton conditionnel à la connexion
		histoBtn = new JButton("historique");
		histoBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelAff.removeAll();
				panelAff.add(new Historique(panelAff, out));
				panelAff.revalidate();
				panelAff.repaint();
			}
		});
		
		filtreBtn = new JButton("Ajouter Filtre");
		
		add(rendreButton);
		
		add(connexionButton);
		add(creationDeCompteButton);

		rendreButton.addActionListener(new RendreAction(this, panelAff));
		connexionButton.addActionListener(new ConnexionAction(this, panelAff, out));
		

		creationDeCompteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelAff.removeAll();
				panelAff.add(new Souscription());
				panelAff.revalidate();
				panelAff.repaint();
			}
		});
	}

	public JButton getHistoBtn() {
		return histoBtn;
	}
	
	public JButton getFiltreBtn() {
		return filtreBtn;
	}
	
	public JButton getConnexionButton() {
		return connexionButton;
	}
	
	private class ConnexionAction implements ActionListener {
		private JPanel btmPanel;
		private JPanel panelAff;
		private FacadeNf out;

		public ConnexionAction(JPanel panel, JPanel panelAff, FacadeNf out) {
			super();
			this.btmPanel = panel;
			this.panelAff = panelAff;
			this.out = out;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// changement affichage central
			panelAff.removeAll();
			
			panelAff.add(new Connexion(panelAff, (BtmMenu) btmPanel, out));
			panelAff.revalidate();
			panelAff.repaint();
		}
	}

	private class RendreAction implements ActionListener {
		private JPanel btmPanel;
		private JPanel panelAff;

		public RendreAction(JPanel panel, JPanel panelAff) {
			super();
			this.btmPanel = panel;
			this.panelAff = panelAff;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Rendre
			JPanel dmgPanel = new JPanel(new GridLayout(2,1));
			JPanel numPanel = new JPanel(new GridLayout(2,1));
			JTextField locField = new JTextField();
			JLabel dmgLabel = new JLabel();
			JLabel numLabel = new JLabel();
			JButton valButton = new JButton("Validation");
			JCheckBox dmgdBox = new JCheckBox();
			
			

			dmgLabel.setText("Cocher si le cd a ete endommage");
			numLabel.setText("Entrer votre numero de location");

			dmgPanel.add(dmgLabel);
			dmgPanel.add(dmgdBox);

			numPanel.add(numLabel);
			numPanel.add(locField);

			panelAff.removeAll();
			panelAff.add(numPanel,BorderLayout.WEST);
			panelAff.add(dmgPanel,BorderLayout.EAST);
			panelAff.add(valButton,BorderLayout.SOUTH);

			panelAff.revalidate();
			panelAff.repaint();

			valButton.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					try {
						String numStr = locField.getText();
						int num = Integer.parseInt(numStr);
						boolean damage = dmgdBox.isSelected();

						Film aRendre = new Film("logan lucky", "comedie");
						//loc logan lucky num 110
						CD film = new CD(aRendre, false);
						out.rendre(num, film, damage); 

						JOptionPane.showMessageDialog(null, " Votre rendu a ete effectué", "Rendu",
							JOptionPane.INFORMATION_MESSAGE);
					} 
					catch(ErreurRenduException e2){
						JOptionPane.showMessageDialog(null, "Le rendu a échoué", "Il n'y a pas de location a ce numero",
							JOptionPane.ERROR_MESSAGE);
					e2.printStackTrace();
					}
					catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Le rendu a échoué", "Il y a un soucis au niveau de vos insertion",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
					}
				}
			});


		}

	}

	private class EmprunterAction implements ActionListener {
		private JPanel btmPanel;
		private JPanel panelAff;

		public EmprunterAction(JPanel panel, JPanel panelAff) {
			super();
			btmPanel = panel;
			this.panelAff = panelAff;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Emprunt

		}
	}

	private class CreerAction implements ActionListener {
		private JPanel btmPanel;
		private JPanel panelAff;

		public CreerAction(JPanel panel, JPanel panelAff) {
			super();
			btmPanel = panel;
			this.panelAff = panelAff;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO creation d un compte
			// Lance la fenetre souscrire

		}
	}
}
