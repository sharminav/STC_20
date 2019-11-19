package lesson_08;

/**
 * Интерфейс, описывающий класс сериализации/десериализации
 */
public interface SerializerInterface {

    public void serialize (Object object, String file);
    public Object deSerialize(String file);

}
