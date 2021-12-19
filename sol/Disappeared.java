package sol;

import java.util.LinkedList;
import java.util.List;

public class Disappeared {
	 public List<Integer> findDisappearedNumbers(int[] nums) {
		 List <Integer> l= new LinkedList<>();
		        for( int i=0;i<nums.length;i++){
		            int index=Math.abs(nums[i])-1;
		            //System.out.println(index);
		            nums[index]=Math.abs(nums[index])*(-1);
		        }
		        
		        
		        for( int i=0;i<nums.length;i++){
		            if(nums[i]>0){l.add(i+1);}
		        }
		        return l;
		    }
}
