// Time Complexity : Since for every case, we are doing 3 comparisions, each case is 3*O(1). 
// We are also pairing up these elements, so for pairing, it is O(N/2). Total is N/2 * 3 times O(1)
// Space Complexity : O(1) 
// Did this code successfully run on IDE : Yes
// Any problem you faced while coding this : No

public class MaxMinFromUnknownArray {

    public static void main(String... args) {
        int[] array = {4,5,99,54,8,2};
        int n= array.length;
        int min=array[0], max = array[0];
        for (int i = 0; i < n; i=i+2) {
            if (i == n - 1) { //comparision 1
                //case 1: last element in the array
                max = Math.max(max, array[i]); //comparision 2
                min = Math.min(min, array[i]); //comparision 3
                
                //case 2: if(i'th ele is < (i+1)'th ele
            } else if (array[i] > array[i + 1]) { //comparision 1
                max = Math.max(max, array[i]); //comparision 2
                min = Math.min(min, array[i + 1]); //comparision 3
                
                //case 3: if(i'th ele is > (i+1)'th ele
            } else { 
                max = Math.max(max, array[i + 1]); //comparision 2
                min = Math.min(min, array[i]); //comparision 3
            }
        }
        System.out.println(min);
        System.out.println(max);
    }
}
