package people;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class StackOfStrings {
    private ArrayList<String> data;
    private int lastElementIndex;  //extension

    public StackOfStrings() {
        this.data = new ArrayList<>();  // kompyziciq  - kompusition
        this.lastElementIndex = -1;
    }

    public void push(String element) {
        lastElementIndex++;     // tova e extension - nasha logika
        this.data.add(element);   // delegaciq
    }

    public String pop() {
        ensureNonEmpty();

        return this.data.remove(this.lastElementIndex--);     //delegaciq
    }

    public String peek() {
        ensureNonEmpty();
        return this.data.get(this.lastElementIndex);  // delegaciq sushto
    }

    private void ensureNonEmpty() {
        if (this.lastElementIndex < 0) {
            throw new NoSuchElementException("No such element");
        }
    }

    public boolean isEmpty() {
        return this.data.isEmpty();  //delegaciq
    }
}
