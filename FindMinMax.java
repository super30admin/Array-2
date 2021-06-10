// Time Complexity : O(n) -- O(1.5n)
// Space Complexity : O(1)
// Any problem you faced while coding this : no


public class FindMinMax {

    public static Pair getMinMax(int [] nums) {
        //edge case
        Pair p = new Pair(0,0);

        if(nums == null || nums.length == 0) {
            return p;
        }
        //if only one element
        if(nums.length == 1) {
            p.min = p.max = nums[0];
        }
        //consider elements in pair
        for(int i = 0; i<= nums.length-2;i+=2) {
            //compare between pair , then compare it with min and max value
            if(nums[i]>nums[i+1]) {
                p.max = Math.max(p.max,nums[i]);
                p.min = Math.min(p.min,nums[i+1]);
            } else {
                p.max = Math.max(p.max,nums[i+1]);
                p.min = Math.min(p.min,nums[i]);
            }
        }
        return p;
    }

    public static void main(String[] args) {

        int arr[] = {1000};
        Pair minmax = getMinMax(arr);
        System.out.printf("\nMinimum element is %d", minmax.min);
        System.out.printf("\nMaximum element is %d", minmax.max);

    }
}
class Pair {
    public int min;
    public int max;

    public Pair(int min, int max) {
        this.min = Integer.MAX_VALUE;
        this.max = Integer.MIN_VALUE;
    }
}