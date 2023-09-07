class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();


        for(int i=0; i<nums.length; i++){
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx]>=0){
                nums[idx] *= -1;
            }
            
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i]>0){
                list.add(i+1);
            }
        }

        return list;
    }
}



/**

TC : O(n) + O(n) --> First Iteration is to make state change, second iteration is to find missing numbers.
SC : O(1) --> No Auxilary Space used 


Description : Instead of creating a new HashSet, we will use the input array as a HashSet. Here, Learning a Concept called state change.

Iterating through the input array and by doing (num - 1) we get the index. Making this index value -ve. If it is already -ve no changes required. After completing this iteration, again iterating the array and checking for positive numbers. If we find any positive number, index + 1 is the result. TC : O(n) SC : O(1).






 */