package chess;

import javafx.scene.input.DataFormat;

public class Location {
    public static DataFormat DATAFORMAT = new DataFormat("Location");
    private int i;
    private int j;

    public Location(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    @Override
    public String toString() {
        return "Location{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }
}
