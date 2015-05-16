package sample;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by rainvagel on 14/05/15.
 */
public class RakenduseAken extends Application{
    static Täring esimene = new Täring("Esimene");
    static Täring teine = new Täring("Teine");
    static Täring kolmas = new Täring("Kolmas");
    static Täring neljas = new Täring("Neljas");
    static Täring viies = new Täring("Viies");
    static Täring kuues = new Täring("Kuues");
    static Täring seitsmes = new Täring("Seitsmes");
    static Täring kaheksas = new Täring("Kaheksas");
    static Täring üheksas = new Täring("Üheksas");


    public void start(Stage peaLava)throws Exception{
        peaLava.setTitle("Story Cubes");
        BorderPane piiriPaan = new BorderPane();

        VBox vbox = new VBox(); //See läheb keskele ja siia sisse hakkavad tulema järjest uued väljad
        HBox hbox1 = new HBox(); //See on ülemine
        HBox hbox2 = new HBox(); //Keskmine
        HBox hbox3 = new HBox(); //Alumine
        HBox alla = new HBox();

        ImageView iv1 = new ImageView();
        ImageView iv2 = new ImageView();
        ImageView iv3 = new ImageView();
        ImageView iv4 = new ImageView();
        ImageView iv5 = new ImageView();
        ImageView iv6 = new ImageView();
        ImageView iv7 = new ImageView();
        ImageView iv8 = new ImageView();
        ImageView iv9 = new ImageView();
        iv1.setOnMouseClicked(new pildiRuutVajutatud());
        iv2.setOnMouseClicked(new pildiRuutVajutatud());
        iv3.setOnMouseClicked(new pildiRuutVajutatud());
        iv4.setOnMouseClicked(new pildiRuutVajutatud());
        iv5.setOnMouseClicked(new pildiRuutVajutatud());
        iv6.setOnMouseClicked(new pildiRuutVajutatud());
        iv7.setOnMouseClicked(new pildiRuutVajutatud());
        iv8.setOnMouseClicked(new pildiRuutVajutatud());
        iv9.setOnMouseClicked(new pildiRuutVajutatud());

        Button start = new Button("Start");
        Button logi = new Button("Minevik");

        start.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event){
                iv1.setImage(esimene.võtaPilt());
                iv2.setImage(teine.võtaPilt());
                iv3.setImage(kolmas.võtaPilt());
                iv4.setImage(neljas.võtaPilt());
                iv5.setImage(viies.võtaPilt());
                iv6.setImage(kuues.võtaPilt());
                iv7.setImage(seitsmes.võtaPilt());
                iv8.setImage(kaheksas.võtaPilt());
                iv9.setImage(üheksas.võtaPilt());
                try {
                    Date aeg = new Date();
                    SimpleDateFormat formaat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
                    File fail = new File("logi.txt");
                    BufferedWriter välja = new BufferedWriter(new FileWriter(fail));
                    välja.write(formaat.format(aeg) );
                    välja.close();
                } catch(IOException e){
                    System.out.println("Viga logi kirjutamises");
                }
            }
        });

        logi.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                File fail = new File("logi.txt");
                try {
                    java.awt.Desktop.getDesktop().edit(fail);
                } catch(IOException e){
                    Text viga = new Text("Logifaili ei leitud!");
                    piiriPaan.setBottom(viga);
                }
            }
        });

        alla.getChildren().addAll(start,logi);
        hbox1.getChildren().addAll(iv1,iv2,iv3);
        hbox2.getChildren().addAll(iv4,iv5,iv6);
        hbox3.getChildren().addAll(iv7,iv8,iv9);

        vbox.getChildren().addAll(hbox1,hbox2,hbox3);
        piiriPaan.setCenter(vbox);
        piiriPaan.setBottom(alla);


        Scene stseen1 = new Scene(piiriPaan,400,400,Color.SNOW);
        peaLava.setScene(stseen1);
        peaLava.show();
    }

    public static void main(String[] args) throws Exception{
//        otsidaPilte(new File("/Users/rainvagel/IdeaProjects/RoryStory2/Images/esimene"), esimene);
//        otsidaPilte(new File("Images/teine"), teine);
//        otsidaPilte(new File("Images/kolmas"), kolmas);
//        otsidaPilte(new File("Images/neljas"), neljas);
//        otsidaPilte(new File("Images/viies"), viies);
//        otsidaPilte(new File("Images/kuues"), kuues);
//        otsidaPilte(new File("Images/seitsmes"), seitsmes);
//        otsidaPilte(new File("Images/kaheksas"), kaheksas);
//        otsidaPilte(new File("Images/üheksas"), üheksas);
        esimene.lisaPilt(new Image("/Users/rainvagel/IdeaProjects/RoryStory2/Images/esimene/jalg.png"));
        launch(args);
    }

    static void otsidaPilte(File fail, Täring täring) throws IOException {    //See programm vaatab läbi iga täringu kausta ning
        File[] pildid = fail.listFiles();                              //lisab need pildid sellele täringule.
        if(pildid != null) {
            for (File pilt:pildid) {
                BufferedImage pilt1 = ImageIO.read(pilt);
                if(pilt1 != null) {
                    Image pilt2 = SwingFXUtils.toFXImage(pilt1, new WritableImage(250, 250));
                    täring.lisaPilt(pilt2);
                } else{System.out.println("Yo!");}
            }
        }
        else {System.out.println("Hey!");}
    }
}
