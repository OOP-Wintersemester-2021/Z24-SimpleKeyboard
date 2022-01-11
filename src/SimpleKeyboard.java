import config.Settings;
import config.Theme;
import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.events.KeyPressedEvent;
import de.ur.mi.oop.events.KeyReleasedEvent;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;

import java.util.HashMap;

/**
 * In diesem Beispiele stellen wir mehrere Rechtecke auf dem Bildschirm dar, die die Buchstaben-
 * Tasten auf der Tastatur repräsentieren sollen. Beim Druck auf eine der Tasten wird das entsprechende
 * Rechteck farblich hervorgehoben. Wird die Taste wieder losgelassen, verschwindet die Hervorhebung. Um
 * bei einem Tastendruck schnell das passende Rechteck zu finden, speichern wir diese in einer HashMap
 * und nutzen dabei den char-Wert der Taste (z.B. 'a' für die A-Taste) als Schlüssel.
 */
public class SimpleKeyboard extends GraphicsApp {

    private HashMap<Character, Key> keys; // HashMap für die Key-Objekte zur Repräsentation der Tasten

    @Override
    public void initialize() {
        setCanvasSize((int) Settings.WINDOW_WIDTH, (int) Settings.WINDOW_HEIGHT);
        initKeys();
    }

    private void initKeys() {
        // Wir erstellen eine neue HashMap ...
        keys = new HashMap<>();
        float xOffset = 5;
        // ... und iterieren mit einer For-Schleife über alle Buchstaben, die wir repräsentieren wollen ...
        for (int i = 'a'; i <= 'z'; i++) {
            char c = (char) i;
            // ... und erstellen dabei für jeden Buchstaben ein passendes Key-Objekt, das in der Map gespeichert wird
            keys.put(c, new Key(xOffset, 5, c));
            xOffset += Key.SIZE + 10; // Wir erhöhen nach jedem Buchstaben die X-Position, an der der nächste Key eingezeichnet werden soll
        }
    }

    /**
     * Diese Methode sucht in der HashMap nach einem Wert, dessen Schlüssel dem übergebenen Parameter key entspricht. Falls ein solcher
     * Wert gefunden wird (es handelt sich dann um ein Key-Objekt) wird die farbliche Hervorhebung dieses Rechtecks "umgeschaltet".
     *
     * @param key Char-Wert, zu dem der passende Key ("Rechteck") in der HashMap gesucht werden soll
     */
    private void toggleKeyFocus(char key) {
        Key selectedKey = keys.get(key);
        if (selectedKey != null) {
            selectedKey.toggleFocus();
        }
    }

    @Override
    public void draw() {
        drawBackground(Theme.GREY);
        // Über die values-Methode der HashMap können wir einfach auf alle in der Map gespeicherten Werte zugreifen
        for (Key key : keys.values()) {
            key.draw();
        }
    }

    @Override
    public void onKeyPressed(KeyPressedEvent event) {
        toggleKeyFocus(event.getKeyChar()); // Beim Druck einer Taste wird in der HashMap nach dem korrespondierenden Key gesucht
    }

    @Override
    public void onKeyReleased(KeyReleasedEvent event) {
        toggleKeyFocus(event.getKeyChar()); // Beim Loslassen einer Taste wird in der HashMap nach dem korrespondierenden Key gesucht
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch("SimpleKeyboard");
    }
}
