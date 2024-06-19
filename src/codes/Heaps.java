package codes;
import java.util.*;

import static codes.Arrays.printArr;


public class Heaps {
    static class Student implements Comparable<Student>{
        int rank;
        String name;
        public Student(String name, int rank){
            this.name=name;
            this.rank=rank;
        }
        @Override
        public int compareTo(Student s2){
            return this.rank-s2.rank;
        }
    }
    static class Heap1{
        private static ArrayList<Integer> arr=new ArrayList<>();
        public void add(int data){              // inserting: 3, 4, 1, 5.
            // adding firstly the value at the last of the arrayList.
            arr.add(data);
            int x=arr.size()-1;     // child at last.
            int parent=(x-1)/2;     // parent index.
            // setting the child at appropriate position.
            while(arr.get(x)<arr.get(parent)){      // O(logn)
                // swapping the values of parent and child.
                int temp=arr.get(x);
                arr.set(x, arr.get(parent));
                arr.set(parent, temp);
                x=parent;       // reinitializing the values of parent and child so that consecutively we can switch and adjust them to their appropriate positions.
                parent=(x-1)/2;
            }
        }
        public static int peek(){
            return arr.get(0);
        }
        private static void heapifyMin(int i){     // O(logn)      // is method is for minHeap. That is, parent is smaller than its children.
            int left=2*i+1;
            int right=2*i+2;
            int minIdx=i;
            if(left<arr.size() && arr.get(minIdx)>arr.get(left)){
                minIdx=left;
            }
            if(right<arr.size() && arr.get(minIdx)>arr.get(right)){
                minIdx=right;
            }
            if(minIdx!=i){      // here, if the i not equal to minIdx that means we need to fix it that is swapping.
                int temp=arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);
//                further calling recursively to furthermore fix it.
                heapifyMin(minIdx);
            }
        }
        public static int remove(){     // O(logn)
            int data=arr.get(arr.size()-1);     // last element.
//            swapping the first and last.
            int temp=arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);
//            delete the last node which was the first supposed to be removed.
            arr.remove(arr.size()-1);
//            calling the heapify function for further adjusting the elements in the heap if the tree doesn't follow heap's properties.
            heapifyMin(0);
            return data;
        }
        public static boolean isEmpty(){
            return arr.size()==0;
        }
        public static void heapifyMax(int[] arr, int i, int n){
            int left=2*i+1;
            int right=2*i+2;
            int maxIdx=i;
            if(left<n && arr[maxIdx]<arr[left]){
                maxIdx=left;
            }
            if(right<n && arr[maxIdx]<arr[right]){
                maxIdx=right;
            }
            if(maxIdx!=i){
                int temp=arr[maxIdx];
                arr[maxIdx]=arr[i];
                arr[i]=temp;
                heapifyMax(arr, maxIdx, n);
            }
        }
        public static void heapSort(int[] arr){     // O(nlogn)
            // build maxHeap.
            int n=arr.length;
            for(int x=n/2; x>=0; x--){
                heapifyMax(arr, x, n);
            }
            // push the largest element at the end and call heapifyMax method for the remaining array.
            for(int x=n-1; x>0; x--){
                // swapping largest with the last element.
                int temp=arr[0];
                arr[0]=arr[x];
                arr[x]=temp;
                // call heapifyMax();
                heapifyMax(arr, 0, x);
            }
        }

    }
    static class Point implements Comparable<Point>{
        int x, y, distSq, index;
        public Point(int x, int y, int distSq, int index){
            this.x=x;
            this.y=y;
            this.distSq=distSq;
            this.index=index;
        }
        //  comparing on the basis of distances.
        public int compareTo(Point p2){
            return this.distSq-p2.distSq;   // ascending order arranged.
        }
    }
    static class Row implements Comparable<Row>{
        int index, soldiers;
        public Row(int index, int soldiers){
            this.soldiers=soldiers;
            this.index=index;
        }
        // comparing on the basis of soldiers.
        @Override
        public int compareTo(Row r2){
            if(this.soldiers==r2.soldiers){
                return this.index-r2.index;
            }
            else{
                return this.soldiers-r2.soldiers;
            }
        }
    }
    static class Pair implements Comparable<Pair>{
        int value, index;
        public Pair(int value, int index){
            this.value=value;
            this.index=index;
        }
        @Override
        public int compareTo(Pair p2){
            return p2.value-this.value;
        }
    }

    public static void nearbyCars(int[][] points, int k){
        PriorityQueue<Point> pq=new PriorityQueue<>();
        for(int x=0; x<points.length; x++){
            int distSq=points[x][0]*points[x][0]+points[x][1]*points[x][1];
            pq.add(new Point(points[x][0], points[x][1], distSq, x));
        }
        // printing the K nearest cars.
        for(int x=0; x<k; x++){
            System.out.print(pq.remove().index + " ");
        }
    }
    public static int connectRopes(int[] ropes){
        if(ropes.length==0){
            return 0;
        }
        else{
            PriorityQueue<Integer> pq=new PriorityQueue<>();
            int netCost=0;
            // filling the elements in pq.
            for(int x=0; x<ropes.length; x++){
                pq.add(ropes[x]);
            }
            while(!pq.isEmpty()){
                int firstMin=pq.remove();
                int secondMin=pq.remove();
                netCost+=firstMin+secondMin;
                if(pq.isEmpty()){       // here if only two ropes exist, then finally, there will be finally one rope and the final cost is ready.
                    break;
                }
                else{
                    pq.add(firstMin+secondMin);
                }
            }
            return netCost;
        }
    }
    public static void weakSoldiers(int[][] army, int k){
        PriorityQueue<Row> pq=new PriorityQueue<>();
        for(int x=0; x<army.length; x++){
            int cnt=0;
            for(int y=0; y<army[0].length; y++){
                if(army[x][y]==1){
                    cnt++;
                }
            }
            pq.add(new Row(x, cnt));
        }
        // printing the weak soldiers' rows.
        for(int x=0; x<k; x++){
            System.out.println("R" + pq.remove().index);
        }
    }
    public static void slidingWindowMax(int[] arr, int k){      // O(nlogk)
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        int[] subArrMax=new int[arr.length-k+1];
//        Storing the elements of the first window.
        for(int x=0; x<k; x++){
            pq.add(new Pair(arr[x], x));
        }
        // storing value of first max of the first window.
        subArrMax[0]=pq.peek().value;
        // for remaining windows and values.
        for(int x=k; x<arr.length; x++){
            while(pq.size()>0 && pq.peek().index<=x-k){
                pq.remove();
            }
            pq.add(new Pair(arr[x], x));
            subArrMax[x-k+1]=pq.peek().value;
        }
        // printing the result.
        for(int x=0; x<subArrMax.length; x++){
            System.out.print(subArrMax[x] + " ");
        }
        System.out.println();
    }



    public static void main(String[] args){

        // Heaps.

//        Priority Queue - is the normal queue used to implement to store the element with more priority first and then
//                         gradually storing elements with decreasing order of their priorities.

        /*
            Notes for Priority Queue: Time complexities.
             1. add() - O(logn)
             2. remove() - O(logn)
             3. peek() - O(1)
         */
        //        Priority queue using Java Collection Framework (JCF).
//        PriorityQueue<Integer> pq=new PriorityQueue<>();        // if priorities to be given to lower values first than the higher values.
//        pq.add(2);
//        pq.add(5);
//        pq.add(10);
//        pq.add(78);
//        pq.add(1);
//        System.out.print("The Priority Queue with priority from lower to higher values : ");
//        while(!pq.isEmpty()){
//            System.out.print(pq.remove() + " ");
//        }
//        System.out.println();
//        PriorityQueue<Integer> pq1=new PriorityQueue<>(Comparator.reverseOrder());      // if priority to be given to higher values first.
//        pq1.add(2);
//        pq1.add(5);
//        pq1.add(10);
//        pq1.add(78);
//        pq1.add(1);
//        System.out.print("The Priority Queue with priority from higher to lower values : ");
//        while(!pq1.isEmpty()){
//            System.out.print(pq1.remove() + " ");
//        }
//        System.out.println();

//          Comparing the students' data and arranging in Priority queue.
//        PriorityQueue<Student> pq=new PriorityQueue<>();
//        pq.add(new Student("A", 4));
//        pq.add(new Student("B", 5));
//        pq.add(new Student("C", 2));
//        pq.add(new Student("D", 12));
//        while(!pq.isEmpty()){
//            System.out.println(pq.peek().name + ">" + pq.peek().rank);
//            pq.remove();
//        }
//        System.out.println();

//          Heap data structure.    It is a binary tree at max two children.
        /*
                Properties of Heap data structure:
                1. It is a binary with maximum two children.
                2. It is a complete binary tree. That means all the levels are completely filled except possibly
                   the last one, which is filled from left to right.
                3. Heap order property:
                    a. Children>=Parent value (in minHeap)
                    a. Children<=Parent value (in maxHeap)

                When the Heaps are implemented using arrays or arrayLists, the indices of the particular node, its left and right
                child are defined as the formula:
                                            (node)idx=i;
                                            leftChild=2*i+1;
                                            rightChild=2*i+1;
         */

//        Inserting in the minHeap.
        /*
                Steps:
                1. Add at last index.
                2. If child value<parent value then swap parent value by child value.
                    Continue till the conditions of the heap don't satisfy.

         */

//        Adding the values in the heap.
        Heap1 h=new Heap1();
        h.add(97);
        h.add(87);
        h.add(69);
        h.add(99);
        h.add(100);
        h.add(98);
        h.add(110);
        System.out.println(h.arr);
        while(!h.isEmpty()){
            System.out.print(h.peek() + " ");
            h.remove();
        }

//        Heap Sort.
        /*
                Steps:
                1. Obtain the MaxHeap from the given array. MaxHeap contains the parent node greater than its children.
                   That is, opposite to the minHeap.
                2. Put the largest element at last:
                        a. Swap arr[0] with arr[last];
                        b. call the heapify method.
         */
//        int[] arr={1, 2, 4, 5, 3};
//        Heap1.heapSort(arr);
//        printArr(arr);

//        Nearby cars.
        /*
            We are given N points in a 2-D plane which are locations of N cars.
            If we are at the origin, print K cars.      Where K<=N.
            Question is solved using priority queue in ascending queue.
         */
//        int[][] points={{3, 3}, {5, -1}, {-2, 4}};
//        int k=2;
//        System.out.print("The nearby cars are: ");
//        nearbyCars(points, k);

//        Connect N ropes.
        /*
                Given are N ropes of different length, the task is to connect these ropes into one rope
                with minimum cost, such that cost to connect two ropes is equal to the sum of their lengths.
         */
//        int[] ropes={2, 3, 3, 4, 6};
//        System.out.println("The minimum cost to connect all the ropes is: " + connectRopes(ropes));

//        Weakest Soldier.
        /*
                We are given an m x n binary matrix of 1's(soldiers) and 0's(civilians). The soldiers and positioned
                in front of the civilians. That is, 1's to the left of all the 0's in each row.
                A row i is weaker than a row j if one of the following is true:
                    - The number of soldiers in row i is less than the no.of soldiers in row j.
                    - Both the rows have the same number of soldiers and i<j;
                Find the K weakest rows.
         */
//        int[][] army={{1, 0, 0, 0},
//                      {1, 1, 1, 1},
//                      {1, 0, 0, 0},
//                      {1, 0, 0, 0}};
//        int k=2;
//        weakSoldiers(army, k);

//        Sliding Window Maximum.
        /*
                Maximum of all the sub-arrays of size k.

                Here, consider sub-array of size k and print the max element of that sub-array of group of size k.
                Do this by taking the first element first, create group of three elements. Once the max element is
                 known, then take the group of three elements again from the 2nd element from the array and so on.
         */
//        int[] arr={1, 2, 3, 4, 99, 7, 8, 9, 10};
//        int k=3;
//        System.out.print("The maximum of all possible sub-arrays are: ");
//        slidingWindowMax(arr, k);









    }
}
