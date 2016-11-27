package net.smartgst.returns.gstr1.data;

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
