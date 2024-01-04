import java.util.ArrayList;
import java.util.List;

class DisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] > 0) {
                nums[idx] *= -1;
            }
        }

        for(int j = 0; j < nums.length; j++) {
            if(nums[j] > 0){
                result.add(j+1);
            }
        }

        return result;
    }
}
