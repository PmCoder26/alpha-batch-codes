package codes;
import java.math.BigInteger;
import java.util.*;
import codes.*;

public class Greedy_Algorithms{

    static ArrayList<Integer> list=new ArrayList<>();
    public static int activitySelection1(int[] start, int[] end, int startIdx, int endIdx){   // for sorted end array.
        if(startIdx==start.length){     // when the both the arrays are covered.
            return 0;
        }
        else{
            int count=0;
            if(endIdx==0 && startIdx==1){
                list.add(0);
                count++;
            }
            if(start[startIdx]>=end[endIdx]){
                list.add(startIdx);
                return count+=activitySelection1(start, end, startIdx+1, startIdx)+1;
            }
            else{
                return count=activitySelection1(start, end, startIdx+1, endIdx);
            }
        }
    }
    public static int activitySelection2(int[][] activities, int startIdx, int endIdx){
        if(startIdx==activities.length){
            return 0;
        }
        else{
            int count=0;
            if(startIdx==1 && endIdx==0){
                list.add(activities[0][0]);
                count++;
            }
            if(activities[startIdx][1]>=activities[endIdx][2]){
                list.add(activities[startIdx][0]);
                return count+=activitySelection2(activities, startIdx+1, startIdx)+1;
            }
            else{
                return count+=activitySelection2(activities, startIdx+1, endIdx);
            }
        }
    }
    public static int fracKnapsack(double[][] ratios, int[] values, int[] weights, int capacity, int i){
            int netValue=0;
//            checking whether whole quantity can be filled or filling only available quantity within the capacity.
            if(weights[(int)ratios[i][0]]<=capacity){    // includes all items.
                netValue+=values[(int)ratios[i][0]];
                return netValue+=fracKnapsack(ratios, values , weights, capacity-weights[(int)ratios[i][0]], i-1);
            }
            else{     // includes some part of the whole item.
                netValue=(int)(ratios[i][1]*capacity);
                return netValue;
            }
    }
    public static int minAbsDiff(int[] A, int[] B){
        if(A.length==0 && B.length==0){
            return 0;
        }
        else{
//        sorting those arrays.
            java.util.Arrays.sort(A);
            java.util.Arrays.sort(B);
            int diff=0;
            for(int x=0; x<A.length; x++){
                diff+=Math.abs(A[x]-B[x]);
            }
            return diff;
        }
    }
    public static int maxLengthChainPair(int[][] pairs, int startIdx, int endIdx){
        if(startIdx==pairs.length){
            return 0;
        }
        else {
            int chainLength = 0;
            if (startIdx == 1 && endIdx == 0) {
                chainLength+=1;
            }
            if (pairs[startIdx][0]>pairs[endIdx][1]){
                chainLength++;
                return chainLength+=maxLengthChainPair(pairs, startIdx+1, startIdx);
            }
            else{
                return chainLength+=maxLengthChainPair(pairs, startIdx+1, endIdx);
            }
        }
    }
    public static int currChange(int[] denom, int value, int idx){
        if(value<=0){
            return 0;
        }
        else{
            int count=0;
            if(value>=denom[idx]){
                count++;
                return count+=currChange(denom, value-denom[idx], idx);
            }
            else{
                return count+=currChange(denom, value, idx-1);
            }
        }
    }
    static class Job{
        int deadLine;
        int profit;
        int id;
        public Job(int id, int deadLine, int profit){
            this.id=id;
            this.deadLine=deadLine;
            this.profit=profit;
        }
    }
    public static void jobSeqProblem(int[][] jobsInfo){
        if(jobsInfo.length==0){
            System.out.println("There is no job to do!");
        }
        else{
            ArrayList<Job> jobs=new ArrayList<>();
//            filling the jobs information in the arrayList.
            for(int x=0; x<jobsInfo.length; x++){
                jobs.add(new Job(x, jobsInfo[x][0], jobsInfo[x][1]));
            }
//            sorting the arraylist on the basis of profit in descending order.
            Collections.sort(jobs, (obj1, obj2) -> obj2.profit-obj1.profit);
            ArrayList<Integer> seq=new ArrayList<>();
            int time=0;
//            performing the operations to determine whether a job can be done or not.
            for(int x=0; x<jobs.size(); x++){
                Job currJob=jobs.get(x);
                if(currJob.deadLine>time){     // when the time is smaller than the deadline, then only a job can be done.
                    seq.add(currJob.id);
                    time++;
                }
            }
//            printing the sequences of the jobs that can be performed.
            System.out.println("The sequence of jobs that can be done is: ");
            for(int x=0; x<seq.size(); x++){
                System.out.print(seq.get(x) + " ");
            }
            System.out.println();
//            printing the total number of jobs that can be done.
            System.out.println("The total no. of jobs can be done is: " + seq.size());
        }
    }
    public static int chocolaProblem(Integer[] hCost, Integer[] vCost, int h, int v, int hp, int vp){
        //        Sorting the horizontal and vertical cost arrays so that costly cut will be applied first so that cheaper cut will be applied for more
        // pieces in order to minimize the overall cost.
        int netCost=0;
        java.util.Arrays.sort(vCost, Collections.reverseOrder());
        java.util.Arrays.sort(hCost, Collections.reverseOrder());
        while(v<vCost.length && h<hCost.length){
            if(vCost[v]<=hCost[h]){         // for horizontal cuts.
                netCost+=(vp*hCost[h]);
                h++;
                hp++;
            }
            else{               // for vertical cuts.
                netCost+=(hp*vCost[v]);
                v++;
                vp++;
            }
        }
        //            Now for remaining horizontal cuts.
        while(h<hCost.length){
            netCost+=(vp*hCost[h]);
            h++;
            hp++;
        }
//            Now for remaining vertical cuts.
        while(v<vCost.length){
            netCost+=(hp*vCost[v]);
            v++;
            vp++;
        }
        return netCost;
    }



