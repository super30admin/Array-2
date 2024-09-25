// Time Complexity :O(n/2) I am a bit confused can you xplain on this one.
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Not available in Leetcode
// Any problem you faced while coding this :No


import javax.xml.transform.Source;

public class MinMaxArray {
    static class Pair { 
  
        int min; 
        int max; 
    } 

    static Pair getMinMax(int arr[]){
        Pair minmax = new Pair();
        int i;

        if(arr.length % 2 == 0 ){
           if(arr[0]>arr[1]){
               minmax.min = arr[1];
               minmax.max = arr[0];
           }else{
            minmax.min = arr[0];
            minmax.max = arr[1];
           }
           i=2;
        }else{
            minmax.min = arr[0];
            minmax.max = arr[0];
            i=1;
        }

        while(i < arr.length-1){
           if(arr[i] > arr[i+1]){
               if(arr[i] > minmax.max){
                   minmax.max = arr[i];
               }
               if(arr[i + 1] <minmax.min){
                   minmax.min = arr[i + 1];
               }
           }else{
            if(arr[i + 1] > minmax.max){
                minmax.max = arr[i + 1];
            }
            if(arr[i] <minmax.min){
                minmax.min = arr[i];
            }
           }
           i = i + 2;
        }
        return minmax;

    }
    public static void main(String args[]){
        int arr [] = {1,55,74,9,36,54,2,99,7};
        Pair minmax = getMinMax(arr);
        System.out.println("Minimum:"+minmax.min);
        System.out.println("Maximum:"+minmax.max);
    }
}