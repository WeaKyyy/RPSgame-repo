package src.objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class DragonCheckPoint extends SuperCheckPoint {

    public DragonCheckPoint() {

        title = "Grandmaster Non-breathing fire Dragon";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/pixel_greenDragon.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
