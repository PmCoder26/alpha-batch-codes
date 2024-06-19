package codes;
import java.util.*;

public class Queues1 {

    static class MyQueue1{
        static int[] arr;
        static int size;
        static int rear;
        static int front;
        public MyQueue1(int n){
            arr=new int[n];
            size=n;
            rear=-1;
        }
        public boolean isEmpty(){
            return rear==-1;
        }
        // adding the elements in queue.
        public void add(int data){
            if(rear==size-1){
                System.out.println("The queue is full!");
                return;
            }
            else{
                rear=rear+1;
                arr[rear]=data;
            }
        }
        //         removing the elements from the queue.
        public int remove(){
            if(isEmpty()){
                System.out.println("The queue is empty!");
                return -1;
            }
            else{
                int front=arr[0];
                for(int x=0; x<rear; x++){
                    arr[x]=arr[x+1];
                }
                rear--;
                return front;
            }
        }
        public int peek(){
            if(isEmpty()){
                System.out.println("The queue is empty!");
                return -1;
            }
            else{
                return arr[0];
            }
        }

    }
    //        Circular Queue.
    static class CircularQueue{
        private static int[] arr;
        private static int size;
        private static int front;
        private static int rear;
        public CircularQueue(int n){
            arr=new int[n];
            size=n;
            front=-1;
            rear=-1;
        }
        public boolean isEmptyCircular(){
            return rear==-1 && front==-1;
        }
        public boolean isFullCircular(){
            return (rear+1)%size == front;
        }
        public void addCircular(int data){
            if(isFullCircular()){
                System.out.println("The Circular Queue is completely full!");
                return;
            }
            else{
//                adding the first element.
                if(front==-1){
                    front=0;
                }
                rear=(rear+1)%size;
                arr[rear]=data;
            }
        }
        public int removeCircular(){
            if(isEmptyCircular()){
                System.out.println("The Circular Queue is completely empty!");
                return -1;
            }
            else{
                int value=arr[front];
//                if removing the last element.
                if(front==rear){
                    front=rear=-1;
                }
                else{
                    front=(front+1)%size;
                }
                return value;
            }
        }
        public int peekCircular(){
            if(isEmptyCircular()){
                System.out.println("The queue is empty!");
                return -1;
            }
            else{
                return arr[front];
            }
        }

    }

//    Queue using linkedList.
    static class MyQueue2{
        static class Node{
            int data;
            Node next;
            public Node(int data){
                this.data=data;
                next=null;
            }
        }
        static Node head;
        static Node tail;
        public static boolean isEmptyQueue(){
            return head==null && tail==null;
        }
//        since linkedList's limit is infinite, hence no function to indicate that queue is full.
        public static void add(int data){
            Node newNode=new Node(data);
            if(isEmptyQueue()){
                head=tail=newNode;
                return;
            }
            else{
                tail.next=newNode;
                tail=newNode;
            }
        }
        public static int remove(){
            if(isEmptyQueue()){
                System.out.println("The Queue is Empty!");
                return -1;
            }
            else{
                int value=head.data;
                if(head==tail){
                    head=tail=null;
                }
                else{
                    head=head.next;
                }
                return value;
            }
        }
        public static int peek(){
            if(isEmptyQueue()){
                System.out.println("The Queue is empty!");
                return -1;
            }
            else{
                return head.data;
            }
        }
}

    static class MyQueue3{
        static Stack<Integer> st1=new Stack<>();
        static Stack<Integer> st2=new Stack<>();

