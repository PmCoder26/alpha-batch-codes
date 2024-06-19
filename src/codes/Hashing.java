package codes;
import java.util.*;

public class Hashing {
    static class HashMap<K,V>{     // <K,V> this is generics in which we can use any datatype for K and V.
        private class Node{
            K key;
            V value;
            public Node(K key, V value){
                this.key=key;
                this.value=value;
            }
        }
        private int N;
        private int n;
        private LinkedList<Node>[] buckets;
        public HashMap(){
            this.N=4;
            this.buckets=new LinkedList[4];
            for(int x=0; x<4; x++){
                this.buckets[x]=new LinkedList<>();
            }
        }
        public int hashFunction(K key){
            int hc=key.hashCode();      // hc - hashCode.
            return Math.abs(hc) % N;   // return the number whose digits ranging between 0-size;
        }
        private int SearchInLL(K key, int bi){
            LinkedList<Node> ll=buckets[bi];
            int di=0;
            for(int x=0; x<ll.size(); x++){
                Node node=ll.get(x);
                if(node.key==key){
                    return di;
                }
                else{
                    di++;
                }
            }
            return -1;      // if key doesn't exist.
        }
        private void reHash(){
            LinkedList<Node>[] old= buckets;
            buckets=new LinkedList[2*N];
            N=2*n;
            // filling the new bucket with new empty linkedLists.
            for(int x=0; x<buckets.length; x++){
                buckets[x]=new LinkedList<>();
            }
            // adding the nodes of old bucket to the new bucket.
            for(int x=0; x<old.length; x++){
                LinkedList<Node> ll=old[x];
                for(int y=0; y<ll.size(); y++){
                    Node node=ll.remove(y);
                    put(node.key, node.value);
                }
            }
        }
        public void put(K key, V value){    // O(1)
            int bi=hashFunction(key);       // bi - bucket index.
            int di=SearchInLL(key, bi);         // di - data index.
            // if the key exists, update its value.
            if(di!=-1){
                Node node=buckets[bi].get(di);
                node.value=value;
            }
            else{
                buckets[bi].add(new Node(key, value));
                n++;
            }
            double lambda=(double)n/N;
            if(lambda>2.0){
                reHash();
            }
        }
        public boolean containsKey(K key){      // O(1)
            int bi=hashFunction(key);
            int di=SearchInLL(key, bi);
            if(di!=-1){     // valid
                return true;
            }
            else{
                return false;
            }
        }
        public V remove(K key){     // O(1)
            int bi=hashFunction(key);
            int di=SearchInLL(key, bi);
            if(di!=-1){
                Node node=buckets[bi].remove(di);
                n--;
                return node.value;
            }
            else{
                return null;
            }
        }
        public V get(K key){        // O(1)
            int bi=hashFunction(key);
            int di=SearchInLL(key, bi);
            if(di!=-1){
                Node node=buckets[bi].get(di);
                return node.value;
            }
            else{
                return null;
            }
        }
        public ArrayList<K> keySet(){
            ArrayList<K> keys=new ArrayList<>();
            for(int x=0; x<buckets.length; x++){
                LinkedList<Node> ll=buckets[x];
                for(int y=0; y<ll.size(); y++){
                    keys.add(ll.get(y).key);
                }
            }
            return keys;
        }
        public void printMap(){
            for(int x=0; x<buckets.length; x++){
                LinkedList<Node> curr=buckets[x];
                for(int y=0; y<curr.size(); y++){
                    System.out.println(curr.get(y).key + ", " + curr.get(y).value);
                }
            }
        }
        public boolean isEmpty(){
            return n==0;
        }
    }

