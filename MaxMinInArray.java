// Time Complexity : O(n/2); where n is length of nums array
// Space Complexity : O(1)
class MaxMinInArray {
	class Tupple{
		int min;
		int max;
	}
	
	public Tupple getMinMax(int[] nums) {
		Tupple result= new Tupple();	
		
		if(nums==null || nums.length==0) return result;		
		if(nums.length==1) {
			result.min= nums[0];
			result.max= nums[0];
			return result;
		}
		
		int i=0;				
		while(i < nums.length) {
			if(i==nums.length-1) {//if odd numbers array, compare with last element
				result.max= Math.max(result.max, nums[i]);
				result.min= Math.min(result.min, nums[i]);
			}else if(nums[i] > nums[i+1]) {
				result.max= Math.max(result.max, nums[i]);
				result.min= Math.min(result.min, nums[i+1]);				
			}else {
				result.max= Math.max(result.max, nums[i+1]);
				result.min= Math.min(result.min, nums[i]);				
			}
			i+=2;
		}
		
		
		return result;
    }
    
    // Driver code to test above 
    public static void main(String args[]) { 
    	MaxMinInArray ob = new MaxMinInArray();  
    	int[] nums= {4,3,2,7,8,2,3,1};  
    	Tupple t= ob.getMinMax(nums);
        System.out.println("Min in array : "+t.min);
        System.out.println("Max in array : "+t.max);
    } 
}
