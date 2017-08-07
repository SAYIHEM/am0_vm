package GUI.Controller;

import Constants.Colors;
import Exceptions.EventViewNotSetException;
import GUI.Views.Lists.ScrollView;

import java.awt.*;

public abstract class Output {

    protected static ScrollView<String> view = null;
    protected static Color defaultColor = Colors.BLACK;


    public static void setView(ScrollView<String> newView) {

        // Exceptions
        if (newView == null) throw new NullPointerException("EventView to set was NULL!");

        view = newView;
    }

    public static void add(String message) {

        if (view == null) throw new EventViewNotSetException("Cant add Message, EventView is NULL!");

        // Add message with default colour BLACK
        add(message, null);
    }

    public static void add(String message, Color color) {

        if (view == null) throw new EventViewNotSetException("Cant add Message, EventView is NULL!");

        // Exceptions
        if (message == null) throw new NullPointerException("Message to show was NULL!");

        // Set default color when no one is given
        if (color == null) color = defaultColor;

        // Add message to EventView and Highlight with color
        view.addElement(message);
        view.highlight(view.getIndexLastElement(), color);
    }

}
