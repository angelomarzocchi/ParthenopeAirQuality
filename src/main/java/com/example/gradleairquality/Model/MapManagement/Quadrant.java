package com.example.gradleairquality.Model.MapManagement;

public class Quadrant {
    /**
     * Abbiamo creato una classe contenente i dati di un quadrante essendo che una mappa geografica da informazioni relative
     * ai dati di un quadrante
     */
        public Quadrant(Coordinate NE, Coordinate NW, Coordinate SE, Coordinate SO) {
            this.NE= NE;
            this.NW=NW;
            this.SE=SE;
            this.SO=SO;
        }
        private Coordinate NE;
        private Coordinate NW;
        private Coordinate SE;
        private Coordinate SO;

    }

