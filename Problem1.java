//time complexity : o(n)
//space complexity : o(1)
//disappeared number in array
public class Problem1 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //mark each visited element as negative
         for(int i=0;i<nums.length;i++){
             int index = Math.abs(nums[i])-1;
             if(nums[index]>0){
                 nums[index]*=-1;
             }
             }
             
         //traverse and check if the number is not negative, then return the index
             List<Integer> result = new ArrayList<>();
             for(int i=1;i<=nums.length;i++){
                 if(nums[i-1]>0){
                     result.add(i);
                 }
             }
             
             return result;
         } 
}
