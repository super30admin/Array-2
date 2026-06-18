import java.util.*;
class Solution {

    // TC - O(n)
    // SC - O(1)

    /*
        We are updating the input array itself to not use any extra space. 
    */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // iterate array, get value at index and subtract 1 (nums[i] - 1) to get the index at which the number should be present (if it was sorted) and multiply num by -1
        for (int i = 0; i < nums.length; i++) {
            // take absolute value of the element (in case we mofified it with multiplying by -1)
            int index = Math.abs(nums[i]) - 1;
            // if valu at index is greater than 0, then multiply by -1 (this marks that the number index + 1 exists)
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }

        List<Integer> list = new ArrayList<>();

        // iterate the array and if number at index is not -ve, it means that the number (index + 1) does exist in the array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }

        return list;
    }
}