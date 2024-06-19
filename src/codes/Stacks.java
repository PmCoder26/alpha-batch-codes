package codes;
import java.util.*;
import codes.Arrays.*;

public class Stacks {
    //       creating the stack using the ArrayList.
    static class MyStack1 {
        public static ArrayList<Integer> list = new ArrayList<>();

        //        checking whether stack is empty or not, in the form of arrayList.
        public static boolean isEmpty() {
            return list.size() == 0;
        }

        //        push operation - adding the element in the stack at the last.
        public static void push(int data) {
            list.add(data);
        }

        //        pop operation - removing the last element from the stack.
        public static int pop() {
            if (isEmpty()) {
                return -1;
            } else {
                int value = list.get(list.size() - 1);
                list.remove(list.size() - 1);
                return value;
            }
        }

        //        peek operation - fetching the last element of the stack and returning that element.
        public static int peek() {
            if (isEmpty()) {
                return -1;
            } else {
                return list.get(list.size() - 1);
            }
        }
    }

    //          creating stack using linkedList.
    static class MyStack2 {
        private static Node head;
        private static Node tail;

        static class Node {
            int data;
            Node next;

            public Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        //                checking whether stack is empty or not in the form of LinkedList.
        public static boolean isEmpty() {
            return head == null;
        }

        //                push operation.
        public static void push(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                tail = head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        //                 pop operation.
        public static int pop() {
            if (isEmpty()) {
                return -1;
            } else {
                int value = head.data;
                head = head.next;
                return value;
            }
        }

        //                 peek operation.
        public static int peek() {
            if (isEmpty()) {
                return -1;
            } else {
                return head.data;
            }
        }
    }
    public static void printStack(Stack st) {
        Stack st1 = (Stack) st.clone();
        while (!st1.isEmpty()) {
            System.out.print(st1.pop() + " ");
        }
        System.out.println();
    }
    public static void pushAtBottom(Stack<Integer> st, int value) {
        if (st.isEmpty()) {
            st.push(value);
        } else {
            int data = st.pop();
            pushAtBottom(st, value);
            st.push(data);
        }
    }
    public static String reverseString(String strg) {
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while (idx < strg.length()) {
            s.push(strg.charAt(idx++));
        }
        StringBuilder ans = new StringBuilder();
        while (!s.isEmpty()) {
            ans.append(s.pop());
        }
        return ans.toString();
    }
    //   approach to reverse Stack.
    public static void reverseStack2(Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        } else {
            int value = st.pop();
            reverseStack2(st);
            pushAtBottom(st, value);
        }
    }
    public static void stocksSpanCalc(int[] stocks, int[] span) {
        Stack<Integer> st = new Stack<>();
        span[0] = 1;
        st.push(0);
        for (int x = 1; x < stocks.length; x++) {
            int current = stocks[x];
            while (!st.isEmpty() && current >= stocks[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) {
                span[x] = x + 1;
            } else {
                int previousHigh = st.peek();
                span[x] = x - previousHigh;
            }
            st.push(x);
        }
    }
    public static int[] nextGreaterEle1(int[] arr) {
        int[] nextEleArr = new int[arr.length];
        for (int x = 0; x < arr.length; x++) {
            int ele = arr[x];
            boolean flag = false;
            for (int y = x + 1; y < arr.length; y++) {
                if (ele < arr[y]) {
                    flag = true;
                    nextEleArr[x] = arr[y];
                    break;
                }
            }
            if (flag == false) {
                nextEleArr[x] = -1;
            }
        }
        return nextEleArr;
    }
    public static int[] nextGreaterEle2(int[] arr) {
        if (arr.length == 0) {
            return arr;
        } else {
            Stack<Integer> st = new Stack<>();       // Note - the st stack holds the index values not elements.
            int[] nextGreaterEle = new int[arr.length];
            for (int x = arr.length - 1; x >= 0; x--) {
//                 1. while the greater element isn't fetched and stack isn't empty.
                while (!st.isEmpty() && arr[st.peek()] <= arr[x]) {
                    st.pop();
                }
//                 if stack is empty.
                if (st.isEmpty()) {
                    nextGreaterEle[x] = -1;
                } else {
                    nextGreaterEle[x] = arr[st.peek()];
                }
//                 pushing the index of the element whose next greater is found.
                st.push(x);
            }
            return nextGreaterEle;
        }
    }
    public static boolean parenthesisCheck(String strg) {     // time complexity - O(n)
        if (strg.length() == 0) {
            System.out.println("String is Empty");
            return false;
        } else {
            Stack<Character> st = new Stack<>();
            for (int x = 0; x < strg.length(); x++) {
                char ch = strg.charAt(x);
                if (ch == '(' || ch == '[' || ch == '{') {
                    st.push(ch);
                } else {
                    if (st.isEmpty()) {
                        return false;
                    }
                    if ((ch == ')' && st.peek() == '(') || (ch == ']' && st.peek() == '[') || (ch == '}' && st.peek() == '{')) {
                        st.pop();
                    } else {
                        return false;
                    }
                }
            }
            if (st.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }
    }
    public static boolean checkDuplicateParentheses(String str) {
        if (str.length() == 0) {
            return false;
        } else {
            Stack<Character> eleStack = new Stack<>();
            for (int x = 0; x < str.length(); x++) {
//                         for closing brackets.
                if (str.charAt(x) == ')') {
                    int eleCount = 0;
                    while (eleStack.pop() != '(') {
                        eleCount++;
                    }
                    if (eleCount < 1) {
                        return true;
                    }
                } else {
//                             for opening brackets and other characters.
                    eleStack.push(str.charAt(x));
                }
            }
            return false;
        }
    }

    //            methods for the question, find the maximum rectangle form from the given height arrays of bar in histogram.
    //   for the next smaller to the right.
    public static int[] nextSmallerRightEle(int[] arr) {
//                 Note - In this case the actual elements are stored int smallEleArr.
        int[] smallerEleArr = new int[arr.length];
        Stack<Integer> st2 = new Stack<>();
        for (int x = arr.length - 1; x >= 0; x--) {
//                    traversing from right to left till stack isn't empty and smaller isn't fetched.
            while (!st2.isEmpty() && arr[st2.peek()] >= arr[x]) {
                st2.pop();
            }
//                     if stack is empty, specially initially.
            if (st2.isEmpty()) {
                smallerEleArr[x] = arr.length;
            } else {
                smallerEleArr[x] = st2.peek();
            }
//                     finally pushing the current xth element's index of arr in the stack.
            st2.push(x);
        }
        return smallerEleArr;
    }

    //    for the next smaller to the left.
    public static int[] nextSmallerLeftEle(int[] arr) {
//        Note - In this case the actual elements are stored int smallEleArr.
        int[] smallerEleArr = new int[arr.length];
        Stack<Integer> st1 = new Stack<>();
        for (int x = 0; x < arr.length; x++) {
            //                 traversing from left till stack isn't empty and smaller isn't fetched.
            while (!st1.isEmpty() && arr[st1.peek()] >= arr[x]) {
                st1.pop();
            }
//                     if stack is empty, specially initially.
            if (st1.isEmpty()) {
                smallerEleArr[x] = -1;
            } else {
                smallerEleArr[x] = st1.peek();
            }
//                     finally pushing the current xth element's index of arr into stack.
            st1.push(x);
        }
        return smallerEleArr;
    }

    public static int maxArea(int[] heights, int width) {
        if (heights.length == 1) {
            return heights[0] * width;
        } else {
//                     calculating the smaller to the left of each bar.
            int[] smallerLeft = nextSmallerLeftEle(heights);
//                     calculating the smaller to the right of each bar.
            int[] smallerRight = nextSmallerRightEle(heights);
//                     initialized to store area for all bars with respect to others.
            int[] areas = new int[heights.length];
//                     calculating the possible maximum area for each bar with others.
            for (int x = 0; x < heights.length; x++) {
                areas[x] = (heights[x] * (smallerRight[x] - smallerLeft[x] - 1) * width);
            }
//                     calculating the maximum of the area from the areas array and that is the answer.
            int maxArea = Integer.MIN_VALUE;
            for (int x = 0; x < areas.length; x++) {
                if (maxArea <= areas[x]) {
                    maxArea = areas[x];
                }
            }
            return maxArea;
        }
    }


    public static void main(String[] args) {

//        Stacks.    LIFO - last in first out.
//      Operations in stacks - push(), pop(), peek().

//         Defining the stack using ArrayList and operating.
//        MyStack1 st1=new MyStack1();
//        st1.push(3);
//        System.out.println("The last element in the stack is : " + st1.peek());
//        System.out.println("The popped element in the stack is : " + st1.pop());
//        System.out.println("The statement that 'Stack is empty is' : " + st1.isEmpty());

//        Defining the stack using LinkedList and operating.
//        MyStack2 st2=new MyStack2();
//        st2.push(10);
//        System.out.print("The last element in the stack is : " + st2.peek());
//        System.out.println("The popped element in the stack is : " + st2.pop());
//        System.out.println("The statement that 'Stack is empty is' : " + st2.isEmpty());

//        Defining the stack using the Java Collection Framework;
//        Stack<Integer> st=new Stack<>();
//        st.push(90);
//        System.out.println("The last element of the stack is : " + st.peek());
//        System.out.println("The popped element is : " + st.pop());

//          imp Questions.

//        push at the bottom of the stack.   - solved using recursive function.
//        Stack<Integer> st=new Stack<>();
//        st.push(1);
//        st.push(2);
//        st.push(3);
//        st.push(4);
//        st.push(5);
//        pushAtBottom(st, 10);
//        System.out.println("The stack after push at bottom is : ");
//        while(!st.isEmpty()){
//            System.out.print(st.peek()+ " ");
//            st.pop();
//        }

//        Reverse a String using the stack.
//        String name="Parimal";
//        System.out.println("The reversed string is :" + reverseString(name));

//        reversing a stack.
//        Stack<Integer> st=new Stack<>();
//        st.push(1);
//        st.push(2);
//        st.push(3);
//        st.push(4);
//        st.push(5);
//        System.out.println("The Stack before reversing : ");
//        printStack(st);
////        approach 2
//        reverseStack2(st);
//        System.out.println("The stack after reversing : ");
//        printStack(st);

//        Stock span Problem.
//        int[] stocks={100, 80, 60, 70, 60, 85, 100};
//        int[] span=new int[stocks.length];
//        stocksSpanCalc(stocks, span);
////        printing the span.
//        for(int x=0; x<span.length; x++){
//            System.out.print(span[x] + " ");
//

//        next greater element from right.      The main question has three other forms as, next smaller from right, left, next greater from left.
        //      Approach 1 - bruteforce approach.
//        int[] eleArr={6,8,0,1,3};
//        Arrays.printArr(nextGreaterEle1(eleArr));
        //      Approach 2 - stack approach (Optimized).
//        Arrays.printArr(nextGreaterEle2(eleArr));

//        Valid Parenthesis check.
//        System.out.println("The statement 'The string has valid parenthesis is ': " + parenthesisCheck("{}{{({})}[][][]"));

//        Duplicate parenthesis question.  time complexity O(n).
//        String str="((a+b)+(a-b))";
//        System.out.println("The statement 'The given string contains duplicate parentheses ' is : " + checkDuplicateParentheses(str));

//        Max area in histogram question.
//        int[] heights={2,1,5,6,2,3};
//        System.out.println("The maximum possible area for the histogram is : " + maxArea(heights, 1));









        }
}









