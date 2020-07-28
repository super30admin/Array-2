//Problem: 238. Product of Array Except Self
/** 3 Pointer Approach: 
 * Brute Force 1: - Used 2 nested loops to iterate over 1-N and note down which numbers do not appear.
 * Brute Force 2: - Use Hashset and 2 iterations. Loop over all elements and add to set. @nd loop from 1 to N
 *                  and check elements not present in hashset
 * 
 * Implemented Solution
 * 1. 2 iterations
 * 2. 1st iteration loop pver all elments and modify the elemnt value-th index by multplying by -1.
 *    While iteration tale absolue values.
 * 3. This will lead to making avaailable elements index as Negative.
 * 4. Iterate over the aray again and check which index is not modified, missing idexes are the numbers.
 */ 
//
//time Complexity :
// O(N)

// Space Complexity :
// O(1) - o/p List not counted as extra space

// Did this code successfully run on Leetcode : YES.
// Any problem you faced while coding this : NO.

class Solution1 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        if(nums == null || nums.length == 0)
            return new ArrayList();
        
        int n = nums.length;
        
        //ArrayList list = new ArrayList();
        List<Integer> list = new LinkedList<Integer>();
        
        for(int i=0; i<n; i++){
            
            int index = Math.abs(nums[i])-1;
            if(nums[index]>0)
            nums[index] *= -1;
        }
        
        for(int i=0; i<n; i++){
          
            if(nums[i] > 0){
                list.add(i+1);
            }
        }
        
        
        return list;
    }
}
