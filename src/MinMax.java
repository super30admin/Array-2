public class MinMax {
    public int[] minMax (int[] nums) {

        int n = nums.length;
        int i,j=1 ;
        int[] result = new int[2];

        int max = nums[0],min = nums[0];

        for(i=1; i<n && j<n; i++){

            if(nums[i] < nums[j]){
                max = Math.max(max,nums[j]);
                min = Math.min(min,nums[i]);
            }else{

                max = Math.max(max,nums[i]);
                min = Math.min(min,nums[j]);
            }

            i++;
            j = i+2;

        }

        if(i<n){
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);

        }

        result[0] = min; result[1] = max;
        return result;

    }
}
