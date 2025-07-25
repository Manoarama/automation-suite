package framework.config;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    static Properties prop = new Properties();

    public static String get(String key) {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config/config.properties");
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }
}
