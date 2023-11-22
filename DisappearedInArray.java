import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DisappearedInArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        List<Integer> ans = new ArrayList<>();
        Set<Integer> values = new HashSet<>();
        int num=1;
        for(int i  = 0; i < len; i++)
            values.add(nums[i]);
        for(int j = 0; j < len; j++){
            if(values.contains(j+1))
                continue;
            else
                ans.add(j+1);
        }
        return ans;
    }
}
