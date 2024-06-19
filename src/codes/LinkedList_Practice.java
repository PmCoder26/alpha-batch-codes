package codes;
import java.util.*;
import codes.LinkedLists.*;

public class LinkedList_Practice {
    public static Scanner sc=new Scanner(System.in);
    public static Node interSectionPoint(Node head1, Node head2){
        if(head1==null || head2==null){
            System.out.println("No intersection point exists!");
            return null;
        }
        else{
            while(head1!=null){
                Node temp=head2;
                while(temp!=null){
                    if(temp==head1){
                        return temp;
                    }
                    else{
                        temp=temp.next;
                    }
                }
                head1=head1.next;
            }
            return null;
        }
    }
    public static Node addTwoNumbers(Node l1, Node l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        Node l3=null;
        int sum=0;
        int carry=0;
        while(l1!=null || l2!=null){
            if(l1!=null){
                sum+=l1.data;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.data;
                l2=l2.next;
            }
            sum+=carry;
            if(sum>=10){
                carry=sum/10;
                sum=sum%10;

            }
            else{
                carry=0;
            }
            Node newNode=new Node(sum);
            newNode.next=l3;
            l3=newNode;
            sum=0;
        }
        if(carry>0) {
            Node newNode = new Node(carry);
            newNode.next = l3;
            l3 = newNode;
        }
        l1=null;
        while(l3!=null){
            Node temp=l3.next;
            l3.next=l1;
            l1=l3;
            l3=temp;
        }
        return l1;
    }
    public static int pairSum(Node head) {
        Node fast=head;
        Node slow=head;
        int max=Integer.MIN_VALUE;
        int size=0;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            size++;
        }
        Node part2=slow;
        Node part1=null;
        Node curr=head;
        int i=0;
        while(i<size){
            Node temp=curr.next;
            curr.next=part1;
            part1=curr;
            curr=temp;
            i++;
        }
        curr=null;
        while(part1!=null && part2!=null){
            max=Math.max(max, part2.data+part1.data);
            part2=part2.next;
            part1=part1.next;
        }
        System.out.println();
        return max;
    }


    public static void main(String[] args){

//        LinkedList Question Practice.

//        Que.1.

        
        /*
                        Intersection of Two Linked Lists
                In a system, there are two singly linked list. By some programming error,
                the end node of one of the linked lists got linked to the second list, forming
                an inverted Y-shaped list. Write a program to get the point where two linked lists merge.
         */
//        Node head1=new Node(1);
//        Node head2=new Node(4);
//        head1.next=new Node(2);
//        head1.next.next=new Node(3);
//        head1.next.next.next=new Node(6);
//        head1.next.next.next.next=new Node(7);
//        head2.next=new Node(5);
//        head2.next=head1.next.next.next;        // here is the intersection.
//        Node interPoint=interSectionPoint(head1, head2);
//        if(interPoint!=null) {
//            System.out.println("The intersection point is: " +interPoint.data);
//        }
//        else{
//            System.out.println("No intersection exists");
//        }

//        Que.2.
        /*
                    Delete N Nodes After M Nodes of a Linked List
            We have a linked list and two integers M and N. Traverse the linked list such that you retain
            M nodes then delete next N nodes, continue the same till the end of the linked list.
         */
//        System.out.print("Enter the value of M: ");
//        int M=sc.nextInt();
//        System.out.print("Enter the value of N: ");
//        int N=sc.nextInt();
//        Node head1=new Node(1);
//        head1.next=new Node(2);
//        head1.next.next=new Node(3);
//        head1.next.next.next=new Node(4);
//        head1.next.next.next.next=new Node(5);
//        head1.next.next.next.next.next=new Node(6);
//        head1.next.next.next.next.next.next=new Node(7);
//        head1.next.next.next.next.next.next.next=new Node(8);
//        // printing the list.
//        LinkedLists.listPrint(deleteNAfterM(head1, M, N));

//        Que.3.
        /*
                Swapping Nodes in a LinkedList
            We have a linked list and two keys in it, swap nodes for two given keys.
            Nodes should be swapped by changing links. Swapping data of nodes may be expensive in many situations when data contains many fields. It may be assumed that all keys in the linked list are distinct.
         */
//        System.out.print("Enter x: ");
//        int x=sc.nextInt();
//        System.out.print("Enter y: ");
//        int y=sc.nextInt();
//        Node head1=new Node(1);
//        head1.next=new Node(2);
//        head1.next.next=new Node(3);
//        head1.next.next.next=new Node(4);
//        head1.next.next.next.next=new Node(5);
//        swapNodes(head1, x ,y);

//        adding two digits to get overall addition numbers in the linkedList.
//        given two reversed linkedLists perform the addition of the respective node.


        /*
                Given linkedList. Find the maximum pair sum of the linkedList.
                Pair of nodes is considered as-
                ex. List- 1->2->3->4.
                then pairs-(1, 4), (2, 3).
                Note - size of the list is even not odd.
         */
//        Node head=new Node(5);
//        head.next=new Node(4);
//        head.next.next=new Node(2);
//        head.next.next.next=new Node(1);
//        System.out.println(pairSum(head));











    }


}
