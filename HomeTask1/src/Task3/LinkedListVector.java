package Task3;

import java.io.Serializable;

public class LinkedListVector implements Vector, Serializable {
    //Ссылка на голову связного списка.
    private Node head = new Node();
    //Текущая длина связного списка.
    private int size = 0;
    //Ссылка на последний использовавшийся элемент связного списка.
    private Node current = head;
    /*Номер последнего использовавшиегося элемента связного списка. Значение "-1" соответствует голове.*/
    private int currentIndex = -1;

    /*блок инициализации, зацикливающий ссылки головы списка в момент создания объекта.*/ {
        head.prev = head;
        head.next = head;
    }

    public LinkedListVector(int _size) {
        for (int i = 0; i < _size; i++) {
            addElement(Math.random() * 100);

        }
    }

    /*Вспомогательный метод доступа к элементу списка.
       Должен использоваться для доступа из всех остальных методов, т.к. реализует механизм "памяти". index - номер требующегося элемента*/
    private Node gotoNumber(int index) throws VectorIndexOutOfBoundsException {
        if ((index >= 0) && (index < size)) {
            if (index < currentIndex) {
                if (index < currentIndex - index) {
                    current = head;
                    for (int i = -1; i < index; i++)
                        current = current.next;
                } else {
                    for (int i = currentIndex; i > index; i--)
                        current = current.prev;
                }
            } else {
                if (index - currentIndex < size - index) {
                    for (int i = currentIndex; i < index; i++)
                        current = current.next;
                } else {
                    current = head;
                    for (int i = size; i > index; i--)
                        current = current.prev;
                }
            }
            currentIndex = index;
            return current;
        } else
            throw new VectorIndexOutOfBoundsException();
    }

    public double getElement(int index) {
        Node node = null;
        try {
            node = gotoNumber(index);
        } catch (VectorIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return node.value;

    }

    public void addElement(double element) {
        Node node = new Node();
        node.value = element;
        node.next = head;
        node.prev = head.prev;
        head.prev.next = node;
        head.prev = node;
        size++;
    }

    public void deleteElement(int index) {
        Node node;
        try {
            node = gotoNumber(index);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
            currentIndex = -1;
            current = head;
            size--;
        } catch (VectorIndexOutOfBoundsException e) {
            System.out.println("Такого индекса нет, братишка. Хочешь я тебе лучше поесть принесу?");
        }
    }

    public void getAllElements() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s = s + getElement(i) + " ";
        }
        System.out.println(s);
    }

   /* public void addElement(int index, double element) {

        try {
            Node node = new Node();
            node.next = gotoNumber(index);
            node.prev = gotoNumber(index - 1);
            gotoNumber(index + 1).prev = node;
            gotoNumber(index - 1).next = node;
            node.value = element;
            size++;
        } catch (VectorIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

    }*/

    public int getSize() {
        return size;
    }

    /**
     * @return возвращает эвклидову норму чисел в массиве
     */
    public double getNorm() {
        int norm = 0;
        for (int i = 0; i < size; i++) {
            norm += getElement(i) * getElement(i);
        }
        return Math.sqrt(norm);
    }

    public void setElement(int index, double element) {
        try {
            Node node = gotoNumber(index);
            node.value = element;
        } catch (VectorIndexOutOfBoundsException e) {
            System.out.println("Такого индекса нет, братишка. Хочешь я тебе лучше поесть принесу?");
        }
    }

    //Вспомогательный внутренний класс, реализует элемент связного списка.
    private class Node implements Serializable {
        //Значение, которое хранит элемент связного списка.
        double value = Double.NaN;
        //Ссылка на предыдущий элемент связного списка.
        Node prev = null;
        //Ссылка на следующий элемент связного списка.
        Node next = null;

    }


}
