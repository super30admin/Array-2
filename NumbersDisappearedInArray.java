class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
       
        //Declaring a result array
        List<Integer> result = new ArrayList<>();
        
        // iterating through the array
        // since the numbers in array are from 1 to n i.e., the length of the array
        // every time I encounter a new integer, i make the corresponding index value -ve
        // finally the indices with positive value are the ones whose corressponding values are missing
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            
            if(nums[index] > 0){
                nums[index] = nums[index] * -1;
            }
        }
        
        //add the corressponding values of indexes with positive values to the list
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                result.add(i+1);
            }
        }
        
        //return the result list
        return result;
    }
}

//Time Complexity : O(n) n->length of the array
//Space Complexity: O(1) constant space as we are not using any auxilary data structure

