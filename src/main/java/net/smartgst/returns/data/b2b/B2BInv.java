package net.smartgst.returns.data.b2b;

import net.smartgst.returns.data.TaxPayerAction;

import java.util.Date;
import java.util.List;

/**
 * Created by gowthaman on 27/11/16.
 */
public class B2BInv {
    public TaxPayerAction taxPayerAction;

    public String checkSum;

    public String supplierInvNum;

    public Date supplierInvDt;
    public String originalInvNum;

    public Date originalInvDt;

    public double supplierInvVal;

    public String pos;

    public boolean reverseCharge;

    public boolean provisionalAssessment;

    public List<B2BInvItem> items;
}
