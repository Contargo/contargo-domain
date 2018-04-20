package digit.domain.processData.registration;

import digit.domain.masterData.operator.Operator;

import java.util.Date;


/**
 * Contains data for registration of trains by connecting its properties and load as well as schedules and shunting
 * information.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @DIGIT_name  Anmeldung Zug
 * @DIGIT_english  registration train
 * @DIGIT_definition  Enthält Daten für die Anmeldung von Zügen durch die Verknüpfung aller Zugeigenschaften und
 *                    Beladungen sowie Zeitplänen und Rangierdaten. Die Zugbezeichnung ermöglicht zusammen mit der
 *                    Trassennummer eine eindeutige Identifizierung des Verkehrsmittels.
 * @DIGIT_definition_english  Contains data for registration of trains by connecting its properties and load as well as
 *                            schedules and shunting information. The train title in combination with the train paths
 *                            is used for clear identification.
 */
public class Train {

    private String trainTitle;

    private Operator railwayOperator;

    private Operator operator;

    /**
     * Estimated Time of Arrival (Format: ISO 8601 inclusive UTC)
     */
    private Date terminalEta;

    /**
     * Estimated Time of Departure (Format: ISO 8601 inclusive UTC)
     */
    private Date terminalEtd;

    /**
     * Estimated Time of Arrival (Format: ISO 8601 inclusive UTC)
     */
    private Date shuntingYardEta;

    private String shunter;

    /**
     * in meter.
     */
    private double totalLength;

    private int waggonQuantity;

    /**
     * Number of LUs.
     */
    private int volumeToDischarge;

    /**
     * Number of LUs.
     */
    private int volumeToLoad;

    private String trainPaths;
}
