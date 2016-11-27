package net.smartgst.returns.data.b2b;

import net.smartgst.returns.data.GoodsService;
import net.smartgst.returns.data.TaxPayerAction;

/**
 * Created by gowthaman on 27/11/16.
 */
public class B2BInvItem {
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

}
