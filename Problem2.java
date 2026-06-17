// Time Complexity: O(n)
// Space Complexity: O(1)
// The idea here is to reduce the number of comparisions by using pairwise comparison technique for finding min and max
// Total comparisons:
// For Even n:  3 × (n/2) = 1.5n
// For Odd n:  3 × ((n-1)/2) + 2
class Problem2 {
    public ArrayList<Integer> getMinMax(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        int min = arr[0];
        int max = arr[0];
        int length = arr.length;
        int remainder = length%2;
        // find number of times we have to iterate based on length of array
        // if length is even all iterations. If length is odd skip the ;ast iteration
        // to avoid index out of bound
        int iterations = remainder == 0 ? length : length-1;

        for(int i=0; i<iterations; i = i+2){
            if(arr[i] > arr[i+1]) {
                min = Math.min(min, arr[i+1]);
                max = Math.max(max,arr[i]);
            } else {
                min = Math.min(min, arr[i]);
                max = Math.max(max,arr[i+1]);
            }
        }

        // extra 2 comparisions for last element in odd length case.
        if(remainder!=0){
            min = Math.min(min, arr[length-1]);
            max = Math.max(max, arr[length-1]);
        }
        res.add(min);
        res.add(max);
        return res;
    }
}
