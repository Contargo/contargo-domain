package net.contargo.intermodal.domain;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.time.LocalDate;


/**
 * A {@link Person} transported on a {@link Barge} as described in {@link ProcessingBarge}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Passagier
 * @name_english  passenger
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Passenger extends Person {

    private Passenger() {

        // OK
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


    /**
     * Creates a new builder for {@link Passenger}.
     *
     * @return  new builder
     */
    public static Builder newBuilder() {

        return new Builder();
    }


    /**
     * Creates a new builder with the values of another {@link Passenger}.
     *
     * @param  passenger  that should be copied.
     *
     * @return  new builder with values of given passenger.
     */
    public static Builder newBuilder(Passenger passenger) {

        return new Builder().named(passenger.getFirstName(), passenger.getName())
            .withAddress(passenger.getAddress())
            .withCellphoneNumber(passenger.getCellphone())
            .bornOn(passenger.getDateOfBirth())
            .bornIn(passenger.getCityOfBirth())
            .withNationality(passenger.getNationality());
    }

    public static final class Builder {

        private String name;
        private String firstName;
        private Address address;
        private String cellphone;
        private LocalDate dateOfBirth;
        private Location location;
        private String countryCode;

        private Builder() {
        }

        public Builder named(String firstName, String lastName) {

            this.firstName = firstName;
            this.name = lastName;

            return this;
        }


        public Builder withAddress(Address address) {

            this.address = address;

            return this;
        }


        public Builder withCellphoneNumber(String cellphone) {

            this.cellphone = cellphone;

            return this;
        }


        /**
         * @param  dateOfBirth  Format yyyy-mm-dd
         *
         * @return  this
         */
        public Builder bornOn(String dateOfBirth) {

            this.dateOfBirth = LocalDate.parse(dateOfBirth);

            return this;
        }


        Builder bornOn(LocalDate dateOfBirth) {

            this.dateOfBirth = dateOfBirth;

            return this;
        }


        public Builder bornIn(Location location) {

            this.location = location;

            return this;
        }


        public Builder withNationality(String unLocode) {

            this.countryCode = unLocode;

            return this;
        }


        /**
         * Builds {@link Passenger} without input validation.
         *
         * @return  new {@link Passenger} with attributes specified in {@link Builder}
         */
        public Passenger build() {

            Passenger passenger = new Passenger();
            passenger.setName(name);
            passenger.setFirstName(firstName);
            passenger.setAddress(address);
            passenger.setCellphone(cellphone);
            passenger.setDateOfBirth(dateOfBirth);
            passenger.setCityOfBirth(location);
            passenger.setNationality(countryCode);

            return passenger;
        }


        /**
         * Validates the input and builds {@link Passenger}. Throws IllegalStateException if input doesn't fulfill the
         * minimum requirement of {@link Passenger}.
         *
         * @return  new {@link Passenger} with attributes specified in {@link Builder}
         */
        public Passenger buildAndValidate() {

            Passenger passenger = this.build();

            MinimumRequirementValidator.validate(passenger);

            return passenger;
        }
    }
}
