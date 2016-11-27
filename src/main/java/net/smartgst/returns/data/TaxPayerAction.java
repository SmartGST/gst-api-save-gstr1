package net.smartgst.returns.data;

/**
 * Created by gowthaman on 27/11/16.
 */
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
