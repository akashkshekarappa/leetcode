/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Stack<Iterator<NestedInteger>> stack;
    NestedInteger nextElement;
​
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        stack.push(nestedList.iterator());
    }
​
    @Override
    public Integer next() {
        return nextElement.getInteger();
    }
​
    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()){
            //case1, //check if the element at peek has a next element, if not it has been traversed so pop
            if(!stack.peek().hasNext())
                stack.pop();
            //case2, // check if the peek next element is integer, next moves the iterator so storing the value in nextEl
            else if((nextElement = stack.peek().next()).isInteger())
                return true;
             //case3, // get the list and put an iterator and push to stack
            else
                stack.push(nextElement.getList().iterator());
        }
        return false;
    }
}
​
/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
