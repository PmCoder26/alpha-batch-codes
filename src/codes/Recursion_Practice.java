package codes;
public class Recursion_Practice {
    public static void findKeyIndices(int[] arr, int idx, int key){
        if(idx>=arr.length){
            return;
        }
        if(arr[idx]==key){
            System.out.print(idx+" ");
        }
        findKeyIndices(arr, idx+1, key);
    }

    public static String numToStr(int num, String engWord){
        if(num==0){
            return engWord;
        }
        int rem=num%10;
        String word="";
        switch(rem){
            case 0: word="zero";
                    break;
            case 1: word="one";
                    break;
            case 2: word="two";
                    break;
            case 3: word="three";
                    break;
            case 4: word="four";
                    break;
            case 5: word="five";
                    break;
            case 6: word="six";
                    break;
            case 7: word="seven";
                    break;
            case 8: word="eight";
                    break;
            case 9: word="nine";
                    break;
        }
        return numToStr(num/10, (word+" "+engWord));
    }

    public static int strLength(String str, int length){
        if(length==str.length()){
            return length;
        }
        else{
            return strLength(str, length+1);
        }
    }

    public static int substringStr(String str, int idx){
        if(idx>=str.length()){
            return 0;
        }
        else{
            String subStr="";
            int count=0;
            for(int x=idx; x<str.length(); x++){
                subStr+=str.charAt(x);
                if(subStr.charAt(0)==subStr.charAt(subStr.length()-1)){
                    count++;
                }
            }
            return count+substringStr(str, idx+1);
        }
    }

    public static void main(String[] args){

//        Practice the recursion with questions.

//        Q.1.
//        int[] arr={3, 2, 4, 5, 6, 2, 7, 2, 2};
//        findKeyIndices(arr, 0,2);

//        Q.2.
//        int num=2019;
//        System.out.println("The form number to english string is : "+numToStr(num, ""));

//        Q.3.
//        String str="Parimal";
//        System.out.println(strLength(str, 0));

//        Q.4.
        String S="abcab";
        System.out.println(substringStr(S, 0));

//        Q.5.  -- Tower of HANOI. (IMPORTANT).





    }
}
