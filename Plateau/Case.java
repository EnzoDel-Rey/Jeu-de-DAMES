package plateau;

import pieces.Piece;

public class Case {

    private Piece piece;

    public boolean estVide(){

        return piece==null;

    }

    public Piece getPiece(){

        return piece;

    }

    public void setPiece(Piece p){

        piece=p;

    }

}