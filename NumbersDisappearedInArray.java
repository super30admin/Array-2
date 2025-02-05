import java.util.ArrayList;
import java.util.List;

//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/*
We use concept of temporary state change. We traverse the array left to right 
and for each element we go to nums[element-1] and make it negative to 
show that we have that element. Its like keeping the boolean array. Then we traverse again
and check whichever element is positive that means we didnt find that index, so we do index +1
and store in result.
*/
class NumbersDisappearedInArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n=nums.length;
        List<Integer> ll=new ArrayList<>();
        for(int i=0;i<n;i++){
            int idx=Math.abs(nums[i]);
            if(nums[idx-1]>0){
                nums[idx-1]=nums[idx-1]*-1;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                ll.add(i+1);
            }else{
                nums[i]=nums[i]*-1;
            }
        }
        return ll;
    }
}
