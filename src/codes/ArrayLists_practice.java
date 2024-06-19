package codes;
import java.util.*;



public class ArrayLists_practice {
    public static boolean monotonicIncrease(ArrayList<Integer> list){
        for(int x=0; x<list.size()-1; x++){
            if(list.get(x)>list.get(x+1)){
             return false;
            }
        }
        return true;
    }
    public static boolean monotonicDecrease(ArrayList<Integer> list){
        for(int x=0; x<list.size()-1; x++){
            if(list.get(x)<list.get(x+1)){
                return false;
            }
        }
        return true;
    }
    public static boolean isMonotonicArrList(ArrayList<Integer> list){
        if(monotonicIncrease(list)){
            return true;
        }
        else{
            return monotonicDecrease(list);
        }
    }
    public static ArrayList lonelyNumbers(ArrayList<Integer> list){
        ArrayList<Integer> lonelyNums=new ArrayList<>();
        for(int x=0; x<list.size(); x++){
            boolean flag=false;
            for(int y=0; y<list.size(); y++){
                if((x!=y) && list.get(y)==list.get(x)){
                    flag=true;
                    break;
                }
                if(list.get(y)==(list.get(x)-1) || ((list.get(y))==list.get(x)+1)){
                    flag=true;
                    break;
                }
            }
            if(flag==false){
                lonelyNums.add(list.get(x));
            }
        }
        return lonelyNums;
    }
    public static int mostFrequent(ArrayList<Integer> nums, int key){
        if(nums.isEmpty()){
            System.out.println("The given list is empty!");
            return -1;
        }
        else{
            int[]result = new int[1000];
            for(int i=0; i<nums.size()-1; i++){
                if(nums.get(i) == key){
                    result[nums.get(i+1)-1]++;
                }
            }
            int max = Integer.MIN_VALUE;
            int ans = 0;
            for(int i=0; i<1000; i++){
                if(result[i] > max){
                    max = result[i];
                    ans = i+1;
                }
            }
            return ans;

        }
    }



    public static void main(String[] args){

//        ArrayList practice;

//        Q.1.
//        ArrayList<Integer> list=new ArrayList<>();
//        list.add(6);
//        list.add(5);
//        list.add(4);
//        list.add(4);
//        System.out.println(isMonotonicArrList(list));

//        Q.2.
//        ArrayList<Integer> list=new ArrayList<>();
//        list.add(1);
//        list.add(3);
//        list.add(5);
//        list.add(3);
//        System.out.println(lonelyNumbers(list));

//        Q.4.
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(100);
        list.add(200);
        list.add(1);
        list.add(100);
        int key=1;
        System.out.println(mostFrequent(list, key));




    }
}
