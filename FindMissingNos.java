import java.util.ArrayList;
import java.util.List;

/**
 TC -  O(n), SC - O(1)
 */
class FindMissingNos {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> list = new ArrayList<>();

        //Start with 1st index and make value at index=nums[i]-1 as negative if value at tha index is positive
        for(int i =0; i < nums.length; i++) {
            if(nums[Math.abs(nums[i])-1] > 0)
                nums[Math.abs(nums[i])-1] = nums[Math.abs(nums[i])-1] * -1;
        }

        //If any value is left positive, then the missing numbers are at the index+1 position

        for(int i =0; i< nums.length; i++) {
            if(nums[i] > 0)
                list.add(i+1);
        }

        return list;

    }
}