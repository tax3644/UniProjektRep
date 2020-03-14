package Semester_2.AlgoritmerOgDatastrukturer.ProjektDel1;


import java.util.ArrayList;

public class PQHeap implements PQ {

    ArrayList<Element> heapArray;

    //Constructor of empty ArrayList
    PQHeap () {
        this.heapArray = new ArrayList<>();
    }



    public static void main(String[] args) {

        PQHeap heap1 = new PQHeap();

        Element elementm1 = new Element(2, "Integer");
        Element elementm2 = new Element(2, "Integer");
        Element elementm3 = new Element(2, "Integer");
        Element elementm4 = new Element(2, "Integer");
        Element elementm5 = new Element(2, "Integer");
        Element elementm6 = new Element(2, "Integer");
        Element elementm7 = new Element(2, "Integer");
        Element elementm8 = new Element(2, "Integer");
        Element elementm9 = new Element(2, "Integer");
        Element elementm10 = new Element(2, "Integer");
        Element elementm11 = new Element(2, "Integer");
        Element elementm12 = new Element(2, "Integer");
        Element elementm13 = new Element(2, "Integer");
        Element elementm14 = new Element(2, "Integer");

        heap1.insert(elementm1);
        heap1.insert(elementm2);
        heap1.insert(elementm3);
        heap1.insert(elementm4);
        heap1.insert(elementm5);
        heap1.insert(elementm6);
        heap1.insert(elementm7);
        heap1.insert(elementm8);
        heap1.insert(elementm9);
        heap1.insert(elementm10);
        heap1.insert(elementm11);
        heap1.insert(elementm12);
        heap1.insert(elementm13);
        heap1.insert(elementm14);


        heap1.minHeapifyMachine();

        Element lowestElement;
        int counter = 0;

        while (heap1.heapArray.size()>0){
            lowestElement = heap1.extractMin();
            counter++;
            System.out.println(counter + " - Element is: " + lowestElement.getKey());
        }

        System.out.println("lol");
    }

    private void minHeapifyMachine(){
        for (int i = heapArray.size() / 2; i >= 0; i--) {
            minHeapify(i);
        }
    }
    private void minHeapify(int i) {

        int left = left(i);
        int right = right(i);
        int smallest;

        if (left<=heapArray.size() - 1 && heapArray.get(left).getKey() < heapArray.get(i).getKey()){
            smallest = left;
        } else { smallest = i; }
        if (right <= heapArray.size() - 1 && heapArray.get(right).getKey() < heapArray.get(smallest).getKey()) {
            smallest = right;
        }
        if (smallest != i) {

            exchange(heapArray.get(i), heapArray.get(smallest), i, smallest);
            minHeapify(smallest);
        }
    }

    private int left(int i){
        return i * 2 + 1;
    }
    private int right(int i) {
        return i * 2 + 2;
    }
    public int parent(int i){
        if (i % 2 == 1){
            return (i - 1) / 2;
        }
        return (i - 2) / 2;
    }
    private void exchange(Element elementOne, Element elementTwo, int indexOne, int indexTwo){
        heapArray.set(indexOne, elementTwo);
        heapArray.set(indexTwo, elementOne);
    }


    @Override
    public Element extractMin() {
        Element min = heapArray.get(0);
        heapArray.set(0, heapArray.get(heapArray.size()-1));
        heapArray.remove(heapArray.size()-1);
        minHeapify(0);
        return min;
    }

    @Override
    public void insert(Element e) {

        heapArray.add(e);
        int i = heapArray.size()-1;

        while (i>0 && heapArray.get(parent(i)).getKey() > heapArray.get(i).getKey()){
            exchange(heapArray.get(i), heapArray.get(parent(i)), i, parent(i));
            i = parent(i);
        }


    }
}
