package utilsobjects;

import org.apache.logging.log4j.LogManager;

import java.io.*;
import java.util.Properties;
import java.util.logging.Logger;

public class OProperties {


    private static final org.apache.logging.log4j.Logger LOG = LogManager.getLogger("OProperties");

    private Properties property = new Properties();
    private String userPath = System.getProperty("user.dir");

    public String getProperty(String key) {

        try (BufferedReader buffer = new BufferedReader(new FileReader(new File(userPath + "/src/main/resources/config.properties")))) {
            property.load(buffer);
            return property.getProperty(key);
        } catch (FileNotFoundException e) {
            LOG.info("No file 'config.properties'");
            e.printStackTrace();
        } catch (IOException e) {
            LOG.info("Connot read file 'config.properties'");
            e.printStackTrace();
        }
        return null;
    }
}
