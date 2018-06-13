package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.Destination;
import net.contargo.intermodal.domain.Vessel;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class DestinationTest {

    @Test
    void ensureCanBeCreatedWithAllInformation() {

        Destination destination = Destination.newBuilder()
                .withVessel(new Vessel())
                .withCountryCode("DE")
                .withLocation("Duisburg", "Terminal Duisburg")
                .withSeaport("DEDUI")
                .buildAndValidate();

        assertNotNull(destination.getVessel());
        assertEquals("DE", destination.getCountryCode());
        assertEquals("Duisburg", destination.getLocation().getCity());
        assertEquals("Terminal Duisburg", destination.getLocation().getDesignation());
        assertEquals("DEDUI", destination.getSeaportName());
    }


    @Test
    void ensureCanBeCreatedWithMinimumRequirements() {

        Destination.newBuilder().withLocation("Terminal Duisburg").buildAndValidate();
    }


    @Test
    void ensureMinimumRequirementIsChecked() {

        assertThrows(IllegalStateException.class, () -> Destination.newBuilder().buildAndValidate());

        assertThrows(IllegalStateException.class,
            () -> Destination.newBuilder().withLocation(null).buildAndValidate());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        Destination destination = Destination.newBuilder()
                .withVessel(new Vessel())
                .withCountryCode("DE")
                .withLocation("Duisburg", "Terminal Duisburg")
                .withSeaport("DEDUI")
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(destination);

        Destination deserialize = mapper.readValue(jsonString, Destination.class);

        assertNotNull(deserialize.getVessel());
        assertEquals("DE", deserialize.getCountryCode());
        assertEquals("Duisburg", deserialize.getLocation().getCity());
        assertEquals("Terminal Duisburg", deserialize.getLocation().getDesignation());
        assertEquals("DEDUI", deserialize.getSeaportName());
    }
}
