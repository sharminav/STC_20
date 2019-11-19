package lesson_08;

import java.io.Serializable;
import java.util.Random;

/**
 * Дочерний клас для сериализации
 */
public class SerializationObjectChild implements Serializable
{
    public int childIntField;
    private char childCharField;

    public SerializationObjectChild() {
        childCharField = (char)((new Random()).nextInt(26) + 'a');;
        childIntField = (int)(Math.random() * 10000);
    }

    @Override
    public String toString() {
        return "SerializationObjectChild{" +
                "childCharField=" + childCharField +
                ", childIntField=" + childIntField +
                '}';
    }

}
