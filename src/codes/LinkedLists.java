package codes;
import com.sun.security.jgss.GSSUtil;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

public class LinkedLists {
    public static Node head;
    public static Node tail;
    public static int size;
    public static void printHead(Node head1) {
        Node temp = head1;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public static void printTail(Node tail1) {
        Node temp = tail1;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public static class Node {
        int data = 0;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }
    public void addFirst(int data) {     // time complexity-O(1)
//        creating the new Node.
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
    }
    public void addLast(int data) {      // time complexity-O(1)
        Node newNode = new Node(data);
        size++;
        if (tail == null) {
            tail = head = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }
    public void removeFirst() {
        if (size == 0) {
            System.out.println("The LinkedList is empty!");
            return;
        }
        head = head.next;
        size--;
    }
    public void removeLast() {
        if (size == 0) {
            System.out.println("The LinkedLIst is enpty!");
            return;
        }
//        reaching to the previous of the last;
        Node temp = head;
        for (int x = 0; x < size - 2; x++) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        size--;
    }
    public static void printList() {
        Node temp = head;
        if (temp == null) {
            System.out.println("The list is empty!");
        } else {
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
    public static void listPrint(Node node){
        while(node!=null){
            System.out.print(node.data + " ");
            node=node.next;
        }
    }
    public void addInMiddle(int index, int data) {  // 4
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public boolean linearSearchKey(int key) {    // time Complexity - O(n)
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                return true;
            } else {
                temp = temp.next;
            }
        }
        return false;
    }
    public int recursiveSearchKey(Node curr, int position, int key) {
        if (curr.data == key) {
            return position;
        } else {
            return recursiveSearchKey(curr.next, position + 1, key);
        }
    }
    public void reverseList() {
        Node previous = null;
        Node current = head;
        Node temp;
        while (current != null) {
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        head = previous;
    }
    public static Node listReverse(Node node){
        if(node==null){
            return null;
        }
        else{
            Node prev=null;
            Node curr=node;
            Node temp=null;
            while(curr!=null){
                temp=curr.next;
                curr.next=prev;
                prev=curr;
                curr=temp;
            }
            return prev;
        }
    }
    // method to delete node at nth position from rear side.
    public void removeNthNode(int n) {
        Node temp = head;
        int size = 0;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
//        if first is to remove.
        if (n == size) {
            head = head.next;
            return;
        }
//        for (size-n)th node.
        int i = 1;
        int idxToFind = size - n;
        Node previous = head;
        while (i < idxToFind) {
            previous = previous.next;
            i++;
        }
        previous.next = previous.next.next;
    }
    // method to delete node at nth position from front side.
    public static void deleteNthNode(Node head, int pos){
        Node curr=head;
        Node part1=null;
        Node part2=null;
        for(int x=0; x<pos; x++){
            Node temp=curr.next;
            curr.next=part1;
            part1=curr;
            curr=temp;
        }
        curr=curr.next;
        while(curr!=null){
            Node temp=curr.next;
            curr.next=part1;
            part1=curr;
            curr=temp;
        }
        curr=null;
        while(part1!=null){
            Node temp=part1.next;
            part1.next=curr;
            curr=part1;
            part1=temp;
        }
    }
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;    // slow is the mid-node.
    }
    public boolean isPalindromeList() {
        if (head == null || head.next == null) {
            return true;
        }
// step 1: finding the mid of the list.
        //        finding the mid using the slo-fast technique.
        //          as fast covers the whole, the slow covers the half, hence the mid is caught.
        Node mid = findMid(head);
//  step 2: reversing the second half.
        Node previous = null;
        Node current = mid;
        Node temp = null;
        while (current != null) {
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
//  step 3: checking whether firstHalf==secondHalf.
        Node firstHalf = head;
        Node secondHalf = previous;
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }
    public boolean isCycleExists() {
        Node slow = head;
        Node fast = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {        // if true then cycle exists.
                return true;
            }
        }
        return false;
    }
    public void removeCycle() {
//        checking whether cycle exists or not.
        Node slow = head;
        Node fast = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) {
            return;
        }
//        Now finding the meet point of slow and fast.
        slow = head;
        Node previous = null;
        while (slow != fast) {
            previous = fast;
            slow = slow.next;
            fast = fast.next;
        }
//        removing the cycle.
        previous.next = null;
    }
    public Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
//        slow is the mid.
        return slow;
    }
    public Node mergeList(Node left, Node right) {
        Node mergedList = new Node(-1);
        Node temp = mergedList;
        while (left != null && right != null) {
            if (left.data <= right.data) {
                temp.next = left;
                left = left.next;
                temp = temp.next;
            } else {
                temp.next = right;
                right = right.next;
                temp = temp.next;
            }
        }
        //            for remaining node's data.
        while (left != null) {
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }
        while (right != null) {
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }
//        to avoid -1 in the temp's head data.
        return mergedList.next;
    }
    public Node mergeSortLinkedList(Node head) {
        if (head.next == null || head == null) {
            return head;
        } else {
//            finding the mid of the linkedList.
            Node midNode = getMid(head);
//           initializing some nodes for further operations.
            Node rightHalf = midNode.next;
            midNode.next = null;
            Node newLeftHalf = mergeSortLinkedList(head);
            Node newRightHalf = mergeSortLinkedList(rightHalf);
//            merging the linkedList.
            return mergeList(newLeftHalf, newRightHalf);
        }
    }
    public void zig_ZagList(Node head) {
        if (head == null || head.next == null) {
            System.out.println("The LinkedList is empty!");
            return;
        } else {
            Node mid = getMid(head);
            Node temp = null;
            Node right = mid.next;
            //            reversing the right half.
            Node previous = null;
            while (right != null) {
                temp = right.next;
                right.next = previous;
                previous = right;
                right = temp;
            }

//            filling the list in the zigzag pattern.
            Node leftHalf = head;
            mid.next = null;
            Node rightHalf = previous;
            Node nextLH;
            Node nextRH;
            while (leftHalf != null && rightHalf != null) {
//               arranging in zigzag manner;
                nextLH = leftHalf.next;
                leftHalf.next = rightHalf;
                nextRH = rightHalf.next;
                rightHalf.next = nextLH;
//                updating
                leftHalf = nextLH;
                rightHalf = nextRH;
            }
        }

    }

    // Doubly.
    private static class DoublyLL{
        private static class Node{
            Node next, prev;
            int data;
            public Node(int data){
                this.next=null;
                this.prev=null;
                this.data=data;
            }
        }
        private Node head=null;
        private boolean isEmpty(){
            return head==null;
        }
        private void addFirst(int data){
            if(isEmpty()){
                head=new Node(data);
            }
            else{
                Node newNode=new Node(data);
                newNode.next=head;
                head.prev=newNode;
                head=newNode;
            }
        }
        private void addLast(int data){
            if(isEmpty()){
                head=new Node(data);
            }
            else{
                Node newNode=new Node(data);
                Node curr=head;
                while(curr.next!=null){
                    curr=curr.next;
                }
                curr.next=newNode;
                newNode.prev=curr;
            }
        }
        private int removeLast(){
            if(isEmpty()){
                return -1;
            }
            if(head.next==null){
                int val=head.data;
                head=null;
                return val;
            }
            else{
                Node curr=head;
                while(curr.next!=null){
                    curr=curr.next;
                }
                int val=curr.data;
                curr.prev.next=null;
                return val;
            }
        }
        private int removeFirst(){
            if(head==null){
                return -1;
            }
            if(head.next==null){
                int val=head.data;
                head=null;
                return val;
            }
            else{
                int val=head.data;
                head=head.next;
                head.prev=null;
                return val;
            }
        }
        private void printList(Node head){
            if(head==null){
                return;
            }
            else{
                while(head!=null){
                    System.out.print(head.data + " ");
                    head=head.next;
                }
                System.out.println();
            }
        }
        private void printListChain(Node head){
            if(head==null){
                return;
            }
            else{
                while(head.next!=null){
                    System.out.print(head.data + " ");
                    head=head.next;
                }
                while(head!=null){
                    System.out.print(head.data + " ");
                    head=head.prev;
                }
                System.out.println();
            }
        }

    }

    // SinglyCircular.
    private static class SinglyCircularLL{

        private static class Node{
            Node next;
            int data;
            public Node (int data){
                this.next=null;
                this.data=data;
            }
        }
        private Node head=null;
        private boolean isEmpty(){
            return head==null;
        }
        private void addFirst(int data){
            if(isEmpty()){
                head=new Node(data);
            }
            else{
                Node newNode=new Node(data);
                Node curr=head;
                while(curr.next!=head && curr.next!=null){
                    curr=curr.next;
                }
                curr.next=newNode;
                newNode.next=head;
                head=newNode;
            }
        }
        private void addLast(int data){
            if(isEmpty()){
                head=new Node(data);
            }
            else{
                Node newNode=new Node(data);
                Node curr=head;
                while(curr.next!=head && curr.next!=null){
                    curr=curr.next;
                }
                curr.next=newNode;
                newNode.next=head;
            }
        }
        private int removeFirst(){
            if(isEmpty()){
                return -1;
            }
            else if(head.next==null){
                int val=head.data;
                head=null;
                return val;
            }
            else{
                int val=head.data;
                Node curr=head;
                while(curr.next!=head){
                    curr=curr.next;
                }
                curr.next=curr.next.next;
                head=curr.next;
                return val;
            }
        }
        private int removeLast(){
            if(isEmpty()){
                return -1;
            }
            else if(head.next==null){
                int val=head.data;
                head=null;
                return val;
            }
            else{
                Node curr=head;
                Node preCurr=curr;
                while(curr.next!=head){
                    preCurr=curr;
                    curr=curr.next;
                }
                int val=curr.data;
                preCurr.next=curr.next;
                return val;
            }
        }
        private void printList(Node head){
            if(isEmpty()){
                return;
            }
            if(head.next==null){
                System.out.println(head.data);
            }
            else{
                Node curr=head;
                while(curr.next!=head){
                    System.out.print(curr.data + " ");
                    curr=curr.next;
                }
                System.out.println(curr.data);
            }
        }

    }

    // DoublyCircularLL.
    private static class DoublyCircularLL{
        private static class Node{
            Node next, prev;
            int data;
            public Node(int data){
                this.prev=null;
                this.next=null;
                this.data=data;
            }
        }
        private Node head=null;
        private boolean isEmpty(){
            return head==null;
        }
        private void addFirst(int data){
            if(isEmpty()){
                head=new Node(data);
                head.next=head;
                head.prev=head;
            }
            else{
                Node newNode=new Node(data);
                Node curr=head;
                while(curr.next!=null && curr.next!=head){
                    curr=curr.next;
                }
                curr.next=newNode;
                newNode.next=head;
                newNode.prev=curr;
                head.prev=newNode;
                head=newNode;
            }
        }
        private void addLast(int data){
            if(isEmpty()){
                head=new Node(data);
                head.next=head;
                head.prev=head;
            }
            else{
                Node newNode=new Node(data);
                Node curr=head;
                while(curr.next!=null && curr.next!=head){
                    curr=curr.next;
                }
                curr.next=newNode;
                newNode.prev=curr;
                head.prev=newNode;
                newNode.next = head;
            }
        }
        private int removeFirst(){
            if(head==null){
                return -1;
            }
            else if(head.next==head){
                int val=head.data;
                head=null;
                return val;
            }
            else{
                Node curr=head;
                while(curr.next!=null && curr.next!=head){
                    curr=curr.next;
                }
                int val=curr.data;
                curr.next=head.next;
                head.next.prev=curr;
                head=head.next;
                return val;
            }
        }
        private int removeLast(){
            if(isEmpty()){
                return -1;
            }
            else if(head.next==head){
                int val=head.data;
                head=null;
                return val;
            }
            else{
                Node curr=head;
                while(curr.next!=head){
                    curr=curr.next;
                }
                int val=curr.data;
                curr.prev.next=head;
                head.prev=curr.prev;
                return val;
            }
        }
        private void printList(Node head){
            if(isEmpty()){
                return;
            }
            else if(head.next==null){
                System.out.println(head.data);
            }
            else{
                Node curr=head;
                while(true){
                    System.out.print(curr.data + " ");
                    if(curr.next==head){
                        break;
                    }
                    curr=curr.next;
                }
                System.out.println();
            }
        }
        private void printListChain(Node head){
            if(head==null){
                return;
            }
            else if(head.next==null){
                System.out.println(head.data);
                return;
            }
            else{
                Node curr=head;
                while(curr.next!=head){
                    System.out.print(curr.data + " ");
                    curr=curr.next;
                }
                while(curr!=head){
                    System.out.print(curr.data + " ");
                    curr=curr.prev;
                }
                System.out.println(curr.data);
            }
        }

    }


        public static void main(String[] args) {

//        LinkedLists.

////        creating linkedList using the logic of classes and objects.
//        LinkedLists ll=new LinkedLists();
//        ll.addFirst(1);
//        ll.addFirst(2);
//        ll.addFirst(3);
//        ll.addFirst(4);
//        ll.addFirst(5);
//        ll.addLast(6);
//        ll.addLast(7);
//        ll.addLast(8);
//        ll.addLast(9);
//        ll.addLast(10);
//
//            //        accessing/traversing/printing the created linkedList.

////        printing reversely.
//        printHead(head);
//        printHead(head);
//        printTail(tail);

//        printing the list separately by head and tail.
//        ll.printHead(head);
//        ll.printTail(tail);

//        printing the whole list.
//        ll.printList();

//        adding the element in the middle of the list.
//        ll.addInMiddle(5,100);
//        ll.printList();

//        printing the size of the LinkedList.
//            System.out.println("The size of the linkedList is : "+size);

//        removing the nodes from the list.
//        ll.removeFirst();
//        ll.printList();
//        ll.removeLast();
//        ll.printList();

//        iterative searching in the linkedList.
//        System.out.println(ll.linearSearchKey(116));

//        recursive search.
//        System.out.println(ll.recursiveSearchKey(head,  0, 10));

//        reversing the LinkedList.
//        ll.reverseList();
//        ll.printList();

//        finding and removing the Nth node from end using iterative approach.
//            LinkedLists ll=new LinkedLists();
//            for(int x=0; x<10; x++){
//                ll.addLast(x+1);
//            }
//            System.out.println("The LinkedList before removing any element : ");
//        ll.printList();
//        System.out.println("LinkedList after removing the given nth node : ");
//        ll.removeNthNode(5);
//        ll.printList();

//        checking whether LinkedList is palindrome or not.
//        LinkedLists l2=new LinkedLists();
//        l2.addFirst(1);
//        l2.addFirst(2);
//        l2.addFirst(2);
//        l2.addFirst(1);
//        System.out.println(l2.isPalindromeList());

//        Detect a loop/cycle in a LinkedList.
//        Floyd's Cycle Finding Algorithm.
//        slow-fast approach is used.
//        if slow and fast overlap or meet at one node, the cycle or loop exists.
//        LinkedLists ll2=new LinkedLists();
//        head=new Node(1);
//        head.next=new Node(2);
//        head.next.next=new Node(3);
//        head.next.next.next=new Node(4);
//        head.next.next.next.next=head;
//        System.out.println("The existence of cycle/loop in the LinkedList is : "+ll2.isCycleExists());

//        Removing the loop/cycle in the LinkedList.
//        strategy - 1. finding the last node and making the last node as null.
     /* Theory - after detecting that the loop exists, then slow in initialized to head and fast to fast.next.
                   Hence, mathematically, it is found that they will meet at the node where the loop/cycle starts.
      */
//        LinkedLists ll2=new LinkedLists();
//        head=new Node(1);
//        Node temp=new Node(10);
//        head.next=temp;
//        head.next.next=new Node(3);
//        head.next.next.next=new Node(4);
//        head.next.next.next.next=temp;
//        System.out.println("The existence of the cycle before removing : "+ll2.isCycleExists());
//        ll2.removeCycle();
//        System.out.println("The existence of the cycle after removing : "+ll2.isCycleExists());

//          Java Collections Framework.

//        creating the linkedLists.
//        LinkedList<Integer> ll=new LinkedList<>();

////        adding in linkedList.
//        ll.add(1);
//        ll.add(2);
//        ll.add(3);
//        System.out.println(ll);
//
////        removing the elements in linkedList.
//        ll.remove(0);
//        System.out.println(ll);

//        merge sort in LinkedList.
//        LinkedLists ll=new LinkedLists();
//        ll.addFirst(1);
//        ll.addFirst(2);
//        ll.addFirst(3);
//        ll.addFirst(4);
//        ll.addFirst(5);
//        System.out.println("The LinkedList before mergeSort : ");
//        ll.printList();
//        ll.head=ll.mergeSortLinkedList(head);
//        System.out.println("The LinkedList after mergeSort : ");
//        ll.printList();

//        zig-zag linkedList.
//        LinkedLists ll=new LinkedLists();
//        ll.addFirst(1);
//        ll.addFirst(2);
//        ll.addFirst(3);
//        ll.addFirst(4);
//        ll.addFirst(5);
//        System.out.println("The linkedList before zig-zag arrangement : ");
//        ll.printList();
//        System.out.println("The linkedList after the zig-zag arrangement : ");
//        ll.zig_ZagList(head);
//        ll.printList();

//        Doubly linkedList.
//        Note - This type of linkedList contains its data, it's next, and it's previous object of class Node.

//        Since doubly LinkedList is created, adding the nodes and the data at first.
//        DoublyLL.addFirst(5);
//        DoublyLL.addFirst(4);
//        DoublyLL.addFirst(3);
//        DoublyLL.addFirst(2);
//        DoublyLL.addFirst(1);
//        System.out.println("The doubly linkedList is : ");
//        DoublyLL.printDoubleLL();
//            printing the chain ouf doubly linkedList.
//            DoublyLL.printDoublyChain();

//        Now removing the first element from the Doubly linkedList.
//        System.out.println("Doubly linkedList before removing the first element : ");
//        DoublyLL.printDoubleLL();
//        DoublyLL.removeFirst();
//        System.out.println("Doubly linkedList after removing the first element : ");
//        DoublyLL.printDoubleLL();

//            Now adding the node at last.
//            DoublyLL.addLast(6);
//            DoublyLL.addLast(7);
//            DoublyLL.addLast(8);
//            DoublyLL.addLast(9);
//            DoublyLL.addLast(10);
//            System.out.println("The Doubly linkedList is : ");
//            DoublyLL.printDoubleLL();

//            Now, removing the last element from the doubly LinkedList.
//            DoublyLL.removeLast();
//            System.out.println("The doubly linkedList after removing the last element is : ");
//            DoublyLL.printDoubleLL();

//            reversing the doubly linkedList.
//            DoublyLL.addLast(6);
//            DoublyLL.addLast(7);
//            DoublyLL.addLast(8);
//            DoublyLL.addLast(9);
//            DoublyLL.addLast(10);
//            System.out.println("The doubly LinkedList before reversing is : ");
//            DoublyLL.printDoubleLL();
//            DoublyLL.reverseDLL();
//            System.out.println("The doubly linkedList after reversing is : ");
//            DoublyLL.printDoubleLL();

//            Circular LinkedLists.
//        LinkedLists l=new LinkedLists();
//        l.addFirst(1);
//        l.addFirst(2);
//        l.addFirst(3);
//        l.printList();


            









        }
}


