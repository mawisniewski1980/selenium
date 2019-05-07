package tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

import static exceptions.PropertiesMessageExceptions.NO_KEY_EXISTS;

public enum Property {

    INSTANCE;

    private static final Logger LOG = LoggerFactory.getLogger(Property.class);

    private Properties prop = new Properties();
    private String config = "config.properties";

    Property() {
        try (InputStream inputStream = Property.class.getClassLoader().getResourceAsStream(config)) {
            prop.load(inputStream);
        } catch (IOException  e) {
            e.printStackTrace();
        }
    }

    public String getPropertyValue(String key) {
        if(isPropertyExists(key)) {
            return prop.getProperty(key);
        } else {
            throw new IllegalStateException(MessageFormat.format(NO_KEY_EXISTS, key));
        }
    }

    private boolean isPropertyExists(String key) {
        return prop.get(key) != null;
    }
}
