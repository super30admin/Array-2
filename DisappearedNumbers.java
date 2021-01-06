
// Time Complexity : O(n), n is the number of elements
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Three line explanation of solution in plain english
/*
make use of the given property that, nums[i] is in the range of 1 to n.
at every iteration, go the index of nums[i] i.e nums[nums[i]] and if its greater than 0,  then mark it is as visited by simply chaning the sign.

traverse the nums array again, at any given point if element is > 0 then add (i+1) which is the missing element to result list. 



*/

// Your code here along with comments explaining your approach
class DisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
    
        if(nums.length == 0){
            return new ArrayList<>();
        }
        
        for(int i =0 ;i < nums.length;i++){
            int currNum = Math.abs(nums[i]);
            
            if(nums[currNum-1] >0)
                nums[currNum-1] = -nums[currNum-1];
            
           
        }
        
        List<Integer> res = new ArrayList<>();
        for(int i =0 ;i < nums.length;i++){
            if(nums[i] > 0 ){
                res.add(i+1);
            }
        }
        return res;
    }
}
