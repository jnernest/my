package utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.util.Optional;

public class ConfigUtils {

    private static final Config config = ConfigFactory.load();

    public static String get(String path) {
        return config.getString(path);
    }

    public static String get(String path, Object... args) {
        return String.format(get(path), args);
    }

    public static Config getConfig() {
        return config;
    }

    public static Optional<String> getOptional(String path) {
        if (!config.hasPath(path))
            return Optional.empty();

        String value = config.getString(path);
        if (value == null || value.equals(""))
            return Optional.empty();

        return Optional.of(value);
    }

    public static boolean isTest() {
        return config.getBoolean("test");
    }

    public static int getPort() {
        return config.getInt("port");
    }

    public static Optional<String> getProxy() {
        return getOptional("proxy");
    }

    public static Optional<String> getUsername() {
        return getOptional("username");
    }

    public static Optional<String> getPassword() {
        return getOptional("password");
    }
}
