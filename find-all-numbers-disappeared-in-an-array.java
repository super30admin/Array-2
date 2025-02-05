// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach:bruetforce approach first i have created a array of size n+1 because the elements range between 1 
// to n then i filled that array with  1 where index of array is nums element then 
// i took elements which elements value has zero in arr so those vaues are missing from input array from range except index 0 because the range is (1ton) as mentioned

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
      int n=nums.length;
    
      List<Integer> result=new ArrayList<>();
      int[] arr=new int[n+1];
      for(int i=0;i<n;i++){
       
            arr[nums[i]]= 1;
        }
        for(int i=0;i<arr.length;i++){
       
           if(arr[i] == 0 && i != 0){
           result.add(i);

           }
        }
      
 return result;
    }
}



// Time Complexity : O(2n)->O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : did small mistake later i was able to resolve


// Your code here along with comments explaining your approach:  Mark the numbers  Use each number as an index and make the value at that index negative.  
// Find missing The indices of positive numbers indicate missing values.

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
      int n=nums.length;
      List<Integer> result=new ArrayList<>();
      for(int i=0;i<n;i++){//O(n)
        int index=Math.abs(nums[i])-1;
          if(nums[index] > 0){
       nums[index] *= -1;
        }
         }
      for(int i=0;i<n;i++){//O(n)
        if(nums[i] > 0){
            result.add(i+1);
        }
       }
        return result;
       
      }
}