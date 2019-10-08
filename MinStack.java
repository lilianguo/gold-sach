/*
155. Min Stack
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 

Example:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
*/
class MinStack {

    Stack<Integer> stk = new Stack<>();
    Stack<Integer> stk2 = new Stack<>();
    
    public void push(int x) {
        stk.push(x);                             //Always push into main stack
        if(stk2.isEmpty() || x <= stk2.peek())   //Push when empty OR x<= current smallest value
            stk2.push(x);
    }
    
    public void pop() {
        if(stk.pop().equals(stk2.peek()))    //Main stk always pop
            stk2.pop();                      //Other stk pops only if it equal to main stk's min
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return stk2.peek();
    }
}
