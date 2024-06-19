package codes;
import java.util.*;

public class Tries {

    static class Node{
        Node[] children=new Node[26];
        int frequency;
        boolean endOfWord=false;      // To know whether a specific word has ended or not. Default is false.
        public Node(){
            for(int x=0; x<children.length; x++){
                children[x]=null;
            }
            frequency=1;
        }
    }
    public static Node root=new Node();
    public static void insert(String word){     //O(n)
        Node curr=root;
        for(int level=0; level<word.length(); level++){
            int idx=word.charAt(level)-'a';
            if(curr.children[idx]==null){       // if the character is not present, then adding it to the array at that level.
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
        }
        curr.endOfWord=true;        // when we traversed the whole word.
    }
    public static void insert2(String word){     //O(n)
        Node curr=root;
        for(int level=0; level<word.length(); level++){
            int idx=word.charAt(level)-'a';
            if(curr.children[idx]==null){       // if the character is not present, then adding it to the array at that level.
                curr.children[idx]=new Node();
            }
            else {
                curr.children[idx].frequency++;
            }
            curr=curr.children[idx];
        }
        curr.endOfWord=true;        // when we traversed the whole word.
    }
    public static boolean search(String word){      // O(n)
        Node curr=root;
        for(int level=0; level<word.length(); level++){
            int idx=word.charAt(level)-'a';
            if (curr.children[idx] == null) {       // if the character is not present, that means the node is null.
                return false;
            }
            curr=curr.children[idx];
        }
        return curr.endOfWord==true;    // if the word completely exists, then the endOfWord boolean value must be true otherwise false.
                                        // Hence, no such word exists.
    }
    public static boolean wordBreak(String key){
        if(key.length()==0){        // ilikesamsung
            return true;
        }
        else{
            for(int x=1; x<=key.length(); x++){
                if(search(key.substring(0, x)) && wordBreak(key.substring(x))){
                    return true ;
                }
            }
            return false;
        }
    }
    public static void uniquePrefix(Node root, String ans){     // O(L), L is the max levels in trie.
        if(root==null){
            return;
        }
        if(root.frequency==1){
            System.out.print(ans + " ");
            return;
        }
        for(int i=0; i<root.children.length; i++){
            if(root.children[i]!=null){
                uniquePrefix(root.children[i], ans+(char)(i+'a'));
            }
        }
    }
    public static boolean startsWith(String prefix){
        if(prefix.length()==0){
            return false;
        }
        else{
            Node curr=root;
            for(int x=0; x<prefix.length(); x++){
                int idx=prefix.charAt(x)-'a';
                if(curr.children[idx]==null){   // checking every character of prefix in the trie.
                    return false;
                }
                curr=curr.children[idx];
            }
            return true; // If all the characters of prefix present in the trie.
        }
    }
    public static int countNodes(Node root){
        if(root==null){
            return 0;
        }
        else{
            int count=0;
            for(int x=0; x<26; x++){
                if(root.children[x]!=null){
                    count+=countNodes(root.children[x]);
                }

            }
            return count+1;
        }
    }
    public static int uniqueSubstrings(String str){
        // creating trie by suffix of string.
        for(int x=0; x<str.length(); x++){
            insert(str.substring(x));
        }
        // finaly printing the no.of unique substrings.
        return countNodes(root);
    }
    public  static String ans="";
    public static void longestWordPrefix(Node root, StringBuilder temp){
        if(root==null){
            return;
        }
            for(int x=0; x<26; x++){
                if(root.children[x]!=null && root.children[x].endOfWord==true){
                    temp.append((char)(x+'a'));
                    if(temp.length()>ans.length()){
                        ans=temp.toString();
                    }
                    longestWordPrefix(root.children[x], temp);
                    temp.deleteCharAt(temp.length()-1);     // backtracking.
                }
            }
        }

    public static void main(String[] args){

//        Trie Data Structure.      // Also called prefix trees and retrieval trees.

//        Creating and inserting in a Trie.
//        String[] words={"the", "a", "there", "their", "any", "thee"};
//        for(String word:words){
//            insert(word);
//        }

//        Searching in Trie.
//        String[] words={"the", "a", "there", "their", "any", "thee"};
//        for(String word:words){
//            insert(word);
//        }
//        System.out.println(search("hello"));

//        Word Break Problem.
        /*
                Given an input string and a dictionary of words, find out if the
                input string can ve broken into a space-separated sequence of
                dictionary works.
         */
//        String[] words={"i", "like", "sam", "samsung", "mobile", "ice"};
//        String key="ilikesamsung";
//        // inserting the words in trie.
//        for(String word:words){
//            insert(word);
//        }
//        System.out.println(wordBreak(key));

//        Prefix Problem.
        /*
                Find the shortest unique prefix for every word in a given list.
                Assume no word is prefix of another.
         */
//        String[] words={"zebra", "dog", "duck", "dove"};
//        // inserting the words in trie.
//        for(String word:words){
//            insert2(word);
//        }
//        root.frequency=-1;        // as root node is always null.
//        uniquePrefix(root, "");

//        startsWith Problem.
        /*
                Create a function boolean startsWith(String prefix) for a trie.
                Return true if there is a previously inserted string word that
                has the prefix and false otherwise.
         */
//        String[] words={"apple", "app", "mango", "man", "woman"};
//        // creating trie.
//        for(String word:words){
//            insert(word);
//        }
//        System.out.println(startsWith("app"));          // returns true

//        Count Unique Substrings.
        /*
                Given a string of length n of lowercase alphabet characters, we need
                to count the total number of distinct substrings of this string.
                Approach- 1. find all suffixes of string.
                          2. create trie by inserting them.
                          3. count nodes of trie==unique prefix==unique substrings.
                          Hence, solved.
         */
//        String str="ababa";
//        System.out.println("The count of unique substrings is: " + uniqueSubstrings(str));

//        Longest word with all prefixes.
        /*
                Find the longest string in words such that every prefix of it is also in words.
         */
//        String[] words={"a", "banana", "appl", "ap", "app",  "apple"};
//        // creating trie.
//        for(String word:words){
//            insert(word);
//        }
//        longestWordPrefix(root, new StringBuilder());
//        System.out.print("The longest word with all prefixes is: " + ans);





    }
}
