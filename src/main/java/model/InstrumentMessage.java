package model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InstrumentMessage {

    @JsonProperty("instrument")
    private Instrument instrument;

    @JsonAlias("product_id")
    @JsonSetter("instrument")
    private void setInstrument(String product_id) throws Exception{
        if(product_id != null ){
            this.instrument = Instrument.valueOf(product_id.replaceAll("-",""));
        }
    }

    @JsonAlias("best_bid")
    @JsonProperty("bid")
    private double bid;

    @JsonAlias("best_ask")
    @JsonProperty("ask")
    private double ask;

    @JsonAlias("price")
    @JsonProperty("last")
    private double last;

    @JsonProperty("time")
    private String time;

    @JsonAlias("time")
    @JsonSetter("time")
    private void setTime(String time) throws Exception{
        if(time != null) {
            OffsetDateTime off = OffsetDateTime.parse(time);
            this.time = off.toLocalTime().truncatedTo(ChronoUnit.SECONDS).toString();
        }
    }


    public Instrument getInstrument(){
        return this.instrument;
    }

    public double getBid(){
        return this.bid;
    }

    public double getAsk(){
        return this.ask;
    }

    public double getLast(){
        return this.last;
    }

    public String getTime(){
        return this.time;
    }


    @Override
    public String toString(){
        return "{" +
                "\"instrument\": " + this.instrument + "," +
                "\"bid\":" + this.bid + "," +
                "\"ask\":" + this.ask + "," +
                "\"last\":" + this.last + "," +
                "\"time\":" + this.time +"}";
    }
}
