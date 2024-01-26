package com.prog2.main.Process;

import java.io.File;

/**
 * This class is used to connect to the database
 * 
 * @author Jiucheng Zang
 * @version 1.0
 * @since 2023-03-26
 * 
 */

public class IOConnect {

    /**
     * @param fileDir
     * @return Database
     */
    public static Database connect(String fileDir) {
        return (Database) SerializationData.deserializeData(fileDir);
    }

    /**
     * @param database
     */
    public static void save(Database database) {
        SerializationData.serializeData(database, database.getFileDir());
    }

    /**
     * @param fileDir
     */
    public static void delete(String fileDir) {
        new File(fileDir).delete();
    }

    /**
     * @param database
     */
    public static void delete(Database database) {
        new File(database.getFileDir()).delete();
    }

    /**
     * @param database
     * @return Database
     */
    public static Database update(Database database) {
        return (Database) SerializationData.deserializeData(database.getFileDir());
    }

}