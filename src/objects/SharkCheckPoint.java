package src.objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class SharkCheckPoint extends SuperCheckPoint {

    public SharkCheckPoint() {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/pixel_shark.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
