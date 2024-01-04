public class FindMinMaxInArray {

    static class Pair {
        int min;
        int max;
    }
    private static  Pair getMinMax (int[] arr, int size) {
        Pair minmax = new Pair();
        int min = arr[0];
        int max = arr[1];

        for(int i = 2; i < arr.length; i=i+2) {
            if(arr[i] < arr[i+1]) {
                min = Math.min(arr[i], min);
                max = Math.max(arr[i+1], max);
            } else {
                max = Math.max(arr[i], max);
                min = Math.min(arr[i+1], min);
            }
        }
        minmax.min = min;
        minmax.max = max;
        return minmax;
    }

    public static void main(String[] args) {
        int arr[] = { 1000, 11, 445, 1, 330, 3000 };
        int arr_size = arr.length;
        Pair minmax = getMinMax(arr, arr_size);
        System.out.println("Minimum element is " + minmax.min);
        System.out.println("Maximum element is " + minmax.max);
    }
}
