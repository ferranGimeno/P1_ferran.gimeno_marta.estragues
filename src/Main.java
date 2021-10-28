import Logic.Logic;

public class Main {
    static final int nInterations = 10;

    public static void main(String[] args) {
        Logic logic = new Logic();
        Logic.readDataset();;
        Logic.menu();
    }

    /*public static void doGraphs(LinkedList<int[]> a){
        long total = 0;
        for (int k = 0; k < a.size(); k++){
            for (int j = 0; j < nInterations; j++){
                for (int i = 0; i < a.get(k).length-1; i++) {
                    long start = System.currentTimeMillis();
                    MergeSort.sort(a.get(k), 0, a.get(k).length-1);
                    //QuickSort.sort(a.get(k), 0, a.get(k).length-1);
                    long elapsedTime = System.currentTimeMillis() - start;
                    total += elapsedTime;
                }
            }
            total = total/nInterations;
            System.out.println(total);
        }
    }

    public static void listGenerator(LinkedList<int[]> list, int nArrays){
        int dimension = 10;
        for (int i = 0; i < nArrays; i++) {
            list.add(arrayGenerator(dimension));
            dimension += 50;
        }
    }
    public static int[] arrayGenerator(int dimension){
        int[] a = new int[dimension];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 1000);
        }
        return a;
    }*/
}
