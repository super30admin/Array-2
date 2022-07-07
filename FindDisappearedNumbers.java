import java.util.ArrayList;
import java.util.List;
/**
 * Time Complexity: O(n)
 * Space Complexity: O(N) -> N is the number of the element
 * */
public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums.length == 0 || nums == null) {
            return result;
        }
        int temp[] = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            temp[num - 1] = num;
        }
        for(int i = 0 ; i < temp.length; i++){
            if(temp[i] == 0){
                result.add(i+1);
            }
        }
        return result;
    }
}
