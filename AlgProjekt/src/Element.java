

public class Element {

    private int key;
    private Object data;
    public int getKey(){
        return this.key;
    }

    public Element(int i, Object o){
        this.key = i;
        this.data = o;
    }

    public Object getData(){
        return this.data;
    }
}
