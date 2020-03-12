import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 */

/**
 * @author aupadhye
 *
 */

//Space complexity would be O(N) for maintaining all elements
//Time complexity would be O(N) since we iterate through all elements.
public class Find_disappeared_numbers {

	/**
	 * @param args
	 */
	
	  public List<Integer> findDisappearedNumbers(int[] nums) {
	        
	        // Hash table for keeping track of the numbers in the array
	        // Note that we can also use a set here since we are not 
	        // really concerned with the frequency of numbers.
	        HashMap<Integer, Boolean> hashTable = new HashMap<Integer, Boolean>();
	        
	       
	        for (int i = 0; i < nums.length; i++) {
	            hashTable.put(nums[i], true);
	        }
	        
	       
	        List<Integer> result = new LinkedList<Integer>();
	        
	        // Iterate over the numbers from 1 to N and add all those
	        // that don't appear in the hash table. 
	        for (int i = 1; i <= nums.length; i++) {
	            if (!hashTable.containsKey(i)) {
	                result.add(i);
	            }
	        }
	        
	        return result;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int[] nums = new int[] {4,3,2,7,8,2,3,1};
		Find_disappeared_numbers obj = new Find_disappeared_numbers();
		List<Integer> result = obj.findDisappearedNumbers(nums);
		System.out.println(Arrays.asList(result));
	}

}
