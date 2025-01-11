import java.util.*;
import java.lang.*;
import java.io.*;
/*
Time Complexity 
For odd -> 3*(n-1) / 2
For even -> 3*(n-2)/2 +1;
Space Complexity -> O(2)
*/

// The main method must be in a class named "Main".
class Problem3_Solution3 {

    public static List<Integer> returnNums(int[] A, int n) {
        if(A == null || A.length ==0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int min, max;
        int inc;
        if(n%2 ==1) {
            min = A[0];
            max= A[0];
            inc = 1;
        }else {
            if(A[0] < A[1]) {
                min = A[0];
                max = A[1];
            }else {
                min = A[1];
                max = A[0];
            }
            inc = 2;
        }
        for (int i = inc; i< n-1; i= i+2) {
            if(A[i] > A[i+1]) {
                if(A[i] > max) {
                    max = A[i];
                }else if(A[i+1] < min) {
                    min = A[i];
                }
            }else if(A[i] < A[i+1]){
                if(A[i] < min) {
                    min = A[i];
                } else if(A[i+1] > max) {
                    max = A[i];
                } 
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