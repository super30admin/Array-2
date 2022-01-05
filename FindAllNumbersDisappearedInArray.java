//TC: O(n)
//SC: O(n)
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindAllNumbersDisappearedInArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list =new ArrayList();
        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(int i = 1; i<= nums.length; i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }
        return list;
    }
}
