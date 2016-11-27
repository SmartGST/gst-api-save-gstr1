package net.smartgst.returns.gstr1.data;

/**
 * Created by gowthaman on 27/11/16.
 */
public class InvLineItem {
    public int slNo;

    public TaxPayerAction action;

    public GoodsService goodsOrService;

    public String goodsOrServiceCode;
    
    public double taxableValue;
    
    public double igstRate;
    
    public double igstAmt;

    public double cgstRate;
    
    public double cgstAmt;

    public double sgstRate;
    
    public double sgstAmt;

    public String stateCode;

}
