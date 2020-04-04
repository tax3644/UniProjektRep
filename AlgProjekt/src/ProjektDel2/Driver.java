package ProjektDel2;

import java.util.Map;

public class Driver {

    public static void main(String[] args) {

        DictBinTree dbt = new DictBinTree();

        dbt.insert(10);
        dbt.insert(15);
        dbt.insert(200);
        dbt.insert(-20);
        dbt.insert(30);
        dbt.insert(45);

        dbt.inorder();


    }

}
