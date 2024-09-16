// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :No
// Any problem you faced while coding this : No

public class FindMinMax {
    static class Pair{
        int min;
        int max;
    }
    public Pair minMax(int[] arr, int size){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Pair minmax = new  Pair();
        for(int i=0;i<arr.length;i++){
            if (arr[i]>max){
                max = arr[i];
            }
        }
        for(int i=0;i<arr.length;i++){
            if (arr[i]<min){
                min = arr[i];
            }
        }

        minmax.max = max;
        minmax.min = min;
        return minmax;
    }
    public static void main(String[] args) {
    FindMinMax fm =  new FindMinMax();
    int[] ip = {1,2,3,4};

        Pair minmax = fm.minMax(ip,ip.length);
        System.out.println("Max: " +minmax.max);
        System.out.println("Min: " +minmax.min);
    }
}
