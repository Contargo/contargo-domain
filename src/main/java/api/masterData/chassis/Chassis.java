package api.masterData.chassis;

import api.masterData.meansOfTransport.MeansOfTransport;

import java.util.Date;


/**
 * Trailer to transport loading units.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @DIGIT_name  Fahrgestell
 * @DIGIT_english  chassis
 * @DIGIT_definition  Anhänger zur Beförderung von Ladeeinheiten.
 * @DIGIT_definition_english  Trailer to transport loading units.
 */
public class Chassis implements MeansOfTransport {

    /**
     * Format: spaces included.
     */
    private String numberPlate;

    /**
     * Ministry of Transport Test (Format: DateTime ISO 8601 inclusive UTC).
     *
     * @DIGIT_name  Hauptuntersuchung
     */
    private Date mot;

    /**
     * e.g. Multichassis.
     */
    private String type;

    private int axles;

    /**
     * in meter.
     */
    private double size;

    /**
     * in meter.
     */
    private double height;

    private boolean euAuthorization;

    /**
     * Safety test.
     *
     * @DIGIT_name  Sicherheitsprüfung.
     */
    private boolean st;

    private boolean suitabilityDangerousGoods;

    private boolean suitabilityWaste;

    private boolean suitabilityReefer;

    /**
     * in kg.
     */
    private double weightTara;
}
