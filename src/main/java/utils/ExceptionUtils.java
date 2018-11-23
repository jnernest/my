package utils;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtils {

    public static Throwable getCause(Throwable exception) {
        while (exception.getCause() != null)
            exception = exception.getCause();
        return exception;
    }

    public static String getStacktrace(Throwable exception) {
        StringWriter writer = new StringWriter();
        exception.printStackTrace(new PrintWriter(writer));
        return writer.toString().trim();
    }

    public static String toString(Throwable exception) {
        Throwable cause = getCause(exception);
        String name = cause.getClass().getSimpleName();
        String message = cause.getLocalizedMessage();
        return message == null ? name : name + ": " + message.trim();
    }
}
