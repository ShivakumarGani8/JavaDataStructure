public class BinarySearch {
    public static void main(String args[]){  
        int arr[] = {10,20,30,40,50};  
        int key = 30;  
        int last=arr.length-1;  
        System.out.println(binarySearch(arr,0,last,key));     
 }
    public static boolean binarySearch(int arr[], int first, int last, int key){  
        int mid = (first + last)/2;  
        while( first <= last ){
            if ( arr[mid] == key )
                return true; 
            if ( arr[mid] < key ) 
             first = mid + 1;
            else
              last = mid - 1; 
            mid = (first + last)/2;  
        } 
        return false;
}
}
