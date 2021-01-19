package patterns.listener;

public class Button {

    private ClickListener[] listeners = new ClickListener[10];
    private int count = 0;

    public void addListener(ClickListener listener) {
        listeners[count] = listener;
        count++;
    }

    public void  wasClicked() {
        for (int i=0; i<count; i++) {
            listeners[i].onClick();
        }
    }

}
