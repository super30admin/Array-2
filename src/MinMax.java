//                           Iterative Optimal       Recursive Optimal        Brute-Force
// Number of Comparisons:    (3n-4)/2 [n-Even]     (3n-4/2)[n-power of 2]       (2n-2)
//                            (3n-6)/2 [n-Odd]        (2n-2) [n-other]          (2n-2)
// where n is length of array
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement


public class MinMax {
    static class Pair {                                             // inner class
        int max;
        int min;
    }

    static Pair getMinMax(int[] arr, int n) {
        Pair minmax = new Pair();
        int i;
        if(n%2 != 0)                                                // odd number of elements
        {                                                           // setting up min, max
            minmax.min = arr[0];
            minmax.max = arr[0];
            i = 1;
        }
        else                                                        // even number of elements
        {
            if(arr[0] < arr[1])                                     // setting up min, max
            {
                minmax.min = arr[0];
                minmax.max = arr[1];
            }
            else
            {
                minmax.min = arr[1];
                minmax.max = arr[0];
            }
            i = 2;
        }

        while(i < n-1)                                             // Rest of the elements
        {
            if(arr[i] < arr[i+1])                                  // setting up min, max
            {
                if(arr[i] < minmax.min)
                    minmax.min = arr[i];
                if(arr[i+1] > minmax.max)
                    minmax.max = arr[i+1];
            }
            else
            {
                if(arr[i+1] < minmax.min)
                    minmax.min = arr[i+1];
                if(arr[i] > minmax.max)
                    minmax.max = arr[i];
            }
            i += 2;
        }
        return minmax;
    }


// ****************************** Recursive Approach ******************************
//    static Pair getMinMax(int[] arr, int l, int r) {
//        Pair minmax = new Pair();
//
//        if(l == r)                                                // only one value
//        {                                                         // setting up min, max
//            minmax.min = arr[l];
//            minmax.max = arr[l];
//        }
//        else if(l+1 == r)                                         // only two values
//        {
//            if(arr[l]>arr[r])                                     // setting up min, max
//            {
//                minmax.min = arr[r];
//                minmax.max = arr[l];
//            }
//            else
//            {
//                minmax.min = arr[l];
//                minmax.max = arr[r];
//            }
//        }
//        else                                                      // more than two values
//        {
//            int mid = l + (r-l)/2 ;
//            Pair mml = new Pair();
//            Pair mmr = new Pair();
//
//            mml = getMinMax(arr,l,mid);                           // left sub part
//            mmr = getMinMax(arr,mid+1,r);                         // right sub part
//
//            if(mml.min < mmr.min)                                 // setting up min, max
//                minmax.min = mml.min;
//            else
//                minmax.min = mmr.min;
//
//            if(mml.max < mmr.max)
//                minmax.max = mmr.max;
//            else
//                minmax.max = mml.max;
//        }
//        return minmax;
//    }


// ****************************** Brute Force Approach ******************************
//    static Pair getMinMax(int[] arr, int n) {
//        Pair minmax = new Pair();
//        minmax.max = arr[0];
//        minmax.min = arr[0];
//
//        for(int i=0; i<n; i++)
//        {
//            if(minmax.max < arr[i])
//                minmax.max = arr[i];
//            else if(minmax.min > arr[i])
//                minmax.min = arr[i];
//        }
//        return minmax;
//    }

    public static void main(String[] args) {
        int[] nums = {1000, 11, 445, 1, 330, 3000};
        int length = nums.length;
        Pair minmax = getMinMax(nums, length);
        System.out.println("Minimum: " + minmax.min);
        System.out.println("Maximum: " + minmax.max);
    }
}
