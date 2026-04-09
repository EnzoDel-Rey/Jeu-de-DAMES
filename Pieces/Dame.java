package pieces;

public class Dame extends Piece {

    public Dame(String couleur) {
        super(couleur);
    }

    @Override
    public String getType() {
        return "DAME";
    }
}