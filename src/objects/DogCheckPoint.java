package src.objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class DogCheckPoint extends SuperCheckPoint {

    public DogCheckPoint() {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/pixel_dog.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}