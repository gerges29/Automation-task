package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static ConfigReader instance = null;
    private static final String CONFIG_FILE = "D:\\Java\\Automation_task\\src\\test\\java\\config\\config.properties";
    private Properties props;

    private ConfigReader() {
        props = new Properties();
        try (InputStream input = new FileInputStream(CONFIG_FILE)) {
            props.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConfigReader getInstance() {
        if (instance == null) {
            instance = new ConfigReader();
        }
        return instance;
    }

    public String getSearchInput() {
        return props.getProperty("searchInput");
    }
}
