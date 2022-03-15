import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n); where n is length of array
// Space Complexity : O(1)
class FindMissingNumbers {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> list= new ArrayList<>();
		
		//Change the state of element at index of current number from +ve to -ve
		for(int i=0; i<nums.length; i++){
        	int index= Math.abs(nums[i])-1;      	
        	if(nums[index] > 0) {
        		nums[index] *= -1;
        	}
        }
        
        //Reset the state back to +ve and record the missing numbers found
        for(int i=0; i<nums.length; i++) {
        	if(nums[i] > 0) {
        		list.add(i+1);
        	}else {
        		nums[i]*= -1;
        	}
        }
        
        return list;
    }
    
    // Driver code to test above 
    public static void main(String args[]) { 
    	FindMissingNumbers ob = new FindMissingNumbers();  
    	int[] nums= {4,3,2,7,8,2,3,1};  
        System.out.println("Missing numbers : "+ob.findDisappearedNumbers(nums));
    } 
}
