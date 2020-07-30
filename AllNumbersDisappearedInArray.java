/*
time complexity- O(n)
space complexity - O(1) we are not using any extra space
1.We know that all elements are in the range of [1,n]
2.while iterating over the array I would somehow mark the number as visited and the i would be finding the missing number. 
3.For each element nums[i], mark the element at the corresponding location negative if it's not already marked
4. Now, loop over numbers and for each number check if nums[j] is negative. If it is negative, that means we've seen this number somewhere in the array.
5. I would be adding all the numbers to the resultant array which don't have their corresponding locations marked as negative in the original array.

*/
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
         List<Integer> res = new ArrayList<>();
        //edge case
        if(nums == null || nums.length == 0)
            return res;
        
        for(int i=0; i< nums.length; i++){
            int index = Math.abs(nums[i])-1;
            //For each element nums[i], mark the element at the corresponding location negative if it's not already marked
            if(nums[index] > 0)
                nums[index] = Math.abs(nums[index]) *-1;
        }
        for(int i=0; i< nums.length; i++)
            //Adding all the numbers to the resultant array which don't have their corresponding locations marked as negative in the original array. 
            //Because if the number is positive means I never visited this number thats why I did not mark this negavetive
            if(nums[i] > 0)
                res.add(i+1);
        
        return res;
    }
}
