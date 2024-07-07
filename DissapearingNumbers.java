
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


/*Approach1: use HashSet to store the input numbers and search through this for each index to get the missing numbers.
Approach2: Use boolean array and set the value at index nums[i] to true. return all false indices.
*/
/*Optimized way is to use the input array itself to store the found flag. Eg. we set the sign at the index nums[i] to -ve */

class DissapearingNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for(int i=0;i< nums.length;i++){
            int t = Math.abs(nums[i])-1;
            if(nums[t] > 0){
                nums[t] *= -1; //using -ve sign to mark element
            }
        }

        for(int j=0;j<nums.length;j++){
            if(nums[j]<0){
                nums[j] *= -1; //putting back the actual value
            }else{
                result.add(j+1); 
            }
        }

        return result;
    }
}