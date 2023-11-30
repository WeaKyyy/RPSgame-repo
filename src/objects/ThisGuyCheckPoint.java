package src.objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ThisGuyCheckPoint extends  SuperCheckPoint{

    public ThisGuyCheckPoint() {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/pixel_thisGuy.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
