package codes;

import java.util.Scanner;

public class Arrays {
    public static Scanner sc=new Scanner(System.in);

    public static int indexOfTarget(int[] arr, int target){
        for(int x=0; x<arr.length; x++){
            if(arr[x]==target){
                return x;
            }
        }
        return -1;
    }

    public static int maxEle(int[] arr){
        int max=Integer.MIN_VALUE;
        for(int x=0; x<arr.length; x++){
            if(max<arr[x]){
                max=arr[x];
            }
        }
        return max;
    }

    public static int binarySearchTargetIndex(int[] arr, int target){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(target==arr[mid]){
                return mid;
            }
            else if(target<arr[mid]){
                end=mid-1;
            }
            else if(target>arr[mid]){
                start=mid+1;
            }
        }
        return start;
    }

    public static int[] reverseArr(int[] arr){
        for(int x=0; x<arr.length/2; x++){
            int temp=arr[x];
            arr[x]=arr[arr.length-1-x];
            arr[arr.length-1-x]=temp;
        }
        return arr;
    }

    public static void printArr(int[] arr){
        for(int x=0; x<arr.length; x++){
            System.out.print(arr[x]+" ");
        }
        System.out.println();
    }

    public static void printSubArrays(int[] arr){
        for(int x=0; x<arr.length; x++){
            for(int y=x; y<arr.length; y++){
                for(int z=x; z<=y; z++){
                    System.out.print(arr[z]+", ");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void pairsArr(int[] arr){
        for(int x=0; x<arr.length; x++){
            for(int y=x+1; y<arr.length; y++){
                System.out.print("("+arr[x]+","+arr[y]+") ");
            }
            System.out.println();
        }
    }

    public static void sumSubArrays(int[] arr){
        for(int x=0; x<arr.length; x++){
            for(int y=x; y<arr.length; y++){
                int sumSubArr=0;
                for(int z=x; z<=y; z++){
                    sumSubArr+=arr[z];
                }
                System.out.print(sumSubArr);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static int maxSumSubArray(int[] arr){
        int max=Integer.MIN_VALUE;
        for(int x=0; x<arr.length; x++){
            for(int y=x; y<arr.length; y++){
                int sumSubArr=0;
                for(int z=x; z<=y; z++){
                    sumSubArr+=arr[z];
                }
               if(max<=sumSubArr){
                   max=sumSubArr;
               }
            }
        }
        return max;
    }

    public static int areAllNegative(int[] arr){
        int num=0;
        for(int x=0;  x<arr.length; x++){
            if(arr[x]<0){
                num++;
            }
        }
        return num;
    }
    public static int sumArrEle(int[] arr){
        int eleSum=0;
        for(int x=0; x<arr.length; x++){
            eleSum+=arr[x];
        }
        return eleSum;
    }

    public static int maxSumSubArrKdAlgo(int[] arr){
        int n=areAllNegative(arr);
        if(n==arr.length){
            return sumArrEle(arr);
        }
        else {
            int currentSum = 0;
            int finalSum = Integer.MIN_VALUE;
            for (int x = 0; x < arr.length; x++) {
                if (currentSum < 0) {
                    currentSum = 0;
                } else {
                    currentSum += arr[x];
                }
                if (finalSum < currentSum) {
                    finalSum = currentSum;
                }
            }
            return finalSum;
        }
    }

    public static int rainWater(int[] arr, int wdh){
        if(arr.length==1 || arr.length==2){
            return 0;
        }
        else {
            int[] leftMaxArr=new int[arr.length];
//        now calculating the left max height arr of each element.
            leftMaxArr[0]=arr[0];
            for(int x=1; x<arr.length;  x++){
                leftMaxArr[x]=Math.max(arr[x], leftMaxArr[x-1]);
            }

//            now calculating the right max height of each element.
            int[] rightMaxArr=new int[arr.length];
            rightMaxArr[rightMaxArr.length-1]=arr[arr.length-1];
            for(int x=rightMaxArr.length-2; x>=0; x--){
                rightMaxArr[x]=Math.max(arr[x], rightMaxArr[x+1]);
            }

//            calculating volume of trapped water.
            int volume = 0;
            for (int x = 0; x < arr.length; x++) {
                int waterLevel=Math.min(leftMaxArr[x], rightMaxArr[x]);
                volume+=(waterLevel-arr[x])*wdh;
            }
            return volume;
        }
    }

    public static int stockProfit(int[] arr){
        int buy=Integer.MAX_VALUE;
        int profit=0;
        for(int x=0; x<arr.length; x++){
            if(arr[x]<buy){
                buy=arr[x];
            }
            if(profit<=(arr[x]-buy)){
                profit=arr[x]-buy;
            }
        }
        if(profit<=0){
            return 0;
        }
        else{
            return profit;
        }
    }

//    Assignment methods.

    public static boolean repeatedAny(int[] arr){
        boolean flag=false;
        for(int x=0; x<arr.length-1; x++){
            for(int y=x+1; y<arr.length; y++){
                if(arr[x]==arr[y]){
                    flag=true;
                    break;
                }
            }
        }
        return flag;
    }

    public static int findTarget(int[] arr, int target){
        //  int[] nums={4,5,6,7,0,1,2};

        // finding minimum element's index.
        int minIdx=minSearch(arr);
       if(arr[minIdx]<=target && target<=arr[arr.length-1]){
            return findTarget(arr, minIdx, arr.length-1, target);
       }
       else{
           return findTarget(arr, 0, minIdx, target);
       }
    }
    public static int minSearch(int[] arr){
        //  int[] nums={4,5,6,7,8,1,2};

        int left=0;
        int right=arr.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(arr[mid-1]>=arr[mid] && mid>0){
                return mid;
            }
            else if(arr[mid]>=arr[left] && arr[mid]>arr[right]){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return left;
    }

    public static int findTarget(int[] arr, int left, int right, int target){
        int l=left;
        int r=right;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(target==arr[mid]){
                return mid;
            }
            else if(target<arr[mid]){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return -1;
    }






    public static void main(String[] args){
//        Arrays.

//        Linear search. Target index.
//        int[] arr={2,4,6,8,10,12,14,16};
//        System.out.println("Index="+indexOfTarget(arr, 10));

//        largest in array.
//        int[] arr={2,4,6,8,10,12,14,16};
//        System.out.println("the largest element in the array is : "+maxEle(arr));

//        binary search.
//        int[] arr={2,4,6,8,10,12,14,16};
//        System.out.println("Index="+binarySearchTargetIndex(arr, 2));

//        reversing array
//        int[] arr={2,4,6,8,10,12,14,16};
//        printArr(reverseArr(arr));

//        print sub-arrays;
//        int[] arr={2,4,6,8,10};
//        System.out.println("Sub arrays are : ");
//        printSubArrays(arr);

//         Pairs in array.
//        int[] arr={2,4,6,8,10};
//        pairsArr(arr);
//        Note - to find the total no. of pairs use- n(n-1)/2 formula. n->arr.length-1.

//        finding sum of subArrays.
//        System.out.println("Sum of Sub arrays is as follows ");
//        int[] arr1={2,4,6,8,10};
//        sumSubArrays(arr1);

//        finding max of the sum of sub-array. Method 1 -> bruteforce.
//        int[] arr1={-2,-3,4,-1,-2,1,5,-3};
//        System.out.println("The maximum of the sum of sub-array is : "+maxSumSubArray(arr1));

//        finding max of the sum of sub-array. Method 2 ->Kadane's algorithm.
//        int[] arr2={-2,-3,4,-1,-2,1,5,-3};
//        System.out.println("The maximum of the sum of sub-array is  : "+maxSumSubArrKdAlgo(arr2));

//        Trapping Rainwater Question.
//        int[] height={4,2,0,6,3,2,5};
//        System.out.println("The volume is : "+rainWater(height, 1));

//      Buy and sell stocks questions.
//        int[] prices={7,6,5,4,3,100};
//        System.out.println("The maximum profit is : "+stockProfit(prices));

    //  Assignment.

//        Q.1.
//        int[] nums={1,2,11,3,1};
//        System.out.println(repeatedAny(nums));

//        Q.2.
//        int[] nums={4,5,6,7,0,1,2};
//        int target=1;
//        System.out.println(findTarget(nums, target));

























    }
}
