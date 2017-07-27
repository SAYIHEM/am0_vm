package GUI.Models;

import javax.swing.*;



public class ModelMainView {

    private DefaultListModel<String> StackModel = new DefaultListModel<>();
    private DefaultListModel<String> ProgramModel = new DefaultListModel<>();
    private DefaultListModel<String> OutputModel = new DefaultListModel<>();

    public ModelMainView() { }


    ///////////////////////////////////////////////////////////////////////////
    // Getter & Setter
    ///////////////////////////////////////////////////////////////////////////
    public DefaultListModel<String> getStackModel() {

        return StackModel;
    }

    public void setStackModel(DefaultListModel<String> stackModel) {

        // Exceptions
        if (stackModel == null) throw new NullPointerException("StackModel to set was NULL!");

        StackModel = stackModel;
    }

    public DefaultListModel<String> getProgramModel() {

        return ProgramModel;
    }

    public void setProgramModel(DefaultListModel<String> programModel) {

        // Exceptions
        if (programModel == null) throw new NullPointerException("ProgramModel to set was NULL!");

        ProgramModel = programModel;
    }

    public DefaultListModel<String> getOutputModel() {

        return OutputModel;
    }

    public void setOutputModel(DefaultListModel<String> outputModel) {

        // Exceptions
        if (outputModel == null) throw new NullPointerException("OutputModel to set was NULL!");

        OutputModel = outputModel;
    }
}
