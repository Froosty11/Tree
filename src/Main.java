import com.sun.source.tree.Tree;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.addNode(5,105);
        tree.addNode(2,102);
        tree.addNode(7,107);
        tree.addNode(1,101);
        tree.addNode(8,108);
        tree.addNode(6,106);
        tree.addNode(3,103);

        BinaryTree.printDebug(tree.root, 0);
        for (int i : tree)
            System.out.println("next value " + i);



    }
}
