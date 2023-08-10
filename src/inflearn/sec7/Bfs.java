package inflearn.sec7;

import java.util.LinkedList;
import java.util.Queue;

public class Bfs {

    Node root;

    public void BFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int L = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            System.out.print(L + " : ");
            for (int i = 0; i < len; i++) {
                Node cur = queue.poll();
                System.out.print(cur.getData() + " ");
                if (cur.l != null) queue.offer(cur.l);
                if (cur.r != null) queue.offer(cur.r);
            }
            L++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Bfs D = new Bfs();

        D.root = new Node(1);
        D.root.l = new Node(2);
        D.root.r = new Node(3);

        D.root.l.l = new Node(4);
        D.root.l.r = new Node(5);

        D.root.r.l = new Node(6);
        D.root.r.r = new Node(7);

        D.BFS(D.root);
    }
}
