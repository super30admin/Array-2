import java.util.ArrayList;
import java.util.List;

public class FindAllDisappearedNumbers {
    /**
     range of elements 1-n
     range of indices 0-n-1

     whether specific element is present or not.
     start iterating.
     at any given index pick an element and subtract 1 from that element to get the index of that number.
     goto that number and mark it negative to indicate we found htta number.
     Iterate through and find elements that are not positive add them to result and return the result.

     follow up. if interviewer asks not to mutate an array, while second pass, multiply again by -1 to convert back to original.
     TIme - o(n)
     Space o(1)
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i])-1;
            // mark it with negative value to show visited. do this only if index is  positive
            if(nums[index] >0){
                nums[index] = nums[index] *(-1);
            }
        }
        // second pass
        for(int i=0; i<nums.length; i++){
            if(nums[i] >0){
                result.add(i+1);
            }else{
                nums[i] = nums[i] *-1;
            }
        }

        return result;
    }
}
