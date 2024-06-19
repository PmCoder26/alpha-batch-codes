package codes;
import codes.Divide_and_Conquer.*;

import java.math.BigInteger;
import java.sql.Array;
import java.util.*;

public class Backtracking extends Divide_and_Conquer{
    public static void subsetStrg(String s, String sub, int idx){
        if(idx==s.length()){
            System.out.print(sub+" ");
            return;
        }
//        choice 1: character allowed.
        subsetStrg(s, sub+s.charAt(idx), idx+1);
//        choice 2: character not allowed.
        subsetStrg(s, sub, idx+1);
    }
    public static void chargeArr(int[] arr, int idx, int val){
        if(idx>=arr.length){
            return;
        }
        arr[idx]=val;
        chargeArr(arr, idx+1, val+1);
        arr[idx]-=2;
    }
    public static void strPermutations(String s,  String ans){
        if(s.length()==0){
            System.out.print(ans+" ");
            return;
        }
        for(int x=0; x<s.length(); x++){
            char current=s.charAt(x);
//            "abc" => "b" + "c";
            String newStr=s.substring(0, x)+s.substring(x+1);
            strPermutations(newStr, ans+current);
        }
    }
//    Chess game methods.
    public static char[][] board=new char[5][5];
    public static void printBoard(char[][] board){
    for(int x=0; x<board.length; x++){
        for(int y=0; y<board.length; y++){
            System.out.print(board[x][y]+" ");
        }
        System.out.println();
    }
    System.out.println("--------------------------------");
}
    public static void nQueensBasics(int row){
        if(row==board.length){
            printBoard(board);
            return;
        }
        for(int x=0; x<board.length; x++){
            board[row][x]='Q';
            nQueensBasics(row+1);
            board[row][x]='x';
        }
    }
    public static boolean isSafeQueen(int row, int column){
        //        1. Vertically upward.
        for(int x=row-1; x>=0; x--){
            if(board[x][column]=='Q'){
                return false;
            }
        }
        //       2. Diagonally upward left.
        for(int x=row-1, y=column-1; x>=0 && y>=0; x--, y--){
            if(board[x][y]=='Q'){
                return false;
            }
        }
        //       3. Diagonally upward right .
        for(int x=row-1, y=column+1; x>=0 && y<board.length; x--, y++){
            if(board[x][y]=='Q'){
                return false;
            }
        }
        return true;
    }
    public static void nQueensActual(int row){
        if(row==board.length){
            printBoard(board);
            return;
        }
            for(int x=0; x<board.length; x++){
                if(isSafeQueen(row, x)){
                board[row][x]='Q';
                nQueensActual(row+1);
                board[row][x]='x';
            }
        }
    }
    public static boolean nQueensActualOnce(int row){
        if(row==board.length){
            printBoard(board);
            return true;
        }
        for(int x=0; x<board.length; x++){
            if(isSafeQueen(row, x)){
                board[row][x]='Q';
                if(nQueensActualOnce(row+1)){
                    return true;
                }
                board[row][x]='x';
            }
        }
        return false;
    }
    public static void nElephants(int row){
        if(row==board.length){
            printBoard(board);
            return;
        }
        else{
            for(int x=0; x<board.length; x++){
                if(isSafeElephant(row, x)){
                    board[row][x]='E';
                    nElephants(row+1);
                    board[row][x]='x';
                }
            }
        }
    }
    public static int count=0;
    public static void nElephantsCountWays(int row){
        if(row==board.length){
            count++;
            return;
        }
        else{
            int count=0;
            for(int x=0; x<board.length; x++){
                if(isSafeElephant(row, x)){
                    board[row][x]='E';
                    nElephantsCountWays(row+1);
                    board[row][x]='x';
                }
            }
        }
    }
    public static boolean isSafeElephant(int row, int column){
//       1. Checking vertically upward.
        for(int x=row-1; x>=0; x--){
            if(board[x][column]=='E'){
                return false;
            }
        }
//        2. Checking horizontally left.
        for(int x=column-1; x>=0; x--){
            if(board[row][x]=='E'){
                return false;
            }
        }
        return true;
    }
    public static boolean isSafeCamel(int row, int column){
        // checking whether the camel is safe or not at this position.

        // 1. up-left diagonally.
        for(int x=row-1, y=column-1; x>=0 && y>=0; x--, y--){
            if(board[x][y]=='C'){
                return false;
            }
        }
        // 2. up-right diagonally.
        for(int x=row-1, y=column+1; x>=0 && y<board.length; x--, y++){
            if(board[x][y]=='C'){
                return false;
            }
        }
        // The position is suitable for the camel as all cases has been checked. Hence, camel is safe.
        return true;
    }
    public static void nCamels(char[][] board, int row){
        if(row>= board.length){
            printBoard(board);
            return;
        }
        else{
            for(int x=0; x<board.length; x++){
                if(isSafeCamel(row, x)){
                    board[row][x]='C';
                    nCamels(board, row+1);      // recursively working.
                    board[row][x]='X';      // backtracking.
                }
            }
        }
    }
//    public static boolean isSafeKnight(int row, int column){
//        // checking whether the knight is safe to place at (x, y) = (row, column).
//        // 1. up-left.
//
//    }
//    public static void nKnights(int row){
//        if(row>=board.length){
//            printBoard(board);
//            return;
//        }
//        else{
//            for(int x=0; x<board.length; x++){
//                if(isSafeKnight(row, x)){
//                    board[row][x]='K';
//                    nKnights(row+1);
//                    board[row][x]='X';
//                }
//            }
//        }
//    }

//    End of chess game methods.
    public static int gridWays(int[][] arr, int i, int j){
        if(i>=arr.length-1 || j>=arr.length-1){
            return 1;
        }
        else{
            int right=gridWays(arr, i, j+1);
            int down=gridWays(arr, i+1, j);
            return right+down;
        }
    }
    public static boolean isDigitSafe(int[][] sudoku, int digit, int row, int column){
//    checking in column.
        for(int r=0; r<9; r++){
            if(sudoku[r][column]==digit){
                return false;
            }
        }
//        checking in row.
        for(int c=0; c<9; c++){
            if(sudoku[row][c]==digit){
                return false;
            }
        }

//        checking in the gird.
        int startRowIdx=(row/3)*3;
        int startColumnIdx=(column/3)*3;
        for(int r=startRowIdx; r<startRowIdx+3; r++){
            for(int c=startColumnIdx; c<startColumnIdx+3; c++){
                if(sudoku[r][c]==digit){
                    return false;
                }
            }
        }
        //  digit is present neither in row nor column.
        return true;
    }
    public static boolean sudokuSolver(int[][] sudoku, int row, int column){
//        base case.
        if(row==9 && column==0){
            return true;
        }
        int nextRow=row;
        int nextColumn=column+1;
//        switching the row at the end of column
        if(column+1==9){
            nextRow=row+1;
            nextColumn=0;
        }
//        if any digit is already present then moving to the next column.
        if(sudoku[row][column]!=0){
            return sudokuSolver(sudoku, nextRow, nextColumn);
        }
//        placing the digits along the row.
        for(int digit=1; digit<=9; digit++){
            if(isDigitSafe(sudoku, digit, row, column)){
                sudoku[row][column]=digit;
                if(sudokuSolver(sudoku, nextRow, nextColumn)){
                    return true;
                }
                sudoku[row][column]=0;
            }
        }
        return false;
    }
    public static void printSudoku(int[][] sudoku){
        for(int row=0; row<9; row++){
            for(int column=0; column<9; column++){
                System.out.print(sudoku[row][column]+" ");
            }
            System.out.println();
        }
    }
    public static boolean isSafe(char[][] board, int row, int col){
        // up.
        for(int x=row-1; x>=0; x--){
            if(board[x][col]=='Q'){
                return false;
            }
        }
        // left diagonal.
        for(int x=row-1, y=col-1; x>=0 && y>=0; x--, y--){
            if(board[x][y]=='Q'){
                return false;
            }
        }
        // right diagonal.
        for(int x=row-1, y=col+1; x>=0 && y<board.length; x--, y++){
            if(board[x][y]=='Q'){
                return false;
            }
        }
        return true;
    }

