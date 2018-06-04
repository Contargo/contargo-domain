package net.contargo.intermodal.domain;

import com.fasterxml.jackson.core.JsonProcessingException;

import tec.units.ri.quantity.Quantities;

import javax.measure.Quantity;
import javax.measure.quantity.Mass;

import javax.validation.constraints.NotNull;

import static tec.units.ri.unit.Units.KILOGRAM;


/**
 * Case for the transport of goods for the change to another {@link MeansOfTransport means of transport}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Container
 * @name_english  Container
 * @definition_german  Behälter für den Gütertransport für den Wechsel von einer zur anderen
 *                     {@link MeansOfTransport Transportform}.
 * @definition_english  Case for the transport of goods for the change to another
 *                      {@link MeansOfTransport means of transport}.
 * @note_german  Containertypen können Flat-, Open-Top-, High-Cube-, Bulk-, ISO-, Reefer- oder Tank-Container sein.
 *               (@see DIN EN ISO 17261:2012-12, 3.14 — modifiziert, Änderung der Anmerkung)
 * @note_english  Container types can be flat, open top, high cube, bulk, ISO, reefer- or tank containers. (@see DIN EN
 *                ISO 17261:2012-12, 3.14 — modifiziert, Änderung der Anmerkung)
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 * @minimum_requirement  sizeType, type, size, also @see minimum requirements of {@link LoadingUnit}
 */
public class Container extends LoadingUnit {

    /**
     * ISO 6346 Container Size Type e.g. 20G0 for GENERAL PURPOSE CONTAINERS
     */
    @NotNull(message = "sizeType is part of minimum requirement")
    private String sizeType;

    /**
     * e.g. flat, open top, high cube, bulk, ISO, reefer- or tank containers.
     */
    @NotNull(message = "type is part of minimum requirement")
    private String type;

    /**
     * in foot.
     */
    @NotNull(message = "size is part of minimum requirement")
    private Integer size;

    public Container withSizeType(String sizeType) {

        this.sizeType = sizeType;

        return this;
    }


    public Container withType(String type) {

        this.type = type;

        return this;
    }


    public Container withSize(Integer size) {

        this.size = size;

        return this;
    }


    public String getSizeType() {

        return sizeType;
    }


    public String getType() {

        return type;
    }


    public Integer getSize() {

        return size;
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

        private String identification;
        private String number;
        private LoadingUnitCategory category;
        private Quantity<Mass> weightBruttoMax;
        private Quantity<Mass> weightNettoMax;
        private String sizeType;
        private Quantity<Mass> weightTara;
        private String condition;
        private String type;
        private Boolean reefer;
        private Integer size;
        private String operator;

        private Builder() {
        }

        public static Builder newContainer() {

            return new Builder();
        }


        public Builder withIdentification(String identification) {

            this.identification = identification;

            return this;
        }


        public Builder withNumber(String number) {

            this.number = number;

            return this;
        }


        public Builder withWeightBruttoMax(Double weightBruttoMax, MassUnit unit) {

            if (unit.equals(MassUnit.KILOGRAM)) {
                this.weightBruttoMax = Quantities.getQuantity(weightBruttoMax, KILOGRAM);
            } else {
                // TODO
            }

            return this;
        }


        public Builder withWeightNettoMax(Double weightNettoMax, MassUnit unit) {

            if (unit.equals(MassUnit.KILOGRAM)) {
                this.weightNettoMax = Quantities.getQuantity(weightNettoMax, KILOGRAM);
            } else {
                // TODO
            }

            return this;
        }


        public Builder withSizeType(String sizeType) {

            this.sizeType = sizeType;

            return this;
        }


        public Builder withWeightTara(Double weightTara, MassUnit unit) {

            if (unit.equals(MassUnit.KILOGRAM)) {
                this.weightTara = Quantities.getQuantity(weightTara, KILOGRAM);
            } else {
                // TODO
            }

            return this;
        }


        public Builder withCondition(String condition) {

            this.condition = condition;

            return this;
        }


        public Builder withType(String type) {

            this.type = type;

            return this;
        }


        public Builder isReefer(Boolean reefer) {

            this.reefer = reefer;

            return this;
        }


        public Builder withSize(Integer size) {

            this.size = size;

            return this;
        }


        public Builder withOperator(String operator) {

            this.operator = operator;

            return this;
        }


        public Container build() {

            Container container = new Container();
            container.setIdentification(identification);
            container.setNumber(number);
            container.setCondition(condition);
            container.setReefer(reefer);
            container.setOperator(operator);
            container.sizeType = this.sizeType;
            container.type = this.type;
            container.size = this.size;

            if (weightBruttoMax != null || weightNettoMax != null) {
                Weight weight = new Weight();
                weight.setBruttoMax(weightBruttoMax);
                weight.setNettoMax(weightNettoMax);
                weight.setTara(weightTara);
                container.setWeight(weight);
            }

            container.setCategory(LoadingUnitCategory.CONTAINER);

            return container;
        }


        public Container buildAndValidate() {

            Container container = this.build();

            Validator.validate(container);

            return container;
        }
    }
}
