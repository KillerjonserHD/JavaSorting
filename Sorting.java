import java.util.Arrays;
import java.util.Random;
/**
 * Write a description of class Sorting here.
 *
 * @author Jonathan Mertens
 * @version 14/03/2022
 */
public class Sorting
{
    private int[] toSort;

    /**
     * Constructor for objects of class Sorting
     */
    public Sorting()
    {
        
    }
    
    public int[] selectionSort(int[] toSort)
    {
        int p = 0;
        while(p < toSort.length)
        {
            
            int smallest = p;
            for(int i = p; i < toSort.length; i++)
            {
                if(toSort[i] < toSort[smallest])
                {
                    toSort[smallest] = toSort[i];
                }
            }
            int cache = toSort[p];
            toSort[p] = toSort[smallest];
            toSort[smallest] = cache;
            p++;
        }
        return toSort;
    }
    
    public int[] mergeSort(int[] toSort)
    {
        if(toSort.length <= 1)
        {
            return toSort;
        }
        
        int[] left = new int[toSort.length / 2];
        int[] right;
        if (toSort.length % 2 == 0)
            right = new int[toSort.length / 2];
        else
            right = new int[toSort.length / 2 + 1];
            
        for(int i = 0; i < toSort.length; i++)
        {
            if(i < (toSort.length / 2))
            {
                left[i] = toSort[i];
            }
            else
            {
                right[i - toSort.length / 2] = toSort[i];
            }
        }
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }
    
    private int[] merge(int[] left, int[] right)
    {
        int[] merge = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        for (int k = 0; i < left.length || j < right.length; k++) {

            if (i < left.length && j < right.length) {
                if (left[i] <= right[j]) {
                    merge[k] = left[i];
                    i++;
                }
                else {
                    merge[k] = right[j];
                    j++;
            }
            }
            else if (i < left.length) {
                merge[k] = left[i];
                i++;
            }
            else if (j < right.length)
            {
                merge[k] = right[j];
                j++;
            }
        }
        return merge;
    }
    
    public void sortIt()
    {
        Random rd = new Random(); 
        int[] toSort = new int[30];
        for (int i = 0; i < toSort.length; i++) 
        {
            toSort[i] = rd.nextInt(100);
        }
        System.out.println(Arrays.toString(toSort));
        System.out.println(Arrays.toString(mergeSort(toSort)));
    }

    
}
