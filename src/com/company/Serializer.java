package com.company;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

public class Serializer implements Serializable {
    public static void serialize(Object object, String fileName, Class<?> clazz) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
        fileOutputStream.close();
    }

    public static Object deserialize(String fileName, Class<?> clazz) throws IOException, ClassNotFoundException {
        File file = new File(fileName);
        System.out.println("file");
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("new file");

        }
        FileInputStream fileInputStream = new FileInputStream(file);
        System.out.println("file input stream");
        if (file.length() == 0) {
            try {
                System.out.println("no file new instance");
                fileInputStream.close();
                return clazz.getDeclaredConstructor().newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } else {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            System.out.println("object input stream");
            Object object = clazz.cast(objectInputStream.readObject());
            System.out.println("new object with data");
            objectInputStream.close();
            fileInputStream.close();
            return object;
        }
        return null;
    }
}
