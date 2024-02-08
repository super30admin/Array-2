class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
       List<Integer> mylist = new ArrayList<>();
       
        // Linear search O(n2)
        /*
        boolean flag = false;
        for(int i =1; i<=nums.length;i++) {
            flag = false;
            for(int j = 0; j<nums.length;j++) {
                if(nums[j] == i) {
                    flag = true;
                }

            }
            if(flag!=true) {
                 mylist.add(i);
            }

        }
        return mylist;*/
      //Optimised solution 
      // Time complexity : O(n)
      // Space Complexity:O(1)
     
      for(int i =0; i<nums.length;i++) {
          int absvalue = Math.abs(nums[i]);
          if(absvalue > 0) {
              if(nums[absvalue-1] >0) {
              nums[absvalue-1] = nums[absvalue-1] * -1;
              }
          } 
          }

      for(int i =0; i<nums.length;i++) {
          if(nums[i] > 0) {
              mylist.add(i+1);
          } else {
              nums[i] = nums[i]*-1;
          }
      }

       return mylist;
    }
}