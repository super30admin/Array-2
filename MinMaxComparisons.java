// Time Complexity : O(n)
// Space Complexity : O(1)

//Approach compare elements in pairs. coompare local minimum and maximum with global max and min.

public class MinMaxComparisons {
    
    public int[] getMinMax(int[] nums) {
        int[] result = new int[2];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        boolean evenLength;

        if(nums.length % 2 == 0) {
            evenLength = true;
        } else {
            evenLength = false;
        }

        if(evenLength) {
            for(int i = 0; i<nums.length-1; i+=2) {
                int num1 = nums[i];
                int num2 = nums[i+1];

                if(num1 < num2) {
                    min = Math.min(num1, min);
                    max = Math.min(num2, max);
                } else {
                    min = Math.min(num2, min);
                    max = Math.min(num1, max);
                }
            }
        } else {
            for(int i = 0; i<nums.length-2; i+=2) {
                int num1 = nums[i];
                int num2 = nums[i+1];

                if(num1 < num2) {
                    min = Math.min(num1, min);
                    max = Math.min(num2, max);
                } else {
                    min = Math.min(num2, min);
                    max = Math.min(num1, max);
                }
            }

            if(nums[nums.length -1] > max) {
                max = nums[nums.length -1];
            } else if(nums[nums.length -1] < min) {
                min = nums[nums.length -1];
            }

        }

        result[0] = min;
        result[1] = max;
        return result;
    }

}