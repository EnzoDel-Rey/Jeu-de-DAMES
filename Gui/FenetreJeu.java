package gui;

import javax.swing.*;
import java.awt.*;

public class FenetreJeu extends JFrame {

    public FenetreJeu(){

        setTitle("Jeu de Dames");
        setSize(850,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JLabel info = new JLabel("Tour : ROUGE");
        info.setFont(new Font("Arial",Font.BOLD,18));
        info.setHorizontalAlignment(JLabel.CENTER);

        JTextArea historique = new JTextArea();
        historique.setEditable(false);

        JScrollPane scroll = new JScrollPane(historique);
        scroll.setPreferredSize(new Dimension(200,600));

        PlateauPanel plateau = new PlateauPanel(info,historique);

        add(info,BorderLayout.NORTH);
        add(plateau,BorderLayout.CENTER);
        add(scroll,BorderLayout.EAST);

        setVisible(true);
    }
}