
//Time Complexity - O(N)
//Space complexity - O(1)


public class MinMax {

    static class MinNMaxPair {
        int min;
        int max;
    }


    static MinNMaxPair getPair(int arr[], int size) {

        MinNMaxPair pair = new MinNMaxPair();

        int i;

        if(size == 1) {

            pair.max = arr[0];
            pair.min = arr[0];
            return pair;

        }

        if(arr[0] > arr[1]) {
            pair.max = arr[0];
            pair.min = arr[1];
        }
        else {
            pair.min = arr[0];
            pair.max = arr[1];
        }

        for( i = 2; i < size; i++) {

            if(arr[i] > pair.max) {
                pair.max = arr[i];
            }
            else if(arr[i] < pair.min){
                pair.min = arr[i];
            }


        }

        return pair;


    }

    public static void main(String [] args) {

        int arr[] = new int[]{3,4,2,6,5,8,9};
        int size = arr.length;
        MinNMaxPair pair = getPair(arr,size);
        System.out.println("minimum element" + " " + pair.min);
        System.out.println("max element" + " " + pair.max);


    }

}
