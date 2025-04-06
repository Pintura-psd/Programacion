package Programacion.Tema6.Bibilioteca;

import java.util.ArrayList;

public class Ficha {

    private int num;
    private String title;

    public Ficha(int num, String title) {
        this.num = num;
        this.title = title;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
