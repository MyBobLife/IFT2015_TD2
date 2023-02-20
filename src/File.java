// Nom: Nathan Frenette
// Matricule: 20208608

public class File {
    public int[] elements;
    public int start;
    public int end;

    public File() {
        elements = new int[100];
        start = -1;
        end = -1;
        return;
    }

    // Implémenter à partir de la slide 44 de la démo
    public void push(int element) {
        end++;

        if (end == 100) {
            end = 0;
        }

        if (start == -1) {
            start = 0;
        }

        elements[end] = element;
    }

    // Implémenter à partir de la slide 45 de la démo
    public int pop() {

        if (start == -1) {
            System.out.println("Queue is empty");
        }

        int element = elements[start];

        if (start == end) {
            start = -1;
            end = -1;
        } else {
            start++;
            if (start == 100) {
                start = 0;
            }
        }
        return element;
    }

    public int length() {
        if (start == -1) {
            return 0;
        } else {
            return (end - start + 1) % 100;
        }
    }

    public void print() {
        if (start == -1) {
            System.out.println("Queue is empty");
            return;
        }

        for (int i = start; i != end; i = (i + 1) % 100) {
            System.out.println(elements[i] + ", ");
        }

        System.out.println(elements[end]);
        return;
    }

    // J'ai du changer un peu la signature de la fonction, car on ne savait pas
    // quel élément chercher.
    public boolean search(int value) {
        if (start == -1) {
            return false;
        }

        for (int i = start; i != end; i = (i + 1) % 100) {
            if (elements[i] == value) {
                return true;
            }
        }

        if (elements[end] == value) {
            return true;
        }

        return false;
    }

    public void remove(int value) {
        if (start == -1) {
            return;
        }

        int i = start;
        while (i != end) {
            if (elements[i] == value) {
                for (int j = i; j != end; j = (j + 1) % 100) {
                    elements[j] = elements[(j + 1) % 100];
                }
                end = (end - 1 + 100) % 100;
            } else {
                i = (i + 1) % 100;
            }
        }

        if (elements[end] == value) {
            end = (end - 1 + 100) % 100;
        }
    }
}
