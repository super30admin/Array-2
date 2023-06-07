// Time Complexity : O(n) + O(n) = O(n) [ 2 pass algorithm]
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //base case
        if(nums.length == 0 || nums == null )return new ArrayList<>();

        ArrayList<Integer> result = new ArrayList<Integer>();
 int n = nums.length;

   for(int i=0;i<n;i++){
      // since the array ranges from 0 to n-1 and the range of the array is 1-n
    int index = Math.abs(nums[i])- 1;
    //if the value is +ve in the index convert to negative indicating the value is present in the array
   if(nums[index] > 0){
       nums[index] = nums[index] * -1;//fancy way to convert it to negative value
   }
       }
       //if the array has +ve value that means the value is not present oin the array. So return its index+1
        for(int i=0;i<n;i++){
            if(nums[i] > 0){
                result.add(i+1);
            }
            else{//not necessary in this problem but if the question asks to return the original array
                nums[i] = nums[i] * -1;
            }
        }
        return result;
   }
         
    } 