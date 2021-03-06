package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class PickUpTest {

    @Test
    void ensureCanBeCreatedWithAllInformation() {

        PickUp pickUp = PickUp.newBuilder()
                .withLocation(Location.newBuilder()
                        .withCity("Ludwigshafen")
                        .withDesignation("Terminal Ludwigshafen")
                        .withType("hinterland terminal")
                        .buildAndValidate())
                .withLoadingUnit("12345", false)
                .withBillingReference("20568097")
                .withLoadingUnitOperator(TestDataCreator.createOperator())
                .withEarliest(Instant.parse("2018-05-14T11:00:00Z"))
                .withLatest(Instant.parse("2018-05-14T11:30:00Z"))
                .withMeansOfTransport(TestDataCreator.createTruckChassisCombination())
                .buildAndValidate();

        assertEquals("Ludwigshafen", pickUp.getLocation().getCity());
        assertEquals("Terminal Ludwigshafen", pickUp.getLocation().getDesignation());
        assertEquals("hinterland terminal", pickUp.getLocation().getType());
        assertEquals("12345", pickUp.getLoadingUnit().getReference());
        assertFalse(pickUp.getLoadingUnit().getEmpty());
        assertEquals("20568097", pickUp.getBillingReference());
        assertNotNull(pickUp.getLoadingUnit().getOperator());
        assertEquals("2018-05-14T11:00:00Z", pickUp.getEarliest().toString());
        assertEquals("2018-05-14T11:30:00Z", pickUp.getLatest().toString());
        assertNotNull(pickUp.getMeansOfTransport());
    }


    @Test
    void ensureCanBeCreatedWithAllInformationWithStepBuilder() {

        PickUp pickUp = PickUp.newStepBuilder()
                .withLocation(Location.newBuilder()
                        .withCity("Ludwigshafen")
                        .withDesignation("Terminal Ludwigshafen")
                        .withType("hinterland terminal")
                        .buildAndValidate())
                .withEarliest(Instant.parse("2018-05-14T11:00:00Z"))
                .withMeansOfTransport(TestDataCreator.createTruckChassisCombination())
                .withLoadingUnit("12345", false)
                .withBillingReference("20568097")
                .withLoadingUnitOperator(TestDataCreator.createOperator())
                .withLatest(Instant.parse("2018-05-14T11:30:00Z"))
                .buildAndValidate();

        assertEquals("Ludwigshafen", pickUp.getLocation().getCity());
        assertEquals("Terminal Ludwigshafen", pickUp.getLocation().getDesignation());
        assertEquals("hinterland terminal", pickUp.getLocation().getType());
        assertEquals("12345", pickUp.getLoadingUnit().getReference());
        assertFalse(pickUp.getLoadingUnit().getEmpty());
        assertEquals("20568097", pickUp.getBillingReference());
        assertNotNull(pickUp.getLoadingUnit().getOperator());
        assertEquals("2018-05-14T11:00:00Z", pickUp.getEarliest().toString());
        assertEquals("2018-05-14T11:30:00Z", pickUp.getLatest().toString());
        assertNotNull(pickUp.getMeansOfTransport());
    }


    @Test
    void ensureCanBeCreatedWithMinimumRequirements() {

        PickUp.newBuilder()
            .withLocation(Location.newBuilder()
                    .withCity("Ludwigshafen")
                    .withDesignation("Terminal Ludwigshafen")
                    .buildAndValidate())
            .withEarliest(Instant.parse("2018-05-14T11:00:00Z"))
            .withMeansOfTransport(TestDataCreator.createTruckChassisCombination())
            .buildAndValidate();
    }


    @Test
    void ensureCanBeCopied() {

        PickUp pickUp = PickUp.newBuilder()
                .withLocation(Location.newBuilder()
                        .withCity("Ludwigshafen")
                        .withDesignation("Terminal Ludwigshafen")
                        .withType("hinterland terminal")
                        .buildAndValidate())
                .withLoadingUnit("12345", false)
                .withBillingReference("20568097")
                .withLoadingUnitOperator(TestDataCreator.createOperator())
                .withEarliest(Instant.parse("2018-05-14T11:00:00Z"))
                .withLatest(Instant.parse("2018-05-14T11:30:00Z"))
                .withMeansOfTransport(TestDataCreator.createTruckChassisCombination())
                .buildAndValidate();

        PickUp copiedPickUp = PickUp.newBuilder(pickUp).buildAndValidate();

        assertEquals("Ludwigshafen", copiedPickUp.getLocation().getCity());
        assertEquals("Terminal Ludwigshafen", copiedPickUp.getLocation().getDesignation());
        assertEquals("hinterland terminal", copiedPickUp.getLocation().getType());
        assertEquals("12345", copiedPickUp.getLoadingUnit().getReference());
        assertFalse(copiedPickUp.getLoadingUnit().getEmpty());
        assertEquals("20568097", copiedPickUp.getBillingReference());
        assertNotNull(copiedPickUp.getLoadingUnit().getOperator());
        assertEquals("2018-05-14T11:00:00Z", copiedPickUp.getEarliest().toString());
        assertEquals("2018-05-14T11:30:00Z", copiedPickUp.getLatest().toString());
        assertNotNull(copiedPickUp.getMeansOfTransport());
    }


    @Test
    void ensureMinimumRequirementIsChecked() {

        assertThrows(IllegalStateException.class,
            () ->
                PickUp.newBuilder()
                    .withEarliest(Instant.parse("2018-05-14T11:00:00Z"))
                    .withMeansOfTransport(TestDataCreator.createTruckChassisCombination())
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                PickUp.newBuilder()
                    .withLocation(Location.newBuilder().withDesignation("Terminal Ludwigshafen").buildAndValidate())
                    .withEarliest(Instant.parse("2018-05-14T11:00:00Z"))
                    .withMeansOfTransport(TestDataCreator.createTruckChassisCombination())
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                PickUp.newBuilder()
                    .withLocation(Location.newBuilder().withCity("Ludwigshafen").buildAndValidate())
                    .withEarliest(Instant.parse("2018-05-14T11:00:00Z"))
                    .withMeansOfTransport(TestDataCreator.createTruckChassisCombination())
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                PickUp.newBuilder()
                    .withLocation(
                            Location.newBuilder()
                                .withCity("Ludwigshafen")
                                .withDesignation("Terminal Ludwigshafen")
                                .buildAndValidate())
                    .withMeansOfTransport(TestDataCreator.createTruckChassisCombination())
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                PickUp.newBuilder()
                    .withLocation(
                            Location.newBuilder()
                                .withCity("Ludwigshafen")
                                .withDesignation("Terminal Ludwigshafen")
                                .buildAndValidate())
                    .withEarliest(Instant.parse("2018-05-14T11:00:00Z"))
                    .buildAndValidate());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        PickUp pickUp = PickUp.newBuilder()
                .withLocation(Location.newBuilder()
                        .withCity("Ludwigshafen")
                        .withDesignation("Terminal Ludwigshafen")
                        .withType("hinterland terminal")
                        .buildAndValidate())
                .withLoadingUnit("12345", false)
                .withBillingReference("20568097")
                .withLoadingUnitOperator(TestDataCreator.createOperator())
                .withEarliest(Instant.parse("2018-05-14T11:00:00Z"))
                .withLatest(Instant.parse("2018-05-14T11:30:00Z"))
                .withMeansOfTransport(TestDataCreator.createTruckChassisCombination())
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(pickUp);

        PickUp deserialize = mapper.readValue(jsonString, PickUp.class);

        assertEquals("Ludwigshafen", deserialize.getLocation().getCity());
        assertEquals("Terminal Ludwigshafen", deserialize.getLocation().getDesignation());
        assertEquals("hinterland terminal", deserialize.getLocation().getType());
        assertEquals("12345", deserialize.getLoadingUnit().getReference());
        assertFalse(deserialize.getLoadingUnit().getEmpty());
        assertEquals("20568097", deserialize.getBillingReference());
        assertNotNull(deserialize.getLoadingUnit().getOperator());
        assertEquals("2018-05-14T11:00:00Z", deserialize.getEarliest().toString());
        assertEquals("2018-05-14T11:30:00Z", deserialize.getLatest().toString());
        assertNotNull(deserialize.getMeansOfTransport());
    }
}
