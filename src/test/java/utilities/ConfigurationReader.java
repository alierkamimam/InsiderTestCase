package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    private final static Properties CONFIGFILE;

    static {
        try {
            // Location of properties
            String path = System.getProperty("user.dir") + "/src/configuration.properties";
            // Getting this file as a stream
            FileInputStream input = new FileInputStream(path);
            // Creating an object of Properties class
            CONFIGFILE = new Properties();
            //  Loading information from the FileInputStream object into the Properties object with the load method.
            CONFIGFILE.load(input);
            // close the input FileInputStream
            input.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file!");
        }
    }

    /**
     * This method returns property value from configuration.properties file
     *
     * @param keyName property name
     * @return property value
     */
    public static String getProperty(String keyName) {
        return CONFIGFILE.getProperty(keyName);
    }
}
