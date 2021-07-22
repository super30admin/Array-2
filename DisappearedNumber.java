import java.util.*;
class DisapperedNumber {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        List<Integer> result = new LinkedList<Integer>();
        for (int i = 1; i <= nums.length; i++) {

            if (nums[i - 1] > 0) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args){
        int nums[] = {4,3,2,7,8,2,3,1,6};
        DisapperedNumber d = new DisapperedNumber();
        System.out.print(d.findDisappearedNumbers(nums));
    }
}