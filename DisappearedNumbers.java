import java.util.ArrayList;
import java.util.List;

class DisappearedNumber {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingNumberList = new ArrayList<>();
        for(int index = 0; index < nums.length; index++){
                int targetIndex = Math.abs(nums[index]) - 1;
                if(nums[targetIndex] > 0){
                    nums[targetIndex] = nums[targetIndex] * -1;
                }
        }

        for(int index = 0; index < nums.length; index++){
            if(nums[index] > 0){
                missingNumberList.add(index+1);
            }else{
               nums[index] = nums[index] * 1; 
            }
        }

        return missingNumberList;
        
    }
}