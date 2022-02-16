/**
 * # T.C => O(n)
# S.C => O(1)

# Approach => Here we are taking the index and conversting the index value to possitive -1 and storing in index variable. 
then we are travelling to nums[index] value to make that respective value to positive. 
# At the end in the second pass whatever number which are left positive after first pass there index are taken and adding one to it while storing it
 to a array and returning that value             
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        for(int i =0 ; i<nums.length ; i++){
            int num = Math.abs(nums[i]) - 1;
            if(nums[num] > 0){
                nums[num] = -1 * nums[num];
            }
        }
        
        for(int j = 0 ; j< nums.length ; j++){
            if(nums[j]>0){
                result.add(j+1);
            }          
        }
        return result;
        
    }
}
