// Time Complexity: O(n) as we are traversing the array 1 time only => 3(n-1)/2
// Space Complexity: O(1) no auxilliary data structure used
// Did you complete the code on leet code: Yes
// Any problems faced: couldn't identfy less than 2*n-1 comparisons

// Write your explaination here
// Idea here is to perform the comparison in pairs, so instead of checking both max and min for each element, we check
// among each pair, which is greater and which is smaller, then we only compare smaller value with min currently assigned
// and larger value with max currently assigned.
// this provides and a time complexity of 3 times n-1 as we are comparing pair among each other, lower to min and higher to max,
// but as this happens in a pair and increment is with 2 element, it divides by 2 ==> 3(n-1)/2
class Solution {
    public static int[] findMinMaxInArray(int[] nums) {
        int[] result = new int[2];
        if(nums==null|| nums.length==0) {
            return result;
        }
        if(nums.length%2 == 0) {
            if(nums[0]>nums[1]) {
                result[0] = nums[1];
                result[1] = nums[0];
            } else {
                result[0] = nums[0];
                result[1] = nums[1];
            }
            i=2;
        } else {
            result[0] = nums[0];
            result[1] = nums[0];
            i=1;
        }

        while(i<n-1) {
            if(nums[i]>nums[i+1]) {
                if(result[0]>nums[i+1]) {
                    result[0] = nums[i+1];
                }
                if(result[1]<nums[i]) {
                    result[1] = nums[i];
                }
            } else {
                if(result[0]>nums[i]) {
                    result[0] = nums[i];
                }
                if(result[1]<nums[i+1]) {
                    result[1] = nums[i+1];
                }
            }
            i+=2;
        }
        return result;
    }
}