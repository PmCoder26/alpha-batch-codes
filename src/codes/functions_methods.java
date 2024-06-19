package codes;
import java.util.*;

public class functions_methods {
    public static Scanner sc=new Scanner(System.in);

    public static void printHelloWorld(){
        System.out.println("Hello World");
    }

    public static int add(int a, int b){  // parameters defined.
        return a+b;
    }

    public static void swap(int a, int b){
        int temp=a;
        a=b;
        b=temp;
        System.out.println("Swapped value of a :"+a);
        System.out.println("Swapped value of b : "+b);
    }

    public static int product(int a, int b){
        return a*b;
    }

    public static int fact(int n){
       int factorial=1;
       for(int x=n; x>0; x--){
           factorial*=x;
       }
       return factorial;
    }

    public static int binoCoeff(int n, int r){
        return fact(n)/(fact(r)*(fact(n-r)));
    }

    public static int sum(int a, int b, int c){
        return a+b+c;
    }
    public static int sum(int a, int b){
        return a+b;
    }

    public static boolean primeNum(int n){
        if(n==1){
            return false;
        }
        else if(n==2){
            return true;
        }
        else {
            for (int x = 2; x <= Math.sqrt(n); x++) {
                if (n % x == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void binaryToDecimal(int bnum){
        if(bnum<0){
            System.out.println("Invalid binary number!");
        }
        else{
            int decimal=0;
            int mult=1;
            while(bnum>0){
                int rem=bnum%10;
                decimal+=rem*mult;
                mult*=2;
                bnum/=10;
            }
            System.out.println(decimal);
        }
    }

    public static void primeRange(int lower, int upper){
        if(lower<=1){
            System.out.println("Invalid range");
        }
        else{
            for(int x=2; x<=upper; x++){
                if(primeNum(x)==true){
                    System.out.print(x+" ");
                }
            }
            System.out.println();
        }
    }

    public static void decimalToBinary(int dnum){
        if(dnum<0){
            System.out.println("Invalid number.");
        }
        else{
            int binary=0;
            int mult=1;
            while(dnum>0){
                int temp=dnum%2;
                binary+=temp*mult;
                dnum/=2;
                mult*=10;
            }
            System.out.println(binary);
        }
    }

    public static double avgNum(int a, int b, int c){
        return (a+b+c)/3;
    }

    public static boolean isEven(int n){
        if(n%2==0){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean isPalindrome(int n){
        String ns=Integer.toString(n);
        for(int x=0; x<ns.length(); x++){
            if(ns.charAt(x)!=ns.charAt(ns.length()-1-x)){
                return false;
            }
        }
        return true;
    }

    public static int digitNum(int n){
        int dns=0;
        while(n>0){
            int temp=n%10;
            dns+=temp;
            n/=10;
        }
        return dns;
    }
    public static void main(String[] ags){

//        functions.
//        printing hello world by function.
//        printHelloWorld();

//        functions with parameters.
//        System.out.print("Enter num1 : ");
//        int a=sc.nextInt();
//        System.out.print("Enter num2 : ");
//        int b=sc.nextInt();
//        System.out.println("Sum="+add(a, b));   // arguments passed.

//         swapping two numbers.
//        System.out.print("Enter value of a : ");
//        int a=sc.nextInt();
//        System.out.print("Enter value of b : ");
//        int b=sc.nextInt();
//        swap(a, b);

//        finding product of two numbers.

//        System.out.print("Enter a : ");
//        int a=sc.nextInt();
//        System.out.print("Enter b : ");
//        int b=sc.nextInt();
//        System.out.println("Product="+product(a,b));

//        factorial of number by function
//        System.out.print("Enter the number : ");
//        int n=sc.nextInt();
//        System.out.print("Factorial of the entered number is : "+fact(n));

//        finding binomial coefficient.
//        System.out.print("Enter the value of n : ");
//        int n=sc.nextInt();
//        System.out.print("Enter the value of r : ");
//        int r=sc.nextInt();
//        System.out.println("The binomial coefficient is : "+binoCoeff(n, r));

//          function overloading.
//        System.out.print("Enter value of a : ");
//        int a=sc.nextInt();
//        System.out.print("Enter value of b : ");
//        int b=sc.nextInt();
//        System.out.print("Enter value of c : ");
//        int c=sc.nextInt();
//        System.out.println("The sum of two numbers is : "+sum(a,b));
//        System.out.println("The sum of three numbers is "+sum(a,b,c));

//        checking whether number is prime or not.
//        System.out.print("Enter the number : ");
//        int num=sc.nextInt();
//        System.out.println(primeNum(num));

//        finding prime numbers from given range.
//        System.out.print("Enter the lower limit : ");
//        int lower=sc.nextInt();
//        System.out.print("Enter the upper limit : ");
//        int upper=sc.nextInt();
//        primeRange(lower, upper);

//        converting binary to decimal number.
//        System.out.print("Enter the binary number : ");
//        int bn=sc.nextInt();
//        binaryToDecimal(bn);

//        decimal to binary conversion.
//        System.out.print("Enter the decimal number : ");
//        int dn=sc.nextInt();
//        decimalToBinary(dn);

//     practice questions.

//        Q.1.
//        System.out.print("Enter num1 : ");
//        int n1=sc.nextInt();
//        System.out.print("Enter num2 : ");
//        int n2=sc.nextInt();
//        System.out.print("Enter num3 : ");
//        int n3=sc.nextInt();
//        System.out.println(avgNum(n1,n2,n3));

//        Q.2.
//        System.out.print("Enter the number : ");
//        int n=sc.nextInt();
//        System.out.println(isEven(n));

//        Q.3.
//        System.out.print("Enter the number : ");
//        int n=sc.nextInt();
//        System.out.println(isPalindrome(n));

//        Q.5.
//        System.out.print("Enter the three digit number : ");
//        int tn=sc.nextInt();
//        System.out.println(digitNum(tn));










    }
}
