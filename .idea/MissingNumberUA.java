import java.util.ArrayList;
import java.util.List;

public class MissingNumberUA {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums==null || nums.length==0)
            return res;
        for(int i=0; i<nums.length;i++)
        {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index]>0)
            {
                nums[index] = -1 * nums[index];
            }
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<0)
            {
                nums[i] = -1 * nums[i];
            }
            else
            {
                res.add(i + 1);
            }
        }
        return res;
    }
    public static void main(String args[])
    {
        int[] nums= {4,3,2,7,8,2,3,1};
        MissingNumberUA ob = new MissingNumberUA();
        System.out.println(ob.findDisappearedNumbers(nums));
    }
}

//time complexity is O(n)
//space is O(1)
