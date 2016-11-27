package net.smartgst.returns.gstr1.data;


public enum TaxPayerAction {
    MODIFY("M"), DELETE("D"), ACCEPT("A"), REJECT("R");

    private String value;
    TaxPayerAction(String val) {
        this.value = val;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
