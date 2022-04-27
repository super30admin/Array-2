// Time Complexity : O(n) n is num of elements in arr
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach: single pass, store elements in 2 vars
// it is less than 2*(n-2) comparisons. only n comparisons


public class FindMinMax {
    public static int[] findMinMax(int[] arr){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int n: arr){
            if (n < min)
                min = n;
            if(n > max)
                max = n;
        }
        return new int[]{min, max};
    }

    public static void main(String[] args) {

        int[] res = findMinMax(new int[]{1,4,5,2,3,7,3});
        System.out.println(res[0]+" "+res[1]);
    }
}
