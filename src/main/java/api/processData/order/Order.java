package api.processData.order;

import api.masterData.meansOfTransport.MeansOfTransport;

import api.masterData.operator.Operator;

import api.masterData.vessel.Vessel;

import api.processData.loadingUnit.Direction;

import java.util.Date;
import java.util.List;


/**
 * Contains all data of an order.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @DIGIT_name  Auftrag
 * @DIGIT_english  Order
 * @DIGIT_definition  Die komplex verknüpfte Klasse der Auftragsdaten bringt alle Daten zusammen, die zum Auftrag
 *                    gehören. Sie bildet somit eine wichtige Grundlage für die Planung und Durchführung intermodaler
 *                    Ketten nach der vorliegenden Spezifikation. Die Auftragsreferenz dient hierbei der eindeutigen
 *                    Identifizierung. Die vorliegende Gruppe unterscheidet sich deutlich zu ihren Vorgängern und ist
 *                    als komplexe Datenverknüpfung zu interpretieren. Sie kann in der Gesamtheit der relevanten
 *                    Transporteckdaten eine komplette Transportkette abbilden und bedient sich hierfür bei den zuvor
 *                    beschriebenen Datengruppen. Zunächst werden übergeordnete Auftragsdaten herangezogen.
 *                    Anschließend sind alle transportrelevanten Daten gesammelt und nach Informationen zu Abholung,
 *                    Anlieferung, Halt und Ziel geordnet.
 * @DIGIT_definition_english  This class combines all data of an Order. Therefore it is an important foundation for
 *                            planning and execution of intermodal chains in this specification. The order reference is
 *                            used for clear identification. This class differs much from the others and should be
 *                            interpreted as complex connection of data. It can be used to map a complete chain of
 *                            transport with all of its relevant data. It includes high level order data as well as
 *                            data relevant for transport organized by pick up, drop off, stop and destination.
 */
public class Order {

    private String reference;

    private Operator client;

    private Operator billRecipient;

    private api.processData.loadingUnit.Order luOrder;

    private Direction transportDirection;

    private String transportPickUpLocationCity;

    /**
     * name of terminal.
     */
    private String transportPickUpLocationDesignation;

    /**
     * loading place, sea- or hinterlandterminal.
     */
    private String transportPickUpLocationType;

    private boolean transportPickUpLUEmpty;

    private String transportPickUpLUReference;

    /**
     * Abrechnungsreferenz, PO-number für Dienstl.
     */
    private String transportPickUpBillingReference;

    private Operator transportPickUpLUOperator;

    /**
     * DateTime ISO 8601 inclusive UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
     */
    private Date transportPickUpEarliest;

    /**
     * DateTime ISO 8601 inclusive UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
     */
    private Date transportPickUpLatest;

    private MeansOfTransport transportPickUpMoT;

    private String transportDropOffLocationCity;

    private String transportDropOffLocationDesignation;

    private String transportDropOffLocationType;

    private boolean transportDropOffUnitEmpty;

    private String transportDropOffUnitReference;

    private String transportDropOffBillingReference;

    private Operator transportDropOffUnitOperator;

    /**
     * DateTime ISO 8601 inclusive UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
     */
    private Date transportDropOffEarliest;

    /**
     * DateTime ISO 8601 inclusive UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
     */
    private Date transportDropOffLatest;

    private MeansOfTransport transportDropOffMot;

    private List<String> transportStopLocation;

    private List<String> transportStopLocationCity;

    private List<String> transportStopLocationDesignation;

    private String transportStopLocationType;

    private String transportStopSequence;

    /**
     * Format: ISO 8601 inclusive UTC.
     */
    private Date transportStopEarliest;

    /**
     * Format: ISO 8601 inclusive UTC.
     */
    private Date transportStopLatest;

    private String transportStopReference;

    private String transportStopBillingReference;

    private MeansOfTransport transportStopMot;

    private Vessel destinationVessel;

    private String destinationSeaportName;

    private String destinationLocationDesignation;

    /**
     * 2 characters (UN/LOCODE).
     */
    private String destinationCountryCode;

    private String destinationLocationCity;
}
