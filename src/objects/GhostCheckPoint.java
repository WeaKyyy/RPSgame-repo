package src.objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class GhostCheckPoint extends SuperCheckPoint {

    public GhostCheckPoint() {

        title = "Tryhard Ghost";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/pixel_ghost.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
