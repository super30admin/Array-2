//Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison


// Time Complexity : O(n) asymptotic . with less than 2 comparison for each element
// Space Complexity : O(1)
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class Solution{

    public static void main(String []args){
        int[] arr = new int[]{2,8,6,2,11,5,70,88};
        int max = arr[0];
        int min = arr[0];

        for(int i=1;i<arr.length;i=i+2){
            //  System.out.println("Comparing i & i+1"+ i);
            if(i==arr.length-1){
                if(arr[i] > max)
                    max = arr[i];
                if(arr[i] < min){
                    min = arr[i];
                }
            }
            else{
                //Take a window and check for the smaller and bigger elements
                int greater = Math.max(arr[i],arr[i+1]);
                int smaller = Math.min(arr[i],arr[i+1]);

                if(max < greater){
                    max = greater;
                }
                if(min > smaller){
                    min = smaller;
                }

            }

        }

        System.out.println("max"+max);
        System.out.println("min"+min);


    }
}