package net.smartgst.returns.gstr1.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import net.smartgst.returns.gstr1.data.BaseData;
import net.smartgst.returns.gstr1.data.InvLineItem;
import net.smartgst.returns.gstr1.data.Invoice;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created by gowthaman on 27/11/16.
 */
abstract class BaseSerializer<T extends BaseData> extends JsonSerializer<T> {
    private final SimpleDateFormat gstFmt = new SimpleDateFormat("dd-MM-yyyy");

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

            json.writeStringField("flag", inv.taxPayerAction.getValue());
            json.writeStringField("chksum", inv.checkSum);
            json.writeStringField("inum", inv.supplierInvNum);
            json.writeStringField("idt", gstFmt.format(inv.supplierInvDt));
            json.writeNumberField("val", inv.supplierInvVal);
            json.writeStringField("pos", inv.pos);
            json.writeStringField("rchrg", inv.reverseCharge ? "Yes" : "No");
            json.writeStringField("pro_ass", inv.provisionalAssessment ? "Y" : "N");
            if (!b2B.isOriginal) {
                //b2ba b2cla b2csa etc ...
                json.writeStringField("onum", inv.originalInvNum);
                json.writeStringField("odt", gstFmt.format(inv.originalInvDt));
            }


            writeLineItems(b2B, json, inv);

            //End Line Items


            json.writeEndObject();
        } catch (Exception e) {
            //log
        }
    }

    private void writeLineItems(T b2B, JsonGenerator json, Invoice inv) throws IOException {
        //Start Line Items
        json.writeFieldName("itms");
        json.writeStartArray();
        inv.items.forEach(li -> writeLineItem(b2B, json, li));

        json.writeEndArray();
    }

    private void writeLineItem(T b2B, JsonGenerator json, InvLineItem li) {
        try {
            json.writeStartObject();
            json.writeNumberField("num", li.slNo);
            json.writeStringField("status", li.action.getValue());
            json.writeStringField("ty", li.goodsOrService.getValue());
            json.writeStringField("hsn_sc", li.goodsOrServiceCode);
            json.writeNumberField("txval", li.taxableValue);

            json.writeNumberField("irt", li.igstRate);
            json.writeNumberField("iamt", li.igstAmt);

            json.writeNumberField("crt", li.cgstRate);
            json.writeNumberField("camt", li.cgstAmt);

            json.writeNumberField("srt", li.sgstRate);
            json.writeNumberField("samt", li.sgstAmt);

            json.writeEndObject();
        } catch (Exception e) {
            //log
        }
    }

}
