package lesson_08;

import lesson_06.SaveTextToFile;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Phaser;

/**
 * Класс для выполнения сериализации и десерилизации объекта
 */

public class Serializer  implements SerializerInterface{

    /**
     * Сериализаци при помощи рефлексии
     * @param object объект для сериализации
     * @param file имя файла для сохранения объекта
      */
    public void serialize (Object object, String file) {
        //Сериализация в файл с помощью класса ObjectOutputStream
        try {
            FileOutputStream fos = new FileOutputStream(file);
            serialize(object, fos, "");
            fos.close();
            System.out.println("serialize reflection success");
        }

        catch (IOException ex) {
            System.out.println(ex.getMessage());}

    }

    public void serialize (Object object, FileOutputStream fos, String parentClass) {
        try {
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field f : fields) {
                Class<? extends Object> obClass = object.getClass();
                Field f1 = obClass.getDeclaredField(f.getName());
                f1.setAccessible(true);
                String fieldString = "";
                if (f1.getType().toString().compareTo("class lesson_08.SerializationObjectChild") != 0) {
                    fieldString = f1.getName() + "!" + f1.get(object) + "!";
                }
                else {
                    serialize(f1.get(object), fos, f1.getName()+ "." );
                }
                //System.out.println(f1.getName() + " - " + f1.get(object) + " - " + f1.getType().toString());
                SaveObjectToFile.save(fos, fieldString);
            }
        }
        catch (NoSuchFieldException ex) {
            System.out.println(ex.getMessage());}
        catch (IllegalAccessException ex) {
            System.out.println(ex.getMessage());}
    }


    /**
     * Десериализация при помощи рефлексии
     * @param file имя файла с объектом
     * @return объект
     */
    public Object deSerialize(String file) {
        Object result = new SerializationObject();

        SerializationObject serializationObject = new SerializationObject();
        SerializationObjectChild serializationObjectChild = new SerializationObjectChild();

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

        Field f = null;
        // заполнение полей через рефлексию
        for (int i = 0; i < arr.length; i = i + 2) {
            try {
                if (arr[i].indexOf("child") == -1)
                    f = serializationObject.getClass().getDeclaredField(arr[i]);
                else
                    f = serializationObjectChild.getClass().getDeclaredField(arr[i]);
                f.setAccessible(true);

                // обработка примитивных типов
                if (f.getType().toString().compareTo("int") == 0) {
                    if (arr[i].indexOf("child") == -1) f.setInt(serializationObject, Integer.parseInt(arr[i + 1]));
                    else f.setInt(serializationObjectChild, Integer.parseInt(arr[i + 1]));
                }
                else if (f.getType().toString().compareTo("boolean") == 0) {
                    if (arr[i].indexOf("child") == -1) f.setBoolean(serializationObject, Boolean.valueOf(arr[i + 1]));
                    else f.setBoolean(serializationObjectChild, Boolean.valueOf(arr[i + 1]));
                }
                else if (f.getType().toString().compareTo("char") == 0) {
                    if (arr[i].indexOf("child") == -1) f.setChar(serializationObject, (arr[i + 1]).charAt(0));
                    else f.setChar(serializationObjectChild, (arr[i + 1]).charAt(0));
                }
            }
            catch (NoSuchFieldException | IllegalAccessException ex ) {
                System.out.println("ERROR NoSuchFieldException " + ex.getMessage());
            }
        }
        serializationObject.objectFiled = serializationObjectChild;
        result = serializationObject;
        System.out.println("deserialize reflection success");
        return  result;
    }


}

