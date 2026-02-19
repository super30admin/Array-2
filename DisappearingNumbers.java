import java.util.*;

// O(n) time, O(n) space
// class Solution {
//     public List<Integer> findDisappearedNumbers(int[] nums) {
//         List<Integer> ans = new ArrayList<>();
//         Set<Integer> set = new HashSet<>();

//         for (int num : nums) {
//             set.add(num);
//         }

//         for (int i = 1; i <= nums.length; i++) {
//             if (!set.contains(i)) {
//                 ans.add(i+1);
//             }
//         }
//         return ans;
//     }
// }

// O(n) time, O(1) space
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int idx = Math.abs(nums[i]) - 1; // idx of number

            if (nums[idx] > 0) {
                nums[idx] = nums[idx] * -1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                ans.add(i+1);
            }
        }
        return ans;
    }
}