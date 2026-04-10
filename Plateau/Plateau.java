package plateau;

import pieces.Pion;

public class Plateau {

    private Case[][] cases;

    public Plateau(){

        cases=new Case[8][8];

        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                cases[i][j]=new Case();

        initialiser();
    }

    private void initialiser(){

        for(int i=0;i<3;i++)
            for(int j=0;j<8;j++)
                if((i+j)%2==1)
                    cases[i][j].setPiece(new Pion("NOIR"));

        for(int i=5;i<8;i++)
            for(int j=0;j<8;j++)
                if((i+j)%2==1)
                    cases[i][j].setPiece(new Pion("ROUGE"));
    }

    public Case getCase(int x,int y){

        return cases[x][y];

    }
}