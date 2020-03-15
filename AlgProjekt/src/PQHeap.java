
import java.util.ArrayList;
import java.util.List;

/*
Navne:
Tobias Albers Andersen
Jann Jacobsen
----------------------
SDU-login:
toand17@student.sdu.dk
jajac18@student.sdu.dk
*/

// Kommentering efter principperne i Software Engineering, Frank Tsui m.fl., 2018
// Dependencies: PQ interface, klassen Element, List og ArrayList.

public class PQHeap implements PQ {

    /*
    * PQHeap er en prioritets-kø, "priority queue", som implementerer interfacet PQ samt dets abstrakte
    * metoder: extractMin() og insert(Element e). PQHeap tilbyder herudover kerne- og hjælpemetoder
    * til at minimum heapify instansvariablen 'heapArray'. Metoderne er private da der ingen relevante koblinger er.
    * med undtagelse af extractMin() og insert(). Ingen teknisk gæld. Implementeret rekursivt.
    */

    private List<Element> heapArray;

    public PQHeap () {
        this.heapArray = new ArrayList<>();
    }

    // Driveren af koden som looper igennem 'heapArray' og kalder på minHeapify(i),
    private void minHeapifyMachine() {
        int size = heapArray.size() / 2;
        for (int i = size; i >= 0; i--) minHeapify(i);
    }

    // minHeapify() har til intention at tjekke at et givet index' indhold skal flyttes ud fra
    // 'key', som er et medlem i Element-objektet, og som betegner prioriteten som et heltal
    private void minHeapify(int i) {

        // left(i) og right(i) er hjælpemetoder som returnerer de respektive indexer
        int left = left(i);
        int right = right(i);
        int smallest;

        // Sætter den lokale variabel 'smallest' til enten 'left' eller 'i' afhængig af
        // om left's key er er mindre end i's key eller ej; samt tjekker for indexoutofbound
        if (left <= heapArray.size() - 1 && heapArray.get(left).getKey() < heapArray.get(i).getKey()){
            smallest = left;
        } else {
            smallest = i;
        }

        // For at tjekke om 'right' har en mindre key kalder vi på getKey() og sammenligner
        // og sætter den lokale variabel smallest til 'right'
        if (right <= heapArray.size() - 1 && heapArray.get(right).getKey() < heapArray.get(smallest).getKey()) {
            smallest = right;
        }

        // Kalder på hjælpemetoden exchange() og bytter om på de respektive elementer
        // for at kalde på minHeapify() rekursivt.
        if (smallest != i) {
            exchange(heapArray.get(i), heapArray.get(smallest), i, smallest);
            minHeapify(smallest);
        }
    }

    // Hjælpemetoder og implementerede abstrakte metoder:

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

    // Metode til at tage det element med lavest prioritet ud, det vil grundet implementering
    // af mininimum heapify-metoden være på index 0, da vi går fra lav til høj prioritet
    // Vi husker at rykke elementerne ned så det element som nu har laveste prioritet er på index 0

    @Override
    public Element extractMin() {
        Element min = heapArray.get(0);
        heapArray.set(0, heapArray.get(heapArray.size()-1));
        heapArray.remove(heapArray.size()-1);
        minHeapify(0);
        return min;
    }

    // For at indsætte et element tilføjer vi det først til 'heapArray' hvilket gør at det kommer
    // sidst i arrayet, vi ved dog nødvendigvis ikke om det har højeste prioritet, derfor må vi
    // tjekke det og flytte det vha. while-løkken.

    @Override
    public void insert(Element e) {
        heapArray.add(e);
        int i = heapArray.size()-1;

        while (i > 0 && heapArray.get(parent(i)).getKey() > heapArray.get(i).getKey()){
            exchange(heapArray.get(i), heapArray.get(parent(i)), i, parent(i));
            i = parent(i);
        }
    }
}
