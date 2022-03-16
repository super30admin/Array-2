// Time Complexity : O(n) where n is the length of the input
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

class pair {
    long first, second;

    public pair(long first, long second) {
        this.first = first;
        this.second = second;
    }
}

class Compute {
    static pair getMinMax(long a[], long n) {
        boolean isEven;
        long max = Long.MIN_VALUE, min = Long.MAX_VALUE;

        if (a.length % 2 == 0) {
            isEven = true;
        } else {
            isEven = false;
        }

        if (isEven) {
            for (int i = 0; i < a.length; i += 2) {
                if (a[i] > a[i + 1]) {
                    max = Math.max(max, a[i]);
                    min = Math.min(min, a[i + 1]);
                } else {
                    max = Math.max(max, a[i + 1]);
                    min = Math.min(min, a[i]);
                }
            }
        } else {
            for (int i = 0; i < a.length - 1; i += 2) {
                if (a[i] > a[i + 1]) {
                    max = Math.max(max, a[i]);
                    min = Math.min(min, a[i + 1]);
                } else {
                    max = Math.max(max, a[i + 1]);
                    min = Math.min(min, a[i]);
                }
            }

            if (a[a.length - 1] > max) {
                max = a[a.length - 1];
            } else if (a[a.length - 1] < min) {
                min = a[a.length - 1];
            }
        }

        return new pair(min, max);
    }
}