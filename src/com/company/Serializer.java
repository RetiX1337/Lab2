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
        if (!file.exists()) {
            file.createNewFile();

        }
        FileInputStream fileInputStream = new FileInputStream(file);
        if (file.length() == 0) {
            fileInputStream.close();
            return object;
        } else {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            object.readExternal(objectInputStream);
            objectInputStream.close();
            fileInputStream.close();
            return object;
        }
    }
}
