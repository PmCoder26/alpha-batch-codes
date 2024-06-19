package codes;
import java.util.*;

public class ArrayLists {

    public static void printAl(ArrayList al){
        for(int x=0; x<al.size(); x++){
            System.out.print(al.get(x)+" ");
        }
        System.out.println();
    }

    public static void printReverseAl(ArrayList al){
        for(int x=0; x<al.size(); x++){
            System.out.print(al.get(al.size()-1-x)+" ");
        }
        System.out.println();
    }

    public static int alMaxEle(ArrayList<Integer> al){
        int max=Integer.MIN_VALUE;
        for(int x=0; x<al.size(); x++){
            if(max<=al.get(x)){
                max=al.get(x);
            }
        }
        return max;
    }

    public static ArrayList swapTwoEle(ArrayList<Integer> al,int idx1, int idx2){
        int temp=al.get(idx1);
        al.set(idx1, al.get(idx2));
        al.set(idx2, temp);
        return al;
    }

    public static int waterContainer(ArrayList<Integer> height){
        int maxWater=Integer.MIN_VALUE;
        for(int x=0; x<height.size(); x++){
            for(int y=x+1; y<height.size(); y++){
                int netHeight=Math.min(height.get(x), height.get(y));
                int width=y-x;
                int water=width*netHeight;
                if(maxWater<water){
                    maxWater=water;
                }
            }
        }
        return maxWater;
    }

    public static int waterContainerOptimized(ArrayList<Integer> height){
        int maxWater=Integer.MIN_VALUE;
        int x=0;
        int y=height.size()-1;
        while(x<=y){
            int netHeight=Math.min(height.get(x), height.get(y));
            int width=y-x;
            int water=width*netHeight;
            if(maxWater<water){
                maxWater=water;
            }
            if(x<y){
                x++;
            }
            else{
                y--;
            }
        }
        return maxWater;
    }

    public static void pairSum(ArrayList<Integer> list, int target){
        for(int x=0; x<list.size()-1; x++){
            for(int y=x+1; y<list.size(); y++){
                if((list.get(x)+list.get(y))==target){
                    System.out.println("The target pair sum is : ("+list.get(x)+","+list.get(y)+")");
                    return;
                }
            }
        }
        System.out.println("No target pair sum exists!");
    }

    public static void pairSumOptimized(ArrayList<Integer> list, int target){
        int left=0;
        int right=list.size()-1;
        while(left<right){
            if(list.get(left)+list.get(right)==target){
                System.out.println("The target pair sum is : ("+list.get(left)+","+list.get(right)+")");
                return;
            }
            else if(list.get(left)+list.get(right)<target){
                left++;
            }
            else{
                right--;
            }
        }
        System.out.println("No target sum pair exists!");
    }

    public static boolean pairSumOptimized2(ArrayList<Integer> list, int target){
        int breakPoint=-1;
        for(int x=0; x<list.size(); x++){
            if(list.get(x)>list.get(x+1)){
                breakPoint=x;
                break;
            }
        }
        int left=breakPoint+1;
        int right=breakPoint;
        while(left!=right){
            if(list.get(left)+list.get(right)==target){
                return true;
            }
            else if(list.get(left)+list.get(right)<target){
                left=(left+1)%list.size();
            }
            else{
                right=(list.size()-1+right)%list.size();
            }
        }
        return false;
    }



