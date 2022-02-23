public class MinMax {
    static class Pair {
        int max;
        int min;
    }

    static Pair getMinMax(int[] arr, int n) {
        Pair minmax = new Pair();
        minmax.max = arr[0];
        minmax.min = arr[0];

        for(int i=0; i<n; i++)
        {
            if(minmax.max < arr[i])
                minmax.max = arr[i];
            else if(minmax.min > arr[i])
                minmax.min = arr[i];
        }
        return minmax;
    }
    public static void main(String[] args) {
        int[] nums = {1000, 11, 445, 1, 330, 3000};
        int length = nums.length;
        Pair minmax = getMinMax(nums, length);
        System.out.println("Maximum: " + minmax.max);
        System.out.println("Minimum: " + minmax.min);
    }
}
