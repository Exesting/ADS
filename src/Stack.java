public class Stack {
    private StackNode root;
    private int size;

    public Stack() {
        this.root = null;
        this.size = 0;
    }

    public Stack(StackNode root) {
        this.root = root;
        this.size = 1;
    }

    public StackNode getRoot() {
        return this.root;
    }

    public void add(StackNode node) {
        if (node != null) {
            node.setPrevious(this.root);
            this.root = node;
            this.size++;
        }
    }

    public void remove() {
        if (this.root == null) {
            return;
        }
        StackNode result = this.root;
        this.root = root.getPrevious();
        this.size--;
    }

    public StackNode get(int value) {
        StackNode current = this.root;
        while (current != null && current.getValue() != value) {
            current = current.getPrevious();
        }
        return current;
    }

    public int getSize() {
        return this.size;
    }
}