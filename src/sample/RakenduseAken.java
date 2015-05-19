package sample;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
Kasutaja saab ise täringutele enda pilte lisada. Selleks peal olema piltide kaust, kus sees on üheksa kausta. Iga kaust ühe täringu jaoks.
Lisaks sellele peab igas täringu kaustas olema 6 pilti täringu külgede jaoks.
 */


/**
 * Created by rainvagel on 14/05/15.
 */
public class RakenduseAken extends Application {
    Täring esimene = new Täring("Esimene");
    Täring teine = new Täring("Teine");
    Täring kolmas = new Täring("Kolmas");
    Täring neljas = new Täring("Neljas");
    Täring viies = new Täring("Viies");
    Täring kuues = new Täring("Kuues");
    Täring seitsmes = new Täring("Seitsmes");
    Täring kaheksas = new Täring("Kaheksas");
    Täring üheksas = new Täring("Üheksas");
    static BorderPane piiriPaan = new BorderPane();
    static GridPane grid = new GridPane();
    static GridPane gridAlumine = new GridPane();
    ImageView iv1 = new ImageView();
    ImageView iv2 = new ImageView();
    ImageView iv3 = new ImageView();
    ImageView iv4 = new ImageView();
    ImageView iv5 = new ImageView();
    ImageView iv6 = new ImageView();
    ImageView iv7 = new ImageView();
    ImageView iv8 = new ImageView();
    ImageView iv9 = new ImageView();


