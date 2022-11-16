// Time Complexity : O(n) // 3 * n/2 comparisons
// Space Complexity :O(1)
public class FIndMaxMin {
    class Pair{
        int min;
        int max;
    }    

    private Pair getMinMax(int[] nums, int n){
        Pair pair=new Pair();
        int i=0;
        if(n%2==0){
            if(nums[i]>nums[i+1]){
                pair.max=nums[0];
                pair.min=nums[1];
                
            }else{
                pair.max=nums[1];
                pair.min=nums[0];
            }
            i=2;
        }else{
            pair.max=nums[0];
            pair.min=nums[0];
            i=1;
        }

        while(i<n-1){
            if(nums[i]>nums[i+1]){
                pair.max=Math.max(pair.max,nums[i]);
                pair.min=Math.min(pair.min,nums[i+1]);
            }else{
                pair.max=Math.max(pair.max,nums[i+1]);
                pair.min=Math.min(pair.min,nums[i]);
            }
            i+=2;
        }
        return pair;
    } 
}
