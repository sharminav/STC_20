package lesson_08;

import java.io.IOException;

/**
 * Задание 1. Необходимо разработать класс, реализующий следующие методы:
 * void serialize (Object object, String file);
 * Object deSerialize(String file);
 * Методы выполняют сериализацию объекта Object в файл file и десериализацию объекта из этого файла. Обязательна сериализация и десериализация "плоских" объектов (все поля объекта - примитивы, или String).
 *
 * Задание 2. Предусмотреть работу c любыми типами полей (полями могут быть ссылочные типы)
 */
public class Test {

    public static void main(String[] args) {
        // имя файла для записи и чтения
        String file = "C://temp//object.txt";
        String file1 = "C://temp//object_reflection.txt";

        // создание нового объекта
        SerializationObject serializationObject = new SerializationObject();
        System.out.println("create object " + serializationObject.toString());

        // сериализация объектa
        Serializer.serialize(serializationObject, file);
        // обнуление объекта
        objectToNull(serializationObject);
        // десериализация объекта
        serializationObject = (SerializationObject) Serializer.deSerialize(file);
        System.out.println("deserialize object " + serializationObject.toString());

        // сериализация объектa при помощи рефлексии
        Serializer.serializeReflection(serializationObject, file1);
        // обнуление объекта
        objectToNull(serializationObject);
        // десериализация объекта при помощи рефлексии
        serializationObject = (SerializationObject) Serializer.deSerializeReflection(file1);

        System.out.println("deserialize reflection object " + serializationObject.toString());

    }

    /**
     * Обнуление объекта
      * @param serializationObject объект
     */
    private static void objectToNull(Object serializationObject) {
        // обнуление объекта и контроль того, что объект null
        serializationObject = null;
        if (serializationObject == null)
            System.out.println("object is null");
        else
            System.out.println("object is NOT null");
    }

}
