import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDisappearedNumbers {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> hSet = new HashSet<>();
        if(nums == null) return result;
        for(int i = 0; i< nums.length; i++){
            hSet.add(nums[i]);
        }
        for(int i = 1; i <= nums.length ;i++){
            if(!hSet.contains(i)){
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println("Disappeared numbers : "+ findDisappearedNumbers(new int[]{1,1}));
        System.out.println("Disappeared numbers : "+ findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }

}
