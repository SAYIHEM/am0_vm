package OutputHandler;

import java.util.List;

public class AM1ConsoleOutput implements OutputHandler {

    private List<Displayable> devices;

    public AM1ConsoleOutput(List<Displayable> devices) {

        if (devices == null) throw new NullPointerException("Devices in AM1ConsoleOutput was NULL!");
        this.devices = devices;
    }

    @Override
    public String getMachineState() {

        StringBuilder machineState = new StringBuilder();

        // TODO: Better Table view
        for (Displayable device : this.devices) {

            machineState.append(device.getState());
            machineState.append("|");
        }

        return machineState.toString();
    }
}
