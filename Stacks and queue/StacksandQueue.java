// . Stacks and Queues (6 Questions)
// 1.232. Implement Queue using Stacks
class MyQueue {
        Stack<Integer> inStack=new Stack<>();
        Stack<Integer> outStack= new Stack<>();
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        if(outStack.isEmpty()){        // when outstack is empty ,pop elemnets from instack and push to outstack
            while(!inStack.isEmpty()){ 
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }
    
    public int peek() {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }
    
    public boolean empty() {
       return inStack.isEmpty() && outStack.isEmpty();
    }
}
// 2.225. Implement Stack using Queues
class MyStack {

     Queue<Integer> q=new LinkedList<>();
  
    public void push(int x) {
       q.add(x);
       for(int i=0;i<q.size()-1;i++){
            q.add(q.remove());
       }
    }
    
    public int pop() {
        return q.remove();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}


// 3.739. Daily Temperatures
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int result[]=new int[n];
        Stack<Integer> stk=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stk.isEmpty() && temperatures[i]>=temperatures[stk.peek()]){ 
                stk.pop(); // pop elements from stack until we find a greater element than current element
            }
            if(!stk.isEmpty()){
                result[i]=stk.peek()-i;  // if stack is not empty then we can calculate the number of days to wait for a warmer temperature by subtracting the current index from the index of the next greater element on top of the stack
            }
            stk.push(i);
        }
        return result;
    }
}
// 4.496. Next Greater Element I

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int result[]=new int[nums1.length];  // result array to store the next greater elements for nums1
        Stack<Integer>  stk =new Stack<>(); 
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num: nums2){
            while(!stk.isEmpty() && num>stk.peek()){  // compares the current number with the top element of the stack
                map.put(stk.pop(),num); // if current number is greater than the top element of the stack->found greater element->pop top element and map it to current number
            }
            stk.push(num); // push current number onto the stack
        }
        while(!stk.isEmpty()){
            map.put(stk.pop(),-1); // for elements that do not have a next greater element in nums2, map them to -1
        }
        for(int j=0;j<nums1.length;j++){
            result[j]=map.get(nums1[j]); // retrieve the next greater element for each element in nums1 from the map and store it in the result array
        }    
        return result;
    }
}

// 5.20. Valid Parentheses
class Solution {
    public boolean isValid(String s){
        Stack<Character> stk=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='{' || ch=='[' || ch=='('){
                stk.push(ch);
            }
            else {
                if(stk.isEmpty()) return false;

                char top=stk.pop();
                if(ch=='}' && top!='{') return false;
                if(ch==']' && top!='[') return false;
                if(ch==')' && top!='(') return false;
        }
    }
    return stk.isEmpty();
}
}
// 6.155. Min Stack
class MinStack {

    Stack<Integer> stack= new Stack<>();
 
    int min=Integer.MAX_VALUE;

    public void push(int val) {
       if(val <= min){          
            stack.push(min);
            min=val;
        }
        stack.push(val);
    }
    
    public void pop() {
        if(stack.pop()==min){
            min=stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
    // Next greater  Elemnt II
    import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * n; i++) {

            int num = nums[i % n];

            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                result[stack.pop()] = num;
            }

            if (i < n) {
                stack.push(i);
            }
        }

        return result;
    }
}

    //622. Designing a  Circular Queue:
   // the question asked to design a circular queue with the following operations: so we canot implement prebuilt methods
   
    class MyCircularQueue {
    int[] que; //queue must be an array to implement circular queue
    int front;
    int rear;
    int size;
    int capacity;

    public MyCircularQueue(int k) {
        que = new int[k];
        capacity=k;
        front =0;
        rear=-1;
        size=0;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        //when rear=-1 and we add first element rear will become 0 and it will point to the first element of the queue
        // when rear reaches the end of the queue and we add another element rear will become 0 and it will point to the first element of the queue
        rear=(rear+1)%capacity;
        que[rear]=value;
        size++; // increment size of the queue
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;

        front=(front+1)%capacity;
        size--; // decrement size of the queue as we dequeue an element from the front of the queue
        return true;

    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return que[front];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        return que[rear];
    }
    
    public boolean isEmpty() {
        return size==0; 
    }
    
    public boolean isFull() {
        return size==capacity;
        
    }
}



}
