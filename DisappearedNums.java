class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List <Integer> result = new ArrayList<Integer>();

       for(int i = 0; i < nums.length; i++){

           int temp = nums[i];

           // If found index element is negative

           if(temp < 0){

               temp *= -1;

           }

           if(temp <= nums.length) {

              if(nums[temp - 1] > 0){

               nums[temp-1] *= -1;

              } 

           }

       }

       for(int i = 0; i < nums.length; i++){

           if(nums[i] > 0){

               result.add(i+1);

           }

       }

       return result;
    }
}