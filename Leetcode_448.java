//way1
//Store them in Set. Iterate and identify which element is missed.
//TC: O(2n); SC: O(n)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set=new HashSet<>();

        //first iteration
        for(int i:nums){
            set.add(i);
        }

        int n=nums.length;

        List<Integer> ans=new ArrayList<>();
        //second iteration
        for(int i=1;i<=n;i++){
            if(!(set.contains(i))){
                ans.add(i);
            }
        }

        return ans;
        
    }
}

//way2
//Mutate the original array by going to the exact position of element present at index
//nums[0]=5 -- go to index 4[because 5th element's position is at 4] and update it to negative value at 4th index. It means element 5 is present
//After updating the entire array with abive concept, travel array again to identify missing elements
//TC: O(2n); SC: constant
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            int idx=Math.abs(nums[i])-1;
            if(nums[idx]>0){
                nums[idx]*=-1;
            }

        }

        List<Integer> ans=new ArrayList<>();

        for(int i=0;i<n;i++){
            
            if(nums[i]>0){
                ans.add(i+1);
            }else{
                nums[i]*=-1;
            }
        }

        return ans;
        
    }
}
