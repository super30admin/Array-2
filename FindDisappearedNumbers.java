// Time Complexity : O(N) N -> No of elements in array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class FindDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> list = new ArrayList<>();

        // extract absolute value of array element and store in index
        // update value at that index by multiplying by -1
        for(int i=0; i<nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0) {
                nums[index] *= -1;
            }
        }

        // add all positive elements into result
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) {
                list.add(i+1);

            } else {
                nums[i] *= -1;
            }
        }

        return list;
    }
}