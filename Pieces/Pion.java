package pieces;

public class Pion extends Piece {

    public Pion(String couleur) {
        super(couleur);
    }

    @Override
    public String getType() {
        return "PION";
    }
}