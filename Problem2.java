import java.util.Arrays;

public class Problem2 {

    // TC - O(logN)
    // SC - O(1)

    public static int[] findMinAndMax(int[] input){
        if(input == null || input.length == 0) return null;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < input.length; i=i+2) {
            if(input.length % 2 == 1 && i + 1 >= input.length)   break;

            if(input[i] > input[i + 1]){
                max = Math.max(max, input[i]);
                min = Math.min(min, input[i+1]);
            }else{
                max = Math.max(max, input[i+1]);
                min = Math.min(min, input[i]);
            }
        }

        if(input.length % 2 == 1){
            max = Math.max(max, input[input.length - 1]);
            min = Math.min(min, input[input.length - 1]);
        }

        return new int[]{min, max};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findMinAndMax(new int[]{2, 5, 6, 7, 8, 9, 1}))); // 1 and 9
    }


}
