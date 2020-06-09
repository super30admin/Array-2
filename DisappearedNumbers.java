// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * nos range from 1 to n and index too...hence always need to connect index and nos
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> lst = new ArrayList<Integer>();

        for(int i=0;i<nums.length;i++){          //negating those index ele where the number is already found
            int idx = Math.abs(nums[i])-1; //taking each no as the index and making that index val -present

            if(nums[idx] > 0) nums[idx] *= -1;
        }

        for(int i=0;i<nums.length;i++){          //all the nos which r not negative -- coz those nos were not found
            if(nums[i] > 0){
                lst.add(i+1);
            }
        }
        return lst;

    }
}