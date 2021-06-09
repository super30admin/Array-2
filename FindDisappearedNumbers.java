import java.util.ArrayList;
import java.util.List;

/**
 * @author Vishal Puri
 * // Time Complexity : O(n)
 * // Space Complexity : O(1)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> out = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            nums[Math.abs(nums[i])-1] = Math.abs(nums[Math.abs(nums[i])-1])*-1;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
                out.add(i+1);
        }
        return out;
//        List<Integer> list= new ArrayList<>();
//        for(int i=0; i<nums.length;){
//            if(nums[i]==i+1)
//                i++;
//            else if(nums[i]==nums[nums[i]-1])
//                i++;
//            else{
//                int temp=nums[i];
//                nums[i]= nums[nums[i]-1];
//                nums[temp-1] = temp;
//            }
//        }
//        for(int i=0;i<nums.length;i++){
//            if(nums[i]!=i+1)
//                list.add(i+1);
//        }
//        return list;
    }

    public static void main(String[] args){
        FindDisappearedNumbers obj = new FindDisappearedNumbers();
        int[] nums = new int[]{2,2};
        List<Integer> out = new ArrayList<>();
        out = obj.findDisappearedNumbers(nums);
        System.out.println(out);
    }
}
