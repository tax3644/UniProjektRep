package ProjektDel2;

/*
Navne:
Tobias Albers Andersen
Jann Jacobsen
----------------------
SDU-login:
toand17@student.sdu.dk
jajac18@student.sdu.dk
*/

import java.util.ArrayList;

public class DictBinTree implements Dict{

    // Root er træets rod og fungerer i starten som et tomt dictionary
    // OrderedArray benyttes til at returnerer en sorteret ArrayList
    private BinNode root;
    private ArrayList<Integer> orderedArray;

    public DictBinTree() {
        this.orderedArray = new ArrayList<>();
        this.root = null;
    }

    // Vi overwriter insert() metoden fra interfacet Dict og implementerer den ud fra given pseudokode
    @Override
    public void insert(int k) {
        BinNode y = null;
        BinNode x = this.root;
        BinNode z = new BinNode(k);

        // Vi tjekker at x ikke er null og fortsætter loopet i så fald, og x peger på 'root'
        while(x != null){
            y = x;

            // Hvis z's key er mindre et x's key assigner vi x til dens venstre nabo, ellers til dens højre
            if (z.getKey() < x.getKey()){
                x = x.getLeft();
            } else x = x.getRight();
        }

        // Den lokale variabel z peger på et nyt BinNode objekt skabt ud fra nøglen k
        // Vi sætter z's rod til at være y, hvis y er null har vi ikke været inde i insert() metodens
        // while-løkke og nedenstående blok samler op efter insert() metodens logik
        z.setTop(y);
        if (y == null){

            // Hvis y er null sætter vi roden til at være z
            this.root = z;

        // Tjekker om z skal være y's venstre eller højre nabo
        } else if (z.getKey() < y.getKey()) {
            y.setLeft(z);
        } else y.setRight(z);
    }


    // orderedTraversel er en public metode som kalder på den private metode returnOrderedArray
    // sådan at vi er garanteret at root bliver returneret i form af en ordnet ArrayList af heltal
    // Hvis x er null returneres en tom ArrayList
    @Override
    public ArrayList<Integer> orderedTraversal() {
        return returnOrderedArray(this.root);
    }

    private ArrayList<Integer> returnOrderedArray(BinNode x){

        // Tjekker om x er null, da vi ellers ikke har noget at ordne og returnere
        if (x != null){

            // Kalder rekursivt på returnOrderedArray() både for venstre nabo og højre nabo
            returnOrderedArray(x.getLeft());
            this.orderedArray.add(x.getKey());
            returnOrderedArray(x.getRight());
        }
        return orderedArray;
    }


    // Søge-metode fra Dict interface, returnerer en boolean som angivelse af søgeresultat, true betyder at
    // elementet blev fundet i træet
    @Override
    public boolean search(int k) {
        BinNode x = this.root;

        // Imens at x ikke er null og int k ikke har samme værdi som x, så vil vi fortsætte søgning ned gennem træet
        while (x != null && k != x.getKey()) {
            if (k<x.getKey()){
                x = x.getLeft();
            } else x = x.getRight();
        }

        return x != null;
    }
}
