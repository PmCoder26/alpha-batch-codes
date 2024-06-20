package codes;
import java.math.BigInteger;
import java.util.*;

public class Binary_Trees {
    public static BinaryTree tree=new BinaryTree();
    public static Node root=new Node(1);
    public Binary_Trees(){
//        Common Binary tree for all methods and questions.
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
    }

    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            right=null;
            left=null;
        }
    }

    static class BinaryTree{
        static int index=-1;
        public static Node buildTree(int[] nodes){      // Preorder arrangement.
            index++;
            if(nodes[index]==-1){
                return null;
            }
            else{
                Node newNode=new Node(nodes[index]);
                newNode.left=buildTree(nodes);
                newNode.right=buildTree(nodes);
                return newNode;
            }
        }
        public static void preOrder(Node root){         // Preorder printing and traversing.
            if(root==null){
//                System.out.print(-1 + " ");         // optional
                return;
            }
            else{
                System.out.print(root.data + " ");
                preOrder(root.left);
                preOrder(root.right);
            }
        }
        public static void inOrder(Node root){      // InOrder printing and traversing.
            if(root==null){
                return;
            }
            else{
                inOrder(root.left);
                System.out.print(root.data + " ");
                inOrder(root.right);
            }
        }
        public static void postOrder(Node root){      // PostOrder printing and traversing.
            if(root==null){
                return;
            }
            else{
                postOrder(root.left);
                postOrder(root.right);
                System.out.print(root.data + " ");
            }
        }
        public static void levelOrder(Node root){       // Traversing and printing the data level wise.
            if(root==null){
                return;
            }
            Queue<Node> rootSet=new LinkedList<>();
            rootSet.add(root);
            rootSet.add(null);
            while(!rootSet.isEmpty()){
                Node current=rootSet.remove();
                if(current==null){
                    System.out.println();
                    if(rootSet.isEmpty()){
                        break;
                    }
                    else{
                        rootSet.add(null);
                    }
                }
                else{
                    System.out.print(current.data + " ");
                    if(current.left!=null){
                        rootSet.add(current.left);
                    }
                    if(current.right!=null){
                        rootSet.add(current.right);
                    }
                }
            }
        }
        public static void getLevels(ArrayList<Node> nodes, ArrayList<Integer> levels, Node root, int level){
            if (root == null) {
                return;
            }
            else{
                getLevels(nodes, levels, root.left, level+1);
                getLevels(nodes, levels, root.right, level+1);
                levels.add(level);
                nodes.add(root);
            }
        }
        public static void levelOrderReverse(Node root){
            if(root==null){
                return;
            }
            ArrayList<Node> nodes=new ArrayList<>();
            ArrayList<Integer> levels=new ArrayList<>();
//            Filling the levels and nodes with their respective node and levels in binary tree.
            getLevels(nodes, levels, root, 1);
//            Now sorting the levels in decreasing order and accordingly updating the nodes' position.
            decreaseSortLevels(nodes, levels);
//            Finally, printing the values of nodes in decreasing order of their levels.
            int level=Collections.max(levels);
            for(int x=0; x<nodes.size(); x++){
                if(levels.get(x)!=level){
                    level--;
                    System.out.println();
                }
                System.out.print(nodes.get(x).data + " ");
            }
        }
        public static void decreaseSortLevels(ArrayList<Node> nodes, ArrayList<Integer> levels){
//            using bubble sort algorithm.
            for(int x=0; x<levels.size()-1; x++){
                for(int y=0; y<levels.size()-1-x; y++){
                    if(levels.get(y)<levels.get(y+1)){      // here <= is not used because if levels become same then it will affect the order of elements
                        // as per order of binary tree.
//                        Swapping levels.
                        int temp=levels.get(y);
                        levels.set(y, levels.get(y+1));
                        levels.set(y+1, temp);
//                        Swapping nodes.
                        Node tempNode=nodes.get(y);
                        nodes.set(y, nodes.get(y+1));
                        nodes.set(y+1, tempNode);
                    }
                }
            }
        }
        public static int treeHeight(Node root){      // Time Complexity - O(n).
            if(root==null){
                return 0;
            }
            else{
                int left=treeHeight(root.left);
                int right=treeHeight(root.right);
                return Math.max(left, right)+1;
            }
        }
        public static int nodeCount(Node root){      // Time Complexity - O(n).
            if(root==null){
                return 0;
            }
            else{
                int leftCount=nodeCount(root.left);
                int rightCount=nodeCount(root.right);
                return leftCount+rightCount+1;
            }
        }
        public static int nodeSum(Node root){         // Time Complexity - O(n).
            if(root==null){
                return 0;
            }
            else{
                int leftSum=nodeSum(root.left);
                int rightSum=nodeSum(root.right);
                return root.data+leftSum+rightSum;
            }
        }
        public static int treeDiameter1(Node root){
            if(root==null){
                return 0;
            }
            else{
                int leftDiameter=treeDiameter1(root.left);
                int leftHeight=treeHeight(root.left);
                int rightDiameter=treeDiameter1(root.right);
                int rightHeight=treeHeight(root.right);
                int selfDiameter=leftHeight+rightHeight+1;
                return Math.max(selfDiameter, Math.max(leftDiameter, rightDiameter));
            }
        }
        static class nodeInfo{
            int height;
            int diameter;
            public nodeInfo(int h, int d){
                height=h;
                diameter=d;
            }
        }
        public static nodeInfo treeDiameter2(Node root){        // Here, no need to call the treeHeight function as we did in treeDiameter1().
            if(root==null){
                return new nodeInfo(0, 0);
            }
            else{
                nodeInfo leftInfo=treeDiameter2(root.left);
                nodeInfo rightInfo=treeDiameter2(root.right);
                int finalDiameter=Math.max(Math.max(leftInfo.diameter, rightInfo.diameter), leftInfo.height+ rightInfo.height+1);
                int finalHeight=Math.max(leftInfo.height, rightInfo.height)+1;
                return new nodeInfo(finalHeight, finalDiameter);
            }
        }
        public static boolean isIdentical(Node root, Node subRoot){
            if(root==null && subRoot==null){
                return true;
            }
            else if(root==null || subRoot==null || root.data!=subRoot.data){
                return false;
            }
            if(!isIdentical(root.left, subRoot.left)){
                return false;
            }
            if(!isIdentical(root.right, subRoot.right)){
                return false;
            }
            return true;
        }
        public static boolean isSubtree(Node root, Node subRoot){           // returns true is subtree exists.
            if(root==null){
                return false;
            }
            if(root.data==subRoot.data){
                if(isIdentical(root, subRoot)){
                    return true;
                }
            }
            boolean left=isSubtree(root.left, subRoot);
            boolean right=isSubtree(root.right, subRoot);
            return left || right;
        }
        static class NodeInfo2{
            Node node;
            int distance;           // horizontal distance.
            public NodeInfo2(Node node, int distance){
                this.node=node;
                this.distance=distance;
            }
        }
        public static void topView(Node root){
            // The concept of level order traversal is used.
            Queue<NodeInfo2> q=new LinkedList<>();
            HashMap<Integer, Node> map=new HashMap<>();         // Node and its horizontal are stored.
            q.add(new NodeInfo2(root, 0));
            q.add(null);
            int min=0, max=0;
            while(!q.isEmpty()){
                NodeInfo2 curr=q.remove();
                if(curr==null){
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }
                else{
                    if(!map.containsKey(curr.distance)){        // First time the distance occurs.
                        map.put(curr.distance, curr.node);
                    }
                    if(curr.node.left!=null){           // To add the left node.
                        q.add(new NodeInfo2(curr.node.left, curr.distance-1));
                        min=Math.min(min, curr.distance-1);
                    }
                    if(curr.node.right!=null){          // To add the right node.
                        q.add(new NodeInfo2(curr.node.right, curr.distance+1));
                        max=Math.max(max, curr.distance+1);
                    }
                }
            }
            //                Now, printing the result.
            while(min<=max){
                System.out.print(map.get(min++).data + " ");      // As the value is the Node.
            }
        }
        public static void getDistance(Queue<NodeInfo2> al, Node root, int distance){
            if(root==null){
                return;
            }
            else{
                getDistance(al, root.left, distance-1);
                getDistance(al, root.right, distance+1);
                al.add(new NodeInfo2(root, distance));
            }
        }
        public static void bottomView(Node root){           // here postOrder traversal approach is used.
            if(root==null){
                return;
            }
            else{
                Queue<NodeInfo2> al=new LinkedList<>();
                HashMap<Integer, Node> hm=new HashMap<>();
                // getting the distances of all the nodes from the origin i.e., the root node and storing in the queue.
                getDistance(al, root, 0);
                int max=0, min=0;
                while(!al.isEmpty()){
                    NodeInfo2 curr=al.remove();
                    if(al.isEmpty()){
                        break;
                    }
                    else{
                        if(!hm.containsKey(curr.distance)){         // if the distance isn't available, then add to hashMap.
                            hm.put(curr.distance, curr.node);
                            min=Math.min(min, curr.distance);
                            max=Math.max(max, curr.distance);
                        }
                    }
                }
//                Printing the bottom view of binary tree.
                while(min<=max){
                    System.out.print(hm.get(min++).data + " ");
                }
            }
        }
        public static void kthLevelValues(Node node, int k, int level){
            if(node==null){
                return;
            }
            else{
                if(level==k){
                    System.out.print(node.data + " ");
                   return;
                }
                else{
                    kthLevelValues(node.left, k, level+1);
                    kthLevelValues(node.right, k, level+1);
                }
            }
        }
        public static boolean getPath(Node root, int n, ArrayList<Integer> pathList){
            if(root==null){
                return false;
            }
            else{
                pathList.add(root.data);
                if(root.data==n){
                    return true;
                }
                else{
                    boolean leftPath=getPath(root.left, n, pathList);
                    boolean rightPath=getPath(root.right, n, pathList);
                    if(leftPath || rightPath){
                        return true;
                    }
                    else{
                        pathList.remove(pathList.size()-1);
                        return false;
                    }
                }
            }
        }
        public static int lowestCommAncestor(Node root, int n1, int n2){
            ArrayList<Integer> path1=new ArrayList<>();
            ArrayList<Integer> path2=new ArrayList<>();
//            Getting the path for both n1 and n2.
            getPath(root, n1, path1);
            getPath(root, n2, path2);
//            Finalising the common ancestor until the elements in the path1 and path2 are equal.
            int commonAncestor=0;
            int x=0;
            for(; x<path1.size() && x<path2.size(); x++){
                if(path1.get(x)!=path2.get(x)){
                    break;
                }
            }
            commonAncestor=path1.get(x-1);
            return commonAncestor;
        }
        public static Node lowestCommAncestor2(Node root, int n1, int n2){
            if(root==null || root.data==n1 || root.data==n2){
                return root;
            }
            else{
                Node left=lowestCommAncestor2(root.left, n1, n2);
                Node right=lowestCommAncestor2(root.right, n1, n2);
//                When both n1 and n2 lie to the right of the root. Therefore, the left will be null.
                if(left==null){
                    return right;
                }
//                When both n1 and n2 lie to the left of the root. Therefore, the right will be null.
                if(right==null){
                    return left;
                }
//                When the n1 lies to the left or right, and n2 lies to the left or right. That means both n1 and n2 are at opposite side of the root.
                return root;
            }
        }
        public static int distance(Node root, int n){
            if(root==null){
                return -1;
            }
            if(root.data==n){
                return 0;
            }
            else{
                int left=distance(root.left, n);
                int right=distance(root.right, n);
                if(left==-1 && right==-1){
                    return -1;
                }
                else if(left==-1){
                    return right+1;
                }
                else{
                    return left+1;
                }
            }
        }
        public static int minDistance(Node root, int n1, int n2){            // Minimum distance between two given nodes of binary tree.
        Node lca=lowestCommAncestor2(root, n1, n2);     // lca - least common ancestor.
        int left=distance(lca, n1);
        int right=distance(lca, n2);
        return left+right;
        }
        public static int maxEle(Node root){
            if(root==null){
                return 0;
            }
            else{
                int leftMax=Math.max(maxEle(root.left), root.data);
                int rightMax=Math.max(maxEle(root.right), root.data);
                return Math.max(leftMax, rightMax);
            }
        }
        public static int kthAncestor(Node root, int n, int k){
            if(root==null){
                return -1;
            }
            else{
                if(root.data==n){
                    return 0;
                }
                else{
                    int left=kthAncestor(root.left, n, k);
                    int right=kthAncestor(root.right, n, k);
                    if(left==-1 && right==-1){
                        return -1;
                    }
                    else{
                        int max=Math.max(left, right);
                        if(max+1==k){
                            System.out.println("The kth level ancestor is: " + root.data);
                        }
                        return max+1;
                    }
                }
            }
        }
        public static int dataSumTree(Node root){
            if(root==null){
                return 0;
            }
            else{
                int data=root.data;
                int leftSum=dataSumTree(root.left);
                int rightSum=dataSumTree(root.right);
                root.data=leftSum+rightSum;
                return data+root.data;
            }
        }
        public static boolean areSameTrees(Node p, Node q) {
            if((p!=null && q==null) || (p==null && q!=null)){
                return false;
            }
            if(q==null && p==null){
                return true;
            }
            else{
                if(p.data!=q.data){
                    return false;
                }
                else{
                    return areSameTrees(p.left, q.left) && areSameTrees(p.right, q.right);
                }
            }
        }

        public void helper(Node root, Stack<Integer> st){
            if(root == null){
                return;
            }
            if(root != null && root.left == null && root.right == null){
                st.push(root.data);
            }
            else{
                helper(root.left, st);
                helper(root.right, st);
            }
        }

        public boolean leafSimilar(Node root1, Node root2) {
            if(root1 == null && root2 == null){
                return true;
            }
            else if(root1 == null || root2 == null){
                return false;
            }
            else{
                Stack<Integer> st1 = new Stack<Integer>();
                Stack<Integer> st2 = new Stack<Integer>();
                helper(root1, st1);
                helper(root2, st2);
                while(!st1.isEmpty() && !st2.isEmpty()){
                    int n1 = -1;
                    int n2 = -2;
                    if(!st1.isEmpty()) {
                        n1 = st1.pop();
                    }
                    if(!st2.isEmpty()) {
                        n2 = st2.pop();
                    }
                    if(n1 != n2){
                        return false;
                    }
                }
                if(st1.isEmpty() && st2.isEmpty()){
                    return true;
                }
                else{
                    return false;
                }
            }
        }

    }


    public static void main(String[] args){
//        Binary Trees.

        Binary_Trees bt=new Binary_Trees();   // Important constructor, to be executed. Because, it creates static binary tree root.

//        Build Tree Preorder.
//        int[] nodes={1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
//        BinaryTree tree=new BinaryTree();
//        Node root=tree.buildTree(nodes);
//        System.out.println("The data of the root of the binary tree is: " + root.data);

//        Printing the binary tree data in th preorder sequence.  (Preorder traversal).
//        tree.preOrder(root);

//        Inorder Traversal.  Here, first left subtree is printed, and the root is in the middle then printing the right subtree.
//        tree.inOrder(root);

//      Postorder Traversal. Here, first left subtree is printed, and then right subtree and finally the data of root node.
//        tree.postOrder(root);

//        Level order. Here, the data of the root are printed as per level irrespective of their root nodes.
//        tree.levelOrder(root);

        //        Printing the elements in the reverse of levelOrder manner.
//        Printing the elements of binary tree level-wise from the bottom.
//        System.out.println("The reverse levelOrder is: ");
//        BinaryTree.levelOrderReverse(root);

//        Height of a binary tree.
//        System.out.println("The height of the binary tree is: " + tree.treeHeight(root));

//        Count of nodes in binary tree.
//        System.out.println("The total no. of nodes in the binary tree is: " + tree.nodeCount(root));

//        Sum of nodes in the binary tree.
//        System.out.println("The sum of all values of nodes in the binary tree is: " + tree.nodeSum(root));

//        Diameter of a binary tree.    Here, diameter means the longest path between two nodes.
    // Approach 1.
//        System.out.println("The diameter of the binary tree is: " + tree.treeDiameter1(root));
    // Approach.
//        BinaryTree.nodeInfo info=tree.treeDiameter2(root);
//        System.out.println("The diameter of the binary tree is: " + info.diameter);

//        Subtree of another tree.
        /*
        Given the roots of two binary trees root and subRoot, return true if there exists a subtree
        of root with the same structure and node values subRoot and false otherwise.
         */
           /*           Tree
                            1
                           / \
                          2   3
                         / \ / \
                        4  5 6  7
            */

//
//            /*         Subtree
//                          2
//                         / \
//                        4   5
//             */
//            Node subRoot=new Node(2);
//            subRoot.left=new Node(4);
//            subRoot.right=new Node(5);
//            BinaryTree tree=new BinaryTree();
//            System.out.println(tree.isSubtree(root, subRoot));

//        Top view of a binary tree.      The concept of HashMap and the horizontal distance is used. Root node's distance is zero.
//        int[] nodes={1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1};
//        BinaryTree tree=new BinaryTree();
//        Node root=tree.buildTree(nodes);
//        tree.topView(root);

//        Bottom view of a binary tree.
//        Node root=new Node(1);
//        root.left=new Node(2);
//        root.right=new Node(3);
//        root.right.right=new Node(10);
//        root.left.right=new Node(4);
//        root.left.right.right=new Node(5);
//        root.left.right.right.right=new Node(6);
//        BinaryTree tree=new BinaryTree();
//        tree.bottomView(root);

//        Printing the values of nodes of the Kth level.;
//        System.out.println("The values of Kth level are: ");
//        tree.kthLevelValues(root, 3, 1);

//        Lowest common ancestor.
        /*
        Step 1: Calculate the path from root to the given node and store in the path1 array and for second value in path2 array.
        Step 2: Traverse path1 and path2 for common ancestor, traverse until the values are common.
         */
//        System.out.println("The lowest common ancestor of n1 and n2 is: " + tree.lowestCommAncestor(root, 4, 7));

//        Lowest common ancestor, approach 2.
//        System.out.println("The lowest common ancestor of n1 and n2 is: " + tree.lowestCommAncestor2(root, 4, 6).data);

//        Minimum distance between two nodes. Here, the logic of the least common ancestor is used.
//        System.out.println("The minimum distance between the nodes is: " + tree.minDistance(root, 4, 6));

//         Maximum element in the binary tree.
//        System.out.println("The maximum element in the binary tree is: " + BinaryTree.maxEle(root));

//        Kth Ancestor of node.
//        tree.kthAncestor(root, 5, 2);

//        Transform to Sum Tree. Concept - The values of the node will be the sum of their right and left subtree's data value and root.data+right.data+left.data is passes for upper cases for recursion.
//        tree.dataSumTree(root);
//        tree.levelOrder(root);      // Printing the new binary tree(sum tree) for conformation.

//        checking whether the two given trees p and q are identical or not.
//        System.out.println(BinaryTree.areSameTrees(Binary_Trees.root, Binary_Trees.root));

        // checking whether the leaf nodes of the two trees are similar in the sequence from left to right.
        Node root1 = new Node(1);
        Node root2 = new Node(1);
        root1.left = new Node(2);
        root2.left = new Node(2);
        root1.right = new Node(20);
        root2.right = new Node(20);
        System.out.println(tree.leafSimilar(root1, root2));







    }
}
