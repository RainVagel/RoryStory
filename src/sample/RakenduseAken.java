package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/**
 * Created by rainvagel on 14/05/15.
 */
public class RakenduseAken extends Application {
    public void start(Stage peaLava)throws Exception{
        peaLava.setTitle("Story Cubes");
        BorderPane piiriPaan = new BorderPane();

        VBox vbox = new VBox(); //See läheb keskele ja siia sisse hakkavad tulema järjest uued väljad
        HBox hbox1 = new HBox(); //See on ülemine
        HBox hbox2 = new HBox(); //Keskmine
        HBox hbox3 = new HBox(); //Alumine

        ImageView iv1 = new ImageView();
        ImageView iv2 = new ImageView();
        ImageView iv3 = new ImageView();
        ImageView iv4 = new ImageView();
        ImageView iv5 = new ImageView();
        ImageView iv6 = new ImageView();
        ImageView iv7 = new ImageView();
        ImageView iv8 = new ImageView();
        ImageView iv9 = new ImageView();
        Button start = new Button("Start");

        hbox1.getChildren().addAll(iv1,iv2,iv3);
        hbox2.getChildren().addAll(iv4,iv5,iv6);
        hbox3.getChildren().addAll(iv7,iv8,iv9);

        vbox.getChildren().addAll(hbox1,hbox2,hbox3);
        piiriPaan.setCenter(vbox);
        piiriPaan.setBottom(start);







        Scene stseen1 = new Scene(piiriPaan,400,400,Color.SNOW);
        peaLava.setScene(stseen1);
        peaLava.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
