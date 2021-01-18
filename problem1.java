// Time Complexity : O(N) N 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
import java.util.ArrayList;
import java.util.List;

public class problem1 {

	  public static List<Integer> findDisappearedNumbers(int[] nums) {

	        if( nums == null || nums.length == 0) return new ArrayList<>();

	        List<Integer> list = new ArrayList<>();

	        for(int i = 0; i < nums.length; i++){
	            int index = Math.abs(nums[i]);
	            if(nums[index-1] > 0){
	                nums[index-1] *= -1;
	            }  
	        }

	        for(int i = 0; i < nums.length; i++){
	            if(nums[i] > 0)
	                list.add(i+1);
	        }
	        return list;
	    }

	    public static void main(String[] args){
	        int[] arr = {4,3,2,7,8,2,3,1};
	        List<Integer> list = new ArrayList<>();
	        list = findDisappearedNumbers(arr);

	        for(int i=0; i<list.size(); i++)
	            System.out.println(list.get(i));

	    }
	}