package codes;

public class Dynamic_Programming {
    public static int fiboOptimized(int n, int[] arr){      // O(n)
        if(n==1 || n==0){
            return n;
        }
        if(arr[n]!=0){      // if the fib of n is already calculated, rather than calling
                            // the recursive function, directly return its value of fib().
            return arr[n];
        }
        else {
            return arr[n]=fiboOptimized(n - 1, arr) + fiboOptimized(n - 2, arr);   // assigning value to arr[n] are return arr[n].
        }
    }
    public static int fibTabulation(int n){
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int x=2; x<=n; x++){
            dp[x]=dp[x-1]+dp[x-2];
        }
        return dp[n];   // answer of fibonacci of n.
    }
//    memoization of recursion.     Time Complexity - O(n)
    public static int climbStairsOptimized(int n, int[] arr){    // tabulation will be the same as that of the fibonacci series code.
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }

        return arr[n]=climbStairsOptimized(n-1, arr)+climbStairsOptimized(n-2, arr);
    }
    public static int climbStairsVariation(int n , int[]arr){       // memoization.  O(n)
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        if(arr[n]!=0){
            return arr[n];
        }
        return climbStairsVariation(n-1, arr)+climbStairsVariation(n-2, arr)+climbStairsVariation(n-3, arr);
    }

//    Tabulation.
    public static int countWaysTabulation(int n){
        if(n==0 || n==1){
            return n;
        }
        else{
            int[] ways=new int[n+1];
            ways[0]=1;
            ways[1]=1;
            for(int x=2; x<=n; x++){
                ways[x]=ways[x-1]+ways[x-2];
            }
            return ways[n];
        }
    }

//    Using the memoization. We create 2-D Matrix because here, two variables are changing, namely, W and idx.
    public static int knapSack_0_1(int[] values, int[] wt, int W, int idx, int[][] arr){     // Without memoization - O(2^n)   // With memoization - O(nW)
        if(W==0 || idx<0){      // when the capacity of the knapsack is finished, or we filled all the elements.
            return 0;
        }
        if(arr[idx][W]!=-1){
            return arr[idx][W];
        }
        if(wt[idx]<=W){     // That means, if the weight of the particular item is less than or equal to the current capacity So that it can be added.
            // We have two choices.
            // 1. Include this item in the knapsack.
            int ans1=values[idx]+knapSack_0_1(values, wt, W-wt[idx], idx-1, arr);    // calling for other elements to be filled.
            /* 2. Don't include the current element call method for other elements. We did this to know that
                  whether only filling the current element in knapsack is more profitable or filling other
                  along with the current element is more profitable.
             */
            int ans2=knapSack_0_1(values, wt, W, idx-1, arr);
            return arr[idx][W]=Math.max(ans1, ans2);
        }
        else{
            // If the weight of item is not less than or equal to the current capacity of knapsack, then exclude the item.
            return arr[idx][W]=knapSack_0_1(values, wt, W, idx-1, arr);
        }

    }
