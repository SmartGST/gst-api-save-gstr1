package net.smartgst.returns.gstr1.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import net.smartgst.returns.gstr1.data.BaseData;
import net.smartgst.returns.gstr1.data.InvLineItem;
import net.smartgst.returns.gstr1.data.Invoice;

import java.io.IOException;
import java.text.SimpleDateFormat;

abstract class BaseSerializer<T extends BaseData> extends JsonSerializer<T> {
    final SimpleDateFormat gstFmt = new SimpleDateFormat("dd-MM-yyyy");
    final SimpleDateFormat fpFormat = new SimpleDateFormat("MMyyyy");


    void writeInvoices(T b2B, JsonGenerator json) throws IOException {
        //Start Invoice Details
        json.writeFieldName("inv");
        json.writeStartArray();

        b2B.invoices.forEach(inv -> writeInvoice(b2B, json, inv));


        json.writeEndArray();
        //end Invoice Details
    }

    private void writeInvoice(T b2B, JsonGenerator json, Invoice inv) {
        try {
            json.writeStartObject();
            if (inv.taxPayerAction != null)
                json.writeStringField("flag", inv.taxPayerAction.getValue());

            json.writeStringField("chksum", inv.checkSum);

            json.writeStringField("inum", inv.supplierInvNum);
            json.writeStringField("idt", gstFmt.format(inv.supplierInvDt));
            json.writeNumberField("val", inv.supplierInvVal);
            json.writeStringField("pos", inv.pos);
            json.writeStringField("rchrg", inv.reverseCharge ? "Yes" : "No");
            json.writeStringField("prs", inv.provisionalAssessment ? "Y" : "N");
            if (b2B.isAmendment) {
                //b2ba b2cla b2csa etc ...
                json.writeStringField("od_num", inv.originalInvNum);
                json.writeStringField("od_dt", gstFmt.format(inv.originalInvDt));
            }


            writeLineItems(b2B, json, inv);


            json.writeEndObject();
        } catch (Exception e) {
            //log
            e.printStackTrace();
        }
    }

    private void writeLineItems(T b2B, JsonGenerator json, Invoice inv) throws IOException {
        //Start Line Items
        json.writeFieldName("itms");
        json.writeStartArray();
        inv.items.forEach(li -> writeLineItem(b2B, json, li));
        //End Line Items

        json.writeEndArray();
    }

    private void writeLineItem(T b2B, JsonGenerator json, InvLineItem li) {
        try {
            json.writeStartObject();
            json.writeNumberField("num", li.slNo);
            if (li.action != null)
                json.writeStringField("status", li.action.getValue());

            json.writeFieldName("itm_det");

            json.writeStartObject();
            json.writeStringField("ty", li.goodsOrService.getValue());
            json.writeStringField("hsn_sc", li.goodsOrServiceCode);
            json.writeNumberField("txval", li.taxableValue);

            json.writeNumberField("irt", li.igstRate);
            json.writeNumberField("iamt", li.igstAmt);

            json.writeNumberField("crt", li.cgstRate);
            json.writeNumberField("camt", li.cgstAmt);

            json.writeNumberField("srt", li.sgstRate);
            json.writeNumberField("samt", li.sgstAmt);

            json.writeNumberField("csrt", li.csRate);
            json.writeNumberField("csamt", li.csAmt);

            json.writeEndObject();

            json.writeEndObject();
        } catch (Exception e) {
            //log
            e.printStackTrace();
        }
    }

}
