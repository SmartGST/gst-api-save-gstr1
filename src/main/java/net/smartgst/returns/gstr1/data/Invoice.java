package net.smartgst.returns.gstr1.data;

import net.smartgst.returns.gstr1.data.InvLineItem;
import net.smartgst.returns.gstr1.data.TaxPayerAction;

import java.util.Date;
import java.util.List;


public class Invoice {
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

    public List<InvLineItem> items;
}