//    Using tabulation.
    public static int knapSack_0_1_Tab(int[] values, int[] wt, int W){
        if(W==0 || wt.length==0 || values.length==0){
            return 0;
        }
        else{
            int[][] tabs=new int[values.length+1][W+1];
            for(int i=1; i<values.length+1; i++){
                int w=wt[i-1];      // weight of ith item.
                int v=values[i-1];  // value of ith item.
                for(int j=1; j<W+1; j++){
                    if(w<=j){       // valid condition.
                        int includeProfit=v+tabs[i-1][j-w];     // j-w represents the index of the remaining weight to get the max profit with w-j of weight.
                        int excludeProfit=tabs[i-1][j];
                        tabs[i][j]=Math.max(includeProfit, excludeProfit);
                    }
                    else{           // invalid condition.
                        int excludeProfit=tabs[i-1][j];
                        tabs[i][j]=excludeProfit;
                    }
                }
            }
            printIntArr(tabs);
            return tabs[values.length][W];
        }
    }
    public static void printIntArr(int[][] arr){
        for(int x=0; x<arr.length; x++){
            for(int y=0; y<arr[0].length; y++){
                System.out.print(arr[x][y] + " ");
            }
            System.out.println();
        }
    }
    public static void printBoolArr(boolean[][] dp){
        for(int x=0; x<dp.length; x++){
            for(int y=0; y<dp[0].length; y++){
                System.out.print(dp[x][y] + " ");
            }
            System.out.println();
        }
    }
    public static boolean targetSumSubset(int[] numbers, int ts){       // O(n x ts).  n - numbers.length+1.
        if(numbers.length==0){
            return false;
        }
        else{
            int n=numbers.length;
            boolean[][] dp=new boolean[n+1][ts+1];
            // initializing the 0th column to true;
            for(int x=0; x<n+1; x++){
                dp[x][0]=true;
            }
            for(int i=1; i<n+1; i++){
                int v=numbers[i-1];
                for(int j=1; j<ts+1; j++){
                    // including the current element.
                    if(v<=j && dp[i-1][j-v]==true){
                        dp[i][j]=true;
                    }
                    // excluding the current element.
                    else if(dp[i-1][j]==true){
                        dp[i][j]=true;
                    }
                }
            }
            printBoolArr(dp);
            return dp[n][ts];
        }
    }
    public static int unboundedKnapSack(int[] values, int[] wt, int W){      // O(n*W).
        // using the tabulation method.
        if(values.length==0 || wt.length==0){
            return 0;
        }
        else{
            int n=values.length;
            int[][] tabs=new int[n+1][W+1];
            for(int i=1; i<n+1; i++){
                for(int j=1; j<W+1; j++){
                    if(wt[i-1]<=j){     // valid condition
                        // includes the current item.
                        int includeProfit=values[i-1]+tabs[i][j-wt[i-1]];
                        // exclude the current item.
                        int excludeProfit=tabs[i-1][j];
                        tabs[i][j]=Math.max(includeProfit, excludeProfit);
                    }
                    else{
                        // Invalid condition. That is, the current weight of knapsack (j) is less than that of the current element.
                        tabs[i][j]=tabs[i-1][j];
                    }
                }
            }
            return tabs[n][W];
        }
    }
    public static int rodCutting(int[] prices, int[] length, int L){    // O(L*prices.length)
        if(prices.length==0 || length.length==0){
            return 0;
        }
        else{
            int n=prices.length;
            int[][] tabs=new int[n+1][L+1];
            for(int x=1; x<n+1; x++){
                for(int y=1; y<L+1; y++){
                    if(length[x-1]<=y){     // valid condition.
                        // including the length of the part of the current rod.
                        int includeProfit=prices[x-1]+tabs[x][y-length[x-1]];
                        // excluding the length of the part of the current rod.
                        int excludeProfit=tabs[x-1][y];
                        tabs[x][y]=Math.max(includeProfit, excludeProfit);
                    }
                    else{       // invalid condition.
                        tabs[x][y]=tabs[x-1][y];
                    }
                }
            }
            return tabs[n][L];
        }
    }
    public static int longestSubSeq(String str1, String str2){
        if(str1=="" || str2==""){        // if one of the two current strings is empty, hence no subsequence exists.
            return 0;
        }
        else{
            if(str1.charAt(str1.length()-1)==str2.charAt(str2.length()-1)){     // if last char of both current strings is equal, then adding 1.
                return 1+longestSubSeq(str1.substring(0, str1.length()-1), str2.substring(0, str2.length()-1));
            }
            else {
                // we have two choices.
                // 1. either remove last character from str1.
                int removeStr1 = longestSubSeq(str1.substring(0, str1.length() - 1), str2);
                // 2. or remove the last character from str2.
                int removeStr2 = longestSubSeq(str1, str2.substring(0, str2.length() - 1));
                int maxSubSeq = Math.max(removeStr1, removeStr2);
                return maxSubSeq;
            }
        }
    }       // recursion.
    public static int longestSubSeqMemo(String str1, String str2, int[][] mat){      // O(n*m)
        if(str1.length()==0 || str2.length()==0){       // if one of the strings is null, then no need to perform operations.
            return 0;
        }
        else{
            // if the length of subsequence is already calculated in the recursive calls, then directly return its value.
            if(mat[str1.length()][str2.length()]!=-1){
                return mat[str1.length()][str2.length()];
            }
            // if the last characters of the both strings are equal, then return 1 and find for others.
            if(str1.charAt(str1.length()-1)==str2.charAt(str2.length()-1)){
                return mat[str1.length()][str2.length()]=1+longestSubSeqMemo(str1.substring(0, str1.length()-1), str2.substring(0, str2.length()-1), mat);
            }
            else{
                // if last characters aren't equal, then two choices.
                    // 1. Exclude with the last char of str1 and include the last char of str2.
                int removeStr1=longestSubSeqMemo(str1.substring(0, str1.length()-1), str2, mat);
                    // 2. Include with the last char of the str1 and exclude the last char of str2.
                int removeStr2=longestSubSeqMemo(str1, str2.substring(0, str2.length()-1), mat);
                return mat[str1.length()][str2.length()]=Math.max(removeStr1, removeStr2);
            }
        }

    }       // Memoization.
    public static int longestSubSeqTab(String str1, String str2){
        int n1=str1.length();
        int n2=str2.length();
        int[][] tab=new int[n1+1][n2+1];
        String lcs="";
        // initializing the tab array. (for understanding)
        for(int x=0; x<tab.length; x++){            // no need to initialize as java initialize by default to zero.
            for(int y=0; y<tab[0].length; y++){
                if(x==0 || y==0) {
                    tab[x][y]=0;
                }
            }
        }
        // main logic.
        for(int i=1; i<tab.length; i++){
            for(int j=1; j<tab[0].length; j++){
                // if the characters are same of both the strings.
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    tab[i][j]=tab[i-1][j-1]+1;
                }
                // if the characters are not the same of both the strings.
                else{
                    // removing the char of str1 and calculating for the rest.
                    int rmStr1=tab[i-1][j];
                    // removing the char of str2 and calculating for the rest.
                    int rmStr2=tab[i][j-1];
                    // finally, storing the max of them.
                    tab[i][j]=Math.max(rmStr1, rmStr2);
                }
            }
        }
        System.out.println("The lcs is: " + lcs);
        return tab[n1][n2];
    }       // Tabulation.
    public static int longestCommonSubStr(String s1, String s2){
        int n=s1.length();
        int m=s2.length();
        if(n==0 || m==0){
            return 0;
        }
        else{
            int[][] tab=new int[n+1][m+1];
            // Initializing the values to arrays. But no need in java.
            // Main logic.
            for(int i=1; i<tab.length; i++){
                for(int j=1; j<tab[0].length; j++){
                    // if the characters are then add to tab.
                    if(s1.charAt(i-1)==s2.charAt(j-1)){
                        tab[i][j]=tab[i-1][j-1]+1;
                    }
                    else{
                        // as substring gets disturbed, rather than adding to tab we initialize the value of that position to 0.
                        tab[i][j]=0;
                    }
                }
            }
            /*   since here we haven't followed the exactly same logic and same initialization of each tab,
                 the value of the longest substring is not at index (n,m). Hence, we iterate over each cell
                 of tab and find our maximum.
            */
            int max=-1;
            for(int x=0; x<tab.length; x++){
                for(int y=0; y<tab[0].length; y++){
                    if(max<tab[x][y]){
                       max=tab[x][y];
                    }
                }
            }
            return max;
        }
    }







    public static void main(String[] args){

//        Dynamic Programming (DP). It is optimized recursion.
        /*
            Definition - It is a technique in computer programming that helps to efficiently
            solve a class of problems that have overlapping sub-problems and optimal sub-structure
            property.

         */
//        int n=5;
//        int[] arr=new int[n+1];     // To store the fibonacci values.
//        System.out.println(fiboOptimized(5, arr));

//        Ways of DP
        /*
                1. Memoization (Top Down)
                2. Tabulation (Bottom Up)
         */
//        System.out.println(fibTabulation(5));

        // Memoization.
//        Climbing stairs.
        // Count the ways to reach nth stair. The person can climb either one stair or two stairs at a time.
//        int n=5;
//        System.out.println("The total no.of ways is: " + climbStairsOptimized( n, new int[n+1]));

//        Climbing stairs variation.
//        int n=4;
//        System.out.println(climbStairsVariation(n, new int[n+1]));

//        Tabulation.
//        int n=5;
//        System.out.println("The no.of ways to climb the stairs is: " + countWaysTabulation(n));

//        Knapsacks.
        /*
                Types - 1) Fractional Knapsack. - Covered in the greedy algo lesson.
                        2) 0-1 Knapsack.    A whole item will be packed or not considered. Here, fraction of part of item is not allowed.
                        3) Unbounded Knapsack.  The quantity of the items infinity or items can be repeated.
         */

//        0-1 Knapsack.
//        int[] values={15, 14, 10, 45, 30};
//        int[] wt={2, 5, 1, 3, 4};
//        int W=7;
//        int[][] arr=new int[values.length+1][W+1];  // rows=length of values + 1 ,columns=length of wt + 1
//         // filling the whole matrix by -1.
//        for(int x=0; x<arr.length; x++){
//            for(int y=0; y<arr[0].length; y++){
//                arr[x][y]=-1;
//            }
//        }
//        System.out.println(knapSack_0_1(values, wt, W, values.length-1, arr));
//        Tabulation.
//        int[] values={15, 14, 10, 45, 30};
//        int[] wt={2, 5, 1, 3, 4};
//        int W=7;
//        System.out.println("The maximum profit is: " + knapSack_0_1_Tab(values, wt, W));

//        Target sum subset
//        int[] numbers={4, 2, 7, 1, 3};      // if we ue approach of knapsack, then assume value and weight as same. That is, the value is itself as weight.
//        int targetSum=10;
//        System.out.println("The subset exists is: " + targetSumSubset(numbers, targetSum));

//        Unbounded Knapsack.   Using approximate logic of 0-1 knapsack.
//        int[] values={15, 14, 10, 45, 30};
//        int[] wt={2, 5, 1, 3, 4};
//        int W=7;
//        System.out.println("The maximum profit is: " + unboundedKnapSack(values, wt, W));

//        Rod Cutting.
        /*
                Given a rod of length n inches and an array of prices that includes prices
                of all pieces of size smaller than n. Determine the maximum value obtainable
                by cutting up the rod and selling the pieces.
         */
//        int[] length={1, 2, 3, 4, 5, 6, 7, 8};
//        int[] prices={1, 5, 8, 9, 0, 17, 17, 20};
//        System.out.println(rodCutting(prices, length, 8));

//        Longest common subsequence.
        /*
                A subsequence of a string is a new string generated form the original string with some characters
                (can be none) deleted without changing the relative order of the remaining characters.
         */
//        String str1="abcdge";
//        String str2="abedg";
//        System.out.println(longestSubSeq(str1, str2));
        // using the memoization to find the longest common subsequence.
//        String str1="abcdge";
//        String str2="abedg";
//        // creating the n+1 by m+1 matrix, where n-length of str1 and m-length of str2.
//        int[][] mat=new int[str1.length()+1][str2.length()+1];
//        // initializing the matrix.
//        for(int x=0; x<mat.length; x++){
//            for(int y=0; y<mat[0].length; y++){
//                mat[x][y]=-1;
//            }
//        }
//        System.out.println("The longest subsequence of str1 and str2 is: " + longestSubSeqMemo(str1, str2, mat));
        // using the tabulation to find the longest common subsequence.
//        String str1="abcdge";
//        String str2="abedg";
//        System.out.println( + longestSubSeqTab(str1, str2));

//        Longest common substring.
        // A substring is a contiguous sequence of characters within a string.
//        String s1="ABCDE";
//        String s2="ABGCE";
//        System.out.println(longestCommonSubStr(s1, s2));












    }
}
