import java.util.*;
public class prob1 {

    public static List<Integer> disappearedNumbers(int[] nums){
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0){
                nums[index] *= -1;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                result.add(i+1);
            }
        }
        return result;
 
    }
    public static void main(String[] args) {
        int[] nums = {4,-3,-2,-7,8,2,-3,-1};
        List<Integer> result = disappearedNumbers(nums);
        System.out.println(result);
    }
    
}
