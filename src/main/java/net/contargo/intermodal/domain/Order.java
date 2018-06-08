package net.contargo.intermodal.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.time.Instant;

import java.util.List;

import javax.validation.constraints.NotNull;


/**
 * Contains all data of an order.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Auftrag
 * @name_english  Order
 * @definition_german  Die komplex verknüpfte Klasse der Auftragsdaten bringt alle Daten zusammen, die zum Auftrag
 *                     gehören. Sie bildet somit eine wichtige Grundlage für die Planung und Durchführung intermodaler
 *                     Ketten nach der vorliegenden Spezifikation. Die Auftragsreferenz dient hierbei der eindeutigen
 *                     Identifizierung. Die vorliegende Gruppe unterscheidet sich deutlich zu ihren Vorgängern und ist
 *                     als komplexe Datenverknüpfung zu interpretieren. Sie kann in der Gesamtheit der relevanten
 *                     Transporteckdaten eine komplette Transportkette abbilden und bedient sich hierfür bei den zuvor
 *                     beschriebenen Datengruppen. Zunächst werden übergeordnete Auftragsdaten herangezogen.
 *                     Anschließend sind alle transportrelevanten Daten gesammelt und nach Informationen zu Abholung,
 *                     Anlieferung, Halt und Ziel geordnet.
 * @definition_english  This class combines all data of an Order. Therefore it is an important foundation for planning
 *                      and execution of intermodal chains in this specification. The order reference is used for clear
 *                      identification. This class differs much from the others and should be interpreted as complex
 *                      connection of data. It can be used to map a complete chain of transport with all of its
 *                      relevant data. It includes high level order data as well as data relevant for transport
 *                      organized by pick up, drop off, stop and destination.
 * @minimum_requirement  pickUpLocation with city and designation, pickUpEarliest, pickUpMeansOfTransport,
 *                       dropOffLocation with city and designation, dropOffMeansOfTransport, stopLocation with city and
 *                       designation, destinationDesignation
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Order {

    @NotNull(message = "reference is part of minimum requirement")
    private String reference;

    private Operator client;

    private Operator billRecipient;

    @NotNull(message = "luOrder is part of minimum requirement")
    private LUOrder luOrder;

    @NotNull(message = "transport is part of minimum requirement")
    @TransportConstraint(
        message = "pickUpLocation (with city and designation), pickUpEarliest, pickUpMoT, "
            + "dropOffLocation (with city and designation), dropOffMoT and stopLocation (with city and designation) "
            + "are part of minimum requirement of Transport"
    )
    private Transport transport;

    @NotNull(message = "destination is part of minimum requirement")
    @DestinationConstraint(message = "locationDesignation is part of minimum requirement of Transport")
    private Destination destination;

    public static Builder newBuilder() {

        return new Builder();
    }


    public String getReference() {

        return reference;
    }


    public Operator getClient() {

        return client;
    }


    public Operator getBillRecipient() {

        return billRecipient;
    }


    public LUOrder getLuOrder() {

        return luOrder;
    }


    public Transport getTransport() {

        return transport;
    }


    @JsonIgnore
    public Direction getTransportDirection() {

        return transport.getDirection();
    }


    @JsonIgnore
    public Transport.PickUp getPickUp() {

        return this.transport.getPickUp();
    }


    @JsonIgnore
    public Transport.DropOff getDropOff() {

        return this.transport.getDropOff();
    }


    @JsonIgnore
    public List<Stop> getStops() {

        return this.transport.getStops();
    }


    public Destination getDestination() {

        return destination;
    }


    @Override
    public String toString() {

        try {
            return this.getClass().getSimpleName() + ": " + JsonStringMapper.map(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static final class Builder {

        private String destinationCity;
        private String destinationDesignation;
        private String destinationSeaport;
        private Vessel destinationVessl;
        private String destinationCountryCode;
        private String reference;
        private Operator client;
        private Operator billRecipient;
        private LUOrder luOrder;
        private Transport transport = new Transport();

        private Builder() {
        }

        public Builder withTransportDirection(Direction direction) {

            this.transport.setDirection(direction);

            return this;
        }


        public Builder withReference(String reference) {

            this.reference = reference;

            return this;
        }


        public Builder withClient(Operator client) {

            this.client = client;

            return this;
        }


        public Builder withBillRecipient(Operator billRecipient) {

            this.billRecipient = billRecipient;

            return this;
        }


        public Builder withOrderForLoadingUnit(LUOrder luOrder) {

            this.luOrder = luOrder;

            return this;
        }


        public Builder withPickUpLocation(String city, String designation, String type) {

            this.transport.setPickUpLocation(city, designation, type);

            return this;
        }


        public Builder withPickUpLocation(String city, String designation) {

            this.transport.setPickUpLocation(city, designation);

            return this;
        }


        public Builder withEarliestPickUp(Instant instant) {

            this.transport.setEarliestPickUp(instant);

            return this;
        }


        public Builder withLatestPickUp(Instant instant) {

            this.transport.setLatestPickUp(instant);

            return this;
        }


        public Builder withPickUpMeansOfTransport(MeansOfTransport meansOfTransport) {

            this.transport.setPickUpMoT(meansOfTransport);

            return this;
        }


        public Builder withLoadingUnitToPickUp(String reference, Boolean isEmpty) {

            this.transport.setPickUpLoadingUnit(reference, isEmpty);

            return this;
        }


        public Builder withPickUpLoadingUnitOperator(Operator operator) {

            this.transport.setPickUpLoadingUnitOperator(operator);

            return this;
        }


        public Builder withBillingReferenceForPickUp(String billingReference) {

            this.transport.setPickUpBillingReference(billingReference);

            return this;
        }


        public Builder withDropOffLocation(String city, String designation, String type) {

            this.transport.setDropOffLocation(city, designation, type);

            return this;
        }


        public Builder withDropOffLocation(String city, String designation) {

            this.transport.setDropOffLocation(city, designation);

            return this;
        }


        public Builder withEarliestDropOff(Instant instant) {

            this.transport.setEarliestDropOff(instant);

            return this;
        }


        public Builder withLatestDropOff(Instant instant) {

            this.transport.setLatestDropOff(instant);

            return this;
        }


        public Builder withDropOffMeansOfTransport(MeansOfTransport meansOfTransport) {

            this.transport.setDropOffMoT(meansOfTransport);

            return this;
        }


        public Builder withLoadingUnitToDropOff(String reference, Boolean isEmpty) {

            this.transport.setDropOffLoadingUnit(reference, isEmpty);

            return this;
        }


        public Builder withDropOffLoadingUnitOperator(Operator operator) {

            this.transport.setDropOffLoadingUnitOperator(operator);

            return this;
        }


        public Builder withBillingReferenceForDropOff(String billingReference) {

            this.transport.setDropOffBillingReference(billingReference);

            return this;
        }


        public Builder withStop(Stop stop) {

            this.transport.addStop(stop);

            return this;
        }


        public Builder withStops(List<Stop> stops) {

            stops.forEach(stop -> this.transport.addStop(stop));

            return this;
        }


        public Builder withDestinationSeaport(String name) {

            this.destinationSeaport = name;

            return this;
        }


        public Builder withDestinationVessel(Vessel vessel) {

            this.destinationVessl = vessel;

            return this;
        }


        public Builder withDestinationLocation(String city, String designation) {

            this.destinationCity = city;
            this.destinationDesignation = designation;

            return this;
        }


        public Builder withDestinationLocation(String designation) {

            this.destinationDesignation = designation;

            return this;
        }


        /**
         * @param  countryCode  2 characters (UN/LOCODE).
         *
         * @return
         */
        public Builder withDestinationCountryCode(String countryCode) {

            this.destinationCountryCode = countryCode;

            return this;
        }


        public Order build() {

            Order order = new Order();
            order.billRecipient = this.billRecipient;
            order.luOrder = this.luOrder;
            order.client = this.client;
            order.transport = this.transport;
            order.reference = this.reference;

            Destination destination = new Destination();
            destination.setCountryCode(destinationCountryCode);
            destination.setVessel(destinationVessl);

            Seaport seaport = new Seaport();
            seaport.setName(destinationSeaport);
            destination.setSeaport(seaport);

            Location location = new Location();
            location.setDesignation(destinationDesignation);
            location.setCity(destinationCity);
            destination.setLocation(location);

            order.destination = destination;

            return order;
        }


        public Order buildAndValidate() {

            Order order = this.build();

            Validator.validate(order);

            return order;
        }
    }
}
