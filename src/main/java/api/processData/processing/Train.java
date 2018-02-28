package api.processData.processing;

import api.processData.loadingUnit.Order;

import java.util.Date;
import java.util.List;


/**
 * Contains information necessary for loading and discharging of a train like properties of the train, timetables,
 * information about its load etc.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Train {

    private String trainTitel;

    // TODO - type: type for waggon?
    private List<String> loadingListWaggon;

    private String loadingListWaggonType;

    private String loadingListWaggonId;

    // TODO - type: Sequenz Fahrtrichtung?
    private String loadingListWaggonRanking;

    private Order loadingListWaggonLoadingPositionLuOrder;

    /**
     * format: ISO 8601 incl. UTC
     */
    private Date terminalEta;

    /**
     * format: ISO 8601 incl. UTC
     */
    private Date terminalEtd;

    /**
     * format: ISO 8601 incl. UTC
     */
    private Date shuntingYardEta;

    private String shunter;

    private String trainPaths;
}
