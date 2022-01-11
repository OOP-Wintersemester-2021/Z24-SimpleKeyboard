import config.Theme;
import de.ur.mi.oop.graphics.Label;
import de.ur.mi.oop.graphics.Rectangle;

public class Key {

    public static final float SIZE = 30;

    public final Rectangle shape;
    public final Label value;

    public Key(float x, float y, char key) {
        shape = new Rectangle(x, y, SIZE, SIZE, Theme.RED);
        value =  new Label(x + 8, y + 22, String.valueOf(key).toUpperCase(), Theme.GREY);
        value.setFont("Arial Rounded MT Bold");
        value.setFontSize(14);
    }

    public void toggleFocus() {
        if(shape.getColor() == Theme.YELLOW) {
            unfocus();
        } else {
            focus();
        }
    }

    private void focus() {
        shape.setColor(Theme.YELLOW);
    }

    private void unfocus() {
        shape.setColor(Theme.RED);
    }


    public void draw() {
        shape.draw();
        value.draw();
    }
}
