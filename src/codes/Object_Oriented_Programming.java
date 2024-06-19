package codes;
import java.util.*;

class Pen{
     private String color;
     private int tip;
    public void setColor(String newColor){
        color=newColor;
    }
    public void setTip(int newTip){
        tip=newTip;
    }
    public int getTip(){
        return tip;
    }
    public String getColor(){
        return color;
    }
}

class BankAccount{
    String userName;
    private String password;  // password is visible  only in this class not anywhere outside this class.
    public void setPassword(String pwd){
        password=pwd;
    }
    public void setUserName(String userName){
        this.userName=userName;
    }
}

//class Student{
//    String name;
//    int roll;
//    int[] marks;
//    public Student(){
//        marks=new int[3];
//        System.out.println("I am a constructor");
//    }
//    public Student(String name){
//        marks=new int[3];
//        this.name=name;
//    }
//    public Student(int roll){
//        marks=new int[3];
//        this.roll=roll;
//    }
//////  shallow copy constructor.   -- changes are reflected.
////    public Student(Student s){
////        this.name=s.name;
////        this.roll=s.roll;
////        this.marks=s.marks;
////    }
//
////    deep copy constructor.  -- changes aren't reflected.
//    public Student(Student s){
//        marks=new int[s.marks.length];
//        this.name=s.name;
//        this.roll=s.roll;
//        for(int x=0; x<s.marks.length; x++){
//            this.marks[x]=s.marks[x];
//        }
//    }
//}

//base class.
//class Animal{
//    String color;
//    public void eat(){
//        System.out.println("Eats");
//    }
//    public void breath(){
//        System.out.println("Breathes");
//    }
//}
//// derived class.
//class Fish extends Animal{
//    int fins;
//    public void swim(){
//        System.out.println("Swims");
//    }
//
//}
//
//class Mammal extends Animal{
//    int legs;
//}
//class Dog extends Mammal{
//    String breed;
//    public void walk(){
//        System.out.println("Walking");
//    }
//}
//class Bird extends Animal{
//    public void fly(){
//        System.out.println("Flying");
//    }
//}

class Calculator{
    public int sum(int a, int b){
        return a+b;
    }
    public float sum(float a, float b){
        return a+b;
    }
    public int sum(int a, int b, int c){
        return a+b+c;
    }
}

class Father{
    public void intro(){
        System.out.println("I am a father");
    }
}
class Son extends Father{
    public void intro(){
        System.out.println("I am a father in the class of son");
    }
}

abstract class Animal{
    String color;
     public Animal(){
        System.out.println("I am an Animal's constructor");
         this.color="Brown";
    }
    public void eat(){
        System.out.println("animal eats");
    }
    abstract void walk();

}
class Horse extends Animal{
    public Horse(){
        System.out.println("I am a horse's constructor");
    }
    public void changeColor(){
        color="Black";
    }
    public void walk(){
        System.out.println("walk on four legs");
    }
}
class Chicken extends Animal{
    public Chicken(){
        System.out.println("I am a chicken's constructor");
    }
    public void changeColor(){
        color="Red";
    }
    public void walk(){
        System.out.println("walks on four legs");
    }
}

interface chessPlayer{
    void moves();
}
class Queen implements chessPlayer{
    public void moves(){
        System.out.println("'up', 'down', 'left', 'right', 'diagonally'(in all four directions)");
    }
}
class Rook implements chessPlayer{
    public void moves(){
        System.out.println("'up', 'down', 'left', 'right'");
    }
}
class King implements chessPlayer{
    public void moves(){
        System.out.println("'up', 'down', 'left', 'right', 'diagonally'(by one step)");
    }
}

class NewStudent{
    static String schoolName;
    public void setSchoolName(String sName){
        schoolName=sName;
    }
    public void getSchoolName(){
        System.out.println(schoolName);
    }
}

class A{
    public A(){
        System.out.println("I am class A");
    }
    public A(int a){
        System.out.println("I am class A new constructor");
    }
}
class B extends A{
    public B(){
        super(10);
        System.out.println("I am class B");
    }
}






public class Object_Oriented_Programming{
    public Object_Oriented_Programming(){
        System.out.println("helo");
    }
    public static Scanner sc=new Scanner(System.in);

    public static void main(String[] args){
//        Object oriented programming.

//      Basic class and object defining and using.
//        Pen p1=new Pen();
//        p1.setColor("Black");
//        System.out.println("The color of the pen is : "+p1.color);
//        p1.setTip(5);
//        System.out.println("The tip of the pen is : "+p1.tip);

//        using access modifiers.

//        BankAccount myAcc=new BankAccount();
//        System.out.print("Enter username : ");
//        myAcc.userName=sc.nextLine();
//        System.out.print("Set the password : ");
//        myAcc.setPassword(sc.nextLine());

//        getters and setters.

//        Pen p1=new Pen();
//        p1.setColor("Red");
//        p1.setTip(5);
//        System.out.println(p1.getColor());
//        System.out.println(p1.getTip());

//        Encapsulation.
        /*
        It is defined as wrapping up of data and methods under a single unit.
        It also implements data hiding.
         */

//        Constructors. -- it is a method which is invoked automatically after instantiation of an object.
//        Student s1=new Student();

//        Types of constructors.
//        1. Non-parameterized.
//        Student s1=new Student();
////        2. parameterized.
//        Student s2=new Student("Parimal");
//        3. Copy constructor. --included shallow and deep copy.
//        Student s1=new Student();
//        s1.name="Parimal";
//        s1.roll=42;
//        s1.marks[0]=100;
//        s1.marks[1]=70;
//        s1.marks[2]=89;
//        Student s2=new Student(s1);   //s1 as object is passed.
//        s1.marks[2]=200;
//        for(int x=0; x<s1.marks.length; x++){
//            System.out.println(s2.marks[x]);
//        }

//        Destructors.  -- java garbage collector automatically do work of destructor so, no need to define manually.
//        use of destructor is to delete objects.

//        Inheritance.
//        Fish shark=new Fish();
//        shark.eat();
//        shark.swim();

//      multilevel inheritance.
//        Dog dobby=new Dog();
//        dobby.eat();

//        Hierarchical inheritance.
//            Dog d1=new Dog();
//            d1.walk();
//            Bird b1=new Bird();
//            b1.fly();

//        Polymorphism.
    //        Method overloading.
//        Calculator c=new Calculator();
//        System.out.println(c.sum(10, 20));
//        System.out.println((c.sum(10.5f, 20.6f)));
//        c.sum(10, 20, 30);
    //        Method Overriding.
//        Son s=new Son();
//        s.intro();

//        Abstraction. -- hiding all unnecessary details and showing only important part to the user.

//        Abstract classes.
//        Horse h=new Horse();
//        h.walk();
//        Chicken c=new Chicken();
//        c.walk();

//        Interfaces -- these are the blueprints of class.  -- can implement multiple inheritance. -- 100% abstraction.
//        Queen q=new Queen();
//        q.moves();
//        King k=new King();
//        k.moves();
//        Rook r=new Rook();
//        r.moves();

//      'static' keyword.  -- used to have common property or variable for all objects.
//        NewStudent ns1=new NewStudent();
//        ns1.setSchoolName("Modern");
//        NewStudent ns2=new NewStudent();
//        ns2.getSchoolName();
//        NewStudent ns3=new NewStudent();
//        ns3.getSchoolName();

//      super keyword.
//        used to invoke the base class constructor first than sub-class.
//        B b=new B();


    //      Practice Questions.



















    }
}
