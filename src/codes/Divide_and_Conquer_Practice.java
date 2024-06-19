package codes;

public class Divide_and_Conquer_Practice {

    public static void sortPlanetMerge(String[] arr, int start, int end){
        if(start>=end){
            return;
        }
        else{
            int mid=start+(end-start)/2;
            sortPlanetMerge(arr, start, mid);
            sortPlanetMerge(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void merge(String[] arr, int start, int mid, int end){
        String[] temp=new String[end-start+1];
        int i=start;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=end){
            if(arr[i].compareTo(arr[j])<0){
                temp[k++]=arr[i++];
            }
            else{
                temp[k++]=arr[j++];
            }
        }
//        for remaining elements.
        // for left part.
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=end){
            temp[k++]=arr[j++];
        }
//        final merge.
        for(int x=start, m=0; m<temp.length; x++, m++){
            arr[x]=temp[m];
        }
    }

    public static void printArr(String[] arr){
        for(int x=0; x<arr.length; x++){
            System.out.print(arr[x]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args){
//        Divide and Conquer practice.

//        Q.1.
//        String[] arr={"sun", "earth", "mars", "mercury"};
//        sortPlanetMerge(arr, 0, arr.length-1);
//        printArr(arr);

//        Q.3.





    }


}
