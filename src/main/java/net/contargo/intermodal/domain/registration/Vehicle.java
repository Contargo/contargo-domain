package net.contargo.intermodal.domain.registration;

import net.contargo.intermodal.domain.Chassis;
import net.contargo.intermodal.domain.Driver;
import net.contargo.intermodal.domain.LUOrder;
import net.contargo.intermodal.domain.meansOfTransport.Truck;

import java.util.Date;


/**
 * Describes the registration of road vehicles on a handling point by connecting vehicle, {@link Driver Person} and
 * {@link LUOrder}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Anmeldung Fahrzeug
 * @name_english  registration vehicle
 * @definition_german  Die Beschreibung der Anmeldung von Straßenfahrzeugen an Umschlagpunkten durch die Verknüpfungen
 *                     von Fahrzeug, Person und Auftrag wird hier dargestellt. Die Gruppe hat sowohl für die
 *                     Anlieferung von LE Gültigkeit als auch für die Abholung von LE an einem Umschlagknoten.
 * @definition_english  Describes the registration of road vehicles on a handling point by connecting vehicle,
 *                      {@link Driver Person} and {@link LUOrder}. It is valid for the delivery of loading units as
 *                      well as for the pick up of an loading unit on a handling point.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Vehicle {

    private Truck truck;

    private Chassis chassis;

    private Driver driver;

    private String haulierClient;

    private String haulierRealizing;

    /**
     * Format: ISO 8601 inclusive UTC
     */
    private Date deliveryTime;

    private LUOrder luLUOrder;
}
