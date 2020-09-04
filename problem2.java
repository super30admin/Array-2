
public class MinMax {

    static class pair {
        public static int min;
        public static int max;
    }

    public static void getMinMax(int arr[], int n) {

        int i = 0;
        // if has even elements, then compare first 2 elements and do min and max
        if (n % 2 == 0) {

            if (arr[i] < arr[i + 1]) {
                pair.min = arr[i + 1];
                pair.max = arr[i];

            } else {
                pair.max = arr[i];
                pair.min = arr[i + 1];

            }
            // MOVE BY 2
            i = 2;
        } else {
            pair.max = arr[i];
            pair.min = arr[i];

            // assign min max to first ele and move by 1
            i = 1;
        }

        while (i < n - 1) {
            if (arr[i] > arr[i + 1]) {

                if (arr[i] > pair.max) {
                    pair.max = arr[i];
                }
                if (arr[i + 1] < pair.min) {
                    pair.min = arr[i + 1];
                }
            } else {
                if (arr[i + 1] > pair.max) {
                    pair.max = arr[i + 1];
                }
                if (arr[i] < pair.min) {
                    pair.min = arr[i];
                }
            }
            i = i + 2;// move next pair
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int arr[] = { 1000, 11, 445, 1, 330, 3000 };

        getMinMax(arr, 6);
        System.out.println(pair.max + " " + pair.min);
    }

}
