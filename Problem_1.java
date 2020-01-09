import java.util.ArrayList;
import java.util.List;

public class Problem_1 {

public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> list = new ArrayList();
        
        if(nums.length == 0|| nums == null){
            return list;    
        }
        
        for(int i=0; i<nums.length; i++){
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] > 0)
                nums[idx] = nums[idx] * -1;
        }
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                list.add(i+1);
            }
        }
        
        return list;
    }
}
