package pieces;

public abstract class Piece {

    protected String couleur;

    public Piece(String c){

        couleur=c;

    }

    public String getCouleur(){

        return couleur;

    }
}