    public static void main(String[] args){
//        ArrayLists.

//        ArrayList<Integer> al=new ArrayList<>();
//        System.out.println(al);

//        adding elements in the list.
//        al.add(5);
//        al.add(10);
//        al.add(15);

        //      accessing the elements from the list.
//        System.out.println(al.get(0));
//        System.out.println(al.get(2));

//      deleting the elements.
//        al.remove(0);
//        al.remove(1);
//        System.out.println(al);

        //      setting the elements at specific indices.
//        al.set(2,12);
//        al.set(1, 111);
//        System.out.println(al);

        //      checking whether an element is present or not.
//        System.out.println(al.contains(111));
//        System.out.println(al.contains(5));

        //      getting the size of arrayList.
//        System.out.println(al.size());

//        printing the elements of the arraylist.
//        ArrayList<Integer> al=new ArrayList<>();
//        al.add(1);
//        al.add(2);
//        al.add(3);
//        al.add(4);
//        al.add(5);
//        printAl(al);

//        printing reverse the arrayList.
//        ArrayList<Integer> al=new ArrayList<>();
//        al.add(1);
//        al.add(2);
//        al.add(3);
//        al.add(4);
//        al.add(5);
//        printReverseAl(al);

//        finding the maximum in the arraylist.
//        ArrayList<Integer> al=new ArrayList<>();
//        al.add(1);
//        al.add(2);
//        al.add(3);
//        al.add(4);
//        al.add(5);
//        System.out.println("The maximum element is : "+alMaxEle(al));

//        Swapping the two numbers in arraylist.
//        ArrayList<Integer> al=new ArrayList<>();
//        al.add(1);
//        al.add(2);
//        al.add(3);
//        al.add(4);
//        al.add(5);
//        int idx1=2, idx2=4;
//        printAl(swapTwoEle(al, idx1, idx2));

//        Sorting in ArrayList.
//        ArrayList<Integer> al=new ArrayList<>();
//        al.add(12);
//        al.add(9);
//        al.add(322);
//        al.add(2);
//        al.add(5);
//        System.out.println("List before sorting : ");
//        printAl(al);
//        Collections.sort(al);   // optimized sort.
//        System.out.println("List after sorting in ascending order : ");
//        printAl(al);
//        System.out.println("List after sorting in descending order :");
//        Collections.sort(al, Collections.reverseOrder());
//        printAl(al);

//        Multidimensional arrayList.
//        ArrayList<ArrayList<Integer>> main=new ArrayList<>();
//        ArrayList<Integer> list1=new ArrayList<>();
//        list1.add(1);
//        list1.add(2);
//        list1.add(3);
//        list1.add(4);
//        list1.add(5);
//        ArrayList<Integer> list2=new ArrayList<>();
//        list2.add(2);
//        list2.add(4);
//        list2.add(6);
//        list2.add(8);
//        list2.add(10);
//        ArrayList<Integer> list3=new ArrayList<>();
//        list3.add(3);
//        list3.add(6);
//        list3.add(9);
//        list3.add(12);
//        list3.add(15);
//        main.add(list1);
//        main.add(list2);
//        main.add(list3);
//        System.out.println(main);

//        accessing the sublist from the main list.
//        for(int x=0; x<main.size(); x++){
//            ArrayList<Integer> current=main.get(x);
//            System.out.print("ArrayList "+(x+1)+" - ");
//            for(int y=0; y<current.size(); y++){
//                System.out.print(current.get(y)+" ");
//            }
//            System.out.println();
//        }

//        question - container with most water.
//        ArrayList<Integer> height=new ArrayList<>();
//        height.add(1);
//        height.add(8);
//        height.add(6);
//        height.add(2);
//        height.add(5);
//        height.add(4);
//        height.add(8);
//        height.add(3);
//        height.add(7);
//        System.out.println("The most of the water in the container is : "+waterContainer(height));
//        optimized approach - two pointer approach.
//        System.out.println("The most of the water in the container is : "+waterContainerOptimized(height));

//        Pair Sum Question.
//        Find if any pair in a Sorted ArrayList has a target sum. ex. target=5, which can be 3+2, 4+1, etc.
//        ArrayList<Integer> list=new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        list.add(6);
//        int target=5;
//        pairSum(list, target);
//         Optimized approach.   Tow Pointer approach.
//        pairSumOptimized(list, target);
//        optimized logic for the rotated array which was sorted.

//        ArrayList<Integer> list=new ArrayList<>();
//        list.add(11);
//        list.add(15);
//        list.add(6);
//        list.add(8);
//        list.add(9);
//        list.add(10);
//        int target=16;
//        System.out.println(pairSumOptimized2(list, target));









    }
}
