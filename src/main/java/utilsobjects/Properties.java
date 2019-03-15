package utilsobjects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class Properties {

    static Logger logger = LoggerFactory.getLogger(Properties.class);


    private static java.util.Properties property = new java.util.Properties();
    private static String userPath = System.getProperty("user.dir");

    public static String getProperty(String key) {

        try (BufferedReader buffer = new BufferedReader(new FileReader(new File(userPath + "/src/main/resources/config.properties")))) {
            property.load(buffer);
            return property.getProperty(key);
        } catch (FileNotFoundException e) {
            logger.info("No file 'config.properties'");
            e.printStackTrace();
        } catch (IOException e) {
            logger.info("Connot read file 'config.properties'");
            e.printStackTrace();
        }
        return null;
    }

    public static String getBasePath() {
        return getProperty("basepathlogs");
    }
}
