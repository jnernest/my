package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;
import org.pac4j.core.profile.CommonProfile;
import org.pac4j.core.profile.ProfileManager;
import org.pac4j.sparkjava.SparkWebContext;
import spark.Request;
import spark.Response;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ServerUtils {

    public static <T extends CommonProfile> T getProfile(Request request, Response response) {
        SparkWebContext context = new SparkWebContext(request, response);
        ProfileManager<T> manager = new ProfileManager<>(context);
        return manager.get(true).orElseThrow(IllegalStateException::new);
    }

    public static Gson newGson() {
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .registerTypeAdapter(ZonedDateTime.class, (JsonSerializer<ZonedDateTime>) (d, t, c) -> new JsonPrimitive(d.format(DateTimeFormatter.ISO_ZONED_DATE_TIME)))
                .setPrettyPrinting()
                .create();
    }

    public static String toJson(Object value) {
        return newGson().toJson(value);
    }
}
