package sample;

import javafx.scene.image.Image;

import java.util.ArrayList;

/**
 * Created by rainvagel on 14/05/15.
 */
public class Täring {
    private String nimetus;
    private ArrayList<Image> pildid;

    public Täring(String nimetus){
        this.nimetus = nimetus;
    }

    public String getNimetus() {
        return nimetus;
    }

    public ArrayList<Image> getPildid() {
        return pildid;
    }

    void lisaPilt(Image pilt){
        this.getPildid().add(pilt);
    }

    Image võtaPilt(){
        int mitmes = (int)(Math.random() * (5 + 1));
        return this.getPildid().get(mitmes);
    }

    public String toString(){
        return "Täring: " + ", pildid: " + this.getPildid();
    }
}