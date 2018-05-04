package net.contargo.intermodal.domain.loadingUnit;

import javax.validation.constraints.NotNull;


/**
 * {@link net.contargo.intermodal.domain.loadingUnit.LoadingUnit} intended for the transport of goods, optimized with
 * regard to the dimensions of road vehicles and equipped with gripping edges for the transfer between means of
 * transport, usually between road/rail transport.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Wechselbrücke
 * @name_english  swap body
 * @abbreviation_english  SB
 * @synonym_german  Wechselbehälter, Wechselaufbau
 * @definition_german  Für den Gütertransport bestimmter Behälter, der im Hinblick auf die Abmessungen von
 *                     Straßenfahrzeugen optimiert wurde und mit Greifkanten für den Umschlag zwischen den
 *                     Verkehrsmitteln, in der Regel der Verkehrsträger Straße-Schiene, ausgestattet ist.
 * @definition_english  Loading unit intended for the transport of goods, optimized with regard to the dimensions of
 *                      road vehicles and equipped with gripping edges for the transfer between means of transport,
 *                      usually between road and rail transport.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class SwapBody extends LoadingUnit implements Wechselbrücke, Wechselaufbau, Wechselbehälter {

    /**
     * e.g. Klasse A, Klasse C (C715, C745, C765, C782), Open Top
     */
    @NotNull(message = "type is part of minimum requirement")
    private String type;

    /**
     * in foot.
     */
    @NotNull(message = "size is part of minimum requirement")
    private Double size;

    @NotNull(message = "stackable is part of minimum requirement")
    private Boolean stackable;

    public SwapBody() {

        super.withCategory(LoadingUnitCategory.SWAP_BODY);
    }

    public SwapBody withType(String type) {

        this.type = type;

        return this;
    }


    public SwapBody withSize(Double size) {

        this.size = size;

        return this;
    }


    public SwapBody isStackable(Boolean stackable) {

        this.stackable = stackable;

        return this;
    }


    @Override
    public SwapBody withIdentification(String identification) {

        super.withIdentification(identification);

        return this;
    }


    @Override
    public SwapBody withNumber(String number) {

        super.withNumber(number);

        return this;
    }


    @Override
    public SwapBody withWeightBruttoMax(double weightBruttoMax) {

        super.withWeightBruttoMax(weightBruttoMax);

        return this;
    }


    @Override
    public SwapBody withWeightNettoMax(double weightNettoMax) {

        super.withWeightNettoMax(weightNettoMax);

        return this;
    }


    @Override
    public SwapBody withWeightTara(double weightTara) {

        super.withWeightTara(weightTara);

        return this;
    }


    @Override
    public SwapBody withCondition(String condition) {

        super.withCondition(condition);

        return this;
    }


    @Override
    public SwapBody isReefer(Boolean reefer) {

        super.isReefer(reefer);

        return this;
    }


    @Override
    public SwapBody withOperator(String operator) {

        super.withOperator(operator);

        return this;
    }


    public String getType() {

        return type;
    }


    public Double getSize() {

        return size;
    }


    public Boolean isStackable() {

        return stackable;
    }
}

interface Wechselbrücke {
}

interface Wechselbehälter {
}

interface Wechselaufbau {
}
