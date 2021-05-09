package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Subscription {

    @JsonProperty("type")
    private String type;

    @JsonProperty("product_ids")
    private String[] productIds;

    @JsonProperty("channels")
    private String[] channels;

    public String getType(){
        return this.type;
    }

    public void setType(String type){
        this.type = type;
    }

    public String[] getProductIds(){
        return this.productIds;
    }

    public void setProductIds(String[] productIds){
        this.productIds = productIds;
    }

    public String[] getChannels(){
        return this.channels;
    }

    public void setChannels(String[] channels){
        this.channels = channels;
    }

    @Override
    public String toString(){
        return "{" +
                "\"type\": " + this.type + "," +
                "\"product_ids\":" + this.productIds + "," +
                "\"channels\":" + this.channels + "}";
    }
}
