package codes;

//      practice problems.

class Complex{                   // Note - public static methods can be accessed without creating objects.
    //     better for data privacy make private static methods or non-static methods.
    int real;
    int img;

    public Complex(int r, int i){
        real=r;
        img=i;
    }
    public static Complex add(Complex a, Complex b){
        return new Complex((a.real+b.real),(a.img+b.img));
    }
    public static Complex subtract(Complex a, Complex b){
        return new Complex((a.real-b.real),(a.img-b.img));
    }
    public static Complex product(Complex a, Complex b){
        return new Complex((a.real*b.real)-(a.img*b.img),(a.img*b.real+a.real*b.img));
    }
    public void result(){
        if(real==0 && img!=0){
            System.out.println (img+"i");
        }
        else if(real==0 && img==0){
            System.out.println(0);
        }
        else if(real!=0 && img!=0){
            System.out.println(real+"+("+img+")i");
        }
        else{
            System.out.println(real);
        }
    }
}

class Shape{
    protected void display(){
        System.out.println("Display-base");
    }
}

class Circle extends Shape{
    protected void display(){      // both public and protected access-modifiers can be used to override method;
        System.out.println("Displayed-derived");
    }
}

abstract class Car{
    static{
        System.out.println("1");
    }
    public Car(String name){
        super();
        System.out.println("2");
    }
    {
        System.out.println("3");
    }
}

public class Object_Oriented_Programming_Practice extends Car{
    {
        System.out.println("4");
    }
    public Object_Oriented_Programming_Practice(String name) {
        super(name);        // Imp note - when we extend the other class by our public main class, we have to create the constructor for the main class and invoke constructor of that other class suing 'super()' keyword.
        System.out.println("5");
    }

    public static void main(String[] args){
//                Q.1
//        Complex c1=new Complex(10,12);
//        Complex c2=new Complex(11, 13);
//        Complex c3=Complex.add(c1,c2);
//        Complex c4=Complex.subtract(c1,c2);
//        Complex c5=Complex.product(c1,c2);
//        System.out.println("The addition of the two complex numbers is : ");
//        c3.result();
//        System.out.println("The product of the two complex numbers is : ");
//        c4.result();
//        System.out.println("The subtraction of the two complex numbers is : ");
//        c5.result();
//
//        Q.2.
//        Ans-Code doesn't compile.
//
//        Q.3.
//        Ans-both public and private access modifiers can be used to override the methods.
//
//        Q.4.
//        new Object_Oriented_Programming_Practice("blue");
        /*
        Important concept:
        when class is loaded firstly static block is executed then only curly braces block then the constructor.
        in the q.4,
        when we created constructor of main class sue to extension of class Car,
        we invoked the constructor of main class, then due to super keyword, the constructor of Car was invoked, as static block executes first
        "1" was printed, then "3", then "2", then in main class only curly braces block executed hence "4", and finally
        "5" as after the super(name);
        IMP:
        In case of constructor presence if object is created, the java  runs primarily static blocks, then checks whether {// code} is present or not,
        if yes then executes all the {} blocks then other code.
        In case of absence of constructor invocation due to object instantiation, only static{} is executed,even not the {} block.
         */










    }


}
