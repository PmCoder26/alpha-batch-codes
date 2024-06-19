package codes;
import java.util.*;



public class Dynamic_Programming {
    public static Scanner sc=new Scanner(System.in);
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
    public static int lcs2(int[] arr1, int[] arr2){
        int n=arr1.length;
        int m=arr2.length;
        int[][] tab=new int[n+1][m+1];
        // initializing some columns of tab to zero.
        for(int x=0; x<n+1; x++){
            tab[x][0]=0;
        }
        for(int x=0; x<m+1; x++){
            tab[0][x]=0;
        }
        // main logic. using lcs technique.
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(arr1[i-1]==arr2[j-1]){
                    tab[i][j]=tab[i-1][j-1]+1;
                }
                else{
                    int ans1=tab[i-1][j];
                    int ans2=tab[i][j-1];
                    tab[i][j]=Math.max(ans1, ans2);
                }
            }
        }
        return tab[n][m];
    }
    public static int longestIncSubSeq(int[] arr){
        // To avoid the repeating elements in the array, creating HashSet
        // thereby storing the element's frequency.
        // HashSet don't allow the duplicate elements.
        HashSet<Integer> hs=new HashSet<>();
        for(int x=0; x<arr.length; x++){
            hs.add(arr[x]);
        }
        // Now creating another array and storing the non-repeating elements form hashSet.
        int[] arr2=new int[hs.size()];
        int i=0;
        for(int ele:hs){
            arr2[i++]=ele;
        }
        java.util.Arrays.sort(arr2);
        return lcs2(arr, arr2);
    }
    // Tabulation.
    public static int editDistanceWordConversionTabu(String word1, String word2){
        int n=word1.length();
        int m=word2.length();
        if(n==0 && m==0){
            return 0;
        }
        else if(n==0 && m!=0){
            return m;
        }
        else if(n!=0 && m==0){
            return n;
        }
        else{
            int[][] tabs=new int[n+1][m+1];
            // initializing the base case array cells.
            // 1. if the word1 is empty and word2 not empty then no.of operations is equal to m.
            // 2. if the word2 is empty and word1 not empty then no.of operations is equal to n.
            // 3. if both word1 and word2 empty then no.of operations is 0.
            for(int x=0; x<n+1; x++){
                for(int y=0; y<m+1; y++){
                    if(x==0){
                        tabs[x][y]=y;
                    }
                    else if(y==0){
                        tabs[x][y]=x;
                    }
                }
            }
            // using the tabulation for solving the problem.
            for(int x=1; x<n+1; x++){
                for(int y=1; y<m+1; y++){
                    // if the two the (x-1)th char of word1 is equal to (y-1)th char of word2.
                    if(word1.charAt(x-1)==word2.charAt(y-1)){
                        tabs[x][y]=tabs[x-1][y-1];
                    }
                    else{
                        // comparing the strings by comparing on add, delete and replace operations.
                        /*
                            1. add - remaining word1 length = x, word2 length = y-1.
                            2. delete - remaining word1 length = x-1, word2 length = y.
                            3. replace - remaining word1 length = x-1, word2 length = y-1.
                         */
                        // comparing the minimum of the all three operations and adding +1 to the net minimum operations.
                        tabs[x][y]=Math.min(tabs[x][y-1], Math.min(tabs[x-1][y], tabs[x-1][y-1]))+1;
                    }
                }
            }
            // returning the total minimum no.of operations required.
            return tabs[n][m];
        }
    }
    // Normal recursion.
    public static int editDistanceWordConversion(String word1, String word2){
        int n=word1.length();
        int m=word2.length();
        if(n==0 && m==0){
            return 0;
        }
        else if(n!=0 && m==0){
            return n;
        }
        else if(n==0 && m!=0){
            return m;
        }
        else{
            // last characters of word1 and word2.
            char c1=word1.charAt(n-1);
            char c2=word2.charAt(m-1);
            // if the last char of word1 and word2 are same, hence no need to perform any operations.
            if(c1==c2){
                return editDistanceWordConversion(word1.substring(0, n - 1), word2.substring(0, m - 1));
            }
            else{
                // performing the add operation to word1.
                // remaining length of the word1 = n and word2 = m-1.
                int addChar=editDistanceWordConversion(word1.substring(0, n), word2.substring(0, m-1));
                // performing delete operation.
                // remaining length of the word1 = n-1 and word2 = m.
                int deleteChar=editDistanceWordConversion(word1.substring(0, n-1), word2.substring(0, m));
                // performing replace operation.
                // remaining length of the word1 = n-1 and word2 = m-1.
                int replaceChar=editDistanceWordConversion(word1.substring(0, n-1), word2.substring(0, m-1));
                // finally, comparing the minimum operations required of adding, deleting and replacing.
                return Math.min(addChar, Math.min(deleteChar, replaceChar))+1;
            }
        }
    }
    // normal recursion.
    public static int stringConversion(String word1, String word2){
        // referring the  logic of the edit distance question.
        int n=word1.length();
        int m=word2.length();
        if(n==0 && m==0){
            return 0;
        }
        else if(n!=0 && m==0){
            return n;
        }
        else if(n==0 && m!=0){
            return m;
        }
        else{
            // getting the last characters of the word1 and word2.
            char c1=word1.charAt(n-1);
            char c2=word2.charAt(m-1);
            //  case 1: if c1 and c2 are same then no need to perform any operation.
            if(c1==c2){
                return stringConversion(word1.substring(0, n-1), word2.substring(0, m-1));
            }
            else {
                // case 2: delete.
                int delete=stringConversion(word1.substring(0, n-1), word2.substring(0, m));
                int insert=stringConversion(word1.substring(0, n), word2.substring(0, m-1));
                return Math.min(delete, insert)+1;
            }

        }
    }
    // tabulation.
    public static boolean wildcardMatchingTabu(String s, String p){   // O(n*m).
        int n=s.length();
        int m=p.length();
        boolean[][] tabs=new boolean[n+1][m+1];
        // initialization of tabulation matrix 'tabs'.
            // if the both the strings are empty, then it's true.
        tabs[0][0]=true;
        // if the pattern is empty.
        for(int x=1; x<n+1; x++){
            tabs[x][0]=false;
        }
        // if the string 's' is empty.
        for(int x=1; x<m+1; x++){
            if(p.charAt(x-1)=='*'){
                tabs[0][x]=tabs[0][x-1];
            }
        }
        // for remaining cases.
        for(int x=1; x<n+1; x++){
            for(int y=1; y<m+1; y++){
                // if (ith char==jth char) || (jth char==?).
                if(s.charAt(x-1)==p.charAt(y-1) || (p.charAt(y-1)=='?')){
                    tabs[x][y]=tabs[x-1][y-1];
                }
                else if(p.charAt(y-1)=='*'){
                    tabs[x][y]=tabs[x-1][y] || tabs[x][y-1];
                }
                else{
                    tabs[x][y]=false;
                }
            }
        }
        // returning the final answer.
        return tabs[n][m];
    }
    public static int catalanNum(int n){   // simple recursion.
        if(n==0 || n==1){
            return 1;
        }
        else{
            int ans=0;
            for(int x=0; x<n; x++){
                ans+=catalanNum(x)*catalanNum(n-x-1);
            }
            return ans;
        }
    }
    public static int catalanNumMemo(int n, int[] memo){    // Memoization. O(n*n)
        if(n==0 || n==1){
            return 1;
        }
        else{
            if(memo[n]!=-1){
                return memo[n];
            }
            else{
                int ans=0;
                for(int x=0; x<n; x++){
                    ans+=catalanNumMemo(x, memo)*catalanNumMemo(n-1-x, memo);
                }
                return memo[n]=ans;
            }
        }
    }
    public static int catalanNumTabu(int n){    // tabulation.  O(n*n)
        if(n==0 || n==1){
            return 1;
        }
        else{
            int[] tabs=new int[n+1];
            tabs[0]=1;
            tabs[1]=1;
            for(int x=2; x<n+1; x++){
                for(int y=0; y<x; y++){
                    tabs[x]+=tabs[y]*tabs[x-1-y];
                }
            }
            return tabs[n];
        }
    }
    public static int uniquePathsMemo(int m, int n, int[][] tabs){
        if(m==1 && n==1){
            return tabs[m][n]=1;
        }
        if(tabs[m][n]!=-1){
            return tabs[m][n];
        }
        if(m==1 && n!=1){
            return tabs[m][n]=uniquePathsMemo(m, n-1, tabs);
        }
        if(m!=1 && n==1){
            return tabs[m][n]=uniquePathsMemo(m-1, n, tabs);
        }
        else{
            int right=uniquePathsMemo(m, n-1, tabs);
            int down=uniquePathsMemo(m-1, n, tabs);
            return tabs[m][n]=right+down;
        }
    }
    public static int uniquePathsTabu(int m, int n){     // tabulation.
        int[][] tabs=new int[m][n];
        for(int x=0; x<m; x++){
            tabs[x][0]=1;
        }
        for(int x=0; x<n; x++){
            tabs[0][x]=1;
        }
        for(int x=1; x<m; x++){
            for(int y=1; y<n; y++){
                tabs[x][y]=tabs[x][y-1]+tabs[x-1][y];
            }
        }
        return tabs[m-1][n-1];
    }
    public static int countTrees(int n){        // O(n*n)
        if(n==0 || n==1){
            return 1;
        }
        else{
            int[] tabs=new int[n+1];
            tabs[0]=1;
            tabs[1]=1;
            for(int x=2; x<n+1; x++){
                for(int c=0; c<x; c++){
                    tabs[x]+=tabs[x-1-c]*tabs[c];
                }
            }
            return tabs[n];
        }
    }
    public static int mountainRanges(int n){
        if(n==0 || n==1){
            return 1;       // By default for n==0.
        }
        else{
            int ans=0;
            for(int x=0; x<n; x++){
                ans+=mountainRanges(x)*mountainRanges(n-x-1);
            }
            return ans;
        }
    }
    public static int matChainMulti(int[] arr, int i, int j){
        if(i==j){
            return 0;
        }
        else{
            int ans=Integer.MAX_VALUE;
            for(int k=i; k<j; k++){
                // cost of multiplying first part of multiplication.
                int cost1=matChainMulti(arr, i, k);     // Ai....Ak, matrix form will be of dimensions -> arr[i-1] x arr[k].
                // cost of multiplying second part of multiplication.
                int cost2=matChainMulti(arr, k+1, j); // Ak+1.....Aj, matrix form will be of dimensions -> arr[k] x arr[j].
                // cost of multiplying the resultant two matrices from cost1 and cost2.
                int cost3=arr[i-1]*arr[k]*arr[j];
                // final cost, cost for all three operations for cost1, cost2, and cost3.
                int finalCost=cost1+cost2+cost3;
                // finally updating the minimum cost.
                ans=Math.min(ans, finalCost);
            }
            return ans;
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
//        String str1="ae";
//        String str2="abe";
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
//        System.out.println(longestSubSeqTab(str1, str2));

//        Longest common substring.
        // A substring is a contiguous sequence of characters within a string.
//        String s1="ABCDE";
//        String s2="ABGCE";
//        System.out.println(longestCommonSubStr(s1, s2));

//        Longest increasing subsequence.   Variation of the longest common subsequence.
        // Finding the length of the subsequences consecutively with next number greater than previous.
        // In short, how many numbers are arranged in increasing order continuously.
//        int[] arr={50, 3, 10, 7, 40, 80};
//        System.out.println("The length of the longest increasing subsequence is: " + longestIncSubSeq(arr));

//        Edit distance problem.
        /*
                Given two strings word1 and word2, return minimum no.of operations required to convert
                word1 to word2.
                You have three operations permitted on a word:
                1.Insert a character.
                2.Delete a character.
                3.Replace a character.

                // this question is quite similar to the lcs question.
         */
//        String word1="intention";
//        String word2="execution";
//        // tabulation.
//        System.out.println("The minimum no.of operations required is: " + editDistanceWordConversionTabu(word1, word2));
//        // normal recursion.
//        System.out.println("The minimum no.of operation required is: " + editDistanceWordConversion(word1, word2));

        // String conversion.
        /*
                Convert string1 to string2 with only delete and insert operation.
                Print the no.of deletions and insertions.
         */

//        String word1="pear";
//        String word2="sea";
//        System.out.println("The total no.of deletions and insertions are: " + stringConversion(word1, word2));

        // Wildcard Matching.
        /*
                Given a text and a wildcard pattern, implement wildcard pattern matching algorithm that finds if
                wildcard pattern is matched with text. The matching should cover the entire text (not partial text).
                 The wildcard pattern can include the characters '?' and '*'.
                    1. '?' - matches any single character.
                    2. '*' - matches any sequence of characters(including the empty sequence).
         */
                // false case.
//        String str="abc";
//        String pat="**d";
//        System.out.println("The wildcard matching is: " + wildcardMatchingTabu(str, pat));
//                // true case.
//        String str2="baaabab";
//        String pat2="*****ba*****ab";
//        System.out.println("The wildcard matching is: " + wildcardMatchingTabu(str2, pat2));

        /*
                Catalan's number.
                C0=1, C1=1,
                C2 = C0.C1 + C1.C0,
                C3 = C2.C0 + C1.C1 + C0.C2.
                ..... and so on.
                the basic formula is:
                CN = C(N-1).C0 + C(N-2).C1 +...+ C0.C(N-1);
         */
//        System.out.print("Enter the nth term for Catalan Number: ");
//        int n=sc.nextInt();
////        System.out.println("The " + n + "th Catalan Number is: " + catalanNum(n));
//            // using memoization.
//        int[] memo=new int[n+1];
//        for(int x=0; x<n+1; x++){
//            memo[x]=-1;
//        }
//        System.out.println("The Catalan's number using memoization is: " + catalanNumMemo(n, memo));
//            // using the tabulation.
//        System.out.println("The Catalan's number using the tabulation is: " + catalanNumTabu(n));


        /*
                There is a robot on an m x n grid. The robot is initially located at the top-left
                corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner
                (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
                Given the two integers m and n, return the number of possible unique paths that the robot
                 can take to reach the bottom-right corner.
         */
//        int m=5;
//        int n=7;
//        System.out.println(uniquePathsTabu(m, n));      // Tabulation.
//        int[][] tabs=new int[m+1][n+1];
//        for(int x=0; x<m+1; x++){
//            for(int y=0; y<n+1; y++){
//                tabs[x][y]=-1;
//            }
//        }
//        System.out.println(uniquePathsMemo(m, n, tabs));    // Memoization.

        /*
                    Counting the Trees.
               Find the possible no.of BSTs form from the n values in array.
               e.g. n=4 (10, 20, 30), 40;
         */
            // this question is the variant of the Catalan's number.
//        System.out.println("The total BSTs can be formed are: " + countTrees(4));


        /*
                    Mountain Ranges.
                    Mountain -> up stroke, Valley -> down stroke.
                    At any moment, the no.of down strokes can't be more than the no.of upstrokes.
                    ex. /\/\/\
                        here, the mountains are 3 and valleys are 2.

                    This question is similar to Catalan's Number.
         */
//        System.out.println("The total no.of mountain ranges is: " + mountainRanges(3));

//              Matrix Chain Multiplication.
        /*
                An array is given ex. arr={1, 2, 3, 4, 5};
                matrix Ai(where i>=1 and i<arr.length-1) is of dimensions arr[i-1] x arr[i] -> rows x columns.
                In this question we have to find the minimum cost required of all the matrices multiplications
                from all possible combinations form from the array given.
                Basically, from the array we find the total matrices and multiply all of them to get
                the cost of multiplication. We have to find the minimum cost of multiplying all the
                matrices, so we need to consider that format/order of multiplication.
                    For array arr={1, 2, 3, 4, 5}, total no.of matrices will be arr.length-1.
                    i.e., A1, A2,....,A4.
                    where dimensions of Ai=arr[i-1] x arr[i] -> rows x columns.
                    Hence, finding the order of matrices to consider it to get the minimum cost of
                    multiplication.
         */
//        int[] arr={1, 2, 3, 4, 3};
//        System.out.println("The minimum cost required is: " + matChainMulti(arr, 1,arr.length-1));











    }
}
