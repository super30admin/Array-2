//TC: O(n)
//SC: O(n) used boolean array of space n+1
//Leetcode : succesful 

// BRUTE FORCE
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean [] arr = new boolean[nums.length+1];
        for(int i=0;i<nums.length;i++){
            if(arr[nums[i]]==false)
                arr[nums[i]]=true;
        }
        for(int i=1;i< arr.length;i++){
            if(arr[i]==false)
                list.add(i);
        }
        return list;
    }
    
}


// Optimized soln

//TC: O(n)
//SC:O(1)
//leetcode successful

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i =0;i<nums.length;i++){
            int idx = Math.abs(nums[i])-1;
            if(nums[idx]>0)
                nums[idx]=-1*nums[idx];
        }
        for(int i =0;i<nums.length;i++){
            if(nums[i]>0)
                list.add(i+1);
        }
        return list;
    }
}