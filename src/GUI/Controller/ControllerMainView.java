package GUI.Controller;

import GUI.JPanel.MainView;
import VirtualMachines.RuntimeMachine;

import javax.swing.*;

public class ControllerMainView {

    private MainView mainView;
    private RuntimeMachine model;

    public ControllerMainView() {

        this.mainView = new MainView(500,500);
        mainView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainView.setVisible(true);
    }

}
