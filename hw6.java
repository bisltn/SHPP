import java.util.HashMap;
import java.util.Map;

public class ConfigurationManager {
    private static volatile ConfigurationManager instance;
    
    private Map<String, String> settings;

    private ConfigurationManager() {
        settings = new HashMap<>();
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            synchronized (ConfigurationManager.class) {
                if (instance == null) { 
                    instance = new ConfigurationManager();
                }
            }
        }
        return instance;
    }
    public void setSetting(String key, String value) {
        settings.put(key, value);
    }
    public String getSetting(String key) {
        return settings.get(key);
    }

    public void loadSettings() {
        settings.put("AppName", "MyApplication");
        settings.put("Version", "1.0.0");
    }

    public void printSettings() {
        for (Map.Entry<String, String> entry : settings.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ConfigurationManager config1 = ConfigurationManager.getInstance();
        config1.loadSettings();
        config1.setSetting("Environment", "Production");

        System.out.println("Config 1 settings:");
        config1.printSettings();

        ConfigurationManager config2 = ConfigurationManager.getInstance();
        System.out.println("\nConfig 2 settings:");
        config2.printSettings();

        System.out.println("\nIs config1 same as config2? " + (config1 == config2));
    }
}
