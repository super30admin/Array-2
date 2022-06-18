public class MaxMinArray {
    // TC is O(n)
    // SC is constant
    public static void main(int args[]) {
        int max, min;
        int[] arr = new int[] { 10, 12, 23, 9, 16, 30 };
        int n = arr.length;
        max = arr[0];
        min = arr[0];
        for (int i = 0; i < n; i = i + 2)
        {
            if (i == n - 1)
            {
                if (arr[i] > max)
                    max = arr[i];
                if (arr[i] < min)
                    min = arr[i];
            }
            else if (arr[i] > arr[i + 1])
            {
                if (arr[i] > max)
                    max = arr[i];

                if (arr[i + 1] < min)
                    min = arr[i + 1];
            }
            else
            {
                if (arr[i + 1] > max)
                    max = arr[i + 1];

                if (arr[i] < min)
                    min = arr[i];
            }

        }

        System.out.println(max);

        System.out.println(min);

    }
}
