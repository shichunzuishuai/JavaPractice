public class ArraySearch {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,4,6,4,5,5};
        arraySearch(arr);
    }
    public static void  arraySearch(int[] arr){
        int n = arr.length;
        for( int i = 0; i < n; i++){
                int count = 0;
            for(int j = 0; j < n; j++){
                if(arr[i] == arr[j]){
                    count++;
                }
            }
            if(count == 1){
                System.out.println(arr[i]);
            }
        }
    }
}

