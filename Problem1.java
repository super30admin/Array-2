//Accepted on LT
//The idea i used was to make a array of boolean to act it like a hashmap
//but later after the class there was more better solution to optimize space
//Time O(n) space O(1)


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> l = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
           int x = Math.abs(nums[i]);
           if(nums[x-1]>0){
               nums[x-1] = nums[x-1] * (-1);
           }
           

        }

        for(int j=0;j<nums.length;j++){
            if(nums[j]>0){
                l.add(j+1);
            }

        }

        return l;
        
    }
}