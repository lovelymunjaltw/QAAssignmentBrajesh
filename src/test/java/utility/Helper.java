package utility;

import java.util.*;
import java.io.*;

public class Helper {

    static private Properties prop = null;

    public static void loadProperties (String propertyfile) {
        prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(propertyfile); // file name +  path
            // load a properties file
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getPropertyValue (String key) {
        return prop.getProperty(key);
    }
}