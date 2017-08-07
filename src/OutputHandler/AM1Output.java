package OutputHandler;

import java.util.List;

public class AM1Output implements OutputHandler {

    private List<Displayable> devices;

    public AM1Output(List<Displayable> devices) {

        if (devices == null) throw new NullPointerException("Devices in AM1ConsoleOutput was NULL!");
        this.devices = devices;
    }

    @Override
    public String get() {

        StringBuilder machineState = new StringBuilder();

        // TODO: Better Table view
        for (Displayable device : this.devices) {

            machineState.append(device.getState());
            machineState.append(" | ");
        }

        return machineState.toString();
    }
}
