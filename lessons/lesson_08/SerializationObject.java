package lesson_08;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Класс для сериализации и десериализации
 */
public class SerializationObject implements Serializable {

    private int intField;
    public boolean booleanField;
    public SerializationObjectChild objectFiled;

    // Поля убраны для уменьшения кода
    //public char charField;
    //public String stringField;
    //public Integer intField1;
    //private ArrayList<Integer> arrayListFiled;

    public SerializationObject() {
        intField = (int)(Math.random() * 10000);
        booleanField = false;
        objectFiled = new SerializationObjectChild();

        // Поля убраны для уменьшения кода
        //charField = 'b';
        //stringField = "Crocodile" + intField;
        //intField1 = (int)(Math.random() * 10000);
        //arrayListFiled = new ArrayList<Integer>();
        //arrayListFiled.add((int)(Math.random() * 10000));
        //arrayListFiled.add((int)(Math.random() * 10000));
    }

    @Override
    public String toString() {

        //StringBuilder str = new StringBuilder();
        //for (Integer n: arrayListFiled) {
        //    str.append(n.toString() + ", ");
        //}
        //str.deleteCharAt(str.length() - 1);
        //str.deleteCharAt(str.length() - 1);

        return "SerializationObject{" +
                "intField=" + intField +
                ", booleanField=" + booleanField +
                ", objectFiled=" + objectFiled.toString() +
                //", charField=" + charField +
                //", stringField=" + stringField +
                //", intField1=" + intField1 +
                //", arrayListFiled=[" + str  + "]" +
                '}';
    }


}
