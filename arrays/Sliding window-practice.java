// Maximum average Subarray I
class Solution {
    public double findMaxAverage(int[] nums, int k) {

        int maxSum=0,sum=0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        maxSum=sum;

        int start=0;
        int end=k;
        while(end<nums.length){
            sum-=nums[start]; //remeove prev element 
            start++;

            sum+=nums[end];  //add next element
            end++;

            maxSum=Math.max(maxSum,sum);
        }
        return (double)maxSum/k;
    }
}

//Contains Duplicate II
class Solution {            
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])) return true;
            set.add(nums[i]); //else, add to set
            if(set.size()>k){ //remove prev element if size of set exceeds k
                set.remove(nums[i-k]); 
            }
        }
        return false;
    }
}

//Minimum Size Subarray Sum

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min=Integer.MAX_VALUE;
        int low=0,high=0,sum=0;
        while(high<nums.length){
            sum+=nums[high];
            high++;
            while(sum>=target){
                int currentWindowLen=high-low;
                min=Math.min(currentWindowLen,min);
                sum-=nums[low]; 
                low++;
            }
        } return min==Integer.MAX_VALUE?0:min;
    }    
}
//Longest Substring Without Repeating Characters
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0;
        int maxlen=0;
        HashSet<Character> set=new HashSet<>();
        for(int right=0;right<s.length();right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxlen=Math.max(maxlen, right-left+1);
        }
        return maxlen;
    }
}


//Fruit Into Baskets
class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int left=0,max=0;
        for(int right=0;right<fruits.length;right++){
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            while(map.size()>2){
                map.put(fruits[left],map.get(fruits[left])-1);
                if(map.get(fruits[left])==0){
                    map.remove(fruits[left]);
                }
                left++;
            }
            max=Math.max(max,right-left+1);

        }
        return max;
    }
}

//Longest Repeating Character Replacement
class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq=new int[26];
        int left=0,maxfreq=0,maxlen=0;
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            freq[ch- 'A']++;
            maxfreq=Math.max(maxfreq,freq[ch-'A']);
            // remove left character  if window size - maxfreq > k
            while((right-left+1)-maxfreq > k){
                freq[s.charAt(left)-'A']--;
                left++;
            } 
            maxlen=Math.max(maxlen,right-left+1);
       } return maxlen;
    }
}



//Minimum Window Substring
class Solution {
    public String minWindow(String s, String t) {
        if(s.length()==0 || t.length()==0) return "";
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int left=0,minLen=Integer.MAX_VALUE,start=0;
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
            }
            while(allCharsCovered(map)){
                int currentWindowLen=right-left+1;
                if(currentWindowLen<minLen){
                    minLen=currentWindowLen;
                    start=left;
                }
                char leftChar=s.charAt(left);
                if(map.containsKey(leftChar)){
                    map.put(leftChar,map.get(leftChar)+1);
                }
                left++;
            }
        } return minLen==Integer.MAX_VALUE?"":s.substring(start,start+minLen);
    }

    private boolean allCharsCovered(HashMap<Character,Integer> map){
        for(int count:map.values()){
            if(count>0) return false;
        }
        return true;
    }
}


