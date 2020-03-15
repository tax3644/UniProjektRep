
import java.util.ArrayList;
import java.util.List;

/*
Navne:
Tobias Albers Andersen
Jann Jacobsen

SDU-login:
toand17@student.sdu.dk
jajac18@student.sdu.dk
 */

public class PQHeap implements PQ {

    private List<Element> heapArray;

    public PQHeap () {
        this.heapArray = new ArrayList<>();
    }

    private void minHeapifyMachine(){
        int size = heapArray.size() / 2;
        for (int i = size; i >= 0; i--) minHeapify(i);
    }

    private void minHeapify(int i) {

        int left = left(i);
        int right = right(i);
        int smallest;

        if (left <= heapArray.size() - 1 && heapArray.get(left).getKey() < heapArray.get(i).getKey()){
            smallest = left;
        } else {
            smallest = i;
        }

        if (right <= heapArray.size() - 1 && heapArray.get(right).getKey() < heapArray.get(smallest).getKey()) {
            smallest = right;
        }

        if (smallest != i) {
            exchange(heapArray.get(i), heapArray.get(smallest), i, smallest);
            minHeapify(smallest);
        }
    }

    private int left(int i) {
        return i * 2 + 1;
    }

    private int right(int i) {
        return i * 2 + 2;
    }

    private int parent(int i) {
        if (i % 2 == 1) {
            return (i - 1) / 2;
        } else

        return (i - 2) / 2;
    }

    private void exchange(Element elementOne, Element elementTwo, int indexOne, int indexTwo){
        heapArray.set(indexOne, elementTwo);
        heapArray.set(indexTwo, elementOne);
    }

    @Override
    private Element extractMin() {
        Element min = heapArray.get(0);
        heapArray.set(0, heapArray.get(heapArray.size()-1));
        heapArray.remove(heapArray.size()-1);
        minHeapify(0);
        return min;
    }

    @Override
    private void insert(Element e) {

        heapArray.add(e);
        int i = heapArray.size()-1;

        while (i>0 && heapArray.get(parent(i)).getKey() > heapArray.get(i).getKey()){
            exchange(heapArray.get(i), heapArray.get(parent(i)), i, parent(i));
            i = parent(i);
        }
    }
}
