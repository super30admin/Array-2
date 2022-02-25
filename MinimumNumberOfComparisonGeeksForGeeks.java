// Time Complexity : O(n)
// Space Complexity : O(1)
// It runs successfully
// didn't face any problems

public class MinimumNumberOfComparisonGeeksForGeeks {

        // Approach 1
        // Time Complexity : O(n)
        // Space Complexity : O(1)
        //Comparison : 1 + 3*(n-2)/2    when n is even
        //             3(n-1)/2         when n is odd
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        public void getMinMax(int[] arr){

            int n = arr.length;
            int i=0;

            if(n==0){                       //if array is zero length
                min = -1;
                max = -1;
                return;
            }

            if(n%2 == 0){                   //if array length is even

                if(arr[0]>arr[1]){          //check for 1st and 2nd element for max and min and assign global max and min
                    min = arr[1];
                    max = arr[0];
                }
                else{
                    min = arr[0];
                    max = arr[1];
                }
                i+=2;                   //assigned 2 element so increment i pointer to 2
            }
            else{
                min = arr[0];           //if length is odd then assign first element to global min and max
                max = arr[0];
                i+=1;
            }

            while(i<n-1){               //iterate through last element of the array

                if(arr[i]>arr[i+1]){    // check which is the min and max element for the next 2 element

                    if(arr[i] > max){   //whichever is greater check with the global max
                        max = arr[i];
                    }
                    if(arr[i+1] < min){ //whichever is lower check with the global min
                        min = arr[i+1];
                    }

                }
                else{

                    if(arr[i+1] > max){
                        max = arr[i+1];
                    }

                    if(arr[i] < min){
                        min = arr[i];
                    }

                }
                i+=2;                       //taking 2 element at a time so increment i pointer to 2
            }
        }


    // Approach 2
    // Time Complexity : O(n)
    // Space Complexity : O(n)
    //Comparison : 3(n/2) - 2    when n is in power of 2
    //            > 3(n/2) - 2    when n is not in power of 2
//    static class Pair{
//        int min;
//        int max;
//    }
//
//    public Pair getMinMax(int[] arr, int low, int high){
//
//        Pair minmax = new Pair();
//
//        if(low == high){
//
//            minmax.min = arr[low];
//            minmax.max = arr[low];
//            return minmax;
//        }
//        if(high == low + 1){
//            if(arr[low]>arr[high]){
//                minmax.max = arr[low];
//                minmax.min = arr[high];
//            }
//            else{
//                minmax.max = arr[high];
//                minmax.min = arr[low];
//            }
//            return minmax;
//        }
//
//        int mid = (low + high)/2;
//
//        Pair left = getMinMax(arr, low, mid);
//        Pair right = getMinMax(arr, mid+1, high);
//
//        if(left.max > right.max){
//            minmax.max = left.max;
//        }
//        else{
//            minmax.max = right.max;
//        }
//
//        if(left.min < right.min){
//            minmax.min = left.min;
//        }
//        else{
//            minmax.min = right.min;
//        }
//        return minmax;
//
//    }

    // Approach 3
    // Time Complexity : O(n)
    // Space Complexity : O(n)
    //Comparison : 1 + 2(n-2)
//    int min = Integer.MAX_VALUE;
//    int max = Integer.MIN_VALUE;
//
//    public void getMinMax(int[] arr){
//
//        int n = arr.length;
//        if(n==0){
//            return;
//        }
//        else if(n==1){
//            min = arr[0];
//            max = arr[0];
//            return;
//        }
//        else {
//
//            if(arr[0] > arr[1]){
//                min = arr[1];
//                max = arr[0];
//            }
//            else{
//                min  = arr[0];
//                max = arr[1];
//            }
//            for (int i = 2; i < n; i++) {
//
//                if (arr[i] > max) {
//                    max = arr[i];
//                } else if (arr[i] < min) {
//                    min = arr[i];
//                }
//            }
//        }
//    }


        public static void main(String[] args){

            MinimumNumberOfComparisonGeeksForGeeks obj = new MinimumNumberOfComparisonGeeksForGeeks();
            int[] arr = {10,1,22,55,7,8,13,6};

            //Approach 1
            obj.getMinMax(arr);
            System.out.println("Max: "+ obj.max);
            System.out.println("Min: "+ obj.min);

            //Approach 2
//            Pair pair = obj.getMinMax(arr, 0, arr.length-1);
//            System.out.println("Max: "+pair.max);
//            System.out.println("Min: "+ pair.min);


            //Approach 3
//            obj.getMinMax(arr);
//            System.out.println("Max: "+ obj.max);
//            System.out.println("Min: "+ obj.min);






        }




}
