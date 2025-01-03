package main.strategies.binarytree;

public class NodeTree <T extends Object> {

    private T value;
    private int i;
    private int j;

    private NodeTree<T> right;
    private NodeTree<T> left;

    public NodeTree() {}
    public NodeTree(T value, int i, int j) {
        super();
        this.value = value;
        this.setI(i);
        this.setJ(j);
    }

    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
    public NodeTree<T> getRight() {
        return right;
    }
    public void setRight(NodeTree<T> right) {
        this.right = right;
    }
    public NodeTree<T> getLeft() {
        return left;
    }
    public void setLeft(NodeTree<T> left) {
        this.left = left;
    }
    public int getI() {
        return i;
    }
    public int getJ() {
        return j;
    }
    public void setI(int i) {
        this.i = i;
    }
    public void setJ(int j) {
        this.j = j;
    }

    public boolean isNILL() {
        return this.getValue() == null;
    }
}