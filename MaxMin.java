class MaxMin{

    static class Pair{
        int min;
        int max;
        
    }
    
    Pair findMaxMin(int[] arr){
        Pair calc = new Pair();
        calc.min = arr[0];
        calc.max = arr[0];
        int n = arr.length;
        if(n == 1) return calc;
        int  i = 0;
        if(n%2 == 0){
            if(arr[0] > arr[1]){
                calc.min = arr[1];
                calc.max = arr[0];
            }else{
                calc.min = arr[0];
                calc.max = arr[1];
            }
            i=2;
        }else{
            calc.min = arr[0];
            calc.max = arr[1];
            i=1;
        }

        while(i<n-1){
            if(arr[i] > arr[i+1]){
                calc.min = Math.min(arr[i+1],calc.min);
                calc.max = Math.max(arr[i], calc.max);
            }else {
                calc.min =Math.min(arr[i],calc.min);
                calc.max = Math.max(arr[i+1],calc.max);
            }
            i++;
        }
        return calc;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,90,999,-2344,3,554,63,1,4,-9,22,-65};

        MaxMin obj = new MaxMin();
        Pair p = obj.findMaxMin(arr);
        System.out.println(p.min + " " + p.max);

    }
}