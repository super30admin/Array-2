/*
  Time complexity: (3*n/2)-1 comparisons
  Space complexity: O(1)

  Code ran successfully: Yes

  Approach: Pairwise comparisons are done to reduce the number of comparisons.
*/

class MinMaxFinder
{
    public static (int min, int max) FindMinMax(int[] arr)
    {
        int n = arr.Length;
        if (n == 0)
            return (0, 0);

        int min, max;
        int i;

        if (n % 2 == 0)
        {
            if (arr[0] < arr[1])
            {
                min = arr[0];
                max = arr[1];
            }
            else
            {
                min = arr[1];
                max = arr[0];
            }
            i = 2;
        }
        else
        {
            min = max = arr[0];
            i = 1;
        }

        while (i < n - 1)
        {
            int localMin, localMax;
            if (arr[i] < arr[i + 1])
            {
                localMin = arr[i];
                localMax = arr[i + 1];
            }
            else
            {
                localMin = arr[i + 1];
                localMax = arr[i];
            }

            if (localMin < min)
                min = localMin;
            if (localMax > max)
                max = localMax;

            i += 2;
        }

        return (min, max);
    }
}
