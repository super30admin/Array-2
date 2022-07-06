// TC : O(n)
// SC : O(1)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length ==0) return new ArrayList<>();
        
        List<Integer> result = new ArrayList<>();
        
        // take absolute, so that dont assign erroneously
        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i])-1;
        // if no. is positive make it negative to know it has been seen in array
           if(nums[index]>0) {
               nums[index] = nums[index] * -1;
            }
        }
        
        // if positive number is present in array, return index+1 as answer
        for(int i =0 ;i<nums.length;i++){
            if(nums[i]>0){
                result.add(i+1);
                
            }
        // else return original array            
            else{
                nums[i]=nums[i]*-1;
            }
        }
        return result;
    }
    
}