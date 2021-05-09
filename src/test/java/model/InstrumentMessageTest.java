package model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static model.Instrument.BTCUSD;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstrumentMessageTest {


    final String jsonIn = "{\n" +
            "\"type\": \"ticker\",\n" +
            "\"sequence\": 14165935228,\n" +
            "\"product_id\": \"BTC-USD\",\n" +
            "\"price\": \"9584.18\",\n" +
            "\"open_24h\": \"9740.00000000\",\n" +
            "\"volume_24h\": \"19882.16807137\",\n" +
            "\"low_24h\": \"9436.97000000\",\n" +
            "\"high_24h\": \"9957.25000000\",\n" +
            "\"volume_30d\": \"654772.33925563\",\n" +
            "\"best_bid\": \"9584.18\",\n" +
            "\"best_ask\": \"9584.19\",\n" +
            "\"side\": \"sell\",\n" +
            "\"time\": \"2020-05-18T12:32:02.331872Z\",\n" +
            "\"trade_id\": 92323410,\n" +
            "\"last_size\": \"0.02252\"\n" +
            "}";

    @Test
    public void SerializationTest() throws Exception{

        ObjectMapper objectMapper = new ObjectMapper();

        InstrumentMessage instrumentMessage = objectMapper.readValue(jsonIn, InstrumentMessage.class);

        assertEquals(instrumentMessage.getInstrument(), BTCUSD);
        assertEquals(instrumentMessage.getBid(), 9584.18);
        assertEquals(instrumentMessage.getAsk(), 9584.19);
        assertEquals(instrumentMessage.getLast(), 9584.18);
        assertEquals(instrumentMessage.getTime(), "12:32:02");
    }
}
