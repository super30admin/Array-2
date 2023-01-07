// Solution 1
// Time Complexity = O(n)
// Space Complexity = O(n)
/*
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList <>(); 
        HashSet <Integer> set = new HashSet<>();
        for(int i = 0; i<=n-1; i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }   
        }
        
        for(int i = 1; i <=n; i++){
            if(!set.contains(i)){
                result.add(i);
            }
        }
    return result;
    }
}
*/

// Time Complexity = O(n)
// Space Complexity = O(1)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List <Integer> result = new ArrayList<>();
        
        for(int i = 0; i<n; i++){
            int idx = Math.abs(nums[i]) -1;
            if(nums[idx] > 0){
                nums[idx] *= -1;
            }
        }
        
        for(int i =0; i<n;i++){
            if(nums[i]>0){
                result.add(i+1);
            }
            
        }
        return result;
    }
}    

