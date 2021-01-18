// Time Complexity : O(N), N - length of array
// Space Complexity : O(1), not using extra space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
public class problem2 {

    public static void findMinMax(int[] arr){
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int count = 0;
        for(int i=0; i<arr.length-1; i=i+2){
            if(arr[i] > arr[i+1]){
                count++;
                if(arr[i] > max){
                    max = arr[i];
                } count++;
                if(arr[i+1] < min){
                    min = arr[i+1];
                } count++; 
            }else if(arr[i] < arr[i+1]){
                count++;
                if(arr[i+1] > max){
                    max = arr[i+1];
                } count++;
                if(arr[i] < min){
                    min = arr[i];
                } count++;
            }
        }
        if(arr.length % 2 !=0){
            if(arr[arr.length-1] > max)
                max = arr[arr.length-1];
            else if(arr[arr.length-1]< min)
                min = arr[arr.length-1];
        }

        System.out.println("Min: "+min+" Max: "+max+" count: "+count);
    }

    public static void main(String[] args){
        int[] arr = {9,2,3,8,4,1,10};
        findMinMax(arr);
    }
}