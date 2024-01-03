class Pair {
    int min;
    int max;

    Pair() {
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }
};

public class MinMax {
    void getMinMax(int[] arr) {
        Pair result = new Pair();

        for (int index = 0; index < arr.length; index += 2) {
            if (index + 1 == arr.length) {
                result.min = Math.min(result.min, arr[index]);
                result.max = Math.max(result.max, arr[index]);
            } else if (arr[index] < arr[index + 1]) {
                result.min = Math.min(result.min, arr[index]);
                result.max = Math.max(result.max, arr[index + 1]);
            } else {
                result.min = Math.min(result.min, arr[index + 1]);
                result.max = Math.max(result.max, arr[index]);
            }
        }

        System.out.println("min:" + result.min + " max:" + result.max);
    }
}
