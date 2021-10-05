// Time Complexity : O(2N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Sample{
    public static int minAndmax(int[] arr, int size){
        if(arr == null || arr.length == 0)
            return -1;

        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for(int i = 0; i < size;i++){
            if(start > arr[i])
                start = arr[i];

        }
        System.out.println(start);
        for(int i = size - 1; i>=0;i--){
            if(end < arr[i])
                end = arr[i];


        }


        return end;
    }
    public static void main(String args[]){
        int[] A = {1,2,3,4,5,6,7,8,9};
        int size = A.length;
        System.out.println(minAndmax(A,size));
    }
}



// Your code here along with comments explaining your approach
//I solved this question using two pointer approach where i started the value of start as Max value and end value as Min Value. Then I just loop through and update the start and the end value.