package net.contargo.intermodal.domain;

/**
 * Capacity of a {@link Barge}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Kapazität
 * @name_english  capacity
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
class Capacity {

    private Double teu;
    private Double tons;

    Capacity() {

        // OK
    }

    public Double getTeu() {

        return teu;
    }


    void setTeu(Double teu) {

        this.teu = teu;
    }


    public Double getTons() {

        return tons;
    }


    void setTons(Double tons) {

        this.tons = tons;
    }
}
