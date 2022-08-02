//TC: O(n)
//SC: O(n) used boolean array of space n+1
//Leetcode : succesful 

// Tried to optimize but not able to
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