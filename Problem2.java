// Time Complexity : O(n)
// Space Complexity : O(1)

// Your code here along with comments explaining your approach
/*
We optimise the number of comparisions from 2n to 1.5n since we compare two elements at a time and calculate the min and max
that is 3 comparisions over 2 elements
*/
class Main {
    private static void getMinMax(int [] nums) {
        int max = 0, min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length-1;i++) {
            if(nums[i]>nums[i+1]) {
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i+1]);
            } else {
                max = Math.max(max, nums[i+1]);
                min = Math.min(min, nums[i]);
            }
        }
        System.out.println("Minimum element is " + min);
        System.out.println("Maximum element is " + max);
        
    }
    public static void main(String[] args) {
        int arr[] = { -4, -1, -3, 2, -1, 6,7 };
        getMinMax(arr); 
    }
}
