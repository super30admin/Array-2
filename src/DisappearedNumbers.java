import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DisappearedNumbers {
    public static void main(String[] args) {
        DisappearedNumbers dn = new DisappearedNumbers();
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> list = dn.findDisappearedNumbers(nums);
        System.out.println(list);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++)
        {
            if(!set.contains(nums[i]))
                set.add(nums[i]);
        }
        for(int i=0; i<nums.length; i++)
        {
            if(!set.contains(i+1))
                list.add(i+1);
        }
        return list;
    }
}
