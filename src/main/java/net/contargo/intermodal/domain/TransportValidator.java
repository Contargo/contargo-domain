package net.contargo.intermodal.domain;

import java.lang.annotation.*;

import java.util.List;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;


/**
 * Validator to check whether the minimum requirements of the volume of a {@link Transport} are fulfilled.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class TransportValidator implements ConstraintValidator<TransportConstraint, Transport> {

    public TransportValidator() {

        // OK
    }

    @Override
    public boolean isValid(Transport transport, ConstraintValidatorContext constraintValidatorContext) {

        return isValid(transport.getPickUp()) && isValid(transport.getDropOff()) && isValid(transport.getStops());
    }


    private boolean isValid(PickUp pickUp) {

        return pickUp != null && isValid(pickUp.getLocation()) && pickUp.getEarliest() != null
            && pickUp.getMeansOfTransport() != null;
    }


    private boolean isValid(DropOff dropOff) {

        return dropOff != null && isValid(dropOff.getLocation()) && dropOff.getMot() != null;
    }


    private boolean isValid(Location location) {

        return location != null && location.getCity() != null && location.getDesignation() != null;
    }


    private boolean isValid(List<Stop> stops) {

        return stops != null && stops.stream().noneMatch(stop -> stop.getLocations() == null)
            && stops.stream().flatMap(stop -> stop.getLocations().stream()).anyMatch(location ->
                    location.getCity() != null && location.getDesignation() != null);
    }
}

@Documented
@Constraint(validatedBy = TransportValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@interface TransportConstraint {

    String message() default "Transport invalid";


    Class<?>[] groups() default {};


    Class<? extends Payload>[] payload() default {};
}
