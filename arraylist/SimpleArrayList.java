package ru.ae.arraylist;

import ru.ae.linkedlist.IndexExceedsSizeLengthException;
import ru.ae.linkedlist.OneLinkedList;

import java.util.Arrays;

public class SimpleArrayList {
    private int count = 0;
    private int[] array = new int[1];

    public void add(int val) {
        if (count == array.length - 1)
            resize(array.length * 2);
        array[count++] = val;
    }

    private void resize(int newLength) {
        int[] newArray = new int[newLength];
        System.arraycopy(array, 0, newArray, 0, count);
        array = newArray;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) stringBuilder.append(array[i] + ",");
        return "SimpleArrayList[" + stringBuilder.deleteCharAt(stringBuilder.length() - 1) + ']';
    }

    public int size() {
        return count;
    }

    public void add(int index, int val) {
        if (index > count) {
            throw new IndexExceedsSizeLengthException(String.format("Index %s cannot be more than real size %s", index, count));
        }
        if (index == count) {
            add(val);
            return;
        }
        resize(array.length + 1);
        for (int i = (count + 1); i > index; i--) array[i] = array[i - 1];

        array[index] = val;
        count++;
    }

    public void remove(int index) {
        if (index >= count) {
            throw new IndexExceedsSizeLengthException(String.format("Index %s cannot be more than or equal to real size %s", index, count));
        }
        if (index < 0) {
            throw new IndexExceedsSizeLengthException(String.format("Index %s cannot be less than 0", index, count));
        }
        if (index == count) {
            array[index] = 0;
            count--;
            return;
        }
        for (int i = index; i < count; i++) array[i] = array[i + 1];
        count--;
    }

    public void set(int index, int val) {
        if (index >= count) {
            throw new IndexExceedsSizeLengthException(String.format("Index %s cannot be more than or equal to real size %s", index, count));
        }
        if (index < 0) {
            throw new IndexExceedsSizeLengthException(String.format("Index %s cannot be less than 0", index, count));
        }
        array[index] = val;
    }


}
