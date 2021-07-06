// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on terminal: yes
// Any problem you faced while coding this : first, checking if the size of the array is even or odd and based on that setting min and max value. Then, traversing the whole array to find the min and max.


// Your code here along with comments explaining your approach

import java.io.*;

class GFG {
    
    public static int[] getMinMax(int[] nums, int size){
        //checking edge case
        if(nums== null || size == 0){
            return new int[0];
        }
        
        int min = 0, max = 0, i=0;
        
        //if size is even, setting first element as Min and second element as max
        if(size % 2 == 0){
            min = nums[0];
            max = nums[1];
            i = 2;
        }
        //if size is odd, setting min and max to first element in the Array 
        else{
            min = nums[0];
            max = nums[0];
            i = 1;
        }
        
        while( i < size -1){
            
            if(nums[i] > nums[i+1]){
                if(nums[i] > max){
                    max = nums[i];
                }
                if(nums[i+1] < min){
                    min = nums[i+1];
                }
            } else {
                if(nums[i+1] > max){
                    max = nums[i+1];
                }
                if(nums[i] < min) {
                    min = nums[i];
                }
            }
            
            i += 2;
        }
        
        int[] result = {min, max};
        
        return result;    
    }
    
	public static void main (String[] args) {
		//System.out.println("GfG!");
		int[] nums = {1000, 11, 445, 1, 330, 3000};
		int size = nums.length;
		int[] result = getMinMax(nums, size);
		System.out.println("Minimum value is: "+result[0]);
		System.out.println("Maximum value is: "+result[1]);
	}
}