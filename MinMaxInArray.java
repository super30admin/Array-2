import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of numbers of length N, find both the minimum and maximum. 
 * Follow up : Can you do it using less than 2 * (N - 2) comparison
 */

public class MinMaxInArray {
    public List<Integer> minMaxOfAGivenArray(int arr[]){
        List<Integer> res = new ArrayList<>();
 
        int min =Integer.MAX_VALUE;
        int max = Integer.MAX_VALUE;

        for(int i=0; i< arr.length; i++){
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        res.add(min);
        res.add(max);
    }
}

