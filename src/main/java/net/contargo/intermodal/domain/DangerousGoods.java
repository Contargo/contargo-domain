package net.contargo.intermodal.domain;

/**
 * Substances or objects that are dangerous in context of public safety and order because of their nature, properties
 * or state.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Gefahrgut
 * @name_english  dangerous goods
 * @definition_german  Stoffe und Gegenstände, von denen auf Grund ihrer Natur, ihrer Eigenschaften oder ihres
 *                     Zustandes im Zusammenhang mit der Beförderung Gefahren für die öffentliche Sicherheit oder
 *                     Ordnung, insbesondere für die Allgemeinheit, für wichtige Gemeingüter, für Leben und Gesundheit
 *                     von Menschen sowie für Tiere und Sachen ausgehen können.
 * @definition_english  Substances or objects that are dangerous in context of public safety and order because of their
 *                      nature, properties or state.
 * @note_german  Bei verschiedenen Verkehrsträgern kommt das entsprechende Regelwerk zum Tragen.
 * @note_english  There are different rules for different modes of transport.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class DangerousGoods {

    /**
     * 4 digits.
     */
    private String unNumber;

    private String material;

    private String dangerNote;

    private String packagingGroup;

    private Integer packages;

    private Integer totalQuantity;

    private TunnelRestrictionCode tunnelRestrictionCode;

    private String mandatoryRouting;

    private Boolean limitedQuantity;

    private Boolean marinePollutants;
}
