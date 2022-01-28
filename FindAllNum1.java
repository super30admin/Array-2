import java.util.*;

public class FindAllNum1 {
    public List<Integer> findAllNum1(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> hS = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!hS.contains(nums[i])) {
                hS.add(nums[i]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (!hS.contains(i + 1)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
