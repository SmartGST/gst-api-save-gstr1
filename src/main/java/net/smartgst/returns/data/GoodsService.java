package net.smartgst.returns.data;

/**
 * Created by gowthaman on 27/11/16.
 */
public enum  GoodsService {
    GOODS("G"), SERVICE("S");
    private String value;

    GoodsService(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
