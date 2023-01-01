import java.util.Arrays;

public class quicksort {
    public static void main(String[] args) {
        int[] arr = {789,7489,8948739,890,8739,364785,783495,743,372485,678,654,74,63,734,643,6547456,37,45,346,347,643,65,5,645,635654,6,63,463,63,6,3,34,64,36,45,646,346,34,634,643,6,6,346,5,65,};
        sort(arr, 0 , arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    static void sort(int[] arr ,int low , int hi){
        if(low >= hi) return;

        int s = low;
        int e = hi;
        int mid = s + (e - s)/2;
        int pivot = arr[mid];
        while(s <= e){
            while(arr[s] < pivot){
                s++;

            }
            while (arr[e] > pivot){
                e--;
            }
            if(s <= e){
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }
        sort(arr, low , e);
        sort(arr,s,hi);
    }
}
