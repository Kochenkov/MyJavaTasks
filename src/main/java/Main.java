import patterns.observer_listener.Button;
import patterns.observer_listener.Listener;

public class Main {

    public static void main(String[] args) {

        Button button = new Button();
        Listener listener = new Listener();
        button.addListener(listener);
        button.wasClicked();

    }
}