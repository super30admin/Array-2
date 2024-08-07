import javafx.util.Pair;

public class MinAndMaxValue {

    public static Pair<Long, Long> minMaxValue(int[] nums){
        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            if(nums[i]<min){
                min = nums[i];
            }
            if(nums[i]>max){
                max = nums[i];
            }
        }
        return new Pair<>(min, max);
    }

    public static void main (String[] args){
        int[] nums = new int[]{4,3,6,9,100,10002};
        Pair<Long,Long> result =  minMaxValue(nums);
        System.out.println(result);
    }
}