        public static boolean isEmpty(){
            return st1.isEmpty();
        }
        public static void add(int data){      // time complexity - O(n)
//            filling the 2nd stack from the first.
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
//           adding the data in 1st stack.
            st1.push(data);
//            Then filling stack 1 by using stack 2's elements to get the first element pushed to be at the top of st1.
            while(!st2.isEmpty()){
                st1.push(st2.pop());
            }
        }
        public static int remove(){
            if(st1.isEmpty()){
                System.out.println("The queue is empty!");
                return -1;
            }
            else{
                return st1.pop();
            }
        }
}

//      Questions.
    static class queuesToStack{
        static Queue<Integer> q1=new LinkedList<>();
        static Queue<Integer> q2=new LinkedList<>();
        public static boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }
        public static void push(int data){
            if(q1.isEmpty()){
                q2.add(data);
            }
            else{
                q1.add(data);
            }
        }
        public static int pop(){
            if(isEmpty()){
                System.out.println("The stack is empty!");
                return -1;
            }
            else{
                int top=-1;
                if(!q1.isEmpty()){
//                    when q1 is not empty and q2 is empty.
                    while(!q1.isEmpty()){
                        top=q1.remove();
                        if(q1.isEmpty()){    // This condition is added because the first element for stack and last for queue will be
                                             //  stored in another queue and that we don't want.
                            break;
                        }
                        q2.add(top);
                    }
                    return top;
                }
                else{
//                    when q2 is not empty and q1 is empty.
                    while(!q2.isEmpty()){
                        top=q2.remove();
                        if(q2.isEmpty()){
                            break;
                        }
                        q1.add(top);
                    }
                    return top;
                }
            }
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("The stack is empty!");
                return -1;
            }
            else{
                int top=-1;
                if(!q1.isEmpty()){
//                    when q1 is not empty and q2 is empty.
                    while(!q1.isEmpty()){
                        top=q1.remove();
                        q2.add(top);
                    }
                    return top;
                }
                else{
//                    when q2 is not empty and q1 is empty.
                    while(!q2.isEmpty()){
                        top=q2.remove();
                        q1.add(top);
                    }
                    return top;
                }
            }
        }

}

    //        first non-repeating character.
    static class firstNonRpt{
        public static void meth(String str){
            String ans="";
            int[] freqArr=new int[26];
            Queue<Character> q=new LinkedList<>();
            for(int i=0; i<str.length(); i++){
                char c=str.charAt(i);
                q.add(c);
                freqArr[c-'a']++;
                while(!q.isEmpty() && freqArr[q.peek()-'a']>1){
                    q.remove();
                }
                if(q.isEmpty()){
                    System.out.print(-1+ " ");
                }
                else{
                    System.out.print(q.peek() + " ");
                }
            }
            System.out.println();
        }
    }

//     Interleave 2 halves of a Queue

    public static Queue<Integer> interLeave(Queue<Integer> q){
        if(q.isEmpty()){
            System.out.println("The queue is empty!");
            return q;
        }
        else{
            Queue<Integer> firstHalf=new LinkedList<>();
            int size=q.size();
//            filling the firstHalf queue.
            for(int x=0; x<size/2; x++){
                firstHalf.add(q.remove());
            }
//            filling the original queue.
            while(!firstHalf.isEmpty()){
                q.add(firstHalf.remove());
                q.add(q.remove());
            }
            return q;
        }
    }