    public static ArrayList<Integer> al=new ArrayList<>();
    public static void helper(char[][] board, int row){
        if(row==board.length){
            al.add(1);
            return;
        }
        for(int x=0; x<board.length; x++){
            if(isSafe(board, row, x)){
                board[row][x]='Q';
                helper(board, row+1);
                board[row][x]='x';
            }
        }
    }
    public static int totalNQueens(int n) {
        if(n==0){
            return 0;
        }
        else{
            char[][] board=new char[n][n];
            for(int x=0; x<n; x++){
                for(int y=0; y<n; y++){
                    board[x][y]='x';
                }
            }
            helper(board, n);
            return al.size();
        }
    }

    public Backtracking(){
        for(int x=0; x<board.length; x++) {
            for (int y = 0; y < board.length; y++) {
                this.board[x][y] = 'X';
            }
        }
    }       // constructor.
    public static void main(String[] args){
        new Backtracking();       // constructor to initialize the board of chess.

//            Backtracking.

//        Backtracking arrays.
//        int[] arr=new int[5];
//        chargeArr(arr, 0, 1);
//        printArr(arr);

//          Finding subsets of string.
//        String s="abc";
//        subsetStrg(s, "", 0);

//        Find and print permutations of string.
//        String s="abc";
//        strPermutations(s, "");

//        N-Queens question.
//        nQueensBasics(0);
//        actual question.
//        nQueensActual(0);

//        printing only on solution board.
//        nQueensActualOnce(0);


//                N-Elephants question.
////        question.
//        nElephants(0);

//        counting the number of ways for N-Elephants.
//        nElephantsCountWays(0);
//        System.out.println("The no.of ways for n-Elephants is : "+count);

////        Possible number of solutions to put n Camels on the chess board.
//        nCamels(board, 0);

//        Finding and printing the possible no.of solutions to put n Knights (Horses) on the chess board.
//        nKnights(0);


//        Grid ways.
//        find the total number of ways to reach from (0,0) to (N-1,M-1) in MxN Grid.
//        Allowed moves-right and down.
//        int[][] arr=new int[10][10];
//        System.out.println("The  no. of ways to reach is : "+gridWays(arr, 0, 0));

//        Sudoku Solver.
//            int[][] sudoku={{7,0,0,0,0,1,0,0,0},
//                    {4,0,8,7,3,0,2,0,0},
//                    {0,0,6,8,5,0,0,3,9},
//                    {0,1,0,0,0,5,3,4,7},
//                    {0,0,0,2,0,3,0,0,0},
//                    {5,8,3,4,0,0,0,6,0},
//                    {2,5,0,0,4,9,8,0,0},
//                    {0,0,4,0,6,2,9,0,3},
//                    {0,0,0,1,0,0,0,0,5}};
//            if(sudokuSolver(sudoku, 0, 0)){
//                System.out.println("There exists a solution which is :");
//                printSudoku(sudoku);
//            }
//            else{
//                System.out.println("There exists no solution.");
//            }


        System.out.println(totalNQueens(4));










    }
}
