package com.main;

import Controller.Controller;
import Model.Model;
import View.View;

public class Main {

    public static void main(String[] args) {
        Model m = new Model(0, 0);
        View v = new View("Conversion Celsus/Kelvin MVC Sans Framework");
        Controller c = new Controller(m, v);
        c.initController();
        m.addobserver(c);
        m.addobserver(v);

    }
}
