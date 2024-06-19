package codes;
import java.util.*;

public class K_D_Tree {

    // 2-D Tree.

    private static class Info{
        int first;      // first space data, comparing the X-direction.
        int second;     // second space data, comparing the Y-direction.
        public Info(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    private static class Node{
        Info data;
        Node left, right;
        int level;
        public Node(Info data, int level){
            this.data = data;
            left = null;
            right = null;
            this.level = level;
        }
    }

    private static Node root = null;

    private static Node insert(Node root, Info data){
        if(root == null){
            return new Node(data, 1);
        }
        else{
            // if the level is odd.
            if(root.level % 2 != 0){
                // comparing the X-component.
                if(data.first < root.data.first){
                    root.left = insert(root.left, data);
                }
                else{
                    root.right = insert(root.right, data);
                }
            }
            // if the level is even.
            else{
                // comparing the Y-component.
                if(data.second < root.data.second){
                    root.left = insert(root.left, data);
                }
                else{
                    root.right = insert(root.right, data);
                }
            }
            return root;
        }
    }
    private static void printTree(){
        if(root == null){
            System.out.println("The K-D tree is empty!");
            return;
        }
        else{
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node curr = q.remove();
                if(curr == null){
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        System.out.println();
                        q.add(null);
                    }
                }
                else{
                    System.out.print("(" + curr.data.first + "," + curr.data.second + ")  ");
                    if(curr.left != null){
                        q.add(curr.left);
                    }
                    if(curr.right != null){
                        q.add(curr.right);
                    }
                }
            }
        }
    }

    public static void main(String[] args){

        root = insert(root, new Info(34, 76));
        root = insert(root, new Info(16, 99));
        root = insert(root, new Info(99, 7));
        root = insert(root, new Info(3, 700));
        root = insert(root, new Info(340, 6));
        root = insert(root, new Info(34, 76));
        printTree();

    }
}
