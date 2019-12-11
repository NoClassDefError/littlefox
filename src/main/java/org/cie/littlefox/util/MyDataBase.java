package org.cie.littlefox.util;

import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class MyDataBase<T> {
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;
    private File file;

    public MyDataBase() {
        file = new File(MyDataBase.class.getResource("/user.txt").getFile());
        try {
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void save(T o) {
        try {
            file.delete();
            file.createNewFile();
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public T get() {
        T result = null;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            result = (T) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
