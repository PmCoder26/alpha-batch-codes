package codes;
import codes.*;
import java.util.*;

class AVLTrees extends Binary_Trees.BinaryTree{
    static class Node1 extends Binary_Trees.Node{
        int height;
        public Node1(int data){
            super(data);
            height=1;
        }
    }
    public static Node1 root;
    public static int height(Node1 root){
        if(root==null){
            return 0;
        }
        else{
            return root.height;
        }
    }
    public static int max(int a, int b){
        return (a>b) ? a:b;
    }
    private static int getBFactor(Node1 root){
        if(root==null){
            return 0;
        }
        else{
            return height((Node1)root.left)-height((Node1)root.right);
        }
    }
    private static Node1 leftRotate(Node1 root){
        Node1 n1=(Node1)root.right;
        Node1 n2=(Node1)n1.left;
        // rotating left.
        n1.left=root;
        root.right=n2;
        // updating the heights.
        root.height=max(height((Node1)root.left), height((Node1)root.right))+1;
        n1.height=max(height((Node1)n1.left), height((Node1)n1.right))+1;
        return n1;      // returning the balanced root node.
    }
    private static Node1 rightRotate(Node1 root){
        Node1 n1=(Node1)root.left;
        Node1 n2=(Node1)n1.right;
        // rotating right.
        n1.right=root;
        root.left=n2;
        // updating the heights.
        root.height=max(height((Node1)root.left), height((Node1)root.right))+1;
        n1.height=max(height((Node1)n1.left), height((Node1)n1.right))+1;
        return n1;      // returning the balanced root node.
    }
    private static Node1 balance(Node1 root){
        if(root==null){
            return root;
        }
        else{
            int bFactor=getBFactor(root);
            // Left-Left.
            if(bFactor > 1 && getBFactor((Node1) root.left) >=0){
                return rightRotate(root);
            }
            // Right-Right.
            else if(bFactor < -1 && getBFactor((Node1) root.right) <=0){
                return leftRotate(root);
            }
            // Right-Left.
            else if(bFactor < -1 && getBFactor((Node1) root.right) > 0){
                root.right=rightRotate((Node1)root.right);
                return leftRotate(root);
            }
            // Left-Right.
            else if(bFactor > 1 && getBFactor((Node1) root.left) < 0){
                root.left=leftRotate((Node1)root.left);
                return rightRotate(root);
            }
            return root;
        }
    }
    public static Node1 insert(Node1 root, int key){
        if(root==null){
            return new Node1(key);
        }
        else if(key<root.data){
            root.left=insert((Node1)root.left, key);
        }
        else if(key>root.data){
            root.right=insert((Node1)root.right, key);
        }
        else{
            return root;        // No duplicate keys are allowed.
        }
        // updating the root's height.
        root.height=Math.max(height((Node1)root.left), height((Node1)root.right))+1;
        // balancing the current root.
        root=balance(root);
        return root;    // returning balanced AVL tree.
    }
    private static Node1 helper(Node1 root, Node1 subRoot){
        if(root==null){
            return subRoot;
        }
        else{
            root.left=helper((Node1)root.left, subRoot);
            return root;
        }
    }
    public static Node1 remove(Node1 root, int key){
        if(root==null){
            return root;
        }
        if(key < root.data){
            root.left=remove((Node1)root.left, key);
        }
        else if(key > root.data){
            root.right=remove((Node1) root.right, key);
        }
        else{
            root=helper((Node1)root.right, (Node1)root.left);
        }
        // updating the height of the current root of AVL tree.
        root.height=Math.max(height((Node1)root.left), height((Node1)root.right))+1;
        // balancing the current root.
        root=balance(root);
        return root;
    }
}

