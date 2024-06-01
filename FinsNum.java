//time complexity:O(n)
//space complexity:O(1)
import java.util.*;
public class FinsNum {
        public List<Integer> findDisappearedNumbers(int[] nums)
        {
            if(nums==null || nums.length==0)
            {
                return new ArrayList<>();
            }
            List<Integer> result=new ArrayList<>();
            for(int i=0;i<nums.length;i++)
            {
                int index = Math.abs(nums[i])-1;
                if(nums[index]>0)
                {
                    nums[index]=nums[index]*-1;
                }
            }
            for(int i=0;i<nums.length;i++)
            {
                if(nums[i]>0)
                {
                    result.add(i+1);
                }
                else
                {
                    nums[i]=nums[i]*-1;   // retrieving the original array
                }
            }
            return result;
        }
        public static void main(String[] args) {
            FinsNum obj=new FinsNum();
            List<Integer> list= new ArrayList<>();
            list=obj.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
            System.out.println(list);

        }
    }