    public static void main(String[] args) {

//        Greedy Algorithms.

//        1. Activity selection.
        /*
            You are given n activities with their start and end times. Select the maximum number of activities
            that can be performed by a single person, assuming that a person can only work on a single activity at a time.
            Activities are sorted according to end time.
         */
//        int[] start={1,3,0,5,8,5};
//        int[] end={2,4,6,7,9,9};
//        System.out.println("The maximum activities are : " + activitySelection1(start, end, 1, 0));
//        System.out.println("The activities can be performed are : ");
//        for(int x=0; x<list.size(); x++){
//            System.out.print("A" + list.get(x) + " ");
//        }
//        System.out.println();

        // in case if the end array isn't sorted.
//        int[] start={1,3,0,5,8,5};
//        int[] end={2,4,6,7,9,9};
//        int[][] activities=new int[start.length][3];  // consists of 3 columns of start.length size.
////        transferring the elements of start, end with their respective indices.
//        for(int x=0; x<start.length; x++){
//            activities[x][0]=x;
//            activities[x][1]=start[x];
//            activities[x][2]=end[x];
//        }
//        now, sorting the activities array on the basis of only end elements, other's position may not be in sorted manner.
//        java.util.Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));   // as end is on index 2, i.e., 2nd column.
//        System.out.println("The maximum activities are : " + activitySelection2(activities, 1, 0));
//        System.out.println("The activities can be performed are : ");
////        printing the activities.
//        for(int x=0; x<list.size(); x++){
//            System.out.print("A" + list.get(x) + " ");
//        }
//        System.out.println();

//        Fractional Knapsack.
        /*
        Given the weights and values of N items, put these items in a knapsack of capacity W to get
        maximum total value in the knapsack
         */
//        int[] weights={10, 20, 30};
//        int[] values={60, 100, 120};
//        int capacity=50;
//        double[][] ratios=new double[weights.length][2];
////        calculating the ratios and adding to ratios arr.
//        for(int x=0; x<weights.length; x++){
//            ratios[x][0]=x;
//            ratios[x][1]=(double)values[x]/(double)weights[x];
//        }
////        Now sorting the ratios arr in decreasing order to get maximum values first and maximum result.
//        java.util.Arrays.sort(ratios, Comparator.comparingDouble(o -> o[1]));
////        More is the ratio, more is the value. Hence, the recursion is in descending order.
//        System.out.println("The maximum value gained is: " + fracKnapsack(ratios, values, weights, capacity, ratios.length-1));

//        Minimum absolute difference pairs.
        /*
        Given two arrays A and B of equal length n. Pair each element of array A to an element in array B,
        such that sum S of absolute difference of all pairs is minimum.
         */
//        int[] A={4,1,8,7};
//        int[] B={2,3,6,5};
//        System.out.println("The minimum absolute difference sum is : " + minAbsDiff(A, B));

//        Maximum length chairs of pairs.
        /*
        You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
        A pair(c,d) can come after pair(a,b) if b<c. Find the longest chain which can be formed from the given set of pairs.
         */
//        int[][] pairs={{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};
//        //        sorting the pairs array.
//        java.util.Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
//        System.out.println("The maximum length of chain is: " + maxLengthChainPair(pairs, 1, 0));

//        Indian Coins.
        /*
        We are given an infinite supply of denominations [1,2,5,10,20,50,100,500,2000].
        Find minimum number of coins/notes to make change for value V.
         */
        /*
        Steps: 1.To sort the denom in ascending order and traverse from end or sort in descending order and traverse from start.
                here, descending order is considered and method is created as per descending manner of denom.
         */
//        int[] denom={1, 2, 5, 10, 20, 50, 100, 500, 2000};
////        java.util.Arrays.sort(denom);       // for ascending order.
////        codes.Sorting.bubbleSortDecreasingOrder(denom);
//        int value=590;
//        System.out.println("The minimum number of coins/notes to make change for respective value is: " + currChange(denom, value, denom.length-1));

//        Job Sequencing Problem.
        /*
        Given an array of jobs where every job has a deadline and profit if the job is finished before deadline.
        It is also given that every job takes a single unit of time, so the minimum possible deadline for any job is 1.
        Maximize the profit if only one job can be scheduled at a time.
         */
        /*
        Steps: 1. Sort jobs on the basis of profit.
               2. Create an array for storing the jobs.
               3. Initialize time to zero and check whether time is less than deadline.
               4. If yes, then add jobs in an array and increment in time by 1.
               5. Do this for whole job-deadline array length-1 times.
         */
//        int[][] jobsInfo={{4, 20}, {1, 10}, {1, 40}, {1, 30}};
//        jobSeqProblem(jobsInfo);

//        Chocola problem.
        /*
             We are given a bar of chocolate composed of m x n square pieces. One should break the chocolate into single squares.
             Each break of a part of the chocolate is charged a cost expressed by a positive integer. This ost does not depend on
             the size of the part that is being broken but only depends on the line the break goes along. Let us denote the costs
             of breaking along the consecutive vertical lines with x1, x2, ...., xm-1, and horizontal lines with y1, y2,...., yn-1.
             Compute the minimal cost of breaking the whole chocolate into single squares.
         */
//        int m=6;
//        int n=4;
//        Integer[] verticalCost={2, 1, 3, 1, 4};  // m-1.
//        Integer[] horizontalCost={4, 1, 2};      // n-1.
//        int h=0, v=0;
//        int hPieces=1, vPieces=1;
//        int netCost=0;
//        System.out.println("The minimum cost charged will be: " + chocolaProblem(horizontalCost, verticalCost, h, v, hPieces, vPieces));


    }

}
