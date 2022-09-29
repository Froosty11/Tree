import java.util.Iterator;

public class BinaryTree implements Iterable<Integer> {

    Node root;

    public BinaryTree() {
        root = null;
    }
    @Override
    public Iterator<Integer> iterator() {
        return new TreeIterator(this);
    }


    public class Node {
        public Integer key;
        public Integer value;
        public Node left, right;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }

    }
    public void addNode(Integer key, Integer value){
        if(root == null){
            root = new Node(key, value);
            return;
        }
        Node current = root;
        while((current.left != null && current.right != null) || current.key == key){//finds a leaf since leafs dont have branches

            if(current.key == key){
                current.value = value;
            }
            else if(key > current.key){
                current = current.right;
            }
            else{
                current = current.left;
            }
        }
        if(key > current.key) current.right = new Node(key, value);
        else current.left = new Node(key, value);
    }
    public Integer lookup(Integer key){
        Node current = root;
        while((current.left != null && current.right != null) || current.key == key){//finds a leaf since leafs dont have branches

            if(current.key == key){
                return current.value;
            }
            else if(key < current.key){
                current = current.left;
            }
            else{
                current = current.right;
            }
        }
        return null;
    }
    static void printDebug(Node currentNode, int space)
    {
        //iterates and prints recursively through a depth first iteration
        int COUNT = 8;
        if (currentNode == null)
            return;
        space += COUNT;

        //left child
        printDebug(currentNode.left, space);

        // spams space
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(currentNode.value + "\n");

        //right child
        printDebug(currentNode.right, space);
    }


}

