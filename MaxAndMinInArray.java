public class MaxAndMinInArray {

    public int[] getMaxAndMinInArray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[] res=new int[2];
        for (int i = 1; i <nums.length;i++){
          min = Math.min(min,Math.min(nums[i],nums[i-1]));
            max = Math.max(max,Math.max(nums[i],nums[i-1]));
        }
        res[0]=min;
        res[1]=max;
        return res;
    }

    public static void main(String[] args) {
        MaxAndMinInArray maxAndMinInArray=new MaxAndMinInArray();
       int[] result= maxAndMinInArray.getMaxAndMinInArray(new int[]{2,8,6,2,11,5,70});
    }
}
