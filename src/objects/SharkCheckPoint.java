package src.objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class SharkCheckPoint extends SuperCheckPoint {

    public SharkCheckPoint() {

        title = "Master Mr. Jaws";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/pixel_shark.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
