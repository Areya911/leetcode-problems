// Strings (10 Questions) ->
// [  ] 1. 20. Valid Parentheses->
class Solution {
    public boolean isValid(String s) {
         Stack<Character> stack = new Stack<>();
         for(char ch:s.toCharArray()){
             // Opening brackets → push
            if(ch=='(' || ch=='{' || ch=='['){
                stack.push(ch);
            }
            else{
                //closing brackets
                if(stack.isEmpty()) return false; //edge case 
                char top=stack.pop(); // pops top element - '{','[','('
                // if top element doesnt match the current element ,it returns false
                if(ch==')' && top!='(')return false; 
                if(ch==']' && top!='[')return false;
                if(ch=='}' && top!='{')return false;
            }
         }
         return stack.isEmpty();
    }
}

// [  ] 2. 125. Valid Palindrome ->
class Solution {
    public boolean isPalindrome(String s) {
        int left=0;
        int right=s.length()-1;
        while(left<right){
            //move left pointer to next alphanumeric character
            while(left<right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            //move right pointer to previous alphanumeric character
            while(left<right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            //compare characters at left and right pointers (case-insensitive)
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false; //mismatch found
            }
            left++;
            right--;
        }
        return true; //all characters matched
    }
}

// [  ] 3. 242. Valid Anagram -brute and optimized ->
int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        for (int count : freq) {
            if (count != 0) return false;
        }

        //optimized sol:

class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length()!=t.length())return false;
        // cannot use set,coz frquency may differ
        Map<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);  //counts frequencies of letters in string s
        }
        for(char ch:t.toCharArray()){
            if(!map.containsKey(ch)) return false; // if map doesnt contain ch returns false
            map.put(ch,map.get(ch)-1); // else subtract the ch freq to make it zero to equal out both strings
            if(map.get(ch)<0) return false; // If count goes negative → t has that char more times than s
        }
        return true;
    }
}

// [  ] 4. 49. Group Anagrams ->
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map=new HashMap<>();
        for(String word:strs){
            char[] chars=word.toCharArray(); // if word='eat',chars=['e','a','t'];
            Arrays.sort(chars); // chars=['a','e','t'];
            String key=new String(chars); // key='aet' -chars array is coverted to string here
            map.putIfAbsent(key,new ArrayList<>()); //if key doesnt exist , new arraylist created
            map.get(key).add(word); //if exists, then word is added to the key
        }
        return new ArrayList<>(map.values()); //given-any order
    }
}

// [  ] 5. 5. Longest Palindromic Substring ->
class Solution {
    public String longestPalindrome(String s) {
        String result="";
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String sub=s.substring(i,j+1); 
                if(isPalindrome(sub) && sub.length()>result.length()){
                    result=sub;
                }
            }
        }
    return result;
    }
    private boolean isPalindrome(String sub){
        int left=0;
        int right=sub.length()-1;
        while(left<right){
            if(sub.charAt(left)!=sub.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}



// [  ]  6. 76. Minimum Window Substring ->(HARD)

class Solution { //https://www.youtube.com/watch?v=zbApqzJpQR8 - refer for logic
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        int freq[]=new int[128];
        for(char ch:t.toCharArray()){
            freq[ch]++;
        }
        int left=0,right=0;
        int needed=t.length();
        int minstart=0;
        int minlength=Integer.MAX_VALUE;
        while(right<s.length()){
            char r=s.charAt(right);
            if(freq[r]>0) needed--;
            freq[r]--;
            right++;
            while(needed==0){
                if(right-left<minlength){
                    minlength=right-left;
                    minstart=left;
                }
            
                char l=s.charAt(left);
                freq[l]++;
                if(freq[l]>0) needed++;
                left++;
            }
        }
        if(minlength==Integer.MAX_VALUE) return "";
        return s.substring(minstart,minstart+minlength);
        }
}

// [  ]  7. 28. Find the Index of the First Occurrence in a String ->
class Solution {
    public int strStr(String haystack, String needle) {
     for(int i=0,j=needle.length();j<=haystack.length();i++,j++){
        if(haystack.substring(i,j).equals(needle)){
            return i;
        }
     } return -1;
    }
}

// [  ] 8. 443. String Compression ->
class Solution {
    public int compress(char[] chars) {
        int write=0;
        int read=0;
        while(read<chars.length){
            char current=chars[read]; //reads current element
            int count=0;
            while(read<chars.length && chars[read]== current){ //counts dupilcates
                read++;
                count++;
            }
            chars[write++]=current; //writes the element at the index with 'write'
            if(count>1){                                                    //if count is 12 ->  it becomes['1','2']
                for(char c:String.valueOf(count).toCharArray()){ 
                    chars[write++]=c; //writes the count of duplicateS
                }
            }
        }
        return write;
    }
}

// [  ]  9. 14. Longest Common Prefix ->
class Solution {
    public String longestCommonPrefix(String[] strs) { 
     if(strs==null || strs.length==0) return ""; //edge case
     String first=strs[0]; //taking first string as reference
     for(int i=0;i<first.length();i++){ 
        char ch=first.charAt(i); //current character from first string
        for(int j=1;j<strs.length;j++){   
            if (i >= strs[j].length() || strs[j].charAt(i) != ch) { //compare with other strings
                return first.substring(0,i); //if mismatch found, return prefix up to i
            }
        }
     }  return first; // if first string itself is the common prefix    
    }
}


// [  ]  10.459. Repeated Substring Pattern ->
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String doubled=s+s;
        String trim= doubled.substring(1,doubled.length()-1); //remove first and last characters of doubled
        return trim.contains(s);
    }
}

//Reverse String-  in place reversal using 2 pointers
class Solution {
    public void reverseString(char[] s) {
        int left=0;
        int right=s.length-1;
        while(left<right){
            char temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }
    }
}

//reverse string II
class Solution {
    public void reverse(char[] arr, int left,int right){
        while(left<=right){
            char temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }

    }
    public String reverseStr(String s, int k) {
        char[] str=s.toCharArray();
        int n=s.length();
        for(int i=0;i<n;i+=2*k){
            int j = Math.min(i+k-1,n-1);
            reverse(str,i,j);
        }
        return new String(str);
        //.toString() returns hashcode
    }
}

//Longest palindromic substring - 2pointers approach
class Solution {
    private boolean isPalindrome(String s,int left,int right){
        int left=0;
        int right=s.length()-1;
            while(left<right)
             if( s.charAt(left)!=s.charAt(right)) return false;
                left++;
                right--;
            }
            
        }
        public String longestPalindrome(String s) {
            String result="";
                for(int i=0;i<s.length();i++){
                    for(int j=i;j<s.length();j++){
                        String sub=s.substring(i,j+1);
                        if(isPalindrome(sub) && sub.length()>result.length()){
                            result=sub;
                        }
                    }
                }
            return result;
        }