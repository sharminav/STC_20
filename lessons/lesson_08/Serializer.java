package lesson_08;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Phaser;

/**
 * Класс для выполнения сериализации и десерилизации объекта
 */

public class Serializer {

    /**
     * Метод для сериализации объекта
     * @param object объект
     * @param file имя файла для сохранения
     */
    public static void serialize (Object object, String file) {
        //Сериализация в файл с помощью класса ObjectOutputStream
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
     * Сериализаци при помощи рефлексии
     * @param object объект для сериализации
     * @param file имя файла для сохранения объекта
      */
    public static void serializeReflection (Object object, String file) {
        //Сериализация в файл с помощью класса ObjectOutputStream
        try {
            FileOutputStream fos = new FileOutputStream(file);
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field f : fields) {
                Class<? extends Object> obClass = object.getClass();
                Field f1 = obClass.getDeclaredField(f.getName());
                f1.setAccessible(true);
                String fieldString = f1.getName() + "!" + f1.get(object) + "!";
                //System.out.println(f1.getName() + " - "  + f1.get(object) + " - " + f1.getType().toString());
                //System.out.println(fieldString);
                saveTextToFileArrayList(fos, fieldString);
            }
            fos.close();
            System.out.println("serialize reflection success");
        }
        catch (NoSuchFieldException ex) {
            System.out.println(ex.getMessage());}
        catch (IllegalAccessException ex) {
            System.out.println(ex.getMessage());}
        catch (IOException ex) {
            System.out.println(ex.getMessage());}

    }


    /**
     * Запись файла
     * @param fos FileOutputStream для записи
     * @param field строка для записи в файл
     * @throws IOException
     */
    public static void saveTextToFileArrayList(FileOutputStream fos, String field)  {
       try {
           byte[] buffer = (field).getBytes();
           fos.write(buffer, 0, buffer.length);
       }
       catch (IOException ex) {
           System.out.println(ex.getMessage());}

    }

    /**
     * Метод для десериализации объекта
     * @param file имя файла, хранящего объект
     * @return объект их файла
     */
    public static Object deSerialize(String file)
    {
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

    /**
     * Десериализация при помощи рефлексии
     * @param file имя файла с объектом
     * @return объект
     */
    public static Object deSerializeReflection(String file) {
        Object result = new SerializationObject();

        SerializationObject serializationObject = new SerializationObject();
        String str = "";
        String[] arr = null;

        // чтение из файла
        try (FileInputStream fin = new FileInputStream(file)) {
            byte[] buffer = new byte[fin.available()];
            fin.read(buffer, 0, buffer.length);
            str = new String(buffer, "Windows-1251");
            arr = str.split("!");

        } catch (IOException  ex) {
            System.out.println(ex.getMessage());
        }

        // заполнение полей через рефлексию
        for (int i = 0; i < arr.length; i = i + 2) {
            try {
                Field f = serializationObject.getClass().getDeclaredField(arr[i]);
                f.setAccessible(true);
                //System.out.println(f.getType());

                // обработка примитивных типов
                if (f.getType().toString().compareTo("int") == 0) {
                    f.setInt(serializationObject, Integer.parseInt(arr[i + 1]));
                }
                else if (f.getType().toString().compareTo("boolean") == 0) {
                    f.setBoolean(serializationObject, Boolean.valueOf(arr[i + 1]));
                }
                else if (f.getType().toString().compareTo("char") == 0) {
                    f.setChar(serializationObject, arr[i + 1].charAt(0));
                }

                // обработка ссылочных типов
                else if (f.getType().toString().compareTo("class java.lang.Integer") == 0) {
                    f.set(serializationObject, Integer.parseInt(arr[i + 1]));
                }
                else if (f.getType().toString().compareTo("class java.lang.String") == 0) {
                    f.set (serializationObject, (Object) arr[i + 1]);
                }
                else if (f.getType().toString().compareTo("class java.util.ArrayList") == 0) {
                    // подготовка строки
                    arr[i + 1] = arr[i + 1].replace("[", "");
                    arr[i + 1] = arr[i + 1].replace("]", "");
                    ArrayList<String> strings = new ArrayList<String>(Arrays.asList(arr[i + 1].split(", ")));

                    // преобразование стпроки в список Integer
                    ArrayList<Integer> integers = new ArrayList<Integer>();
                    for (String str1 : strings) {
                        integers.add(Integer.parseInt(str1));
                    }
                    f.set(serializationObject, (Object) integers);
                }
            }
            catch (NoSuchFieldException ex ) {
                System.out.println(ex.getMessage());
            }
            catch (IllegalAccessException ex) {
                System.out.println(ex.getMessage());
            }

        }
        result = serializationObject;
        System.out.println("deserialize reflection success");
        return  result;
    }


}

