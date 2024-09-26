// Time Complexity : O(n)n=number of elements in the array. 
// Space Complexity : O(1) no extra space used.
// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :


// Your code here along with comments explaining your approach. We are marking the elements that appear at least one with -1, if the 
// elements is not appearing in the array the element will be possitive. then in second traversal we count elements in the array that are
// possitive.
//Success
//Details 
//Runtime: 5 ms, faster than 81.00% of Java online submissions for Find All Numbers Disappeared in an Array.
//Memory Usage: 48.8 MB, less than 32.08% of Java online submissions for Find All Numbers Disappeared in an Array.
  public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums==null || nums.length==0)
            return new ArrayList<Integer>();
        List<Integer> resp= new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            if (nums[Math.abs(nums[i])-1]>0)
              nums[Math.abs(nums[i])-1]*=-1;
        }
            
        for (int i=0;i<nums.length;i++){
            if (nums[i]>0)
                resp.add(i+1);
        }
        return resp;
    }