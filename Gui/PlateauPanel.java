package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import plateau.Plateau;
import pieces.*;

public class PlateauPanel extends JPanel {

    private Plateau plateau;

    private int selX=-1;
    private int selY=-1;

    private String joueur="ROUGE";

    private int scoreRouge =0;
    private int scoreNoir=0;

    private JLabel info;
    private JTextArea historique;

    public PlateauPanel(JLabel info,JTextArea historique){

        this.info=info;
        this.historique=historique;

        plateau=new Plateau();

        addMouseListener(new MouseAdapter(){

            public void mouseClicked(MouseEvent e){

                int taille=70;

                int x=e.getY()/taille;
                int y=e.getX()/taille;

                if(selX==-1){

                    if(!plateau.getCase(x,y).estVide()){

                        Piece p=plateau.getCase(x,y).getPiece();

                        if(p.getCouleur().equals(joueur)){

                            selX=x;
                            selY=y;

                        }

                    }

                }
                else{

                    jouer(x,y);

                }

                repaint();
            }

        });
    }

    private void jouer(int x,int y){

        Piece p=plateau.getCase(selX,selY).getPiece();

        int dx=x-selX;
        int dy=y-selY;

        // déplacement simple
        if(Math.abs(dx)==1 && Math.abs(dy)==1 && plateau.getCase(x,y).estVide()){

            plateau.getCase(x,y).setPiece(p);
            plateau.getCase(selX,selY).setPiece(null);

            ajouterHistorique(joueur+" : "+selX+","+selY+" -> "+x+","+y);

            promotion(x,y,p);

            changerTour();
        }

        // capture
        if(Math.abs(dx)==2 && Math.abs(dy)==2){

            int mx=selX+dx/2;
            int my=selY+dy/2;

            if(!plateau.getCase(mx,my).estVide()){

                Piece cible=plateau.getCase(mx,my).getPiece();

                if(!cible.getCouleur().equals(p.getCouleur())){

                    plateau.getCase(mx,my).setPiece(null);

                    if(cible.getCouleur().equals("ROUGE"))
                        scoreNoir++;
                    else
                        scoreRouge++;

                    plateau.getCase(x,y).setPiece(p);
                    plateau.getCase(selX,selY).setPiece(null);

                    ajouterHistorique(joueur+" capture en "+mx+","+my);

                    promotion(x,y,p);

                    verifierVictoire();

                    changerTour();
                }
            }
        }

        selX=-1;
        selY=-1;
    }

    private void ajouterHistorique(String texte){

        historique.append(texte+"\n");

    }

    private void promotion(int x,int y,Piece p){

        if(p.getCouleur().equals("ROUGE") && x==0){

            plateau.getCase(x,y).setPiece(new Dame("ROUGE"));
            ajouterHistorique("Promotion Dame ROUGE");

        }

        if(p.getCouleur().equals("NOIR") && x==7){

            plateau.getCase(x,y).setPiece(new Dame("NOIR"));
            ajouterHistorique("Promotion Dame NOIR");

        }

    }

    private void changerTour(){

        if(joueur.equals("ROUGE"))
            joueur="NOIR";
        else
            joueur="ROUGE";

        info.setText("Tour : "+joueur+
                " | Score Rouge "+ scoreRouge +
                " - Noir "+scoreNoir);
    }

    private void verifierVictoire(){

        if(scoreRouge >=12){

            JOptionPane.showMessageDialog(this,"ROUGE gagne !");
            System.exit(0);
        }

        if(scoreNoir>=12){

            JOptionPane.showMessageDialog(this,"NOIR gagne !");
            System.exit(0);
        }
    }

    protected void paintComponent(Graphics g){

        super.paintComponent(g);

        int taille=70;

        for(int i=0;i<8;i++){

            for(int j=0;j<8;j++){

                if((i+j)%2==0)
                    g.setColor(Color.WHITE);
                else
                    g.setColor(Color.GRAY);

                g.fillRect(j*taille,i*taille,taille,taille);

                if(i==selX && j==selY){

                    g.setColor(Color.GREEN);
                    g.drawRect(j*taille,i*taille,taille,taille);

                }

                Piece p=plateau.getCase(i,j).getPiece();

                if(p!=null){

                    if(p.getCouleur().equals("NOIR"))
                        g.setColor(Color.BLACK);
                    else
                        g.setColor(Color.RED);

                    g.fillOval(j*taille+10,i*taille+10,50,50);

                    if(p instanceof Dame){

                        g.setColor(Color.YELLOW);
                        g.drawString("D",j*taille+30,i*taille+40);

                    }
                }
            }
        }
    }
}