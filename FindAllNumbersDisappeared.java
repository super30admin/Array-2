/*Approach 1: 
1. Use a HashSet
2. Store the number that has been encountered
3. Loop for number = size of the nums, return the number belonging to theindex that are absent 
Time complexity: O(N)
Space complexity: O(N)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        List<Integer> results = new ArrayList<>();
        for(int i=0;i<=nums.length-1;i++)
        {
            hashSet.add(nums[i]);
        }
        
        for(int j=0; j<=nums.length-1; j++)
        {
            if(!hashSet.contains(j+1))
                results.add(j+1);
        }
        return results;
    }
}*/

/*Approach 2: 
1. While looping through the array, the number that you read, go to the index: num-1, mark the number as -ve
2. Marking the numbers -ve will leave the array un-altered (it can be restored by multiplying the numbers with -1)
3. Loop through the array again, and return the number that hasn't been marked -ve
Time complexity: O(N)
Space complexity: O(1)
*/
class FindAllNumbersDisappeared {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        List<Integer> results = new ArrayList<>();
        int tempIndex=0;
        for(int i=0;i<=nums.length-1;i++)
        {
            /* 
            We need to take the absolute value here as the numbers are being updated to their -ve counterparts randomly
            Because of which, nums[i] might give us a negative number
            */
            tempIndex=Math.abs(nums[i])-1;
            if(nums[tempIndex]>0) 
                nums[tempIndex] *= -1;
        }
        
        for(int j=0; j<=nums.length-1; j++)
        {
            /* The number that are positive, are postive because they were never reached through their indexes.
            That would mean, the positive number index when incremented by 1, is the number that was missing 
            in the array. 
            */
            if(nums[j]>0)
                results.add(j+1);
        }
        return results;
    }
}