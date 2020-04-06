package ProjektDel2;

public class BinNode {

    private BinNode top;
    private BinNode left;
    private BinNode right;
    private int key;


    // Constructor til BinNode, som er en knude til brug i DictBinTree
    // Bladene instantieres til at være null og key er index
    public BinNode (int key){

        this.top = null;
        this.left = null;
        this.right = null;
        this.key = key;

    }


    // Setters og Getters

    public BinNode getTop() {
        return top;
    }

    public void setTop(BinNode top) {
        this.top = top;
    }

    public BinNode getLeft() {
        return left;
    }

    public void setLeft(BinNode left) {
        this.left = left;
    }

    public BinNode getRight() {
        return right;
    }

    public void setRight(BinNode right) {
        this.right = right;
    }

    public int getKey() {
        return key;
    }
}
