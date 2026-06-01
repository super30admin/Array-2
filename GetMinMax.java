//Time Complexity : O(n)
//Space Complexity : O(1)

import java.util.ArrayList;
import java.util.List;

public class GetMinMax {
    public ArrayList<Integer> getMinMax(int[] arr) {
        int n = arr.length;
        int min, max;
        int i;

        if (n % 2 == 0) {
            if (arr[0] < arr[1]) {
                min = arr[0];
                max = arr[1];
            } else {
                min = arr[1];
                max = arr[0];
            }
            i = 2;
        } else {
            min = max = arr[0];
            i = 1;
        }

        while (i < n - 1) {
            if (arr[i] < arr[i + 1]) {
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i + 1]);
            } else {
                min = Math.min(min, arr[i + 1]);
                max = Math.max(max, arr[i]);
            }
            i += 2;
        }

        return new ArrayList<>(List.of(min, max));
    }
}
