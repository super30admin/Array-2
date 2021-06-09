package Array2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class question31_disappearingNumbersInArray {
//    /*
//        Using HashMap:
//            Time Complexity: O(n)
//            Space Complexity: O(n)
//    */
//    public List<Integer> findDisappearedNumbersHashMap(int[] nums) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for(int i = 0 ; i < nums.length ; i++) {
//            map.put(nums[i], i);
//        }
//        List<Integer> list = new ArrayList<>();
//        for(int i = 1 ; i <= nums.length ; i++) {
//            if(!map.containsKey(i)) list.add(i);
//        }
//        return list;
//    }

    /*
        Using HashSet:
            Time Complexity: O(n)
            Space Complexity: O(n)
    */
    public static List<Integer> findDisappearedNumbersHashSet(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 1 ; i <= nums.length ; i++) {
            if(!set.contains(i)) list.add(i);
        }
        return list;
    }

    /*
    By making the index element negative
        Time Complexity: O(n)
        Space Complexity: O(1)
    */
    public static List<Integer> findDisappearedNumbersOptimized(int[] nums) {
        List<Integer> list = new ArrayList<>();

        if(nums == null || nums.length == 0) return list;

        for(int i = 0 ; i < nums.length ; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0) {
                nums[index] *= -1;
            }
        }

        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] > 0) {
                list.add(i + 1);
            } else {
                nums[i] *= -1;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbersHashSet(nums));
        System.out.println(findDisappearedNumbersOptimized(nums));
    }
}