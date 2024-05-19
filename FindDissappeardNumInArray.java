/**
Brute force :
            1. Sort n check missing - TC(nlogn), O(1)
            2. HashSet n check missing - TTC O(n), O(1)
 */
/* Optimal sol = Use nums[i] and go to hat index -1 in array and mark it as negative.
        TC-O(n), SC-O(1)


Note: If arrays contains negative , have a offset of the smallest element and subract with all numbers. 
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            int num = Math.abs(nums[i]);

            int idx = num-1;

            if(nums[idx]>0){
                nums[idx]*= -1;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                result.add(i+1);
            } else {
                nums[i]*=-1;
            }
        }
        return result;
    }
}