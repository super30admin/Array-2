// Time Complexity : TC: O(1.5n+2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/*
Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison
*/
public class FindMaxAndMin {

    public static void main(String args[]) {

        int[] array = new int[]{2,5,6,7,8,50,-1};

        int[] result =  maxandminvalue(array);

        System.out.println("Minimum:"+ result[0]+", Maximum: "+ result[1]);
    }

    public static int[] maxandminvalue(int[] array){

        if(array == null || array.length == 0){
            return new int[]{};
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0;i<array.length-1;i +=2){
            int v1 =  array[i];
            int v2 =  array[i+1];

            int minTemp = Math.min(v1,v2);
            int maxTemp = v1 == minTemp ? v2 : v1;

            min =  Math.min(min, minTemp);
            max = Math.max(max, maxTemp);

        }

        if(array.length % 2 != 0){
            min =  Math.min(min, array[array.length-1]);
            max = Math.max(max, array[array.length-1]);
        }

        return new int[]{min ,max};
    }
}