    public static void majorityEle(int[] arr){
        if(arr.length==0){
            return;
        }
        else{
            int n=arr.length;
            java.util.HashMap<Integer, Integer> hm=new java.util.HashMap<>();
            // inserting the numbers and their frequency in the hashMap.
            for(int x=0; x<n; x++){
                if(hm.containsKey(arr[x])){
                    hm.put(arr[x], hm.get(arr[x])+1);
                }
                else{
                    hm.put(arr[x], 1);
                }
            }
            Set<Integer> keySet=hm.keySet();
            // now, if checking whether frequency is more than n/3;
            for(Integer key:keySet){
                if(hm.get(key) > n/3){
                    System.out.print(key + " ");
                }
            }
        }
    }
    public static boolean isValidAnagram(String s, String t){
        if(s.length()==t.length()){
            return false;
        }
        else {
            java.util.HashMap<Character, Integer> hm = new java.util.HashMap<>();
            // filling the characters and their frequencies in hm.
            for (int x = 0; x < s.length(); x++) {
                if (hm.containsKey(s.charAt(x))) {
                    hm.put(s.charAt(x), hm.get(s.charAt(x)) + 1);
                } else {
                    hm.put(s.charAt(x), 1);
                }
            }
            // Now, traversing the characters of t and correspondingly deleting the frequencies.
            for (int x = 0; x < t.length(); x++) {
                if (hm.containsKey(t.charAt(x))) {
                    hm.put(t.charAt(x), hm.get(t.charAt(x)) - 1);
                    if (hm.get(t.charAt(x)) == 0) {  // if the frequency becomes 0, that means we have to remove that key(character) inorder to make the hashmap empty.
                        hm.remove(t.charAt(x));
                    }
                } else {
                    return false;     // If key doesn't exist, that means that character is not in t. Hence, s and t aren't valid anagrams.
                }
            }
            return hm.isEmpty();        // If hashmap is empty, that means the frequencies are equal in the s and t. Therefore, s and t are valid anagrams.
        }
    }
    public static int cntDistinctEle(int[] nums){
        if(nums.length==0){
            return 0;
        }
        else{
            HashSet<Integer> hs=new HashSet<>();
            for(int x=0; x<nums.length; x++){
                hs.add(nums[x]);
            }
            return hs.size();   // this represents the total no.of distinct elements.
        }
    }
    public static HashSet<Integer> unionOfSets(int[] arr1, int[] arr2){
        HashSet<Integer> hs=new HashSet<Integer>();
        // adding the elements of arr1.
        for(int x=0; x<arr1.length; x++){
            hs.add(arr1[x]);
        }
        // adding the elements of arr2.
        for(int x=0; x<arr2.length; x++){
            hs.add(arr2[x]);
        }
        return hs;
    }
    public static HashSet<Integer> intersectionOfSets(int[] arr1, int[] arr2){
        HashSet<Integer> hs=new HashSet<>();
        // Inserting the values of arr1 in hs.
        for(int x=0; x<arr1.length; x++){
            hs.add(arr1[x]);
        }
        HashSet<Integer> ans=new HashSet<>();
        for(int i: arr2){
            if(hs.contains(i)){
                ans.add(i);
                hs.remove(i);
            }
        }
        return ans;
    }
    public static void findJourney(java.util.HashMap<String, String> tickets){
        java.util.HashMap<String, String> revMap=new java.util.HashMap<>();
        String start="";
        // Inserting the keys of tickets in the revMap as values.
        for(String key:tickets.keySet()){
            revMap.put(tickets.get(key), key);
        }
        // Checking that which key of tickets is not present in the revMap's key.
        for(String key:tickets.keySet()){
            if(!revMap.containsKey(key)){
                start=key;
                break;
            }
        }
        // Now as we got the starting point which wasn't present in the revMap; finding the whole route.
        System.out.print(start);
        for(String key:tickets.keySet()){
            System.out.print(" -> " + tickets.get(start));
            start=tickets.get(start);   // Assigning the values to the start to print further values of keys.
        }
        System.out.println();


    }
    public static int largestSubArrSumZero(int[] arr){      // O(n)
        HashMap<Integer, Integer> hm=new HashMap<>();
        int sum = 0, length=0;
        for(int j=0; j<arr.length; j++){
            sum+=arr[j];
            if(hm.containsKey(sum)){       // If key exists, that means an again sum is equal to the previous one. Therefore, that part of the array doesn't contribute to the sum. Hence, that is the sub-array of sum 0.
                length=Math.max(length, j-hm.get(sum));     // updating the length of the sub-array whose sum is zero to get the sub-array of max length.
            }
            else{
                hm.put(sum, j);
            }
        }
        return length;
    }
    public static int subArrSumCount(int[] arr, int k){     // O(n).
        java.util.HashMap<Integer, Integer> hm=new java.util.HashMap<>();
        int sum=0, ans=0;
        hm.put(0, 1);       // if the sum == k, then net answer will be zero. Where we have to check for sum[0, j]-k=sum[0, i];
        for(int j=0; j<arr.length; j++){
            sum+=arr[j];
            if(hm.containsKey(sum-k)){
                ans+=hm.get(sum-k);
            }
            hm.put(sum, hm.getOrDefault(sum, 0)+1);
        }
        return ans;
    }




