package inflearn.sec7;

class Node {
    protected int data;
    Node l;
    Node r;

    public Node(int data) {
        this.data = data;
    }
}


public class DfsMain2 {
    Node root;

    public void twoTree(Node root) {
        if (root == null) {
            return;
        } else {
            twoTree(root.l);
            System.out.print(root.data + " ");
            twoTree(root.r);
        }
    }
    public static void main(String[] args) {
        DfsMain2 D = new DfsMain2();

        D.root = new Node(1);
        D.root.l = new Node(2);
        D.root.r = new Node(3);

        D.root.l.l = new Node(4);
        D.root.l.r = new Node(5);

        D.root.r.l = new Node(6);
        D.root.r.r = new Node(7);

        D.twoTree(D.root);
    }
}
