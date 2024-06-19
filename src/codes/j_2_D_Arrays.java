package codes;
import java.util.*;

public class j_2_D_Arrays {
    public static Scanner sc=new Scanner(System.in);

    public static void printArr(int[][] arr){
        for(int x=0; x<arr.length; x++){
            for(int y=0; y<arr.length+1; y++){
                System.out.print(arr[x][y]+" ");
            }
            System.out.println();
        }
    }
    public static int[][] creatArr(int[][] arr){
        for(int x=0; x<arr.length; x++){
            for(int y=0; y<arr.length+1; y++){
                System.out.print("Element "+x+","+y+":");
                arr[x][y]=sc.nextInt();
            }
        }
        return arr;
    }
    public static void spiralArrPattern(int[][] arr){
        int rCol=arr[0].length-1;
        int lCol=0;
        int bottomRow=arr.length-1;
        int topRow=0;

        while(topRow<=bottomRow && lCol<=rCol){
//            left to right.
            for(int x=lCol; x<=rCol; x++){
                System.out.print(arr[topRow][x]+" ");
            }
            topRow++;
//            top to bottom
            for(int x=topRow; x<=bottomRow; x++){
                System.out.print(arr[x][rCol]+" ");
            }
            rCol--;
//            right to left.
            for(int x=rCol; x>=lCol; x--){
                System.out.print(arr[bottomRow][x]+" ");
            }
            bottomRow--;
//            bottom to top.
            for(int x=bottomRow; x>=topRow; x--){
                System.out.print(arr[x][lCol]+" ");
            }
            lCol++;
        }
    }
    public static int diagonalSum(int[][] arr){
        int diaSum=0;
//        brute force approach.
//        for(int x=0; x<arr.length; x++){
//            for(int y=0; y<arr.length; y++){
//                if(x==y) {
//                    diaSum += arr[x][x];
//                }
//                else if(x+y==arr.length-1){
//                    diaSum+=arr[x][y];
//                }
//            }
//        }

//        optimized approach.
        for(int x=0; x<arr.length; x++){
            diaSum+=arr[x][x];
            if(x!=arr.length-1-x) {
                diaSum += arr[x][arr.length - 1 - x];
            }
        }
        return diaSum;
    }
    public static void targetSearch(int[][] arr, int target){
//        This is known as staircase approach.
//        This approach is valid if array is sorted row wise and column wise. Time complexity- O(x+y)
//        left and bottom approach.
        int x=0, y=arr[0].length-1;
        boolean flag=false;
        while(x<arr.length && y>=0){
            if(target==arr[x][y]){
                System.out.println("The position of the "+target+" is :("+x+","+y+")");
                flag=true;
                break;
            }
            else if(target<arr[x][y]){
                y--;     // moving to left.
            }
            else{
                x++;     // moving bottom.
            }
        }
        if(flag==false){
            System.out.println(target+" is not present.");
        }
    }


    public static void main(String[] args){
//      2-D arrays.

//        int[][] arr=new int[3][3];
//        filling the array.
//        creatArr(arr);
//        printArr(arr);

//        spiral printing.
//        int[][] arr=new int[3][4];
////        filling the array.
//        creatArr(arr);
////        printing the array.
//        System.out.println("The array before spiral printing.");
//        printArr(arr);
//        System.out.print("Spiral format of the array is : ");
//        spiralArrPattern(arr);

//       finding the sum of two diagonals of matrix.
//        int[][] arr={{1,2,3,4,}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
//        System.out.println("The sum of the primary and secondary diagonal of matrix is : "+diagonalSum(arr));

//        searching the target in sorted row wise and column wise 2D matrix.
//        int[][] arr={{10,20,30,40,},
//                     {15,25,35,45},
//                     {27,29,37,48},
//                     {32,33,39,50}};
//        targetSearch(arr, 50);








    }
}
