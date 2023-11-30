package src.objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class PikachuCheckPoint extends SuperCheckPoint{

    public PikachuCheckPoint() {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/pixel_pikachu.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