    public static void main(String[] args){

//        Hashing.  It is the process of converting one form of data into another using some techniques and methods.

//        HashMap.
//        HashMap<String, Integer> hm=new HashMap<>();
//        hm.put("India", 130);   // O(1)
//        hm.put("China", 150);
//        hm.put("USA", 50);
//        System.out.println(hm.get("India"));    // O(1)
//        System.out.println(hm.get("New York"));
//        System.out.println(hm.containsKey("India"));    // O(1)
//        System.out.println(hm.containsKey("Nepal"));
//        System.out.println(hm.remove("China")); // O(1)     // removes and return the value of the key which is removed.
//        System.out.println(hm.remove("Africa"));        // since no key present, null is returned.
//        System.out.println(hm.size());
//        System.out.println(hm.isEmpty());
//        hm.clear();     // clears all the data in the hashMap.
//        System.out.println(hm);

//        Iteration on Hashing.

//        HashMap<String, Integer> hm=new HashMap<>();
//        hm.put("India", 130);
//        hm.put("China", 150);
//        hm.put("USA", 50);
//        Set<String> keys=hm.keySet();
//        System.out.println(keys);
//        // Iterating using loop.
//        for(String key:keys){
//            System.out.print(key + " ");
//        }

//        Implementation of HashMap.
//        HashMap<String, Integer> hm=new HashMap();      // this is implemented hashmap created from class Hashing not Java Collection Framework.
//        hm.put("India", 100);
//        hm.put("China", 150);
//        hm.put("US", 50);
//        hm.put("Nepal", 5);
//        // printing the keySet.
//        System.out.println(hm.keySet());
//        // printing the values of all the keys.
//        System.out.println(hm.get("India"));
//        hm.remove("India");
//        System.out.println(hm.get("India"));        // as india was removed, it will return null.
//        System.out.println(hm.containsKey("US"));

        /*
                Special note-In the worst case, if the nodes are attached to the single and common bucket index, then time complexity
                of the operations will be O(n).
         */

//        LinkedHashMap.     Here, the keys are assigned in the order of their insertion in the linkedHashMap.
        // Also, here, in LinkedHashMap doubly linkedList are used than the hashMap where normal likedList is used.
//        LinkedHashMap<String, Integer> lhm=new LinkedHashMap<>();
//        lhm.put("India", 120);
//        lhm.put("China", 150);
//        lhm.put("US", 50);
//        System.out.println(lhm);    // Hence the keys and their values are displayed according to their order of their insertion.
        // Hence, the key-value pair inserted first will be assigned first. Hence, order is maintained.

//        Tree Map.
        /*
            1. Keys are sorted. If keys are alphabets, sorting will be done according to alphabetical order,
                if keys are integers, sorting will be done according to the order of numbers.
            2. Time complexity of put, get, remove is O(logn).
            3. In this treeMap data structure, the red-black trees are used who are self-balancing.
         */
//        TreeMap<String, Integer>tm=new TreeMap<>();
//        tm.put("India", 120);
//        tm.put("China", 150);
//        tm.put("Africa", 60);
//        System.out.println(tm);

//        Majority Element.
        /*
                Given an integer array of size n, find all elements that appear more than [n/3] times.
         */
//        int[] nums={1, 3, 2, 5, 1, 3, 1, 5, 1};
//        majorityEle(nums);

//        Valid Anagram.
        /*
                Given two strings s and t, return true of t is an Anagram of s, and false otherwise.
                An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
                using all the original letters exactly once.
                e.g. s=race, t=care , O/P- true.
         */
//        String s="care";
//        String t="race";
//        System.out.println(isValidAnagram(s, t));

//        HashSet.
        /*
            1. HashSet is implemented using hashMap
            2. Used to store unique values.
            3. Unordered arrangements.
            4. Null is allowed.
         */
//        HashSet<Integer> hs=new HashSet<>();
//        hs.add(1);
//        hs.add(12);
//        hs.add(10);
//        System.out.println(hs);
//        System.out.println(hs.remove(122));     // removes and returns true if present otherwise returns false.
//        if(hs.contains(1)){
//            System.out.println("Set Contains 1");
//        }
//        if(hs.contains(190)){
//            System.out.println("Set Contains 190");
//        }
//        System.out.println("The size of the hashSet is: " + hs.size());

        // Iteration on HashSet.
            // a. Using built-in iterator.
//        HashSet<String> hs=new HashSet();
//        hs.add("Mumbai");
//        hs.add("Delhi");
//        hs.add("Noida");
//        hs.add("Bengaluru");
//        Iterator it=hs.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
            // b. Using for-each loop.
//        for(String city:hs){
//            System.out.println(city);
//        }

//        LinkedHasSet.
        /*
                1. Implemented using LinkedHashSet.
                2. Ordered values using the doubly linkedLists. Ordered means the order is followed according to the insertion order of elements.
                    The element inserted first, will appear first, the element inserted second, will appear at second position and so on.
         */
//        LinkedHashSet<String> lhs=new LinkedHashSet<>();
//        lhs.add("Delhi");
//        lhs.add("Mumbai");
//        lhs.add("Pune");
//        lhs.add("Sangamner");
//        System.out.println(lhs);        // order is maintained.
//        System.out.println(lhs.size());
//        System.out.println(lhs.remove("Delhi"));    // returns true if present and false otherwise.

//        TreeSet.
        /*
                1. Implemented using Tree Map.
                2. Sorted in ascending order.
                3. Null values are not allowed because null values cannot be sorted.
         */
//        TreeSet<String> ts=new TreeSet<>();
//        ts.add("Delhi");
//        ts.add("Mumbai");
//        ts.add("Pune");
//        ts.add("Sangamner");
//        System.out.println(ts);     // sorted values.
//        System.out.println(ts.remove("Pune"));
//        System.out.println(ts.size());

//        Count distinct elements.
        /*
            Given array of repeated or non-repeated integers. Task is to calculate the distinct elements
            present in the array. Note that if the elements are repeated in the array, then consider all the
            copies of that element as one element.
         */
//        int[] nums={4, 3, 2, 5, 6, 7, 3, 4, 2, 1};
//        System.out.println(cntDistinctEle(nums));

//        Union and Intersection of 2 arrays.
        /*
                Using the concepts of Mathematics:
                Union: Total no.of unique elements in the set1 and set2 together.
                Intersection: Total no.of common elements in the set1 and set2 together.
         */
//        int[] arr1={7, 3, 9};
//        int[] arr2={6, 3, 9, 2, 9, 4};
//        System.out.println("The union of arr1 and arr2 is: " + unionOfSets(arr1, arr2));
//        System.out.println("The intersection of arr1 and arr2 is: " + intersectionOfSets(arr1, arr2));

//        Find itinerary from tickets.      Itinerary - journey.
//        java.util.HashMap<String, String> tickets=new java.util.HashMap<>();
//        tickets.put("Chennai", "Bengaluru");
//        tickets.put("Mumbai", "Delhi");
//        tickets.put("Goa", "Chennai");
//        tickets.put("Delhi", "Goa");
//        findJourney(tickets);

//        Largest sub-array with 0 sum.
        /*
            Approach: We have, sum[i+1, j]=sum[0, j]-sum[0,i]
                      So, to get net sum zero, sum[i+1, j]=0.
                      Hence, sum[0, i]=sum[0, i].
         */
//        int[] arr={15, -2, 2, -8, 1, 7, 10, 23};
//        System.out.println("The length of largest sub-array sum as 0 is: " + largestSubArrSumZero(arr));

//        Sub-array sum equal to K.
        /*
            Given an array of integers. The Task is to calculate the number of sub-array/count of sub-arrays whose sum is
            equal to K rather than 0 in the previous question.
            As, sum[0, j]-sum[0, i]=sum[i+1, j]=k in this question.
            Hence, sum[0, j]=k+sum[0, i]
         */
//        int[] arr={10, 2, -2, -20, 10};
//        int k=-10;
//        System.out.println(subArrSumCount(arr, k));





    }
}
