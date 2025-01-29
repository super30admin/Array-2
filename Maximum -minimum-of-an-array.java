// Maximum and minimum of an array using minimum number of comparisons
// Time Complexity : O(n)
// Space Complexity : O(1)

// Approach
// we will take pairs and compare between them. Then we will consider the min & max.
// No. of comparisons when n is even: 1 + 3 * ((n-2)/2) = 1.5n-2
// No. of comparisons when n is odd: 1 + 3 * ((n-3)/2) + 2 = 1.5n

class Solution {
    public void minmax(int[] a) {
        // base
        int minnum = Integer.MAX_VALUE;
        int maxnum = Integer.MIN_VALUE;
        if(a == null || a.length == 0) return;
        for(int i = 0; i < a.length - 2; i += 2) {
            if(a[i] > a[i + 1]) {
                minnum = Math.min(minnum, a[i + 1]);
                maxnum = Math.min(maxnum, a[i]);
            }
            else {
                minnum = Math.min(minnum, a[i]);
                maxnum = Math.min(maxnum, a[i + 1]);
            }
        }
        if(a.length % 2 == 1) {
            minnum = Math.min(minnum, a[a.length - 1]);
            maxnum = Math.min(maxnum, a[a.length - 1]);
        }
        System.out.println(minnum + " " + maxnum);
        return;
    }
}