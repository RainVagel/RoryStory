package sample;

import javafx.event.EventHandler;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * Created by rainvagel on 14/05/15.
 */
class pildiRuutVajutatud implements EventHandler<MouseEvent> {
    @Override
    public void handle(MouseEvent event){
        try {
            BoxBlur blur = new BoxBlur();
            blur.setIterations(5);
            ImageView x = (ImageView) event.getSource();
            if (x.getEffect() != null) {
                throw new JubaKasutatudErind();
            }
            x.setEffect(blur);
        }catch(JubaKasutatudErind e){
            System.out.println("Juba vajutatud!");
        }
    }
}