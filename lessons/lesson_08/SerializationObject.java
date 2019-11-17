package lesson_08;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Класс для сериализации и десериализации
 */
public class SerializationObject implements Serializable {

    public int intField;
    public boolean booleanField;
    public char charField;

    public Integer intField1;
    public ArrayList<Integer> arrayListFiled;

    private static final long serialVersionUID = 1L;

    public SerializationObject() {
        intField = (int)(Math.random() * 10000);
        booleanField = true;
        charField = 'a';

        intField = (int)(Math.random() * 10000);
        arrayListFiled = new ArrayList<Integer>();
        arrayListFiled.add((int)(Math.random() * 10000));
        arrayListFiled.add((int)(Math.random() * 10000));
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();
        for (Integer n: arrayListFiled) {
            str.append(n.toString() + " ");
        }

        return "SerializationObject{" +
                "intField=" + intField +
                ", booleanField=" + booleanField +
                ", charField=" + charField +
                ", intField1=" + intField1 +
                ", arrayListFiled=[" + str  + "]" +
                '}';
    }


}
