package api.statusData;

import java.util.Date;


/**
 * Status of means of transport for communication flow of intermodal freight transport.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @DIGIT_name  Verkehrsmittelstatus
 * @DIGIT_english  means of transportation status
 * @DIGIT_definition  Verkehrsmittelstatus für den Informationsfluss in der intermodalen Kette. Über den
 *                    Verkehrsmittelstatus und den {@link api.statusData.StatusLU Ladeeinheitenstatus} kann ein
 *                    reibungsloser Austausch zwischen den Akteuren sichergestellt werden. Prinzipiell sollten die
 *                    beiden Status als Paket verstanden werden. Die Kerndaten sind jeweils immer gleich und werden
 *                    durch den jeweiligen Status konkretisiert. Dabei gibt es zwei Blöcke pro Statuspaket. Zum einen
 *                    die Identifikation des Handelnden inklusive Begleitinformationen und zum anderen die
 *                    Konkretisierung was genau zu welchem Zeitpunkt passiert. Begleitinformationen beim Verkehrsmittel
 *                    betreffen die Transportrelation.
 * @DIGIT_definition_english  Status of means of transport for communication flow of intermodal freight transport. The
 *                            means of transportation status and {@link api.statusData.StatusLU loading unit status}
 *                            ensure a fluent exchange between actors. Both statuses should be seen as package. Their
 *                            core data is similar and is concretized by their status. There are two blocks per status
 *                            package. On one hand the identification of the doer on the other hand the schedule of the
 *                            different operational steps.
 */
public class MeansOfTransportationStatus {

    /**
     * Actual Time of Departure (Format: ISO 8601 inclusive UTC).
     *
     * @DIGIT_name  Abfahrt
     * @DIGIT_definition  Tatsächliche Abfahrt des VM beim Verlassen des Umschlagpunktes.
     */
    private Date atd;

    /**
     * Estimated Time of Arrival (Format: ISO 8601 inclusive UTC).
     *
     * @DIGIT_name  Avisiert
     * @DIGIT_definition  Geplante Ankunft des VM am Umschlagpunkt.
     */
    private Date eta;

    /**
     * Actual Time of Arrival (Format: ISO 8601 inclusive UTC).
     *
     * @DIGIT_name  Ankunft
     * @DIGIT_definition  Tatsächliche Ankunft des VM am Umschlagpunkt.
     */
    private Date ata;

    /**
     * MoT is ready for handling of the LU (Format: ISO 8601 inclusive UTC).
     *
     * @DIGIT_name  Bereitstellung
     * @DIGIT_synonym  Bearbeitungsstart
     * @DIGIT_abbreviation  BS
     * @DIGIT_definition  VM ist bereit für den Umschlag der LE („erste Kranung“).
     */
    private Date handlingStart;

    /**
     * MoT is loaded, end of loading process (Format: ISO 8601 inclusive UTC).
     *
     * @DIGIT_name  Bearbeitungsende
     * @DIGIT_synonym  Ladeschluss
     * @DIGIT_abbreviation  BE
     * @DIGIT_definition  VM beladen, Ende Verladung erreicht („letzte Kranung“).
     */
    private Date handlingEnd;

    /**
     * Safety control of the loaded waggons.
     *
     * @DIGIT_name  Wagentechnische Untersuchung
     * @DIGIT_abbreviation  WTU
     * @DIGIT_definition  Kontrolle der Betriebssicherheit der Waggons mit Ladung.
     */
    private int waggonTechnicalInspection;
}
