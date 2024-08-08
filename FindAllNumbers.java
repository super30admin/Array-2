// space complexity = O(1)
// time complexity = O(n)
// for negative numbers, we can use offset.
// here the offset was 0, since all positive numbers.
// here we converted all numbers which were present to -ve .
// the searched for positive numbers, but we did in-place array.

import java.util.ArrayList;
import java.util.List;

class FindAllNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        // nums = [4,3,2,7,8,2,3,1]
        // actua= [1,2,3,4,5,6,7,8]
        // idx =  [0,1,2,3,4,5,6,7] length = 8
        // array =[-4,-3,-2,-7,8,2,-3,-1]// numbers in the place of 8,2 is 5,6.
        for(int idx=0;idx< nums.length;idx++) {// iterating by index.
            int currNum = Math.abs(nums[idx]);// make it positive
            // positive nums.
            int index = currNum-1;
            if(nums[index] >0) {
                nums[index] *=-1; // make it negative and nums[idx]-1 is actual//eg 4 and 3
            }            
        }
        for(int i=0;i< nums.length;i++) {
            if(nums[i]>0) {
                list.add(i+1);
            } else {// mutate it back to the original array.
                nums[i]*=-1;
            }
        }
        return list;
    }
}