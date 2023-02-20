// Nom: Nathan Frenette
// Matricule: 20208608

public class Node {
    private int value;
    private Node next = null;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public void addValue(int value) {
        if (this.next == null) {
            this.next = new Node(value);
        } else {
            this.next.addValue(value);
        }
    }

    public void addNode(Node next) {
        if (this.next == null) {
            this.next = next;
        } else {
            this.next.addNode(next);
        }
    }

    public void removeLast() {
        if (next == null) {
            return;
        }

        else if (this.next.next == null) {
            this.next = null;
        }

        else {
            this.next.removeLast();
        }
    }

    public void removeValue(int value) {
        if (this.next == null) {
            return;
        }

        else if (this.value == value) {
            if (this.next == null) {
                removeLast();
            } else {
                this.value = this.next.value;
                this.next = this.next.next;
            }
        }

        else {
            this.next.removeValue(value);
        }
    }

    public int length_iteratif() {
        int counter = 0;
        Node presentNode = this;

        while (presentNode != null) {
            counter++;
            presentNode = presentNode.next;
        }

        return counter;
    }

    public int length_recurssion() {
        if (next == null) {
            return 1;
        } else {
            return 1 + next.length_recurssion();
        }
    }

    public int returnNlast(int nLast) {
        int len = length_iteratif();
        int nSart = len - nLast;
        Node presentNode = this;

        while (nSart != 0) {
            nSart--;
            presentNode = presentNode.next;
        }

        return this.value;
    }

    public void addValue_ordered(int value) {
        if (this.next == null) {
            this.addValue(value);
        } else if (value < this.next.value) {
            this.next = new Node(value, this.next);
        } else {
            this.next.addValue_ordered(value);
        }
    }

    public void insertSort() {
        int len = length_iteratif();
        Node presentNode = this;

        while (len != 0) {
            this.addValue_ordered(presentNode.value);
            presentNode = presentNode.next;

            len--;
        }

    }
}
