package patterns.observer_listener;

public class Listener implements ClickListener {

    @Override
    public void onClick() {
        System.out.println("Hello world!!!");
    }
}
