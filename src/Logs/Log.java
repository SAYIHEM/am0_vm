package Logs;

import Constants.Colors;

public abstract class Log {

    public static void d(String source ,String message) {

        System.out.println(source + ": " + message);
    }

    public static void d(Object source, String message) {

        String sourceName = source.getClass().getSimpleName();
        System.out.println(sourceName + ": " + message);
    }

    public static void d(Object source, String message, String colorCode) {

        String sourceName = source.getClass().getSimpleName();
        System.out.println(colorCode + sourceName + ": " + message + Colors.RESET);
    }
}
