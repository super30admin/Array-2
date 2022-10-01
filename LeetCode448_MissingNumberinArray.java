//Hashset approach
//TC - O(n)+ O(n) == O(2n) ==> O(n)
//SC- O(n) -- hashset used as an auxiliary space
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        if(nums == null || nums.length ==0) return new ArrayList<Integer>();
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for(int i =0; i< n ; i++ )
        {
            set.add(nums[i]);
        }
        int count = n;
        while(count >=1)
        {
            if(!set.contains(count))
            {
                result.add(count);
            }
            count--;
        }
        return result;
    }
}

//optimized approach 
//Use array approach where we mutate the array and then revert it back -- always ask interviewer if mutation is okay then we dont need to revert the muatation!
//space - O(1)
//TC: O(n)+ O(n) == O(2n) => O(n)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
    
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        
        int idx=0;
        int n = nums.length;
        
        for(int i =0; i<n; i++)
        {
            idx = Math.abs(nums[i]) -1;
            if(nums[idx] >0)
            {
                nums[idx] *= -1;
            }
        }
        
        for(int i=0; i<n; i++)
        {
            if(nums[i] >0)
            {
                result.add(i+1);
                
            }nums[i] = nums[i]*1;
        }
        return result;
    }
}

//other approach
//Sort the array , then traverse through the array and do the same like we did in optiized, turn the visited index value to negative. 
//TC- O(n log n) + O(n) ==> O(n logn)
//sc - constant 