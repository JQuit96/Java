/**
 * Sorting v1.0.0
 * Created by Julian D. Quitian on 12/30/2015.
 */
public class Program {
    public static void main(String[] args){
        int[] a = {1,4,34,7,6,1,8,9,9,0,59};
        int[] b = {6,6,5,4,4,4,4,8,9,9,-4};

        BubbleSort bubbleSort = new BubbleSort();
        MergeSort mergeSort = new MergeSort();

        bubbleSort.bubbleSort(a, a.length);
        mergeSort.sort(b);

        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < b.length; i++){
            System.out.print(b[i] + " ");
        }
    }
}
