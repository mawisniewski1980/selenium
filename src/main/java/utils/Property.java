package utils;

import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public enum Property {

    INSTANCE;

    private static final Logger LOG = LoggerFactory.getLogger(Property.class);

    private Properties prop = new Properties();

    Property() {
        try (InputStream inputStream = Property.class.getClassLoader().getResourceAsStream("config.properties")) {
            prop.load(inputStream);
        } catch (IOException  e) {
            e.printStackTrace();
        }
    }

    public String getProp(String key) {
        return isPropertyExists(key) ? prop.getProperty(key) : null;
    }

    private boolean isPropertyExists(String key) {
        return prop.get(key) != null;
    }
}