//    Queue reversal.
    public static Queue<Integer> reverseQueue(Queue<Integer> q){
        if(q.isEmpty()){
            System.out.println("The Queue is empty!");
            return q;
        }
        else{
            Stack<Integer> st=new Stack<>();
//            transferring the elements from queue to stack.
            while(!q.isEmpty()){
                st.push(q.remove());
            }
//            re-transferring the elements from stack to queue.
            while(!st.isEmpty()){
                q.add(st.pop());
            }
            return q;
        }
    }

    // approach 2 to reverse the queue.
    public static void reverseQueue2(Queue<Integer> q){
        if(q.isEmpty()){
            return;
        }
        else{
            int value=q.remove();
            reverseQueue2(q);
            q.add(value);
        }
    }

    static class DequeToStack{
        public static Deque<Integer> dq=new LinkedList<>();
        public static void push(int data){
            dq.addLast(data);
        }
        public static int pop(){
            return dq.removeLast();
        }
        public static int peek(){
            return dq.getLast();
        }
    }

    static class DequeToQueue{
        public static Deque<Integer> dq=new LinkedList<>();
        public static void add(int data){
            dq.addLast(data);
        }
        public static int remove(){
            return dq.removeFirst();
        }
        public static int peek(){
            return dq.getFirst();
        }
    }


    public static void main(String[] args){

//        Queues.  FIFO - First in First out.

//        Queue using arrays.

//        Queues1.MyQueue1 q=new Queues1.MyQueue1(5);
//        q.add(1);
//        q.add(2);
//        q.add(3);
//        q.add(4);
//        q.add(5);
//        while(!q.isEmpty()){
//            System.out.print(q.peek() + " ");
//            q.remove();
//        }

//        Circular Queues.
//        Queues1.CircularQueue cq=new CircularQueue(3);
//        cq.addCircular(1);
//        cq.addCircular(2);
//        cq.addCircular(3);
//        System.out.println(cq.removeCircular());
//        cq.addCircular(4);
//        System.out.println(cq.removeCircular());
//        cq.addCircular(5);
//        while(!cq.isEmptyCircular()){
//            System.out.println(cq.peekCircular());
//            cq.removeCircular();
//        }

//        Queue using linkedLists.
//        Queues1.MyQueue2 q2=new Queues1.MyQueue2();
//        q2.add(1);
//        q2.add(2);
//        q2.add(3);
//        q2.add(4);
//        q2.add(5);
//        while(!q2.isEmptyQueue()){
//            System.out.println(q2.peek());
//            q2.remove();
//        }

//        Queue using Java Collection Framework.
//        Using linkedList.
//        Queue<Integer> q=new LinkedList<>();
//        q.add(1);
//        q.add(2);
//        q.add(3);
//        q.add(4);
//        q.add(5);
//        while(!q.isEmpty()){
//            System.out.print(q.remove() + " ");
//        }
//      using ArrayDeque.
//        Queue<Integer> q1=new ArrayDeque<>();
//        q1.add(1);
//        q1.add(2);
//        q1.add(3);
//        q1.add(4);
//        q1.add(5);
//        while(!q1.isEmpty()){
//            System.out.print(q1.remove() + " ");
//        }

//        Queue using stacks.  Note - This is done by using two stacks.
//        MyQueue3 mq3=new MyQueue3();
//        mq3.add(1);
//        mq3.add(2);
//        mq3.add(3);
//        mq3.add(4);
//        mq3.add(5);
//        while(!mq3.st1.isEmpty()){
//            System.out.print(mq3.st1.pop() + " ");
//        }

//        stacks using two queues.
//        queuesToStack qs=new queuesToStack();
//        qs.push(1);
//        qs.push(2);
//        qs.push(3);
//        qs.push(4);
//        qs.push(5);
//        while(!qs.isEmpty()){
//            System.out.print(qs.peek() + " ");
//            qs.pop();
//        }

//        First non-repeating character.  Time complexity - O(n).
//        String str="aabccxb";
//        firstNonRpt f=new firstNonRpt();
//        f.meth(str);

//        Interleave 2 halves of a Queue(even length).
//        Queue<Integer> q=new LinkedList<Integer>();
//        q.add(1);
//        q.add(2);
//        q.add(3);
//        q.add(4);
//        q.add(5);
//        q.add(6);
//        q.add(7);
//        q.add(8);
//        q.add(9);
//        q.add(10);
//        interLeave(q);
//        while(!q.isEmpty()){
//            System.out.print(q.remove() + " ");
//        }

//        reversing the queue.
//        Queue<Integer> q=new LinkedList<Integer>();
//        q.add(1);
//        q.add(2);
//        q.add(3);
//        q.add(4);
//        q.add(5);
//        q.add(6);
//        q.add(7);
//        q.add(8);
//        q.add(9);
//        q.add(10);
//        reverseQueue(q);
//        while(!q.isEmpty()){
//            System.out.print(q.remove() + " ");
//        }
          // recursive approach to reverse the Queue.
//        Queue<Integer> q=new LinkedList<Integer>();
//        q.add(1);
//        q.add(2);
//        q.add(3);
//        q.add(4);
//        q.add(5);
//        q.add(6);
//        q.add(7);
//        q.add(8);
//        q.add(9);
//        q.add(10);
//        reverseQueue2(q);
//        while(!q.isEmpty()){
//            System.out.print(q.remove() + " ");
//        }

//        Deque (Double-ended queue). The Difference between the queue and deque is we can add or remove the elements form front and rear too
//                                     whereas in queue we can add or remove the elements only from rear.
//        Deque<Integer> dq=new LinkedList<>();
//        dq.addFirst(1);
//        dq.addFirst(2);
//        dq.addFirst(3);
//        dq.addFirst(4);
//        dq.addFirst(5);
//        dq.addLast(6);
//        dq.addLast(7);
//        dq.addLast(8);
//        dq.addLast(9);
//        dq.addLast(10);
//        System.out.println(dq);
//        System.out.println("The first element in the Deque is : " + dq.getFirst());
//        System.out.println("The last element in the Deque is : " + dq.getLast());

//        stack and queue using deque.
     //        for stack.
//        DequeToStack st=new DequeToStack();
//        st.push(1);
//        st.push(2);
//        st.push(3);
//        st.push(4);
//        st.push(5);
//        System.out.println("The peeked element is : " + st.peek());
//        System.out.println("The popped element is : " + st.pop());
     // for queue.
//        DequeToQueue q=new DequeToQueue();
//        q.add(1);
//        q.add(2);
//        q.add(3);
//        q.add(4);
//        q.add(5);
//        while(!q.dq.isEmpty()){
//            System.out.print(q.remove() + " ");
//        }
















    }
}
