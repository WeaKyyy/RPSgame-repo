package src.objects;

import java.io.IOException;
import javax.imageio.ImageIO;

public class PenguinCheckpoint extends SuperCheckPoint {

    public PenguinCheckpoint() {

        title = "Novice Penguin";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/pixel_penguin.png"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
