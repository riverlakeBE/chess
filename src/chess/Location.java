package chess;

import javafx.scene.input.DataFormat;

import java.io.Serializable;

public class Location implements Serializable {
    public static DataFormat DATAFORMAT = new DataFormat("Location");
    private int i;
    private int j;

    public Location(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public Location(Location location) {
        this.i = location.getI();
        this.j = location.getJ();
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

    public boolean equals(Location location) {
        return i == location.getI() && j == location.getJ();
    }

    @Override
    public String toString() {
        return "Location{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }

    public void add(Location location) {
        i += location.getI();
        j += location.getJ();
    }

    public boolean isOnBoard() {
        return (0 <= i) && (i < 8) && (0 <= j) && (j < 8);
    }

    public boolean equals(int i, int j) {
        return this.i == i && this.j ==j;
    }
}
