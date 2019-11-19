package lesson_08;

import java.io.*;

/**
 * Класс для сериализации/десериалищации без использования рефлексии
 */
public class Serializer2 implements SerializerInterface {

    /**
     * Метод для сериализации объекта
     * @param object объект
     * @param file имя файла для сохранения
     */
    @Override
    public void serialize(Object object, String file) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
            System.out.println("serialize success");
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Метод для десериализации объекта
     * @param file имя файла, хранящего объект
     * @return объект их файла
     */
    @Override
    public Object deSerialize(String file) {
        // Востановление из файла с помощью класса ObjectInputStream
        Object result = new Object();
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream(file));
            result = (SerializationObject) objectInputStream.readObject();
            objectInputStream.close();
            System.out.println("deserialize success");
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }
}
