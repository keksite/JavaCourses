package Task2;

import java.util.ArrayList;

public class LinkedListVector {
    private int _size;

    public LinkedListVector(int _size) {
        this._size = _size;
        for (int i = 0; i < _size ; i++) {
            addElement(Math.random() *100);

        }
    }

    //Вспомогательный внутренний класс, реализует элемент связного списка.
    private class Node {
        //Значение, которое хранит элемент связного списка.
        double value = Double.NaN;
        //Ссылка на предыдущий элемент связного списка.
        Node prev = null;
        //Ссылка на следующий элемент связного списка.
        Node next = null;
    }

    //Ссылка на голову связного списка.
    private Node head = new Node();

    /*блок инициализации, зацикливающий ссылки головы списка в момент создания объекта.*/ {
        head.prev = head;
        head.next = head;
    }

    //Текущая длина связного списка.
    private int size = 0;
    //Ссылка на последний использовавшийся элемент связного списка.
    private Node current = head;
    /*Номер последнего использовавшиегося элемента связного списка. Значение "-1" соответствует голове.*/
    private int currentIndex = -1;

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

    public double getElement(int index){
        Node node = null;
        try {
            node = gotoNumber(index);
        } catch (VectorIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return node.value;

    }

    public void addElement(double element) {
        size++;
        currentIndex++;
        Node node = new Node();
        node.value = element;
        node.prev = current;
        node.next = head;
        current.next = node;
        head.prev = node;
        current = node;

    }
    public void deleteElement(int index){
        Node node;
        Node previousNode;
        Node nextNode;
        try {
            if( index == size-1 && index != 0 ){

                node = gotoNumber(index);
                previousNode = gotoNumber(index -1);
                previousNode.next = head;
                head.prev = previousNode;
                current = previousNode;
                node.next = null;
                node.prev = null;
                size--;
            }
            else if ( index == 0 && size == 1){

                current = head;
                head.prev = head;
                head.next = head;
                node = gotoNumber(index);
                node.next = null;
                node.prev = null;
                size --;
            }
            else if ( index == 0 && size > 1){
                node = gotoNumber(index);
                nextNode = gotoNumber(index + 1);
                nextNode.prev = head;
                head.next = nextNode;
                node.next = null;
                node.prev = null;
                size --;
            }
            else{
                previousNode = gotoNumber(index - 1);
                nextNode = gotoNumber(index + 1);
                previousNode.next = nextNode;
                nextNode.prev = previousNode;
                size --;
            }


        } catch (VectorIndexOutOfBoundsException e) {
            System.out.println("Такого индекса нет братишка. Хочешь я тебе лучше поесть принесу?");
        }
    }

    public void getAllElements(){
        String s = "";
        for (int i = 0; i < size ; i++) {
            s = s + getElement(i) + " ";
        }
        System.out.println(s);
    }

    public int getSize() {
        return size;
    }

    /**
     * @return возвращает эвклидову норму чисел в массиве
     */
    public double getNorm() {
        int norm = 0;
        for (int i = 0; i <size ; i++) {
            norm += getElement(i) * getElement(i);
        }
        return  Math.sqrt(norm);
    }
}
