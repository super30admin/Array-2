// Time Complexity:           O(n)
// Space Complexity:          O(1)
// where n is length of array
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement

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

        for(int i=0; i<nums.length; i++)
        {
            int val = Math.abs(nums[i]) - 1 ;                                           // Multiplyin with -1 if needed
            if(nums[val] > 0)
                nums[val] *= -1 ;
//            nums[Math.abs(nums[i])-1] = (-1)*Math.abs(nums[Math.abs(nums[i])-1]);    // Another approach
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]>0)                                                               // Putting missing values in list
                list.add(i+1);
        }
        return list;


// ****************************** Another Approach ******************************
//        Set<Integer> set = new HashSet<>();
//        List<Integer> list = new ArrayList<>();
//        for(int i=0; i<nums.length; i++)
//        {
//            if(!set.contains(nums[i]))                                            // if set doesn't contain this value
//                set.add(nums[i]);                                                 // then add it in set
//        }
//        for(int i=0; i<nums.length; i++)
//        {
//            if(!set.contains(i+1))                                                // if value is missing from set
//                list.add(i+1);                                                    // then add it in list
//        }
//        return list;

    }
}
