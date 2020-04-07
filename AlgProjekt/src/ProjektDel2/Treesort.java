package ProjektDel2;

import java.util.Scanner;

public class Treesort {
    public static void main(String[] args) {

        //Laver et tomt nyt dictionary kaldet dbt
        DictBinTree dbt = new DictBinTree();
        int n = 0;

        //Henter inputtet fra scanneren
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            dbt.insert(sc.nextInt());
            n++;
        }

        //printer alle integers i arrayet
        for (Integer integersInArray : dbt.orderedTraversal()){
            System.out.println(integersInArray);
        }

    }
}

