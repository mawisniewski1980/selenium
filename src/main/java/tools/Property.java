package tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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

    public String getProp(String key) {
        return isPropertyExists(key) ? prop.getProperty(key) : null;
    }

    private boolean isPropertyExists(String key) {
        return prop.get(key) != null;
    }
}
