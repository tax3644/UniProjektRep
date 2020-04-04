package ProjektDel2;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class DictBinTree implements Dict{




    private Map<Integer, BinNode> treemap1;
    private int key;
    private BinNode root = null;


    public DictBinTree () {
        treemap1 = new TreeMap<>();
        this.key = key;

    }


    @Override
    public void insert(int k) {
        BinNode y = null;
        BinNode x = this.root;
        BinNode z = new BinNode(k);

        while(x != null){
            y = this.root;
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


    /*--- SLET FØR AFLEVERING ELLER IMPLEMENTER OM!!!!!!!! ellers er det plagiat ---*/
    void inorder()  {
        inorderRec(this.root);
    }

    // A utility function to do inorder traversal of BST
    void inorderRec(BinNode root) {
        if (root != null) {
            inorderRec(root.getLeft());
            System.out.println(root.getKey());
            inorderRec(root.getRight());
        }
    }


    @Override
    public ArrayList<Integer> orderedTraversal() {
        return null;
    }

    @Override
    public boolean search(int k) {
        return false;
    }
}
