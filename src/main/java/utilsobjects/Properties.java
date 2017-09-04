package utilsobjects;

import java.io.*;

public class Properties {

    private static java.util.Properties property = new java.util.Properties();
    private static String userPath = System.getProperty("user.dir");

    public static String getProperty(String key) {

        try (BufferedReader buffer = new BufferedReader(new FileReader(new File(userPath + "/src/main/resources/config.properties")))) {
            property.load(buffer);
            return property.getProperty(key);
        } catch (FileNotFoundException e) {
            //LOG.info("No file 'config.properties'");
            e.printStackTrace();
        } catch (IOException e) {
            //LOG.info("Connot read file 'config.properties'");
            e.printStackTrace();
        }
        return null;
    }

    public static String getBasePath() {
        return getProperty("basepathlogs");
    }
}
