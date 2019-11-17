package lesson_08;

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

        // создание нового объекта
        SerializationObject serializationObject = new SerializationObject();
        System.out.println("create object " + serializationObject.toString());

        // сериализация объекте
        Serializer.serialize(serializationObject, file);

        // обнуление объекта и контроль того, что объект null
        serializationObject = null;
        if (serializationObject == null)
            System.out.println("object is null");
        else
            System.out.println("object is NOT null");

        // десериализация объекта
        serializationObject = (SerializationObject) Serializer.deSerialize(file);
        System.out.println("deserialize object " + serializationObject.toString());
    }

}
