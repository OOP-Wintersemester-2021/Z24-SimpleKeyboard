import config.Settings;
import config.Theme;
import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.events.KeyPressedEvent;
import de.ur.mi.oop.events.KeyReleasedEvent;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;

import java.util.HashMap;

public class SimpleKeyboard extends GraphicsApp {

    private HashMap<Character, Key> keys;

    @Override
    public void initialize() {
        setCanvasSize((int) Settings.WINDOW_WIDTH, (int) Settings.WINDOW_HEIGHT);
        initKeys();
    }

    private void initKeys() {
        keys = new HashMap<>();
        float xOffset = 5;
        for (int i = 'a'; i <= 'z'; i++) {
            char c = (char) i;
            keys.put(c, new Key(xOffset, 5, c));
            xOffset += Key.SIZE + 10;
        }
    }

    private void toggleKeyFocus(char key) {
        Key selectedKey = keys.get(key);
        if (selectedKey != null) {
            selectedKey.toggleFocus();
        }
    }

    @Override
    public void draw() {
        drawBackground(Theme.GREY);
        for (Key key : keys.values()) {
            key.draw();
        }
    }

    @Override
    public void onKeyPressed(KeyPressedEvent event) {
        toggleKeyFocus(event.getKeyChar());
    }

    @Override
    public void onKeyReleased(KeyReleasedEvent event) {
        toggleKeyFocus(event.getKeyChar());
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch("SimpleKeyboard");
    }
}
