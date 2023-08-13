package inflearn.sec7;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeBFS {

    Queue<Node> q = new LinkedList<>();

    public int BFS(Node root) {
        int L = 0;
        q.add(root);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node cur = q.poll();
                if (cur.l == null && cur.r == null) return L;
                if (cur.l != null) q.add(cur.l);
                if (cur.r != null) q.add(cur.r);
            }
            L++;
        }
        return 0;
    }
    public static void main(String[] args) {

    }
}
