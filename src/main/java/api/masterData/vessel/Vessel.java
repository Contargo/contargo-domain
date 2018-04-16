package api.masterData.vessel;

import api.masterData.meansOfTransport.MeansOfTransport;

import api.masterData.operator.Operator;


/**
 * A ship build to drive on seas and oceans.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @DIGIT_name  Seeschiff
 * @DIGIT_english  vessel
 * @DIGIT_definition  Schiff, das zur Fahrt auf Meeren und Ozeanen konzipiert ist.
 * @DIGIT_definition_english  A ship build to drive on seas and oceans.
 * @DIGIT_annotation  Für diese API sind Schiffe relevant, die Ladeeinheiten des Kombinierten Verkehrs transportieren
 *                    können.
 * @DIGIT_annotation_english  In this API only vessels which can transport loading units of combined traffic are
 *                            relevant.
 */
public class Vessel implements MeansOfTransport {

    private String name;

    /**
     * Maritime Mobile Service Identity (9 digits).
     */
    private int mmsi;

    /**
     * International Maritime Organization (IMO plus 7 digits).
     */
    private String imo;

    private Operator operator;
}
