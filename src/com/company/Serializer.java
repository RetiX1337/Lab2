package com.company;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

public class Serializer {
    public static void serialize(Externalizable object, String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        object.writeExternal(objectOutputStream);
        objectOutputStream.close();
        fileOutputStream.close();
    }

    public static <T extends Externalizable> T deserialize(T object, String fileName) throws IOException, ClassNotFoundException {
        File file = new File(fileName);
        System.out.println("file");
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("new file");

        }
        FileInputStream fileInputStream = new FileInputStream(file);
        System.out.println("file input stream");
        if (file.length() == 0) {
            System.out.println("no file new instance");
            fileInputStream.close();
            return object;
        } else {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            System.out.println("object input stream");
            object.readExternal(objectInputStream);
            System.out.println("new object with data");
            objectInputStream.close();
            fileInputStream.close();
            return object;
        }
    }
}
