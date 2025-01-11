// Online Java Compiler
// Use this editor to write, compile and run your Java code online

/*
Time Complexity -> O(N+N) -> O(N)
Space Complexity -> O(1) 
*/
class Main {
    
    public static int setmini(int[] A, int n) {
        if(A == null || A.length ==0) {
            return 0;
        }
        int min =Integer.MAX_VALUE;
        for (int i=0;i<n; i++) {
            min = Math.min(min, A[i]);
        }
        return min;
    }
    
    public static int setmaxi(int[] A, int n) {
        if(A== null || A.length ==0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            max = Math.max(max, A[i]);
        }
        return max;
    }
    public static void main(String[] args) {
       int[] A = { 4, 9, 6, 5, 2, 3 };
        int N = A.length;
        System.out.println("Minimum element is: "
                           + setmini(A, N));
        System.out.println("Maximum element is: "
                           + setmaxi(A, N));
    }
}