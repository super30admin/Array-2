
public class DisappearedNums {
	
	/***********************************************************
	 * 448. Find All Numbers Disappeared in an Array
	 * 
	 * Brute force Approach
	 * use two n*n for loops to find the missing elements
		 Time Complexity : O(n^2)
		 Space Complexity :O(n)
		 Did this code successfully run on Leetcode :yes passed all tests except time limit exceeded
		 Any problem you faced while coding this : no

	 * 	can uncomment the brute force code below to run on leet code 
	 * 
	 * 
	***********************************************************/
	
	/*
	public List<Integer> findDisappearedNumbers(int[] nums) {
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        int max = 0;
	        for (int i = 1 ; i <= nums.length; i++){
	            for (int j = 0 ; j < nums.length; j++){
	               // System.out.println(" j run " + j);
	                if(i == nums[j]){
	                    System.out.println("i value: " + i);
	                    System.out.println("j index: " + j);
	                    System.out.println("j value: " + nums[j]);
	                    break;
	                }
	                if(j == nums.length-1){
	                    result.add(i);
	                }
	            }
	         }
	        return result;
	    }    
	*/
	
	
	
	/***********************************************************
	 * 
	 *  Hash Set Approach
		 Time Complexity : O(n) for iterating HashSet
		 Space Complexity :O(n) for storing HashSet
		 Did this code successfully run on Leetcode :yes 
		 Any problem you faced while coding this : no
	 * 
	 * 
	 * Pseudocode
	 * 1.) add elements to hash set
	 * 2.) iterate over array and see if elements is present in hash set 
	 * 3.) else add element to result array list and return it at end of loop
	 * 
	 * ***********************************************************/
	
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        ArrayList<Integer> result = new  ArrayList<Integer>();
        HashSet <Integer> set = new HashSet <Integer>();
        
        for (int i : nums){
            set.add(i);
        }
        
        for(int i=1; i<= nums.length;i++){
            if(!set.contains(i))
            result.add(i);
        }
        return result;
    }
	
}
