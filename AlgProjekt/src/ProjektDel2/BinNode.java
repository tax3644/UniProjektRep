package ProjektDel2;

public class BinNode {

    private BinNode top;
    private BinNode left;
    private BinNode right;
    private int key;


    public BinNode (int key){

        this.top = null;
        this.left = null;
        this.right = null;
        this.key = key;

    }

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

    public void setKey(int key) {
        this.key = key;
    }
}
