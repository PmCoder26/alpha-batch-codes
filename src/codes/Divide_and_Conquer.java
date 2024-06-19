package codes;

public class Divide_and_Conquer {
    public static void printArr(int[] arr){
        for(int x=0; x<arr.length; x++){
                System.out.print(arr[x]+" ");
        }
        System.out.println();
    }
    public static void merge(int[] arr, int start, int mid, int end){
        int[] tempArr=new int[end-start+1];
        int i=start;
        int j=mid+1;
        int k=0;
//      filling tempArr.
        while(i<=mid && j<=end){
            if(arr[i]<arr[j]){
                tempArr[k++]=arr[i++];
            }
            else{
                tempArr[k++]=arr[j++];
            }
        }
        // for remaining elements in the left part.
        while(i<=mid){
            tempArr[k++]=arr[i++];
        }
        // for remaining elements in the right part.
        while(j<=end){
            tempArr[k++]=arr[j++];
        }
        //   final merging the sorted tempArr into arr.
        for(int m=0, n=start; m<tempArr.length; m++, n++){
            arr[n]=tempArr[m];
        }
    }
    public static void mergeSort(int[] arr, int start, int end){
        if(start>=end){
            return;
        }
        int mid=start+(end-start)/2;
        mergeSort(arr, start, mid);           // left part.
        mergeSort(arr, mid+1, end);     //  right part.
        merge(arr, start, mid, end);
    }
    public static void quickSort(int[] arr, int start, int end){
        if(start>=end){
            return;
        }
        //        let pivot is the last element.
        int pivotIdx=partition(arr, start, end);
        quickSort(arr, start, pivotIdx-1);
        quickSort(arr, pivotIdx+1, end);
    }
    public static int partition(int[] arr, int start, int end){
        int startIdx=start-1;
        for(int x=start; x<end; x++){
            if(arr[x]<=arr[end]){
                startIdx++;
//            swap.
                int temp=arr[x];
                arr[x]=arr[startIdx];
                arr[startIdx]=temp;
            }
        }
        startIdx++;
//            swap.
        int temp=arr[end];
        arr[end]=arr[startIdx];
        arr[startIdx]=temp;
        return startIdx;
    }
    public static int searchTargetIndex(int[] arr, int start, int end , int target){
//      ex : {4,5,6,7,0,1,2}
        if(start>end){
            return -1;
        }
        int mid=start+(end-start)/2;
        if(target==arr[mid]){
            return mid;
        }
//            mid on line L1.
        if(arr[start]<=arr[mid]) {
//            case a: left part.
            if (arr[start] <= target && target <= arr[mid]) {
                return searchTargetIndex(arr, start, mid - 1, target);
            }
            else {
//                case b: right part.
               return searchTargetIndex(arr, mid+1, end, target);
            }
        }
//        mid on line L2.
        else{
//            case c: right part.
            if(arr[mid]<=target && target<=arr[end]){
                return searchTargetIndex(arr, mid+1, end, target);
        }
            else{
//                case d: on the left.
                return searchTargetIndex(arr, start, mid-1, target);
            }

        }



    }


    public static void main(String[] args){

//        Divide and Conquer.  Time complexity - O(nlog(n))

//        Merge Sort.
//        int[] arr={6,3,9,5,2,8};
//        mergeSort(arr, 0, arr.length-1);
//        printArr(arr);

//        Quick sort.
//        Time complexity - Average case - O(nlog(n)).  worst case - O(n^2).
//        int[] arr=x
//        Searching in rotated sorted array.
//        int[] arr={4,5,6,7,0,1,2};
//        quickSort(arr, 0, arr.length-1);
//        printArr(arr);
//        int target=6;
//        System.out.println("The index of the target is: "+searchTargetIndex(arr, 0, arr.length-1, target));







    }
}
