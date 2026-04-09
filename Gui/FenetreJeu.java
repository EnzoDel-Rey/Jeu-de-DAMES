package gui;

import javax.swing.JFrame;

public class FenetreJeu extends JFrame {

    public FenetreJeu(){

        setTitle("Jeu de Dames");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        PlateauPanel panel = new PlateauPanel();

        add(panel);

        setVisible(true);
    }
}