// we coupled the numbers as pairs and compared them
// the issue would be when the length of the array is odd.
// in the case just have a boolean flag as true or false to indicate odd.
// then just  make pairs and till the second last item.
// the last item -> compare it separately.
// for even length, there won't be any problem.
// Time complexity =  3 comparisons at each pair = 3*n/2 = O(1.5n) = O(n)
// Space complexity = O(1)
public class FindMinAndMax {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] array = new int[]{4,-3,2,1,4,0,1,3,4,7};
        findMinAndMax(array);
    }
    
    public static void findMinAndMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        boolean odd = false;
        if(n%2 !=0) {
            // it is odd.
            odd = true;
            n = n-1;
        }
        for(int i=0;i< n-1;i++) {// instead of n-1, we do it till n-2.
            if(nums[i]> nums[i+1]) {
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i+1]);
            } else {
                max = Math.max(max, nums[i+1]);
                min = Math.min(min, nums[i]);
            }
        }
        if(odd) {// account for odd.
            max = Math.max(max, nums[n]);
            min = Math.min(min, nums[n]);
        }
        System.out.println("Max is " + max);
        System.out.println("Min is " + min);
    }
}