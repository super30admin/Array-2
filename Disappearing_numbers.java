// Time Complexity :O(N) N=number of elements in given array
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//Whenever you encounter the element, mark its index as negative value to track that this element has appeared and then add the elements having positive index to result

    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {

            List<Integer> result=new ArrayList<>();

            for(int num: nums){

                int index=Math.abs(num)-1;

                if(nums[index]>0){
                    nums[index]=-nums[index];
                }

            }

            for(int i=0;i<nums.length;i++){

                if(nums[i]>0){

                    result.add(i+1);
                }
            }
            return result;

        }
    }