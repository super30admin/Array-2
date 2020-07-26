//TC: O(n), n: length of nums[]
//SC: O(n)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList();
        List<Integer> res = new ArrayList();
        
        int[] nums2 = new int[nums.length];
        
        for(int x : nums){
            nums2[x-1] = 1;
        }
        
        for(int i = 0; i < nums2.length; i++){
            if(nums2[i]==0){
                res.add(i+1);
            }
        }
    
        return res;
    }
}

//TC: O(n), n: length of nums[]
//SC: O(n)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList();
        Set<Integer> set = new HashSet<Integer>();
        List<Integer> res = new ArrayList();
        for(int x : nums){
            set.add(x);
        }
        
        for(int i = 1; i <= nums.length; i++){
            if(!set.contains(i)){
                res.add(i);
            }
        }
        return res;
    }
}


//TC: O(n), n: length of nums[]
//SC: O(n)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums==null || nums.length == 0) return res;
        int[] nums2 = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            nums2[i] = i+1;
        }
        
         for(int i = 0; i < nums.length; i++){
            nums2[nums[i]-1] = 0;
        }
          
        int low = 0;
        int high = nums2.length-1;
        while(low <= high){
            if(nums2[high] != 0){
                int temp = nums2[low];
                nums2[low] = nums2[high];
                nums2[high] = temp;
                low++;
            }
            else{
                high--;
            }
        }
        
        int pointer = nums2.length-1;
        while(pointer >= 0 && nums2[pointer]==0){
            pointer--;
        }
        for(int i = 0; i <= pointer;i++){
            res.add(nums2[i]);
        }
        return res;
    }
}


//TC: O(n), n: length of nums[]
//SC: O(1)
//Approach:
//1. We iterate over the array and we mark the number at the nums[i] index negative, so as to restore later, that this number is present in the array.
//2. So, if nums[i] = 7, we mark 7th index negative so as to indicate that 7 is present in the array.
//3. At the end of this, if we find number at any of the indexes to be position, it means, no number was found for this index, so if i and j are the indexes 
// which have positive numbers, it means i and j are the disappeared numbers.

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList();
        for(int i = 0; i < nums.length; i++){
            if(nums[Math.abs(nums[i])-1]>0){
                nums[Math.abs(nums[i])-1] *= -1;
            }
        }
        
        for(int i = 0; i < nums.length; i++){
           if(nums[i]>0){
               res.add(i+1);
           }
        }
        return res;
    }
}
