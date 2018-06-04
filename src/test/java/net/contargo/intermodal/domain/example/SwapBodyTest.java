package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.LoadingUnitCategory;
import net.contargo.intermodal.domain.MassUnit;
import net.contargo.intermodal.domain.SwapBody;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class SwapBodyTest {

    @Test
    void ensureCanBeCreatedWithAllInformation() {

        SwapBody swapBody = SwapBody.Builder.newSwapBody()
                .withIdentification("OOOCSSSSSS")
                .withNumber("OOOCSSSSSS")
                .withWeightBruttoMax(70.0, MassUnit.KILOGRAM)
                .withWeightNettoMax(65.0, MassUnit.KILOGRAM)
                .withWeightTara(70.0, MassUnit.KILOGRAM)
                .withCondition("i.O.")
                .isReefer(false)
                .withOperator("Contargo")
                .withType("Open Top")
                .withSize(6.5)
                .isStackable(true)
                .buildAndValidate();

        assertEquals("OOOCSSSSSS", swapBody.getIdentification());
        assertEquals("OOOCSSSSSS", swapBody.getNumber());
        assertEquals(LoadingUnitCategory.SWAP_BODY, swapBody.getCategory());
        assertNotNull(swapBody.getWeight());
        assertEquals(70, swapBody.getWeightBruttoMax().getValue().doubleValue());
        assertEquals(65, swapBody.getWeightNettoMax().getValue().doubleValue());
        assertEquals(70, swapBody.getWeightTara().getValue().doubleValue());
        assertEquals("i.O.", swapBody.getCondition());
        assertFalse(swapBody.isReefer());
        assertEquals("Contargo", swapBody.getOperator());
        assertEquals("Open Top", swapBody.getType());
        assertEquals(6.5, swapBody.getSize().doubleValue());
        assertTrue(swapBody.isStackable());
    }


    @Test
    void ensureCanBeCreatedWithMinimumRequirements() {

        SwapBody.Builder.newSwapBody()
            .withNumber("OOOCSSSSSS")
            .isReefer(false)
            .withType("Open Top")
            .withSize(6.5)
            .isStackable(true)
            .buildAndValidate();
    }


    @Test
    void ensureMinimumRequirementIsChecked() {

        assertThrows(IllegalStateException.class,
            () ->
                SwapBody.Builder.newSwapBody()
                    .isReefer(false)
                    .withType("Open Top")
                    .withSize(6.5)
                    .isStackable(true)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                SwapBody.Builder.newSwapBody()
                    .withNumber("OOOCSSSSSS")
                    .withType("Open Top")
                    .withSize(6.5)
                    .isStackable(true)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                SwapBody.Builder.newSwapBody()
                    .withNumber("OOOCSSSSSS")
                    .isReefer(false)
                    .withSize(6.5)
                    .isStackable(true)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                SwapBody.Builder.newSwapBody()
                    .withNumber("OOOCSSSSSS")
                    .isReefer(false)
                    .withType("Open Top")
                    .isStackable(true)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                SwapBody.Builder.newSwapBody()
                    .withNumber("OOOCSSSSSS")
                    .isReefer(false)
                    .withType("Open Top")
                    .withSize(6.5)
                    .buildAndValidate());
    }
}
