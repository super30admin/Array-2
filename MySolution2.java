import java.util.ArrayList;
public class HelloWorld{

    public static void main(String []args){

        int[] nums = new int[]{1,2,3,6,7,6,7,432};

        ArrayList<Integer> result = new ArrayList<Integer>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int c = 0;
        for (int i = 0; i < nums.length; i++){
            c++;
            if(max < nums[i]){
                max = nums[i];

            }
            c++;
            if (min > nums[i]){
                min = nums[i];

            }

        }
        System.out.println(c +  " " + max+ " "+ min);
    }
}