// Time Complexity : if n is odd O(3*(n-1)/2) if n is even O(3n/2 -2)
// Space Complexity : O(1)
// Did this code successfully run : Yes

public List<Integer> findMininumMaximum(int arr[], int n) {
    List<Integer> output=new ArrayList<Integer>();
    //output[0] stores min and output[1] stores max
    int i;
    if (n % 2 == 0) {
        if (arr[0] < arr[1]) {
            output[0] = arr[0];
            output[1] = arr[1];
        } else {
            output[0] = arr[1];
            output[1] = arr[0];
        }
        i = 2;
    }  
	else {
        output[0] = arr[0];
        output[1] = arr[0];
        i = 1;
    }

    while (i < n - 1) {
        if (arr[i] > arr[i + 1]) {
            if (arr[i] > output[1]) {
                output[1] = arr[i];
            }
            if (arr[i + 1] < output[0]) {
                output[0] = arr[i + 1];
            }
        } else {
            if (arr[i + 1] > output[1]) {
                output[1] = arr[i + 1];
            }
            if (arr[i] < output[0]) {
                output[0] = arr[i];
            }
        }
        i += 2;
    }
    return output;
}
