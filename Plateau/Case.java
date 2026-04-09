package plateau;

import pieces.Piece;

public class Case {

    private Piece piece;

    public Case() {
        piece = null;
    }

    public boolean estVide() {
        return piece == null;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}