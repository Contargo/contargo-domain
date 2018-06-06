package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.LUOrder;
import net.contargo.intermodal.domain.ProcessingBarge;
import net.contargo.intermodal.domain.ProcessingTrain;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class ProcessingTrainTest {

    @Test
    void ensureCanBeCreated() {

        ProcessingTrain processingTrain = ProcessingTrain.Builder.newProcessingTrain()
                .withTrainTitle("My Train")
                .withWaggon("SGNRS", "789784", 1, Arrays.asList(new LUOrder()))
                .withWaggon("SGNRS", "54789", 2, Arrays.asList(new LUOrder()))
                .withWaggon("SGNRS", "24568", 3, Arrays.asList(new LUOrder(), new LUOrder()))
                .withTerminalEta(2018, 5, 14, 11, 0)
                .withTerminalEtd(2018, 5, 14, 13, 0)
                .withShuntingYardEta(2018, 5, 14, 12, 0)
                .withShunter("a shunter")
                .withTrainPaths("12345")
                .buildAndValidate();

        assertEquals("My Train", processingTrain.getTrainTitle());
        assertEquals(3, processingTrain.getLoadingList().size());
        assertEquals("789784", processingTrain.getLoadingList().get(0).getId());
        assertEquals("54789", processingTrain.getLoadingList().get(1).getId());
        assertEquals("24568", processingTrain.getLoadingList().get(2).getId());
        assertEquals(2, processingTrain.getLoadingList().get(2).getLoadingPosition().size());
        assertEquals("2018-05-14T11:00:00", processingTrain.getTerminalEta());
        assertEquals("2018-05-14T13:00:00", processingTrain.getTerminalEtd());
        assertEquals("2018-05-14T12:00:00", processingTrain.getShuntingYardEta());
        assertEquals("a shunter", processingTrain.getShunter());
        assertEquals("12345", processingTrain.getTrainPaths());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        ProcessingTrain processingTrain = ProcessingTrain.Builder.newProcessingTrain()
                .withTrainTitle("My Train")
                .withWaggon("SGNRS", "789784", 1, Arrays.asList(new LUOrder()))
                .withWaggon("SGNRS", "54789", 2, Arrays.asList(new LUOrder()))
                .withWaggon("SGNRS", "24568", 3, Arrays.asList(new LUOrder(), new LUOrder()))
                .withTerminalEta(2018, 5, 14, 11, 0)
                .withTerminalEtd(2018, 5, 14, 13, 0)
                .withShuntingYardEta(2018, 5, 14, 12, 0)
                .withShunter("a shunter")
                .withTrainPaths("12345")
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(processingTrain);

        ProcessingTrain deserialize = mapper.readValue(jsonString, ProcessingTrain.class);

        assertEquals("My Train", deserialize.getTrainTitle());
        assertEquals(3, deserialize.getLoadingList().size());
        assertEquals("789784", deserialize.getLoadingList().get(0).getId());
        assertEquals("54789", deserialize.getLoadingList().get(1).getId());
        assertEquals("24568", deserialize.getLoadingList().get(2).getId());
        assertEquals(2, deserialize.getLoadingList().get(2).getLoadingPosition().size());
        assertEquals("2018-05-14T11:00:00", deserialize.getTerminalEta());
        assertEquals("2018-05-14T13:00:00", deserialize.getTerminalEtd());
        assertEquals("2018-05-14T12:00:00", deserialize.getShuntingYardEta());
        assertEquals("a shunter", deserialize.getShunter());
        assertEquals("12345", deserialize.getTrainPaths());
    }
}
