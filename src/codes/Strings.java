package codes;
import java.util.*;

public class Strings {
    public static Scanner sc=new Scanner(System.in);

    public static void printLetters(String strg){
        for(int x=0; x<strg.length(); x++){
            System.out.print(strg.charAt(x)+" ");
        }
        System.out.println();
    }

    public static boolean isPalindrome(String strg){
        boolean flag=true;
        for(int x=0; x<strg.length()/2; x++){
            if(strg.charAt(x)!=strg.charAt(strg.length()-x-1)){
                flag=false;
                break;
            }
        }
        return flag;
    }

    public static double shortestPath(String strg){
        int x=0;
        int y=0;
        for(int i=0; i<strg.length(); i++){
            if(strg.charAt(i)=='E'){
                x++;
            }
            else if(strg.charAt(i)=='W'){
                x--;
            }
            else if(strg.charAt(i)=='N'){
                y++;
            }
            else{
                y--;
            }
        }
        return Math.sqrt(x*x+y*y);
    }

    public static String subString(String strg, int sIdx, int eIdx){
        String sub="";
        for(int x=sIdx; x<eIdx; x++){
            sub+=strg.charAt(x);
        }
        return sub;
    }

    public static String largestStr(String[] strArr){
        String largest=strArr[0];
        for(int x=1; x<strArr.length; x++){
            if(largest.compareTo(strArr[x])<0){
                largest=strArr[x];
            }
        }
        return largest;
    }

    public static StringBuilder firstLetterToUpper(String st){
        StringBuilder sb=new StringBuilder("");
        sb.append(Character.toUpperCase(st.charAt(0)));
        for(int x=1; x<st.length(); x++){
            if(st.charAt(x)==' '){
                sb.append(st.charAt(x));
                x++;
                sb.append(Character.toUpperCase(st.charAt(x)));
            }
            else{
                sb.append(st.charAt(x));
            }
        }
        return sb;
    }

    public static String compressedStr(String st){
        String compStr=Character.toString(st.charAt(0));     //String st="abbcccdddd"
        int count=1;
        for(int x=0; x<st.length()-1; x++){
            if(st.charAt(x)==st.charAt(x+1)){
                count++;
            }
            else{
                if(count!=1){
                    compStr+=Integer.toString(count);
                    count=1;
                }
                compStr+=st.charAt(x+1);
            }
        }
        if(count>1){
            return compStr+count;
        }
        else {
            return compStr;
        }
    }

//    practice questions methods.

    public static int lowerCaseVowelsCount(String st){
        int count=0;
        for(int x=0; x<st.length(); x++){
            if(st.charAt(x)=='a' || st.charAt(x)=='e' || st.charAt(x)=='i' || st.charAt(x)=='o' || st.charAt(x)=='u'){
                count++;
            }
        }
        return count;
    }

    public static boolean areAnagrams(String s1, String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        else {
            String[] strArr=new String[s2.length()];
            for(int x=0; x< strArr.length; x++){
                strArr[x]=Character.toString(s2.charAt(x));
            }
            for(int x=0; x<s1.length(); x++){
                boolean flag=false;             // s1=race, s2-care
                for(int y=0; y<strArr.length; y++){
                    if(Character.toString(s1.charAt(x)).equals(strArr[y])){
                        strArr[y]="";
                        flag=true;
                        break;
                    }
                }
                if(flag==false){
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args){
//        Strings.
//
//        String name=sc.nextLine();
//        System.out.println("Name is : "+name);
//
////        finding the length of string
//        System.out.println("The lenght of name is : "+name.length());

//      Concatenation.
//        String fName="Parimal";
//        String lName="Matte";
//        String fullName=fName+" "+lName;
//        System.out.println(fullName);

//        printing the individual/all characters of the strings.

//        String name="Parimal";
//        printLetters(name);

//        checking whether string is palindrome or not.
//        String s="racecar";
//        if(isPalindrome(s)){
//            System.out.println("The string is palindrome.");
//        }
//        else{
//            System.out.println("The string is not palindrome");
//        }

//        Given a route containing 4 directions (E, W, N, S), find the shortest path to reach the destination.
//        String path="WNEENESENNN";
//        System.out.println("The shortest path to reach the destination is : "+shortestPath(path));

//        COMPARING STRINGS.
//        String s1="Parimal";
//        String s2="Parimal";
//        String s3=new String("Parimal");
//        if(s1==s2){  // here s2 created will point s1 as s1 was created first without 'new' keyword.
//            System.out.println("The strings are equal.");
//        }
//        else{
//            System.out.println("The strings are not equal.");
//        }
//        if(s1==s3){   // in this case else will execute thought the values are same because s3 is new object type created.
//            System.out.println("The strings are equal.");
//        }
//        else{
//            System.out.println("The strings are not equal.");
//        }
////        hence to check only values of string equal or not we use 'equals' method of strings.
//        if(s1.equals(s3)){      // here if part is executed.
//            System.out.println("The strings are equal.");
//        }
//        else{
//            System.out.println("The strings are not equal.");
//        }

//        Substrings of string.
//        String s="Parimal";
//        substring using manual method.
//        System.out.println(subString(s, 2, 6));
//        substring using string function.
//        System.out.println(s.substring(0,3));       // substring will be printed till ending_index-1
//        printing the largest of the given set of substring.
//        String[] fruits={"Apple", "Mango", "Banana"};
//        System.out.println("The largest of the given strings is : "+largestStr(fruits));

//        String builder.   only works with objects.
//        it is used for better optimization and performance.
//        time complexity - O(n);
//        StringBuilder sb=new StringBuilder("");
//        for(char x='a'; x<='z'; x++){
//            sb.append(x);
//        }
//        System.out.println(sb);

//        for a given string, convert first letter of each word in uppercase.
//        String st="hi, i am parimal";
//        System.out.println("The titled case string is : "+firstLetterToUpper(st));

//        Q.- String compression.
//        e.g. "aaabbcccdd" -> "a3b2c3d2"
//        String st="aaabbcccdd";
//        System.out.println ("The compressed string is : "+compressedStr(st));

//        practice questions.

//        Q.1.
//        System.out.print("Enter the string : ");
//        String st=sc.nextLine();
//        System.out.println("The no. of lowercase vowels occurred in string is :"+lowerCaseVowelsCount(st));

//        Q.2.
//        String str="ShradhaDidi";
//        String str1="ApnaCollege";
//        String str2="ShradhaDidi";
//        System.out.println(str.equals(str1)+" "+str.equals(str2));

//        Q.3.
//        String str="ApnaCollege".replace("l","");
//        System.out.println(str);

//      Q.4.Determining whether two strings are anagrams of each other or not.
        String s1="race";
        String s2="care";
        System.out.println(areAnagrams(s1, s2));










    }
}
