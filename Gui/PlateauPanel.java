package gui;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

import plateau.Plateau;
import pieces.Piece;

public class PlateauPanel extends JPanel {

    private Plateau plateau;

    public PlateauPanel(){
        plateau = new Plateau();
    }

    @Override
    protected void paintComponent(Graphics g){

        super.paintComponent(g);

        int taille = 70;

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){

                if((i+j)%2==0)
                    g.setColor(Color.WHITE);
                else
                    g.setColor(Color.GRAY);

                g.fillRect(j*taille,i*taille,taille,taille);

                Piece p = plateau.getCase(i,j).getPiece();

                if(p!=null){

                    if(p.getCouleur().equals("NOIR"))
                        g.setColor(Color.BLACK);
                    else
                        g.setColor(Color.RED);

                    g.fillOval(j*taille+10,i*taille+10,50,50);
                }
            }
        }

    }
}