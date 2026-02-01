// Strings (10 Questions)
// [  ] 1. 20. Valid Parentheses

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

// [  ] 2. 125. Valid Palindrome
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

// [  ] 3. 242. Valid Anagram -brute and optimized
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

// [  ] 4. 49. Group Anagrams
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
// [  ] 5. 5. Longest Palindromic Substring
// [  ]  6. 76. Minimum Window Substring
// [  ]  7. 28. Find the Index of the First Occurrence in a String
// [  ] 8. 443. String Compression
// [  ]  9. 14. Longest Common Prefix
// [  ]  10.459. Repeated Substring Pattern