package ProjektDel2;

import java.util.Scanner;

public class Treesort {
    public static void main(String[] args) {

        DictBinTree dbt = new DictBinTree();
        int n = 0;

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            dbt.insert(sc.nextInt());
            n++;
        }
        for (Integer integersInArray : dbt.orderedTraversal()){
            System.out.println(integersInArray);
        }

    }
}

