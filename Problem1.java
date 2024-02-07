//## Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)

// Time Complexity : Optimized Solution - O(N), where N is the number of elements in input array
// Space Complexity : Optimized Solution - O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    // 1. Brute force solution
    private List<Integer> bruteForce(int[] nums){
        List<Integer> op=new ArrayList<>();

        // Iterate from 1 to n and check if it exists in nums
        for(int num=1;num<=nums.length;num++){
            // Search num in nums
            boolean found=false;
            for(int n: nums){
                if(n==num){
                    found=true;
                    break;
                }
            }

            if(!found){
                // If number not found, add to op
                op.add(num);
            }
        }

        return op;
    }

    // 2. Optimized Brute force solution
    private List<Integer> optimizedBruteForce(int[] nums){
        List<Integer> op=new ArrayList<>();

        // We are optimizing search using a hashset
        Set<Integer> numSet=new HashSet<>();
        for(int num:nums){
            numSet.add(num);
        }

        // Iterate from 1 to n and check if it exists in nums
        for(int num=1;num<=nums.length;num++){
            // Search num in numSet
            if(!numSet.contains(num)){
                // Element not found, add to op
                op.add(num);
            }
        }

        return op;
    }

    //3. Space and time optimized solution
    private List<Integer> optimized(int[] nums){
        // This builds up on optimized brute force
        // Instead of creating a set, we will use the input array as set itself
        // If an element is seen we will make element at it's index negative
        // This is possible because all elements are positive in input
        List<Integer> op=new ArrayList<>();

        // Build set
        for(int idx=0;idx<nums.length;idx++){
            int currElement=Math.abs(nums[idx]);

            // Mark element at index currElement-1 as negative if not already negative
            if(nums[currElement-1]>0){
                nums[currElement-1]*=-1;
            }
        }

        // Only the elements at indexes will be positive which do not have their
        // corresponding number present in input
        for(int idx=0;idx<nums.length;idx++){
            if(nums[idx]>0){
                op.add(idx+1);
            }
        }
        
        return op;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        //1. Brute force. Time: O(N^2), Space: O(1)
        //return bruteForce(nums);

        //2. Time Optimized brute force. Time: O(N), Space: O(N)
        //return optimizedBruteForce(nums);

        //3. Sapace and time optimized: Time O(N), Space O(1)
        return optimized(nums);
    }
}