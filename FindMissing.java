class FindMissing {
    public List<Integer> findDisappearedNumbers(int[] arr) {
           int temp=0;
          int n= arr.length;
          System.out.println(n);
          List<Integer> result = new ArrayList<>();
          for(int i=0;i<n;i++){
              temp= arr[i]>0?arr[i]:arr[i]*-1;
             arr[temp-1]= arr[temp-1]>0?arr[temp-1]*-1:arr[temp-1];
          }
          
          for(int i=0;i<n;i++){
              if(arr[i]>0){
                  result.add(i+1);
              }
          }
          return result;
    }
}