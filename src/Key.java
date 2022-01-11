import config.Theme;
import de.ur.mi.oop.graphics.Label;
import de.ur.mi.oop.graphics.Rectangle;

/**
 * Diese Klasse repräsentiert einen einzelnen Buchstaben bzw. eine einzelne Taste auf dem Bildschirm.
 * Für jeden Buchstaben wird ein Rechteck gezeichnet, das (fast) zentriert den jeweiligen Buchstaben
 * als Label beinhaltet.
 */
public class Key {

    public static final float SIZE = 30;

    public final Rectangle shape; // "Hintergrund" der Taste
    public final Label value; // "Beschriftung" der Taste

    public Key(float x, float y, char key) {
        shape = new Rectangle(x, y, SIZE, SIZE, Theme.RED);
        /*
         * Die Positionierung des Labels mittig auf dem Rechteck erfolgt über Erfahrungswerte auf Basis der verwendeten
         * Schriftgröße, da die genaue Berechnung der Label-Größe in der GraphicsApp aktuell nur fehlerhaft funktioniert.
         */
        value = new Label(x + 8, y + 22, String.valueOf(key).toUpperCase(), Theme.GREY);
        value.setFont("Arial Rounded MT Bold");
        value.setFontSize(14);
    }

    /**
     * Die Methode hebt je nach aktuellem Zustand entweder die Taste hervor oder entfernt deren Hervorhebung.
     */
    public void toggleFocus() {
        if (shape.getColor() == Theme.YELLOW) { // Wenn die Taste bereits hervorgehoben wurde ...
            unfocus();
        } else { // ... andernfalls
            focus();
        }
    }

    /**
     * Setzt die farbliche Hervorhebung
     */
    private void focus() {
        shape.setColor(Theme.YELLOW);
    }

    /**
     * Entfernt die farbliche Hervorhebung
     */
    private void unfocus() {
        shape.setColor(Theme.RED);
    }


    public void draw() {
        shape.draw();
        value.draw();
    }
}
