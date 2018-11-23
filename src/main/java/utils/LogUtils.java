package utils;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;

public class LogUtils {

    static {
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> newLog(t.getName()).error(e.getMessage(), e));
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
    }

    public static Logger newLog() {
        String name = new Throwable().getStackTrace()[1].getClassName();
        return newLog(name);
    }

    public static Logger newLog(Class<?> type) {
        return newLog(type.getName());
    }

    private static Logger newLog(String name) {
        return LoggerFactory.getLogger(name);
    }

    public static class Filter401 extends Filter<ILoggingEvent> {
        @Override
        public FilterReply decide(ILoggingEvent event) {
            String message = event.getFormattedMessage();
            return "AJAX request detected -> returning 401".equals(message) || "requires HTTP action: 401".equals(message) ? FilterReply.DENY : FilterReply.NEUTRAL;
        }
    }
}
