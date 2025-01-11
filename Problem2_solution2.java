// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.List;
import java.util.ArrayList;

/*
Time Complexity is o(2*(n-2) +1)
Space Complexity is O(2)
*/
class Problem2 {
    
    public static List<Integer> returnNums(int[] A, int N) {
        if(A == null || A.length ==0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int min, max;
        if(A[0] < A[1]) {
            min = A[0];
            max = A[1];
        }else {
            min =A[1];
            max= A[0];
        }
        for(int i = 2; i<N; i++) {
            if(A[i] < min) {
                min = A[i];
            }else if(A[i] > max) {
                max = A[i];
            }
        }
        result.add(min);
        result.add(max);
        return result;
    }
    
    public static void main(String[] args) {
       int[] A = { 4, 9, 6, 5, 2, 3 };
        int N = A.length;
        List<Integer> answers = returnNums(A, N);
        System.out.println("The max element is " + answers.get(1));
        System.out.println("The min element is " + answers.get(0));
    }
}