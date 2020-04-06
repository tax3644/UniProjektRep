package ProjektDel2;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class DictBinTree implements Dict{


    private Map<Integer, BinNode> treemap1;
    private BinNode root = null;
    private ArrayList<Integer> orderedArray = new ArrayList<>();

    public DictBinTree() {
        treemap1 = new TreeMap<>();
    }


    @Override
    public void insert(int k) {
        BinNode y = null;
        BinNode x = this.root;
        BinNode z = new BinNode(k);

        while(x != null){
            y = x;
            if (z.getKey() < x.getKey()){
                x = x.getLeft();
            } else x = x.getRight();
        }
        z.setTop(y);
        if (y == null){
            this.root = z;
        } else if (z.getKey() < y.getKey()) {
            y.setLeft(z);
        } else y.setRight(z);
    }


    @Override
    public ArrayList<Integer> orderedTraversal() {
        return returnOrderedArray(this.root);
    }

    private ArrayList<Integer> returnOrderedArray(BinNode x){
        if (x != null){
            returnOrderedArray(x.getLeft());
            this.orderedArray.add(x.getKey());
            returnOrderedArray(x.getRight());
        }
        return orderedArray;
    }


    @Override
    public boolean search(int k) {
        BinNode x = this.root;
        while (x != null && k != x.getKey()) {
            if (k<x.getKey()){
                x = x.getLeft();
            } else x = x.getRight();
        }

        return x != null;
    }
}
