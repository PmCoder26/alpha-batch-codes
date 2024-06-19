package codes;
import java.util.*;

public class Recursion {
    public static Scanner sc=new Scanner(System.in);
    public static void printNumDecrease(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        System.out.println(n+" ");
        printNumDecrease(n-1);
    }
    public static void printNumIncrease(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        printNumIncrease(n-1);
        System.out.println(n);
    }
    public static int factorial(int n){
        if(n==1 || n==0){
            return 1;
        }
        else{
            return n*factorial(n-1);
        }
    }
    public static int numSum(int n){
        if(n==1){
            return n;
        }
        else{
            return n+numSum(n-1);
        }
    }
    public static int fibo(int n){
        if(n==1){
            return 0;
        }
        else if(n==2 || n==3){
            return 1;
        }
        else{
            return fibo(n-1)+fibo(n-2);
        }
    }
    public static boolean isSorted(int[] arr, int index){
        if(index>=arr.length-1){
            return true;
        }
        else{
            if(arr[index]<=arr[index+1]){
                return (true && isSorted(arr, index+1));
            }
            else{
                return false;
            }
        }
    }
    public static int firstOcc(int[] arr, int target, int index){
        if(target==arr[index]){
            return index;
        }
        else if(index>=arr.length){
            return -1;
        }
        else{
            return firstOcc(arr, target, index+1);
        }
    }
    public static int lastOcc(int[] arr, int target, int index){
        if(index>=arr.length){
            return -1;                                           //int[] arr={8,3,6,9,5,10,2,5,3};
        }
        int found=lastOcc(arr, target, index+1);
        if(found!=-1){
            return found;
        }
        if(arr[index]==target){
            return index;
        }
        else{
            return -1;
        }
    }
    public static int powerMultiply(int x, int n){
        if(n==1){
            return x;
        }
        else{
            return x*powerMultiply(x, n-1);
        }
    }
//    calculating x^n.
    public static int optimizedPowerMultiply(int x, int n){          // time complexity- O(logn);
          if(n==1){
              return x;
          }
          else{
              int halfPow=optimizedPowerMultiply(x, n/2);
              // when n is even.
              if(n%2==0){
                  return halfPow*halfPow;
              }
//              when n is odd
              else{
                  return x*halfPow*halfPow;
              }
          }
    }
    public static int tiling(int n){
        if(n==1 || n==0){
            return 1;
        }
        else{
            // for vertical alignment.
            int vertical=tiling(n-1);
            // for horizontal alignment.
            int horizontal=tiling(n-2);
//            returning the total.
            return vertical+horizontal;
        }
    }
    public static String removeDupli(String str, String previous, String unique, int index){
        if(index>=str.length()){
            return unique;
        }
        else {
            if (previous.contains(Character.toString(str.charAt(index)))) {
                previous += str.charAt(index);
                return removeDupli(str, previous, unique, index + 1);
            }
            else{
                previous += str.charAt(index);
                unique+=str.charAt(index);
                return  removeDupli(str, previous, unique, index + 1);
            }
        }
    }
    public static StringBuilder optimizedRemoveDupli(String str, StringBuilder unique, boolean[] map, int index){
        if(index>=str.length()){
            return unique;
        }
        else{
            if(map[str.charAt(index)-'a']==true){
                return optimizedRemoveDupli(str, unique, map, index+1);
            }
            else{
                map[str.charAt(index)-'a']=true;
                return optimizedRemoveDupli(str, unique.append(str.charAt(index)), map, index+1);
            }
        }
    }
    public static int pairProblem(int n){
        if(n==1 || n==2){
            return n;
        }
        else{
            int single=pairProblem(n-1);
            int pair=(n-1)*pairProblem(n-2);
            return single+pair;
        }
    }
    public static void printBinaryString(int n, int lastPlace, String sb){
        if(n==0){
            System.out.println(sb);
            return;
        }
         printBinaryString(n-1, 0, sb+"0");
         if(lastPlace==0){
             printBinaryString(n-1, 1, sb+"1");
         }
    }

    public static void main(String[] args){

//        Recursion.
//    printing numbers from n to 1.
//        printNumDecrease(10);

//        Stack Overflow.
//        When the memory in the stack gets full up and no space available to have recursion calls.

//     printing numbers from 1 to n.
//        printNumIncrease(10);

//     printing factorial fo number
//        System.out.println(factorial(5));

//     printing sum of n natural numbers.
//        System.out.println(numSum(10));

//        printing fibonacci series.
//        System.out.println(fibo(10));

//      checking whether an array is sorted or not.
//        int[] arr={1,22,3,4,5};
//        System.out.println(isSorted(arr, 0));

//        finding the first occurrence of element in array.
//        int[] arr={8,3,6,9,5,10,2,5,3};
//        System.out.println("The index of the target is : "+firstOcc(arr, 5,  0));

//        finding the last occurrence of element in array.
//        int[] arr={8,3,6,9,5,10,2,5,3};
//        System.out.println("The index of the target is : "+lastOcc(arr, 5,  0));

//        calculating x^n.
//        System.out.println("The x^n is : "+powerMultiply(2, 5));

//        calculating x^n by optimized code.
//        System.out.println("The answer of x^n is : "+optimizedPowerMultiply(2,13));

//        Tiling problem.
        /*
        Description - Given a '2 x n' board and tiles of size '2 x 1', count the number of ways to tile a given board using
                      the 2 x 1 tiles.
                      (A tile can be placed either horizontally or vertically)
         */
//        System.out.println("The total number of ways for tilling the 2 x n board is : "+tiling(4));

//        Remove duplicates from a string.
//        String str="appnacollege";
//        System.out.println("The duplicated removed string is : "+removeDupli(str, "", "", 0));
//        System.out.println("The duplicated removed string with optimized code is : "+optimizedRemoveDupli(str, new StringBuilder(""), new boolean[26], 0));

//        Friends pairing problem.
//        System.out.println("The no. of ways friends can remain single or paired is : "+pairProblem(3));

//        Binary Strings problem.
//        Printing all binary strings of size N without consecutive ones.
//        printBinaryString(3, 0, "");






    }
}
