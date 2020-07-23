import java.util.ArrayList;
import java.util.List;

//Approach: 1.Here, Am iterating the array and marking the index of the elements present in the array with a negative sign.
//2. After the whole iteration, if the element at a particular index stays positive, then the element corresponding to that position is not present in the array and added to the result list.
//3. Return the list we obtained.
public class Find_All_Numbers_Disappeared_in_an_Array {
	public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            int temp = nums[i];
            if(temp < 0)
                temp*=-1;
            if(nums[temp-1] > 0)nums[temp-1] *= -1; 
        }
        for(int i=0;i< n ; i++)
        {
            if(nums[i]>0)
                list.add(i+1);
        }
        return list;
    }
}
//Time Complexity : O(n) 
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :