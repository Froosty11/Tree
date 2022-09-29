import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;

public class TreeIterator implements Iterator<Integer> {
    private BinaryTree.Node next;
    private Stack<BinaryTree.Node> stack;
    public TreeIterator(BinaryTree tree) {
        stack = new Stack<>();
        moveNodesToStack(tree.root);
        next = stack.pop();

    }
    @Override
    public boolean hasNext() {
        return (next != null);
    }
    @Override
    public Integer next() {
        Integer n = next.key;
        if(!stack.isEmpty())
        next = stack.pop();
        else
            next = null;
        return n;
    }
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
    public void moveNodesToStack(BinaryTree.Node root){
        BinaryTree.Node current = root;
        if(current.right != null)
        moveNodesToStack(current.right);
        stack.push(current);
        if(current.left != null)
            moveNodesToStack(current.left);
    }
}
