// Arrays (10 Questions)
// 1.1. Two Sum
// brute logic
// for i:
//   for j:
//     if nums[i] + nums[j] == target
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map= new HashMap<>();  //map{element,index}
        for(int i=0;i<nums.length;i++){
            int complement = target-nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}

// 2.121. Best Time to Buy and Sell Stock
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice=Integer.MAX_VALUE;
        int maxProfit=0;
        for(int nums : prices){
            if(nums < minPrice) minPrice=nums; //update minPrice
            else{
                int profit = nums - minPrice; //checks profit
                maxProfit=Math.max(profit,maxProfit); //if profit is more than maxProfit, update maxProfit
            }
        }
        return maxProfit;
    }
}

// 3.88. Merge Sorted Array
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int j = 0, i = m; j < n; j++){
            nums1[i] = nums2[j];
            i++;
        }
        Arrays.sort(nums1);
    }
}

// 4.217. Contains Duplicate
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set= new HashSet<>();
        for(int i: nums){
            if(set.contains(i)) return true;
            else set.add(i);
        }
        return false;
    }
}

// 5.238. Product of Array Except Self -two pinters
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left=new int[nums.length];
        int[] right= new int [nums.length];
        int[] answer= new int[nums.length];

        left[0]=1;
        right[nums.length-1]=1;

        for(int i=1;i<nums.length;i++){
           left[i]=left[i-1]*nums[i-1];
        }
        for(int i=nums.length-2;i>=0;i--){
           right[i]=right[i+1]*nums[i+1];
        }
        for(int i=0;i<nums.length;i++){
            answer[i]=left[i]*right[i];
        }
        return answer;
    }
}

// 6.53. Maximum Subarray -Kandanes Algorithm
class Solution{
    public int [] maxSubArray(int[] nums){
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            max=Math.max(max,sum); 
            if(sum<0) sum=0; //edge case handing
        }
        return max;
    }
}

// 7.15. 3Sum
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result=new ArrayList<>();
    int n=nums.length;
    Arrays.sort(nums);

    //1st element taken from this for loop
    for(int i=0;i<n-2;i++){
        if( i>0 && nums[i]==nums[i-1]) continue; //skip duplicates
        int left=i+1;
        int right=n-1;
        //2 pointers
        while(left<right){
            int sum= nums[i]+nums[left]+nums[right];

            if(sum==0){
                result.add(Arrays.asList(nums[i],nums[left],nums[right]));

                //skip duplicates for left and right
                while(left<right && nums[left]==nums[left+1]) left++;
                while(left<right && nums[right]==nums[right-1])right--;

                left++;
                right--;
            }
            else if(sum<0) left++; //if sum is less than 0, move left pointer forward
            else right--; //if sum is greater than 0, move right pointer backward   
        }
    }
}

// 8.56. Merge Intervals
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]); //lambda operator-custom sort based on starting time 

        if(intervals.length<=1) return intervals; //if only one interval present    

        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]); //add first interval to merged list

        for(int i=1;i<intervals.length;i++){
             int[] last=merged.get(merged.size()-1); //most recent added interval
             int[] current=intervals[i]; //current interval to be compared
             
             if(current[0]<=last[1]){
                last[1]=Math.max(current[1],last[1]); //merge and last[1] updates in merged also
             }
             else merged.add(intervals[i]); // adds arrays that dont overlap
        }
        return merged.toArray(new int[merged.size()][]);

    }
}

// 9.11. Container With Most Water -use 2 pointer
class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int ans=0;

        while(left<right){
            int width= right-left;
            int h=Math.min(height[left],height[right]); // min height of water area
            int volume= h*width; // volume of water stored in the container
            ans=Math.max(ans,volume); //checks max olume in loop continously

            // move pointers
            if(height[left]<height[right]) left++;
            else right --;
        }
        return ans;
    }
}


// 10.48. Rotate Image

class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        //transpose whole matrix 
        for(int i=0;i<n;i++){
            for(int j=i+1;j<matrix[i].length;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        // reverse each row
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp=matrix[i][j];   
                matrix[i][j]=matrix[i][n-1-j];
                matrix[i][n-1-j]=temp;
            }
        }
    }
}

