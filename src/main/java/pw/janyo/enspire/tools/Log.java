package pw.janyo.enspire.tools;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Formatter;

/**
 * @author kiva
 * @date 2017/12/16
 */
public final class Log {
    public static boolean LOG_ENABLED = true;

    private static String getCallerHeader(String logType) {
        StackTraceElement targetElement = new Throwable().getStackTrace()[3];
        String className = targetElement.getClassName();
        String[] classNameInfo = Arrays.stream(className.split("\\."))
                .filter(it -> !it.isEmpty())
                .toArray(String[]::new);

        if (classNameInfo.length != 0) {
            className = classNameInfo[classNameInfo.length - 1];
        }

        if (className.contains("$")) {
            className = Arrays.stream(className.split("\\$"))
                    .filter(it -> !it.isEmpty())
                    .toArray(String[]::new)[0];
        }

        return new Formatter()
                .format("[Thread:%s @ %s] %s.%s (%s:%d): ",
                        Thread.currentThread().getName(),
                        logType,
                        className,
                        targetElement.getMethodName(),
                        targetElement.getFileName(),
                        targetElement.getLineNumber())
                .toString();
    }

    private static void log(PrintStream printStream, String logType, String message) {
        if (LOG_ENABLED) {
            printStream.print(getCallerHeader(logType));
            printStream.println(message);
        }
    }

    public static void e(String message) {
        log(System.err, "Error", message);
    }

    public static void d(String message) {
        log(System.out, "Debug", message);
    }

    public static void i(String message) {
        log(System.out, "Info", message);
    }

    public static void w(String message) {
        log(System.err, "Warn", message);
    }
}
