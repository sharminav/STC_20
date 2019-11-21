package lesson_09;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Сервисные функции
 */
public class Service {

    private final static String fileName =  "E:\\YandexDisk\\АБЦТ_моя\\Обучение\\Java_2019\\STC_20\\lessons\\lesson_09\\WorkerClass.java";

    /**
     * Ввод данных с клавиатуры
     * @return строки, введенные с клавиатуры
     */
    public static List<String> getCode() {
        System.out.println("start getCode");
        List<String> stringArrayList = new ArrayList<String>();
        Scanner in = new Scanner(System.in);
        String str = "";
        do {
            System.out.print("input code of doWork method: ");
            str = in.nextLine();
            if (str.compareTo("") != 0) stringArrayList.add(str);

        } while (str.compareTo("") != 0);
        System.out.println("input rows: " + stringArrayList.toString());
        System.out.println("end getCode");
        return stringArrayList;
    }

    /**
     * Чтение данных из файла
     * @return содержимое файла в виде строки (без символов перевода строки)
     */
    public static String readFromFile() {
        System.out.println("start read file");
        String result = "";
        try (FileInputStream fin = new FileInputStream(fileName)) {
            byte[] buffer = new byte[fin.available()];
            // считываем буфер
            fin.read(buffer, 0, buffer.length);
            result = new String(buffer, "UTF-8");
            System.out.println("end read file");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    /**
     * Добавление строк в файл
     * @param newRows список строк
     * @param oldRows исходный файл
     * @return исходный файл с добавленными строками
     */
    public static String replaceInFile(List<String> newRows, String oldRows){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("//TODO: new lines").append("\r\n");
        for (String str : newRows) {
            stringBuilder.append("\t\t").append(str).append(";").append("\r\n");
        }
        //saveTextToFile(fileName, originalFile.getBytes());//
        String newString = oldRows.replace("//TODO: new lines", stringBuilder.toString());
        return newString;
    }

    /**
     * Сохранение ArrayList в файл
     * @param filePath адрес и имя файла
     * @param bytes текст, конвертированный в массив байт
     */
    public static void saveTextToFile(String filePath, byte[] bytes) {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(bytes, 0, bytes.length);
            System.out.println("Успешная запись в файл: " + filePath);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