public class Binary_Search_Tree {
    public static Node root;
    public Binary_Search_Tree(){
        root=buildBST(null,new int[]{5, 1, 3, 4, 2, 7});
    }
    public static Binary_Trees bt=new Binary_Trees();
    private static Binary_Trees.BinaryTree tree= new Binary_Trees.BinaryTree();
    static class Node extends Binary_Trees.Node{
        public Node(int data) {
            super(data);        // here super keyword is used because, as we are extending the Node of binary trees class.
                                // this node class consists of constructor of parameters. Hence, this will automatically invoke the
                                // constructor of the node class of binary_trees class; as we are extending that class, constructor of
                                // it will be automatically invoked.
        }
    }        // To use the static class node from the file Binary_Tree.
    public static Node insert(Node root ,int value){
        if(root==null){
            return new Node(value);
        }
        else{
            if(value<root.data){
                root.left=insert((Node) root.left, value);
            }
            else{
                root.right=insert((Node)root.right, value);
            }
            return root;
        }
    }
    public static Node buildBST(Node root, int[] values){
        for(int x=0; x<values.length; x++){
            root=insert(root, values[x]);
        }
        return root;
    }
    public static boolean searchNode(Node root, int key){       // Time complexity - O(H) where H-height of binary tree.
        if(root==null){
            return false;
        }
        else{
            if(root.data==key){
                return true;
            }
            else{
                if(key<root.data) {
                    return searchNode((Node)root.left, key);
                }
                else{
                    return searchNode((Node) root.right, key);
                }
            }
        }
    }
    public static Node findInOrderSuccessor(Node root){
        while(root.left!=null){
            root= (Node) root.left;
        }
        return (Node)root;
    }
    public static Node deleteNode(Node root, int value){
        // Inorder successor is the leftmost node in the right subtree.
        if(root.data>value){
            root.left=deleteNode((Node)root.left, value);
        }
        else if(root.data<value){
            root.right=deleteNode((Node)root.right, value);
        }
        else{
            // for leaf node present.
            if(root.left==null && root.right==null){        // return null.
                return null;
            }
            // for single node/single child is present.
            if(root.left==null){
                return (Node)root.right;
            }
            else if(root.right==null){
                return (Node)root.left;
            }
            else{
                // when both children are present.
                Node IS=findInOrderSuccessor((Node)root.right);
                root.data=IS.data;
//                deleting the useless node that is inorder successor when its value is utilized.
                root.right=deleteNode((Node)root.right, IS.data);
            }
        }
        return root;
    }
    public static Node helper(Node root, Node subRoot){
        if(root==null){
            return subRoot;
        }

        else{
            root.left=helper((Node)root.left, subRoot);
            return root;
        }
    }
    public static Node deleteNode2(Node root, int key){
        if(root==null){
            return root;
        }
        if(key==root.data){
            return helper((Node)root.right, (Node)root.left);
        }
        else{
            root.left=deleteNode2((Node)root.left, key);
            root.right=deleteNode2((Node)root.right, key);
            return root;
        }
    }
    public static void printInRange(Node root, int k1, int k2){
        if(root==null){
            return;
        }
        else if(root.data>=k1 && root.data<=k2){      // if the value lies between the limits, then the root's left and right subtrees are invoked.
            printInRange((Node)root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange((Node) root.right, k1, k2);
        }
        else if(root.data<k1){      // if the value is less than the lower limit, then go to the right subtree as it has higher values than it parent.
            printInRange((Node) root.right, k1, k2);
        }
        else {      // if the value is greater than the upper limit, then go to the left subtree as it will have lower values to be fit in range.
            printInRange((Node) root.left, k1, k2);
        }
    }
    public static void printPathRootToLeaf(Node root, ArrayList<Integer> path){
        if(root==null){
            return;
        }
        if(root.right==null && root.left==null){    // When both subtrees are null i.e., leaf node. Hence, add the data and remove after printing.
            path.add(root.data);
            System.out.println(path);
            path.remove(path.size()-1);
            return;
        }
        else{
            path.add(root.data);
            printPathRootToLeaf((Node)root.left, path);
            printPathRootToLeaf((Node)root.right, path);
            path.remove(path.size()-1);
        }
    }
    public static boolean isValidBST(Node root, Node min, Node max) {
        if(root==null){
            return true;
        }
        if(min!=null && root.data<=min.data){    // if the order of BST is valid, that is when the left node of root is bigger than root, this is an invalid order.
            return false;
        }
        else if(max!=null && root.data>=max.data){  // if the order of BST is valid, when the right node of root is smaller than root, this is an invalid order.
            return false;
        }
        else{       // else checking for the further left and right nodes for a root.
            boolean left=isValidBST((Node)root.left, min, (Node)root);
            boolean right=isValidBST((Node) root.right, (Node)root, max);
            return left && right;
        }
    }
    public static Node mirrorBST(Node root){
        if(root==null){
            return root;
        }
        else{
            Node left=mirrorBST((Node)root.left);
            Node right=mirrorBST((Node)root.right);
            root.left=right;
            root.right=left;
            return root;
        }
    }
    public static Node sortedArrayToBST(int[] nodes, int start, int end){
        if(start>end){
            return null;
        }
        else{
            int mid=(start+end)/2;
            Node root=new Binary_Search_Tree.Node(nodes[mid]);
            root.left=sortedArrayToBST(nodes, start, mid-1);
            root.right=sortedArrayToBST(nodes, mid+1, end);
            return root;
        }
    }
    public static ArrayList<Integer>inOrder(Node root, ArrayList<Integer> values){
        if(root==null){
            return new ArrayList<>();
        }
        else{
            inOrder((Node)root.left, values);
            values.add(root.data);
            inOrder((Node) root.right, values);
            return values;
        }
    }
    public static int[] listToArray(ArrayList<Integer> values){
        if(values.size()==0){
            return new int[0];
        }
        else{
            int[] result=new int[values.size()];
            for(int x=0; x<values.size(); x++){
               result[x]=values.get(x);
            }
            return result;
        }
    }
    public static Node balancedBST(Node root){
        if(root==null){
            return root;
        }
        else{
            // Inorder traversal and forming an arraylist of values of the root.
            ArrayList<Integer> values=inOrder(root, new ArrayList<Integer>());
            // forming the balanced BST using helper function -> sortedArrayToBST(int[] values, int start, int end) but firstly convert arraylist to array.
            return sortedArrayToBST(listToArray(values), 0, values.size()-1);
        }
    }
    static class Info3{
        int size;
        int max;
        int min;
        boolean isBST;
        public Info3(boolean isBST, int size, int min, int max){
            this.isBST=isBST;
            this.size=size;
            this.min=min;
            this.max=max;
        }
    }
    private static int maxSize;
    public static Info3 largestBST(Node root){
        if(root==null){
            return new Info3(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
//        comparing and assigning the values as per method invocation.
        Info3 left=largestBST((Node)root.left);
        Info3 right=largestBST((Node)root.right);
        int size=Math.max(left.size, right.size)+1;
        int min=Math.min(root.data, Math.min(left.min, right.min));
        int max=Math.max(root.data, Math.max(left.max, right.max));
        if(root.data<=left.max || root.data>=right.min){
            return new Info3(false, size, min, max);
        }
        if(left.isBST && right.isBST){      // if both true, that means left and right part is subtree so it is also subtree
            maxSize=Math.max(maxSize, size);
            return new Info3(true, size, min, max);
        }
        return new Info3(false, size, min, max);
    }
    public static Node mergeBSTs(Node BST1, Node BST2){
            // traversing inorder for both BST1 ans BST2 and merging their sorted sequences.
            ArrayList<Integer> firstHalf=inOrder(BST1, new ArrayList<Integer>());
            ArrayList<Integer> secondHalf=inOrder(BST2, new ArrayList<Integer>());
            ArrayList<Integer> finalList=new ArrayList<>();
            // sorting the first half and second half together so that a net sorted arraylist can be formed and finally well-balanced BST formed.
            int i=0, j=0;
            while(i<firstHalf.size() && j<secondHalf.size()){
                if(firstHalf.get(i)<secondHalf.get(j)){
                    finalList.add(firstHalf.get(i++));
                }
                else{
                    finalList.add(secondHalf.get(j++));
                }
            }
            // for remaining elements in the first half.
            while(i<firstHalf.size()){
                finalList.add(firstHalf.get(i++));
            }
            // for remaining elements in the second half.
            while(j<secondHalf.size()){
                finalList.add(secondHalf.get(j++));
            }
            // converting the arraylist into the array.
            int[] values=listToArray(finalList);
            // Now, creating and finally returning balanced BST of merged arrayList.
            return sortedArrayToBST(values, 0, values.length-1);
    }


    private ArrayList<Integer> contains(ArrayList<Node> nums, int key){
        if(nums.isEmpty()){
            return new ArrayList<Integer>();
        }
        else{
            ArrayList<Integer> al =  new ArrayList<Integer>();
            for(int x=0; x<nums.size(); x++){
                if(nums.get(x).data == key){
                    al.add(x);
                }
            }
            return al;
        }
    }
    private boolean areSimilar(Node root1, Node root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if((root1 == null || root2 == null) || (root1.data != root2.data)){
            return false;
        }
        else{
            boolean left = areSimilar((Node) root1.left, (Node) root2.left);
            boolean right = areSimilar((Node) root1.right, (Node) root2.right);
            return left && right;
        }
    }
    private void helper(Node root, ArrayList<Node> tempList, ArrayList<Node> list){
        if(root == null){
            return;
        }
        ArrayList<Integer> idxList = contains(tempList, root.data);
        if(!idxList.isEmpty()){
            for(int x=0; x<idxList.size(); x++){
                if(areSimilar(tempList.get(idxList.get(x)), root)){
                    list.add(root);
                }
            }
        }
        idxList = null;
        tempList.add(root);
        helper((Node) root.left, tempList, list);
        helper((Node) root.right, tempList, list);
    }
    public List<Node> printAllDuplis(Node root) {
        if(root == null){
            return new ArrayList<Node>();
        }
        else{
            ArrayList<Node> list = new ArrayList<>();
            helper(root, new ArrayList<Node>(), list);
            return list;
        }
    }


        public static void main(String[] args){

            Binary_Search_Tree bst=new Binary_Search_Tree();

//        Binary Search Tree.

        /*

        Notes:
        1. Left Subtree Nodes' value > Root's data.
        2. Right Subtree Nodes' value < Root's data.
        3. Left and right subtrees are also BST with no duplicates.

         */

        /*
                BST of {5, 1, 3, 4, 2, 7}
                            5
                           / \
                          1   7
                           \
                            3
                           / \
                          2   4
         */

//        Build a Binary Search Tree.
//        int[] values={5, 1, 3, 4, 2, 7};
//        Node root=buildBST(null, values);
//        tree.inOrder(root);

//        Search in Binary Search Tree.
//        System.out.println("Does key exist? - " + searchNode(root, 10));

//        Delete a node in Binary Search Tree.
//        System.out.println("Tree before deleting the node - ");
//        tree.preOrder(root);
//        deleteNode(root, 5);
//        System.out.println();
//        System.out.println("Tree after deleting the node - ");
//        tree.preOrder(root);

//        Print nodes' data in range.
//        tree.inOrder(root);
//        System.out.println();
//        System.out.println("The range of printing is: ");
//        printInRange(root, 2, 6);

//        Printing the path from root to leaf.
//        printPathRootToLeaf((Node) root, new ArrayList<Integer>());

//        Validating BST.
//        System.out.println("The validity of the BST is: " + isValidBST(root, null, null));

//        Mirroring a BST.
//        System.out.println("BST before mirroring is: ");
//        tree.inOrder(root);
//        System.out.println();
//        mirrorBST(root);
//        System.out.println("BST after mirroring is: ");
//        tree.inOrder(root);

//        A sorted array into balanced BST.       // Creating bst using a sorted array with possible minimum and balanced height.
//        int[] nodes={3, 5, 6, 8, 10, 11, 12};
//        System.out.println("The BST created from a sorted array is: ");
//        tree.levelOrder(sortedArrayToBST(nodes, 0, nodes.length-1));

//        Converting unbalanced BST to balanced BST.    // Balanced BST may contain balanced and minimum height and follows the properties of BST.
        /*
        Step 1: Inorder traversing and storing the values of nodes in a data structure correspondingly and respectively.
        Step 2: Finally, creating the BST using the sortedArrayToBST() function.
         */
        /*
            Unbalanced BST.
                            8
                           / \
                          6   10
                         /     \
                        5       11
                       /         \
                      3           12
         */

//        root=new Binary_Search_Tree.Node(8);
//        root.left=new Binary_Search_Tree.Node(6);
//        root.left.left=new Binary_Search_Tree.Node(5);
//        root.left.left.left=new Binary_Search_Tree.Node(3);
//        root.right=new Binary_Search_Tree.Node(10);
//        root.right.right=new Binary_Search_Tree.Node(11);
//        root.right.right.right=new Binary_Search_Tree.Node(12);
//        System.out.println("The balanced BST is: ");
//        tree.levelOrder(balancedBST(root));

//        Size of the largest BST in Binary tree.
//        largestBST(root);
//        System.out.println("The size of the largest BST is: " + maxSize);

//        Merging two BSTs.
//        Node BST1=new Node(2);
//        BST1.left=new Node(1);
//        BST1.right=new Node(4);
//        Node BST2=new Node(9);
//        BST2.left=new Node(3);
//        BST2.right=new Node(12);
//        System.out.println("The final, balanced BST by merging two BSTs is: ");
//        tree.levelOrder(mergeBSTs(BST1, BST2));

            //      AVL Trees.      They are self-balancing trees.

//        Creating AVL trees.

        /*
                AVL Tree.
                        30
                       /  \
                      20   40
                      /\    \
                     10 25   50
         */

        AVLTrees aTree=new AVLTrees();
        aTree.root=aTree.insert(aTree.root,10);
        aTree.root=aTree.insert(aTree.root,20);
        aTree.root=aTree.insert(aTree.root,30);
        aTree.root=aTree.insert(aTree.root,40);
        aTree.root=aTree.insert(aTree.root,50);
        aTree.root=aTree.insert(aTree.root,90);
        aTree.root=aTree.insert(aTree.root,25);
        System.out.println("The level order sequence of the AVL tree is: ");
        aTree.levelOrder(aTree.root);
        aTree.root=aTree.remove(aTree.root, 40);
        aTree.levelOrder(aTree.root);







    }

}



