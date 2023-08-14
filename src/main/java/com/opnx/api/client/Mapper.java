package com.opnx.api.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Converts json to java object and vice versa
 */

public class Mapper {
    private static Logger logger = Logger.getLogger(Mapper.class.getName());
    private static ObjectMapper mapper = new ObjectMapper();


    /**
     * @param json  string in json-format
     * @param clazz class of object for converting from json to java object
     * @param <T>   lass of object for converting from json to java object
     * @return      an object with object type and data from json
     */
    public static <T> T asObject(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (IOException e) {
            logger.error("asObject error: ", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * @param message java object with json fields
     * @return an string in json-format
     */
    public static String asString(Object message) {
        try {
            return mapper.writeValueAsString(message);
        } catch (IOException e) {
            logger.error("asString error: ", e);
            throw new RuntimeException(e);
        }
    }
}
