package net.contargo.intermodal.domain;

import systems.uom.common.Imperial;

import tec.units.ri.quantity.Quantities;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;

import static systems.uom.common.USCustomary.FOOT;

import static tec.units.ri.unit.Units.CELSIUS;
import static tec.units.ri.unit.Units.KILOGRAM;
import static tec.units.ri.unit.Units.METRE;


/**
 * For conversion between different {@link Unit Units}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
final class UnitConverter {

    public static Quantity<Length> footToMetre(double value) {

        javax.measure.UnitConverter toMeter = FOOT.getConverterTo(METRE);

        return Quantities.getQuantity(toMeter.convert(value), METRE);
    }


    public static Quantity<Length> metreToFoot(double value) {

        javax.measure.UnitConverter toFoot = METRE.getConverterTo(FOOT);

        return Quantities.getQuantity(toFoot.convert(value), FOOT);
    }


    public static Quantity<Mass> kilogramToTon(double value) {

        javax.measure.UnitConverter toTon = KILOGRAM.getConverterTo(Imperial.METRIC_TON);

        return Quantities.getQuantity(toTon.convert(value), Imperial.METRIC_TON);
    }


    public static Quantity<Mass> tonToKilogram(double value) {

        javax.measure.UnitConverter toKilogram = Imperial.METRIC_TON.getConverterTo(KILOGRAM);

        return Quantities.getQuantity(toKilogram.convert(value), KILOGRAM);
    }


    public static Unit<?> symbolToUnit(String symbol) {

        switch (symbol.toLowerCase()) {
            case "m":
                return METRE;

            case "ft":
                return FOOT;

            case "kg":
                return KILOGRAM;

            case "t":

                return Imperial.METRIC_TON;

            case "°c":

                return CELSIUS;

            default:
                throw new IllegalStateException(String.format("Unknown unit %s", symbol));
        }
    }
}
