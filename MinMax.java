
/*
Time : 0(N)
Space: 0(1)
 */

public class MinMax {
  public static int findSum(int A[], int N) {

    int max = A[0];
    int min = A[0];

    for (int i = 0; i < N - 1; i += 2) {

      if (A[i] > A[i + 1]) {
        max = Math.max(max, A[i]);
        min = Math.min(min, A[i + 1]);
      } else {
        max = Math.max(max, A[i + 1]);
        min = Math.min(min, A[i]);
      }

    }

    if (N % 2 != 0) {
      max = Math.max(max, A[N - 1]);
      min = Math.min(min, A[N - 1]);

    }
    return min + max;
  }

}
