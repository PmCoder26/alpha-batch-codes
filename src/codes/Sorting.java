package codes;
import java.util.Arrays;
import java.util.Collections;

public class Sorting{

    public static int[] swap(int[] arr, int n1, int n2){
        int temp=arr[n1];
        arr[n1]=arr[n2];
        arr[n2]=temp;
        return arr;
    }
    public static void printArr(int[] arr){
        for(int x=0; x<arr.length; x++){
            System.out.print(arr[x]+" ");
        }
        System.out.println();
    }
    public static void printArr(Integer[] arr){
        for(int x=0; x<arr.length; x++){
            System.out.print(arr[x]+" ");
        }
        System.out.println();
    }
    public static int[] bubbleSortIncreasingOrder(int[] arr){
        boolean flag=true;
        for(int x=0; x<arr.length-1; x++){
            for(int y=0; y<arr.length-x-1; y++){
               if(arr[y]>=arr[y+1]){
                   flag=false;
                   swap(arr, y, y+1);
               }
            }
            if(flag==true){
                break;
            }
        }
        return arr;
    }
    public static int[] selectionSortIncreasingOrder(int[] arr){
        for(int x=0; x<arr.length-1; x++){
            int idx=x;
            for(int y=x+1; y<arr.length; y++){
                if(arr[idx]>arr[y]){
                    idx=y;
                }
            }
            swap(arr, x, idx);
        }
        return arr;
}
    public static int[] insertionSortIncreasingOrder(int[] arr){
        for(int x=1; x<arr.length; x++){
            int y=x;
            while(y>0 && arr[y]<=arr[y-1]){
                swap(arr, y,y-1);
                y--;
            }
        }
        return arr;
}
    public static int[] countSortIncreasingOrder(int[] arr){
        int maxEle=arr[0];
//        finding the largest element in order to get the size of frequency array.
        for(int x=1; x<arr.length; x++){
            if(maxEle<arr[x]){
                maxEle=arr[x];
            }
        }
        int[] freqArr=new int[maxEle+1];
//        filling the frequency Array.
        for(int x=0; x<arr.length; x++){
              freqArr[arr[x]]++;
        }
//      sorting arr.
    int idx=0;
    for(int x=0; x<freqArr.length; x++){
        for(int y=0; y<freqArr[x]; y++){
            arr[idx++]=x;
        }
    }
        return arr;
}

//      practice questions methods.

    public static int[] bubbleSortDecreasingOrder(int[] arr){
        boolean flag=false;
        for(int x=0; x<arr.length-1; x++){
            for(int y=0; y<arr.length-1; y++){
                if(arr[y]<arr[y+1]){
                    flag=true;
                    swap(arr, y, y+1);
                }
            }
            if(flag==false){
                return arr;
            }
        }
        return arr;
    }
    public static int[] selectionSortDecreasingOrder(int[] arr){
        for(int x=0; x<arr.length-1; x++){
            int y=x;
            for(int z=x+1; z<arr.length; z++){
                if(arr[y]<arr[z]){
                    y=z;
                }
            }
            swap(arr, y, x);
        }
        return arr;
    }
    public static int[] insertionSortDecreasingOrder(int[] arr){
//        int[] arr={3,6,2,1,8,7,4,5,3,1};
        for(int x=1; x<arr.length; x++){
            int y=x;
            while(y>0 && arr[y]>=arr[y-1]){
                swap(arr, y,y-1);
                y--;
            }
        }
        return arr;
    }
    public static int[] countSortDecreasingOrder(int[] arr){
//        finding the max element.
        int maxEle=arr[0];
        for(int x=1; x<arr.length; x++){
            if(maxEle<arr[x]){
                maxEle=arr[x];
            }
        }
//        creating a frequency array.
        int[] freqArr=new int[maxEle+1];
//        int[] arr={3,6,2,1,8,7,4,5,3,1};
//        filling the frequencies with elements in freqArr.
        for(int x=0; x<arr.length; x++){
            freqArr[arr[x]]++;
        }
//      refilling the arr with the help of freqArr to sort the  array.
        int idx=arr.length-1;
        for(int x=0; x< freqArr.length; x++){
            for(int y=0; y<freqArr[x]; y++){
                arr[idx--]=x;
            }
        }
        return arr;
    }

    public static void main(String[] args){

    //        Bubble sort.
//        int[] arr={2,3,4,623,3,221};
//        System.out.println("Array before sorting : ");
//        printArr(arr);
//        System.out.println("Array after sorting : ");
//        printArr(bubbleSortIncreasingOrder(arr));

    //       Selection sort.
//        int[] arr={2,3,4,623,3,221};
//        System.out.println("Array before sorting : ");
//        printArr(arr);
//        System.out.println("Array after sorting : ");
//        printArr(selectionSortIncreasingOrder(arr));

    //       Insertion sort.
//        int[] arr={2,3,4,623,3,221};
//        System.out.println("Array before sorting : ");
//        printArr(arr);
//        System.out.println("Array after sorting : ");
//        printArr(insertionSortIncreasingOrder(arr));

    //      In-built sort.
//        int[] arr={4,78,5,3,6,6};
//        System.out.println("Array before sorting : ");
//        printArr(arr);
//        System.out.println("Array after sorting : ");
//        Arrays.sort(arr);
//      sorting using limits of index.
//        Arrays.sort(arr, 2,5);
//      sorting in reverse order using java collections. Note - works only with objects rather than primitive data types.
//        Integer[] arr={4,78,5,3,6,6};   // here arr is an objects.
//        System.out.println("Array before sorting : ");
//        printArr(arr);
//        System.out.println("Array after sorting : ");
//        Arrays.sort(arr,Collections.reverseOrder());    // reverse sorts from n to m-1
        // reverse sorting using limits.  Note - reverse sorts from n to m-1
//        Arrays.sort(arr, 2,5, Collections.reverseOrder());
//        printArr(arr);

//        Count sort.
//        int[] arr={6,4,2,5,1,7,8};
//        System.out.println("Array before sorting : ");
//        printArr(arr);
//        System.out.println("Array after sorting : ");
//        printArr(countSortIncreasingOrder(arr));

//        Practice question.
//        sorting in descending order.
//        int[] arr={3,6,2,1,8,7,4,5,3,1};
//       bubble sort.
//        System.out.println("The sorted array is : ");
//        printArr(bubbleSortDecreasingOrder(arr));
//        printArr(selectionSortDecreasingOrder(arr));
//        printArr(insertionSortDecreasingOrder(arr));
//        printArr(countSortDecreasingOrder(arr));




    }
}
