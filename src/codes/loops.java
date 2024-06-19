package codes;
import java.util.*;

public class loops {
    public static Scanner sc=new Scanner(System.in);

    public static void main(String[] args){
//        loops

//        while loop.

//        int x=0;
//        while(x<10){
//            System.out.println(x++);
//        }

//        printing 1 to 10 numbers.
//        int x=1;
//        while(x<=10){
//            System.out.print(x+" ");
//            x++;
//        }

//        printing numbers from 1 to n.
//        System.out.print("Enter the limit : ");
//        int limit=sc.nextInt();
//        int n=1;
//        while(n<=limit){
//            System.out.print((n++)+" ");
//        }

//        printing sum of n natural numbers.
//        System.out.print("Enter the limit : ");
//        int limit=sc.nextInt();
//        int i=1;
//        int sum=0;
//        while(i<=limit){
//            sum+=i++;
//        }
//        System.out.println("The sum is : "+sum);

//        for loop.

//        for(int x=1; x<=10; x++){
//            System.out.print(2*x+" ");
//        }

//        printing square pattern.
//        System.out.print("Enter the n: ");
//        int n=sc.nextInt();
//        for(int x=1; x<=n; x++){
//            for(int y=1; y<=n; y++){
//                System.out.print("* ");
//            }
//            System.out.println();
//        }

//        reversing a number.
//        System.out.print("Enter a number : ");
//        int n=sc.nextInt();
//        int n1=0;
//        while(n>0){
//            int rem=n%10;
//            n1=n1*10+rem;
//            n/=10;
//        }
//        System.out.println("The reversed number is : "+n1);

//        do-while loop.
//        int a=1;
//        do {
//            System.out.print(a+" ");
//            a++;
//        }while(a<=10);

//        break statement.
//        int n=1;
//        while(n<=10){
//            if(n==6){
//                System.out.println();
//                System.out.println("Out of the loop");
//                break;
//            }
//            else{
//                System.out.print((n++)+" ");
//            }
//        }

//        printing the numbers entered by user till he enters a number which is non-multiple of 10.
//        while(true){
//            System.out.print("Enter a number : ");
//            int n=sc.nextInt();
//            if(n%10==0){
//                System.out.println("Out of the loop");
//                break;
//            }
//            else{
//                System.out.println(n+" ");
//            }
//        }

//        continue keyword.
//        for(int i=1; i<=10; i++){
//            if(i==5){
//                continue;
//            }
//            System.out.print(i+" ");
//        }

//        checking whether a number is prime or not?
//        System.out.print("Enter a number : ");
//        int n=sc.nextInt();
//        boolean flag=true;
//        for(int x=2; x<Math.sqrt(n); x++){
//            flag=false;
//            if(n%x==0){
//                System.out.println("The number is not prime!");
//                break;
//            }
//            else{
//                flag=true;
//            }
//        }
//        if(flag==true){
//            System.out.println("The number is prime!");
//        }

//      Practice Questions.

//        Q.1.
//        for(int i=0; i<5; i++){
//            System.out.println("Hello");
//            i+=2;
//        }

//        Q.2.
//        int evenSum=0;
//        int oddSum=0;
//        int flag=1;
//        while(flag==1){
//            System.out.print("Enter a number : ");
//            int number=sc.nextInt();
//            if(number%2==0){
//                evenSum+=number;
//            }
//            else{
//                oddSum+=number;
//            }
//            System.out.print("Do you want to continue? [Yes-1, No-2]\nYour Response : ");
//            flag=sc.nextInt();
//        }
//        System.out.println("The sum of even numbers is : "+evenSum);
//        System.out.println("The sum of odd numbers is : "+oddSum);

//        Q.3.
//        System.out.print("Enter a number : ");
//        int n=sc.nextInt();
//        int fact=1;
//        for(int x=n; x>0; x--){
//            fact=fact*x;
//        }
//        System.out.println("The factorial of the entered number is : "+fact);

//        Q.4.
//        System.out.print("Enter the number : ");
//        int num=sc.nextInt();
//        System.out.println("The multiplication table of the entered number is: ");
//        for(int x=1; x<=10; x++){
//            System.out.println(num*x);
//        }

//        Q.5.
//        for(int i=0; i<=5; i++){
//            System.out.println("i = "+i);
//        }
//        System.out.println("i after the loop = "+i);  // error

//      Nested loops.

//        Printing star pattern.

//        for(int x=0; x<4; x++){
//            for(int y=0; y<x+1; y++){
//                System.out.print("*");
//            }
//            System.out.println();
//        }

//        Printing inverted start pattern.
//        System.out.print("Enter the value of n : ");
//        int n=sc.nextInt();
//        for(int x=0; x<n; x++){
//            for(int y=n-x; y>=1; y--){
//                System.out.print("*");
//            }
//            System.out.println();
//        }

//        printing half pyramid pattern.
//        System.out.print("Enter the number of lines : ");
//        int lines=sc.nextInt();
//        for(int x=1; x<=lines; x++){
//            for(int y=1; y<=x; y++){
//                System.out.print(y);
//            }
//            System.out.println();
//        }

//        Printing character pattern.
//        int a=0;
//        for(int x=0; x<4; x++){
//            for(int y=0; y<=x; y++){
//                System.out.print((char)(65+a));
//                a++;
//            }
//            System.out.println();
//        }

//        practice questions based on printing pattern.

//        Q.1.
//        int m=4;
//        for(int x=1; x<=m; x++){
//            for(int y=1; y<=m+1; y++){
//                if(y==1 || y==m+1 || x==1 || x==m){
//                    System.out.print("*");
//                }
//                else{
//                    System.out.print(" ");
//                }
//            }
//            System.out.println();
//        }

//        Q.2.
//        int a=4;
//        for(int x=1; x<=a; x++){
//            for(int y=1; y<=a; y++){
//                if(y<=a-x){
//                    System.out.print(" ");
//                }
//                else{
//                    System.out.print("*");
//                }
//            }
//            System.out.println();
//        }

//        Q.3.
//        int n=5;
//        for(int x=1; x<=n; x++){
//            for(int y=1; y<=n-x+1; y++){
//                System.out.print(y);
//            }
//            System.out.println();
//        }

//        Q.4.
//        int i=5;
//        int num=1;
//        for(int x=1; x<=i; x++){
//            for(int y=1; y<=x; y++){
//                System.out.print((num++)+" ");
//            }
//            System.out.println();
//        }

//        Q.5.
//        int i=1;
//        int line=5;
//        for(int x=1; x<=line; x++){
//            int j=i;
//            for(int y=1; y<=x; y++){
//                if(j==1){
//                    System.out.print(j);
//                    j=0;
//                }
//                else{
//                    System.out.print(j);
//                    j=1;
//                }
//            }
//            if(i==1){
//                i=0;
//            }
//            else{
//                i=1;
//            }
//            System.out.println();
//        }

//         Q.6.
//        System.out.print("Enter the number of lines : ");
//        int n=sc.nextInt();
//        for(int x=1; x<=n; x++){
//            for(int y=n-x; y>0; y--){
//                System.out.print(" ");
//            }
//            for(int z=1; z<=n; z++){
//                System.out.print("*");
//            }
//            System.out.println();
//        }

//        Q.7.
//        System.out.print("Enter the number of lines : ");
//        int n=sc.nextInt();
//        for(int x=1; x<=n; x++){
//            for(int y=n-x; y>0; y--){
//                System.out.print(" ");
//            }
//            for(int z=1; z<=n; z++){
//                if(x==1 || x==n || z==1 || z==n) {
//                    System.out.print("*");
//                }
//                else{
//                    System.out.print(" ");
//                }
//            }
//            System.out.println();
//        }

//        Q.8.
//        System.out.print("Enter the number of lines : ");
//        int lines=sc.nextInt();
////        first half.
//        for(int x=1; x<=lines; x++){
//            for(int y=x; y<lines; y++){
//                System.out.print(" ");
//            }
//            for(int z=1; z<=2*x-1; z++){
//                System.out.print("*");
//            }
//            System.out.println();
//        }
////        second half.
//        for(int x=lines; x>=1; x--){
//            for(int y=1; y<lines-x+1; y++){
//                System.out.print(" ");
//            }
//            for(int z=2*x-1; z>=1; z--){
//                System.out.print("*");
//            }
//            System.out.println();
//        }

//        Q.10.
//        for(int i=1; i<=5; i++){
//            int x=i;
//            for(int y=i; y<5; y++){
//                System.out.print(" ");
//            }
//            for(int a=i;a>=1; a--){
//                System.out.print(a);
//            }
//            for(int b=2; b<=i; b++){
//                System.out.print(b);
//            }
//            System.out.println();
//        }

//        Floyd's triangle pattern.
//        System.out.print("Enter the number of lines : ");
//        int lines=sc.nextInt();
//        int var=1;
//        for(int x=1; x<=lines; x++){
//            for(int y=1; y<=x; y++){
//                System.out.print((var++)+" ");
//            }
//            System.out.println();
//        }

//          Butterfly pattern.
//        int n=4;
////        first half pattern.
//        for(int x=1; x<=n; x++){
//            for(int y=1; y<=2*n; y++){
//                if( x==n || y<=x || y>2*n-x){
//                    System.out.print("*");
//                }
//                else{
//                    System.out.print(" ");
//                }
//            }
//            System.out.println();
//        }
////        second half pattern.
//        int n1=n;
//        for(int x=1; x<=n; x++){
//            for(int y=1; y<=2*n; y++){
//                if( x==1 || y<=n1 || y>2*n-n1){
//                    System.out.print("*");
//                }
//                else{
//                    System.out.print(" ");
//                }
//            }
//            System.out.println();
//            n1--;
//        }



    }
}
