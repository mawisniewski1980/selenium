package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class Property {

    private static Property ourInstance = new Property();
    private Properties prop = new Properties();

    public static Property getInstance() {
        return ourInstance;
    }

    private Property() {
        try (InputStream inputStream = Property.class.getClassLoader().getResourceAsStream("config.properties")) {
            prop.load(inputStream);
        } catch (IOException  e) {
            e.printStackTrace();
        }
    }

    public String getProp(String key) {
        return prop.getProperty(key);
    }
}
