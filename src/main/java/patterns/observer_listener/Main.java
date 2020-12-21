package patterns.observer_listener;

public class Main {

    public static void main(String[] args) {

        Button button = new Button();
        Listener listener = new Listener();
        button.addListener(listener);
        //кнопка оповещает всех своих подписчиков, которые хранятся в списке, о том, что она была нажата = вызывает у всех своих подписчиков метод onClick()
        button.wasClicked();
    }
}