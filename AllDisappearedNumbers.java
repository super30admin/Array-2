class Solution {

    /**
     * one way -  add elements in hashmap, get keys and see which are missning from 1-n. Add them in list and return.
     * Another way - modify given array. Start reading array, update index of curret element with MULTIPLY BY -1. Fo over array and add non negative index+1 in result.
     * time : O(n)
     * space: O(1)
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        //edge
        if (nums == null || nums.length == 0) {
            return new ArrayList();
        }

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }
}
