//executed in Leet code
//Time complexity-o(n)
//space complexity -o(n)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
         List<Integer>  finalResult = new ArrayList<Integer>();
           int[] result= new int[nums.length];
           for(int i=0;i<nums.length;i++){
               result[i]=(i+1);
           }
           for(int i=0;i<nums.length;i++){
               result[nums[i]-1]=0;
           }
           for(int i=0;i<nums.length;i++){
               if(result[i]!=0) finalResult.add(i+1);
           }
           
           return finalResult;
    }
}
