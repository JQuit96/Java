/**
 * Bubble sort class
 * Created by Julian D. Quitian on 12/30/2015.
 */
public class BubbleSort {

    public void bubbleSort( int[] a, int n ){
        int i, j,t;
        for(i = 0; i < n; i++){
            for(j = 1; j < (n-i); j++){
                if(a[j-1] > a[j]){
                    t = a[j-1];
                    a[j-1]=a[j];
                    a[j]=t;
                }
            }
        }
    }
}
