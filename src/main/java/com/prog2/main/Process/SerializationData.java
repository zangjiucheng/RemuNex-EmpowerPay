package com.prog2.main.Process;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * This class is used to serialize and deserialize the data
 * 
 * @author Jiucheng Zang
 * @version 1.0
 * @since 2023-03-26
 * 
 */

public class SerializationData {

    /**
     * @param obj
     * @param path
     */
    static public void serializeData(Object obj, String path) {
        try (FileOutputStream fos = new FileOutputStream(path)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
        } catch (Exception e) {
            throw new IllegalArgumentException("The object is not serializable");
        }
    }

    /**
     * @param path
     * @return Object
     */
    public static Object deserializeData(String path) {
        Object obj = null;
        try (FileInputStream fis = new FileInputStream(path)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            obj = ois.readObject();
        } catch (IOException e) {
            System.out.println(e.getClass() + ": " + e.getMessage());
            throw new IllegalArgumentException("The path is not correct");
        } catch (Exception e) {
            System.out.println(e.getClass() + ": " + e.getMessage());
            throw new IllegalArgumentException("The object is not deserializable");
        }
        return obj;
    }
}
