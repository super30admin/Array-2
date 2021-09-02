//Time complexity: O(n)
//Space complexity: O(1)
public class MinMaxProblem {
        static class Pair {
            int min;
            int max;
        }
    
        static Pair getMinMax(int arr[], int n) {
            Pair minmax = new Pair();
            int i;
    
            //If there is only one element then we will min and max will be the same element/
            if (n == 1) {
                minmax.max = arr[0];
                minmax.min = arr[0];
                return minmax;
            }
    
            //If there are more elements, compare element at first index and
            //initializer min and max
            if (arr[0] > arr[1]) {
                minmax.max = arr[0];
                minmax.min = arr[1];
            } else {
                minmax.max = arr[1];
                minmax.min = arr[0];
            }
    
            for (i = 2; i < n; i++) {
                if (arr[i] > minmax.max) {
                    minmax.max = arr[i];
                } else if (arr[i] < minmax.min) {
                    minmax.min = arr[i];
                }
            }
    
            return minmax;
        }
    
        public static void main(String args[]) {
            int arr[] = {6, 10, -3, 19, 4, 15};
            Pair minmax = getMinMax(arr, arr.length);
            System.out.println("Minimum number: " + minmax.min);
            System.out.println("Maximum number: " + minmax.max);
    
        }
    
    }
    