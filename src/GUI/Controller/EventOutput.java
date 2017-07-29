package GUI.Controller;

import Constants.Colors;
import Exceptions.EventViewNotSetException;
import GUI.Views.Lists.ScrollView;
import java.awt.*;

public abstract class EventOutput {

    private static ScrollView<String> eventView = null;
    private static Color defaultColor = Colors.BLACK;

    private EventOutput() {}

    public static void setEventView(ScrollView<String> view) {

        // Exceptions
        if (view == null) throw new NullPointerException("EventView to set was NULL!");

        eventView = view;
    }

    public static void add(String message) {

        if (eventView == null) throw new EventViewNotSetException("Cant add Message, EventView is NULL!");

        // Add message with default colour BLACK
        add(message, null);
    }

    public static void add(String message, Color color) {

        if (eventView == null) throw new EventViewNotSetException("Cant add Message, EventView is NULL!");

        // Exceptions
        if (message == null) throw new NullPointerException("Message to show was NULL!");

        // Set default color when no one is given
        if (color == null) color = defaultColor;

        // Add message to EventView and Highlight with color
        eventView.addElement(message);
        eventView.highlight(eventView.getIndexLastElement(), color);
    }
}
