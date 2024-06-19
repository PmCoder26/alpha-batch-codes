package codes;
import java.util.*;

public class Bit_Manipulation {
    public static Scanner sc=new Scanner(System.in);
    public static void isEven_Odd(int n){
        int numBit=(n & 1);
        if(numBit==1){
            System.out.println(n+" is odd");
        }
        else {
            System.out.println(n+" is even");
        }
    }

    public static int getIthBit(int dn, int position){
        int ithBit=0;
        if(((dn>>position)&1)==1){
            ithBit=1;
        }
        return ithBit;
    }

    public static int setIthBit(int bn, int i){
        int ithBit=((bn>>i)&1);
        if(ithBit==1){
            ithBit=0;
        }
        else{
            ithBit=1;
        }
        int newBitNum=(ithBit<<i);
        return (bn | newBitNum);
    }

    public static int clearIthBit(int n, int i){
        int bit=(1<<i);
        int newBit=~(bit);
        return n & newBit;
    }

    public static int updateIthBit(int n, int i, int newBit){
//        if(newBit==0){
//            return clearIthBit(n, i);
//        }
//        else{
//            return setIthBit(n, i);
//        }

//        Alternate approach.
        n=clearIthBit(n, i);
        int bitMask=newBit<<i;
        return n | bitMask;
    }

    public static int clearLastIBit(int n, int i){
        int x=n>>i;
        int y=x<<i;
        return y;
    }

    public static int clearRangeOfBits(int n, int lower, int upper){
        int newBit=n;
        for(int x=lower; x<=upper; x++){
            newBit=clearIthBit(newBit, x);
        }
        return newBit;
    }

    public static void main(String[] args){
                                    //        Bit Manipulation.

//     Bit-wise Operators.

//        1. Binary AND(&).
//        System.out.println(5&6);

//        2. Binary OR(|).
//        System.out.println(1|0);

//        3. Binary XOR(^).  When two bits are different then result is 1, else 0.
//        System.out.println(1^1);
//        System.out.println(1^0);
//        System.out.println(0^1);
//        System.out.println(0^0);

//        4. Binary One's Complement(~). it reverses the binary digit i.e 0->1 and 1->0.
//        System.out.println(~1);
//            Steps to find ~n.
        /* 1. if most significant bit is 0 then the number is positive n.
           2. then eg. (5) in decimal->00000101.
           3. 00000101->11111010 number reverses.
           4. 11111010->00000101 taking complement.
           5. adding 1 in 00000101.
           6. answer= 00000110.
        */

//        Binary left shift(<<).
//        System.out.println(5<<2);  // 5 in binary, 0000101->0010100. that is binary number shifted to left by 2 places.

//        Binary right shift(>>).
//        System.out.println(5>>2);    // 5 in binary, 0000101->00001. that is binary number shifted to right by 2 places and the rest are removed that is (101) became (1).

//        check whether the number is even or odd.
//        Note - the least significant bit that is last bit of the binary number of a decimal number should be 0 to have the number even, else the number is odd.
//        System.out.println("Enter the number : ");
//        int n=sc.nextInt();
//        isEven_Odd(n);

//        getting ith bit. note - bit number position starts from 0.
//        System.out.print("Enter the decimal number : ");
//        int dNum=sc.nextInt();
//        System.out.print("Enter the value of i : ");
//        int i=sc.nextInt();
//        System.out.println("The ith position of binary form of "+dNum+" is : "+getIthBit(dNum, i));

//        setting ith bit.
//        System.out.println("Enter the decimal number : ");
//        int bNum=sc.nextInt();
//        System.out.println("Enter the value of i : ");
//        int position=sc.nextInt();
//        System.out.println("Decimal number after setting ith position is : "+setIthBit(bNum, position));

//        Clearing ith bit.
//        System.out.println("Enter the decimal number : ");
//        int bNum=sc.nextInt();
//        System.out.println("Enter the value of i : ");
//        int position=sc.nextInt();
//        System.out.println("Decimal number after setting ith position is : "+clearIthBit(bNum, position));

//        Updating ith bit.
//        System.out.print("Enter the decimal number : ");
//        int n=sc.nextInt();
//        System.out.print("Enter the position : ");
//        int i=sc.nextInt();
//        System.out.println("the decimal number after updating ith element is "+updateIthBit(n, i, 1));

//        Clearing last i bits.
//        System.out.print("Enter the decimal number : ");
//        int n=sc.nextInt();
//        System.out.println("Enter the position i : ");
//        int i=sc.nextInt();
//        System.out.println("The new number after clearing last"+i+" bits is :"+clearLastIBit(n, i));

//       Clearing range of bits.
//        System.out.print("Enter the decimal number : ");
//        int n=sc.nextInt();
//        System.out.print("Enter the lower limit : ");
//        int ll=sc.nextInt();
//        System.out.print("Enter the upper limit : ");
//        int ul=sc.nextInt();
//        System.out.println("New number after manipulation si : "+clearRangeOfBits(n, ll, ul));




    }
}