    public void start(Stage peaLava)throws Exception{
        peaLava.setTitle("Story Cubes");

        File fail = new File("logi.txt");
        PrintWriter välja = new PrintWriter(new FileWriter(fail,true));

        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        ColumnConstraints col3 = new ColumnConstraints();
        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints();
        RowConstraints row3 = new RowConstraints();
        ColumnConstraints col1Alla = new ColumnConstraints();
        ColumnConstraints col2Alla = new ColumnConstraints();
        ColumnConstraints col3Alla = new ColumnConstraints();

        row1.setPercentHeight(33);
        row2.setPercentHeight(33);
        row3.setPercentHeight(33);
        col1.setPercentWidth(33);
        col2.setPercentWidth(33);
        col3.setPercentWidth(33);
        col1Alla.setPercentWidth(33);
        col2Alla.setPercentWidth(33);
        col3Alla.setPercentWidth(33);

        grid.getColumnConstraints().addAll(col1,col2,col3);
        grid.getRowConstraints().addAll(row1,row2,row3);
        grid.setMaxSize(300,300);
        gridAlumine.getColumnConstraints().addAll(col1Alla, col2Alla,col3Alla);
        gridAlumine.setMaxSize(300,300);


        iv1.fitHeightProperty().bind(row1.percentHeightProperty().multiply(3));     //ImageView akende suurused panen siin paika
        iv1.fitWidthProperty().bind(col1.percentWidthProperty().multiply(3));
        iv2.fitHeightProperty().bind(row1.percentHeightProperty().multiply(3));
        iv2.fitWidthProperty().bind(col1.percentWidthProperty().multiply(3));
        iv3.fitHeightProperty().bind(row1.percentHeightProperty().multiply(3));
        iv3.fitWidthProperty().bind(col1.percentWidthProperty().multiply(3));
        iv4.fitHeightProperty().bind(row2.percentHeightProperty().multiply(3));
        iv4.fitWidthProperty().bind(col2.percentWidthProperty().multiply(3));
        iv5.fitHeightProperty().bind(row2.percentHeightProperty().multiply(3));
        iv5.fitWidthProperty().bind(col2.percentWidthProperty().multiply(3));
        iv6.fitHeightProperty().bind(row2.percentHeightProperty().multiply(3));
        iv6.fitWidthProperty().bind(col2.percentWidthProperty().multiply(3));
        iv7.fitHeightProperty().bind(row3.percentHeightProperty().multiply(3));
        iv7.fitWidthProperty().bind(col3.percentWidthProperty().multiply(3));
        iv8.fitHeightProperty().bind(row3.percentHeightProperty().multiply(3));
        iv8.fitWidthProperty().bind(col3.percentWidthProperty().multiply(3));
        iv9.fitHeightProperty().bind(row3.percentHeightProperty().multiply(3));
        iv9.fitWidthProperty().bind(col3.percentWidthProperty().multiply(3));

        grid.setGridLinesVisible(true);
        gridAlumine.setGridLinesVisible(false);
        grid.add(iv1,0,0);
        grid.add(iv2,1,0);
        grid.add(iv3,2,0);
        grid.add(iv4,0,1);
        grid.add(iv5,1,1);
        grid.add(iv6,2,1);
        grid.add(iv7,0,2);
        grid.add(iv8,1,2);
        grid.add(iv9,2,2);
        grid.setMargin(iv1, new Insets(5,5,5,5));
        grid.setMargin(iv2, new Insets(5,5,5,5));
        grid.setMargin(iv3, new Insets(5,5,5,5));
        grid.setMargin(iv4, new Insets(5,5,5,5));
        grid.setMargin(iv5, new Insets(5,5,5,5));
        grid.setMargin(iv6, new Insets(5,5,5,5));
        grid.setMargin(iv7, new Insets(5,5,5,5));
        grid.setMargin(iv8, new Insets(5,5,5,5));
        grid.setMargin(iv9, new Insets(5,5,5,5));

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
        gridAlumine.add(start, 0, 0);
        gridAlumine.add(logi,1,0);
        gridAlumine.setMargin(start,new Insets(5,5,5,5));
        gridAlumine.setMargin(logi,new Insets(5,5,5,5));

        start.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event){
                if(gridAlumine.getChildren().size() == 3) {
                    gridAlumine.getChildren().remove(2);
                }
                startNupp(välja);
            }
        });

        start.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event){
                if(event.getCode() == KeyCode.SPACE){
                if(gridAlumine.getChildren().size() == 3) {
                    gridAlumine.getChildren().remove(2);
                }
                    startNupp(välja);
                }
            }
        });

        logi.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                logiNupp();
            }
        });

        logi.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.SPACE){
                    logiNupp();
                }
            }
        });

        piiriPaan.setCenter(grid);
        piiriPaan.setBottom(gridAlumine);


        Scene stseen1 = new Scene(piiriPaan,400,400,Color.SNOW);
        peaLava.setScene(stseen1);
        peaLava.show();

        otsidaPilte(new File("Images/esimene"), esimene);
        otsidaPilte(new File("Images/teine"), teine);
        otsidaPilte(new File("Images/kolmas"), kolmas);
        otsidaPilte(new File("Images/neljas"), neljas);
        otsidaPilte(new File("Images/viies"), viies);
        otsidaPilte(new File("Images/kuues"), kuues);
        otsidaPilte(new File("Images/seitsmes"), seitsmes);
        otsidaPilte(new File("Images/kaheksas"), kaheksas);
        otsidaPilte(new File("Images/üheksas"), üheksas);
    }

    public static void main(String[] args) throws Exception{
        launch(args);
    }

    void startNupp(PrintWriter välja){
        iv1.setEffect(null);
        iv2.setEffect(null);
        iv3.setEffect(null);
        iv4.setEffect(null);
        iv5.setEffect(null);
        iv6.setEffect(null);
        iv7.setEffect(null);
        iv8.setEffect(null);
        iv9.setEffect(null);
        iv1.setImage(esimene.võtaPilt());
        iv2.setImage(teine.võtaPilt());
        iv3.setImage(kolmas.võtaPilt());
        iv4.setImage(neljas.võtaPilt());
        iv5.setImage(viies.võtaPilt());
        iv6.setImage(kuues.võtaPilt());
        iv7.setImage(seitsmes.võtaPilt());
        iv8.setImage(kaheksas.võtaPilt());
        iv9.setImage(üheksas.võtaPilt());

        Date aeg = new Date();
        SimpleDateFormat formaat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        välja.println(formaat.format(aeg) + ", " + iv1.getImage().toString() + ", " + iv2.getImage().toString()
                + ", " + iv3.getImage().toString() + ", " +
                iv4.getImage().toString() + ", " + iv5.getImage().toString() + ", " + iv6.getImage().toString() + ", " +
                iv7.getImage().toString() + ", " + iv8.getImage().toString() + ", " + iv9.getImage().toString() + "\n");

        välja.flush();
    }

    void logiNupp(){
        File fail = new File("logi.txt");
        try {
            java.awt.Desktop.getDesktop().edit(fail);
        } catch(IOException e){
            System.out.println("Logifaili ei leitud!");
        }
    }

    void otsidaPilte(File fail, Täring täring) throws IOException {    //See programm vaatab läbi iga täringu kausta ning
        File[] pildid = fail.listFiles();                              //lisab need pildid sellele täringule.
        try {
            for (File pilt : pildid) {
                BufferedImage pilt1 = ImageIO.read(pilt);
                if (pilt1 != null) {
                    Image pilt2 = SwingFXUtils.toFXImage(pilt1, new WritableImage(50, 50));
                    täring.lisaPilt(pilt2);
                }
            }
        } catch(NullPointerException e){
            System.out.println("Pilte pole!");
        }
    }
}