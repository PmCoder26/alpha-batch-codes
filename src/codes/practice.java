package codes;
import java.awt.*;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;
import java.lang.*;

class Node1{
    public int n, p;
    public Node1(int n, int p){
        this.n=n;
        this.p=p;
    }
    public void print(){
        System.out.println("Data: " + n + ", Priority: " + p);
    }
}

class priorityQueue{
    private Node1 pq[];
    private int size, rear;
    public priorityQueue(int size){
        this.size=size;
        rear=-1;
        pq=new Node1[size];
    }
    public void add(int n, int p){
        if(rear==size-1){
            System.out.println("The queue is full!");
        }
        else{
            pq[++rear]=new Node1(n, p);
            sort();
        }
    }
    public void sort(){
        for(int x=0; x<rear; x++){
            int min=x;
            for(int y=x+1; y<=rear; y++){
                if(pq[min].p>pq[y].p){
                    min=y;
                }
            }
            Node1 temp=pq[min];
            pq[min]=pq[x];
            pq[x]=temp;
        }
    }
    public void print(){
        for(int x=0; x<=rear; x++){
            pq[x].print();
        }
    }

}


public class practice{

    public static void mergeSort(int[] arr, int start, int end){
        if(start>=end){
            return;
        }
        else{
            int mid=start+(end-start)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }
    public static void merge(int[] arr, int start, int mid, int end){
        int[] temp=new int[end-start+1];
        int i=start, j=mid+1, k=0;
        while(i<=mid && j<=end){
            if(arr[i]<=arr[j]){
                temp[k++]=arr[i++];
            }
            else{
                temp[k++]=arr[j++];
            }
        }
        // for remaining ones.
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=end){
            temp[k++]=arr[j++];
        }
        i=start;
        for(k=0; k<temp.length; k++){
            arr[i++]=temp[k];
        }
    }

    public static void quickSort(int[] arr, int start, int end){
        if(start>=end){
            return;
        }
        else{
            int pvt=partition(arr, start, end);
            quickSort(arr, start, pvt-1);
            quickSort(arr, pvt+1, end);
        }
    }

    public static int partition(int[] arr, int start, int end){
        int startIdx=start-1
                ;
        while(start<end){
            if(arr[start]<=arr[end]){
                int temp=arr[start];
                arr[start]=arr[++startIdx];
                arr[startIdx]=temp;
            }
            start++;
        }
        startIdx++;
        int temp=arr[end];
        arr[end]=arr[startIdx];
        arr[startIdx]=temp;
        return startIdx;
    }

    public static void mergeSort2(int[] arr, int start, int end){
        if(start>=end){
            return;
        }
        else{
            int mid=(start+end)/2;
            mergeSort2(arr, start, mid);
            mergeSort2(arr, mid+1, end);
            merge2(arr, start, mid, end);
        }
    }

    public static void merge2(int[] arr, int start, int mid, int end){
        int[] temp=new int[end-start+1];
        int i=start, j=mid+1;
        int k=0;
        while(i<=mid && j<=end){
            if(arr[i]<=arr[j]){
                temp[k++]=arr[i++];
            }
            else{
                temp[k++]=arr[j++];
            }
        }
        // for remaining ones.
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=end){
            temp[k++]=arr[j++];
        }

        for(k=0,i=start; k<temp.length; k++, i++){
            arr[i]=temp[k];
        }
    }

    public static void mergeSort3(int[] arr, int start, int end){
        if(start>=end){
            return;
        }
        else{
            int mid=(start+end)/2;
            mergeSort3(arr, start, mid);
            mergeSort3(arr, mid+1, end);
            merge3(arr, start, mid, end);
        }
    }
    public static void merge3(int[] arr, int start, int mid, int end){
        int[] temp=new int[end-start+1];
        int i=start, j=mid+1;
        int k=0;
        while(i<=mid && j<=end){
            if(arr[i]<=arr[j]){
                temp[k++]=arr[i++];
            }
            else{
                temp[k++]=arr[j++];
            }
        }
        // for remaining ones.
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=end){
            temp[k++]=arr[j++];
        }
        i=start;
        for(k=0; k<temp.length; k++){
            arr[i++]=temp[k];
        }
    }

        public static LinkedLists.Node deleteDuplicates(LinkedLists.Node head) {
            if(head==null || head.next==null){
                return head;
            }
            else{
                LinkedLists.Node ans=null;
                HashMap<Integer, Integer> hm=new HashMap<Integer, Integer>();
                Stack<Integer>st=new Stack();
                while(head!=null){
                    if(!hm.containsKey(head.data)){
                        hm.put(head.data, 1);
                    }
                    else{
                        hm.put(head.data, hm.get(head.data)+1);
                    }
                    head=head.next;
                }
                Set<Integer> s=hm.keySet();
                for(int k:s){
                    if(hm.get(k)==1){
                        st.push(k);
                    }
                }
                while(!st.isEmpty()){
                    LinkedLists.Node temp=new LinkedLists.Node(st.pop());
                    temp.next=ans;
                    ans=temp;
                }
                return ans;
            }
        }
        public static int fact(int n){
            if(n==0 || n==1){
                return 1;
            }
            else{
                return n*fact(n-1);
            }
        }

        public static void show(){
        try{
            System.out.println("inside try");
            return;
        }
        finally{
            System.out.println("inside finally");
        }
        }


    public static void main(String[] args){


//
//        try {
//            Connection conn = DriverManager.getConnection("df");
//            Statement st= conn.createStatement();
//
//
//        }
//        catch(Exception e){
//            System.out.println(e);
//        }




//        priorityQueue pq=new priorityQueue(5);
//        pq.add(1, 1);
//        pq.add(1, 3);
//        pq.add(1, 4);
//        pq.add(1, 2);
//        pq.print();
//
//        int[] arr={99, 97, 3, 4, 6, 74,2,34 ,23,42,4 ,23, 4};
////        quickSort(arr, 0, arr.length-1);
//        mergeSort3(arr, 0, arr.length-1);
//        for(int x=0; x<arr.length; x++){
//            System.out.print(arr[x] + " ");
//        }


















    }

}
