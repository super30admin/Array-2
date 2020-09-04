import java.util.*;

// Time Complexity : O(N) N - length of array
// Space Complexity : O(1) - not using extra space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//As the numbers present in the array is restricted between 1 - N(length of array), we can find the missing number by 
//comparing the indices.  
//We will traverse the array, get the number, go to index-1 as indices start from zero, change the number present at index to negative.
//Once the whole array is traversed, the numbers at indices present in the array would be negative. 
//Check for positive number, add it to list and return. 

public class DisappearedNumber {
    
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
