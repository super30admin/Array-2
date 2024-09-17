//With Space O(n)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        
        List<Integer> result = new ArrayList<>();
        
        if (nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        
        for (int i = 0;i < nums.length ; i++){
            set.add(i + 1);
        }
        
        for (int num : nums){
            if (set.contains(num)){
                set.remove(num);
            }
        }
        
       result = new ArrayList<Integer>(set);
        return result;
        
    }
}

//With o(1) space
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
       if (nums == null || nums.length == 0){
           return new ArrayList<>();
       }
        
        
       List<Integer> result = new ArrayList<>();
        
       for (int i = 0; i < nums.length; i++){
           
           int index = Math.abs(nums[i]) - 1;
           
           if (nums[index] > 0){
               nums[index] *= -1;
           }
       }
       
        for (int i = 0; i < nums.length; i++){   
           if (nums[i] > 0){
               result.add(i + 1);
           }
       }
        
        return result;
    }
}