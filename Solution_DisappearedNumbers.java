import java.util.ArrayList;
import java.util.List;

//TC: O(n)
//SC: O(1)
//Did it run on leetcode: Yes
public class Solution_DisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int ind = Math.abs(nums[i]) - 1;
            if(nums[ind] > 0){
                nums[ind] *= -1;
            }
        }
        for(int i = 0; i < n; i++){
            if(nums[i] > 0)
                result.add(i+1);
        }
        return result;
    }
}
