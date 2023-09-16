import java.util.ArrayList;
import java.util.List;

public class NumbersDisappeared {
    public static void main(String[] args) {
        NumbersDisappeared solution = new NumbersDisappeared();

        int[] nums1 = {4, 3, 2, 7, 8, 2, 1};
        List<Integer> result1 = solution.findDisappearedNumbers(nums1);
        System.out.println("Disappeared Numbers 1: " + result1);

        int[] nums2 = {1, 1, 2, 2, 3, 4, 4};
        List<Integer> result2 = solution.findDisappearedNumbers(nums2);
        System.out.println("Disappeared Numbers 2: " + result2);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums.length == 0 || nums == null){
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<Integer>();

        for(int i=0; i<nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0){
                nums[index] = nums[index] * -1;
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                result.add(i+1);
            }
        }


        return result;
    }
}
