/**
 * Created by Julian D. Quitian on 12/30/2015.
 */
public class MergeSort {
    private int[] array;
    private int[] helper;

    private int number;

    public void sort(int[] array){
        this.array = array;
        number = array.length;
        this.helper = new int[number];
        mergeSort(0, number - 1);
    }
    public void mergeSort(int low, int high){

    }
}
