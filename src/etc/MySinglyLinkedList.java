package etc;

public class MySinglyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;

    int size;

    public void addFirst(E data) {
        //1. 헤드 가져옴
        Node<E> first = head;
        //2. 새로운 노드 생성 후 헤드와 연결
        Node<E> newNode = new Node<>(data, first);
        //3. 사이즈 증가
        size += 1;
        //4. head 변경
        head = newNode;
        //5. 만약 빈 리스트였다면 tail도 자동으로 head가 됨
        if (first == null) {
            tail = newNode;
        }
    }

    public void addLast(E data) {
        Node<E> last = tail;
        Node<E> newNode = new Node<>(data, null);

        size += 1;

        tail = newNode;

        if (tail == null) {
            head  = newNode;
        } else {
            tail.next = newNode;
        }
    }

    public void add(int index, E data) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        if (index == size - 1) {
            addLast(data);
            return;
        }


    }

    private Node<E> search(int index) {
        Node<E> n = head;

        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        return n;
    }

    private static class Node<E> {

        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }
}
