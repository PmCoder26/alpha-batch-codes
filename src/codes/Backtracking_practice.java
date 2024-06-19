package codes;
import java.util.*;

public class Backtracking_practice {
    public static Scanner sc=new Scanner(System.in);

    //    Que.1.
    public static void printSolution(int[][] solution){
        for(int x=0; x<solution.length; x++){
            for(int y=0; y<solution.length; y++){
                System.out.print(solution[x][y] + " ");
            }
            System.out.println("");
        }
    }
    public static boolean isSafe(int[][] maze, int x, int y){
        if(x>=0 && y>=0 && x<maze.length && y<maze.length && maze[x][y]==1){        // if the rat is within the border and the coordinate is 1.
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean mazeUtil(int[][] maze, int x, int y, int[][] solution){
        if(x==maze.length-1 && y==maze.length-1 && maze[x][y]==1){      // if the rat reached the destination
            solution[x][y]=1;
            return true;
        }
        // checking whether maze[x][y] is valid or not if the rat is in the maze.
        if(isSafe(maze, x, y)){
            // if the solution[x][y] is already true, that means that coordinate is
            // already visited and hence to avoid stack overflow returning false.
            if(solution[x][y]==1){
                return false;
            }
            solution[x][y]=1;
            // now checking for the right.
            if(mazeUtil(maze, x, y+1, solution)==true){
                return true;
            }
            // now checking for the down.
            if(mazeUtil(maze, x+1, y, solution)==true){
                return true;
            }
            // backtracking and tracking another possible path.
            solution[x][y]=0;
            return false;
        }
        return false;
    }
    public static boolean ratInMaze(int[][] maze, int x, int y){
        int n=maze.length;
        int[][] solution=new int[n][n];
        if(mazeUtil(maze, x, y, solution)==false){
            System.out.println("The solution doesn't exists!");
            return false;
        }
        else{
            printSolution(solution);
            return true;
        }
    }

//    Que.2.
// Creating an array of characters to store the characters associated with the number.
public static char[][] chr={{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m','n', 'o'},
        {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
    public static void keypadNums(String num){
       int length=num.length();
       if(length==0){
           System.out.println("");
           return;
       }
       else{
           bfs(0, length, new StringBuilder(), num);
       }
    }
    public static void bfs(int position, int length, StringBuilder sb, String num){
        if(length==position){
            System.out.print(sb.toString() + " ");
        }
        else{
            char[] letters=chr[Character.getNumericValue(num.charAt(position))];   // storing part of array of chr[][] in letters[] of the position number.
            for(int x=0; x<letters.length; x++){    // iterated for all combinations of the word possible.
                // appending the current character in stringBuilder and calling method for next position element of num.
                bfs(position+1, length, new StringBuilder(sb).append(letters[x]), num);
            }
            System.out.println();
        }
    }

//    Que.3.
    public static void knightTour(int N){

    }



    public static void main(String[] args){

//        Practice of Backtracking.


//        Que. 1.
        /*
                                                    Rat in a Maze
            You are given a starting position for a rat which is stuck in a maze at an initial point (0, 0)
            (the maze can be thought of as a 2-dimensional plane). The maze would be given in the form of a
            square matrix of order N * N where the cells with value 0 represent the maze’s blocked locations
            while value 1 is the open/available path that the rat can take to reach its destination. The rat's
            destination is at (N - 1, N - 1).
            Your task is to find all the possible paths that the rat can take to reach from source to destination in the maze.
            The possible directions that it can take to move in the maze are 'U'(up) i.e. (x, y - 1) , 'D'(down)
            i.e. (x, y + 1) , 'L' (left) i.e. (x - 1, y), 'R' (right) i.e. (x + 1, y).
         */
//        int[][] maze={{1, 0, 0, 0},
//                      {1, 1, 0, 1},
//                      {0, 1, 0, 0},
//                      {1, 1, 1, 1}};
//        System.out.println(ratInMaze(maze, 0, 0));

//        Que. 2.
        /*
                                                Keypad Combinations
            Given a string containing digits from 2-9 inclusive, print all possible letter combinations that
            the number could represent. You can print the answer in any order.
            A mapping of digits to letters (just like on the telephone buttons) is given below.
            Note that 1 does not map to any letters.
         */
//        String num="234";
//        keypadNums(num);

//        Que. 3.
        /*
                                            Knight’s Tour
            Given a N*N board with the Knight placed on the first block of an empty board.
            Moving according to the rules of chess, knights must visit each square exactly once.
            Print the order of each cell in which they are visited.
         */
        System.out.print("Enter the N: ");
        int N=sc.nextInt();
        knightTour(N);




    }




}
