class MinAndMaxElement {
    static class  Pair {
        int min;
        int max;
    }

    static public  Pair getMinMax(int arr[]) {
        Pair res = new Pair();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] < arr[i + 1]) {
                min = Math.min(min, arr[i]);
                max = Math.max(min, arr[i + 1]);
            } else {
                min = Math.min(min, arr[i + 1]);
                max = Math.max(min, arr[i]);
            }
        }
        res.max = max;
        res.min = min;
        return res;
    }

    public static void main(String args[]) {
        int arr[] = { 1000, 11, 445, 1, 330, 3000 };
        Pair minmax = getMinMax(arr);
        System.out.println("\nMinimum element is "+ minmax.min);
        System.out.println("\nMaximum element is "+minmax.max);
    }
}