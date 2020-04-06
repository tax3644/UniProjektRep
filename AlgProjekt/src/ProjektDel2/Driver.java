package ProjektDel2;

public class Driver {

    public static void main(String[] args) {

        DictBinTree dbt = new DictBinTree();

        dbt.insert(12);
        dbt.insert(18);
        dbt.insert(-19);
        dbt.insert(15);
        dbt.insert(17);
        dbt.insert(13);
        dbt.insert(5);
        dbt.insert(-2);
        dbt.insert(9);

        System.out.println(dbt.search(20));
        System.out.println(dbt.orderedTraversal());
    }
}
