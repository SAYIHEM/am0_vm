package GUI.Controller.Callbacks;

public interface Caller {

    void register(TerminationCallback callback);
    void doCall();
}
