// No. of comparision:
// if n is even 3n/2
// if n is odd 3(n-1)/2

public class Problem2{
    public static void main(String[] args) {
        int[] arr= {2,43,62,-5,2,-100,3,-6};
        int comparisions=0;
        int gMin=Integer.MAX_VALUE, gMax=Integer.MIN_VALUE;
        int lMin,lMax;
        int n= arr.length;
        int i=0;
        while(i<n-1){
            if(i==0 && n%2==1){
                gMin=arr[i];
                gMax=arr[i];
                System.out.println();
                System.out.println("Since Length is odd, assigning the first element to gMin and gMax directly");
                System.out.println("Global Min="+gMin+","+"Global Max="+gMax);
                System.out.println();
                i++;
                continue;
            }
            System.out.println("Comparing "+arr[i]+" and "+arr[i+1]);
            if(arr[i]>=arr[i+1]){
                lMin=arr[i+1];
                lMax=arr[i];
            }
            else{
                lMin=arr[i];
                lMax=arr[i+1];
            }
            System.out.println("Local Min="+lMin+","+"Local Max="+lMax);
            System.out.println("Global Min="+gMin+","+"Global Max="+gMax);
            comparisions++;
            System.out.println("Comparions: "+comparisions);
            System.out.println();
            gMin=Math.min(gMin,lMin);
            gMax=Math.max(gMax,lMax);
            System.out.println("Local Min="+lMin+","+"Local Max="+lMax);
            System.out.println("Comparing "+gMin+" with "+lMin+" and "+gMax+" with "+lMax);
            System.out.println("Global Min="+gMin+","+"Global Max="+gMax);
            comparisions+=2;
            System.out.println("Comparions: "+comparisions);
            System.out.println();
            i+=2;
        }
        System.out.println("Min: "+gMin);
        System.out.println("Max: "+gMax);
        System.out.println("Length: "+n);
        System.out.println("Comparions: "+comparisions);
        System.out.println();
    }
}