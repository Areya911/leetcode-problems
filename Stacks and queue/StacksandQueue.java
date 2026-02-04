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

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

// 3.739. Daily Temperatures

// 4.496. Next Greater Element I

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