package net.smartgst.returns.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import net.smartgst.returns.data.B2B;
import net.smartgst.returns.data.b2b.B2BInv;
import net.smartgst.returns.data.b2b.B2BInvItem;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created by gowthaman on 27/11/16.
 */
public class B2BSerializer extends JsonSerializer<B2B> {
    private final SimpleDateFormat gstFmt = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    public void serialize(B2B b2B, final JsonGenerator json, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        json.writeStartObject();

        json.writeStringField("ctin", b2B.partyGSTIN);
        writeInvoices(b2B, json);

        json.writeEndObject();
    }

    private void writeInvoices(B2B b2B, JsonGenerator json) throws IOException {
        //Start Invoice Details
        json.writeFieldName("inv");
        json.writeStartArray();

        b2B.invoices.forEach(inv -> writeInvoice(b2B, json, inv));


        json.writeEndArray();
        //end Invoice Details
    }

    private void writeInvoice(B2B b2B, JsonGenerator json, B2BInv inv) {
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
                //b2ba
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

    private void writeLineItems(B2B b2B, JsonGenerator json, B2BInv inv) throws IOException {
        //Start Line Items
        json.writeFieldName("itms");
        json.writeStartArray();
        inv.items.forEach(li -> writeLineItem(b2B, json, li));

        json.writeEndArray();
    }

    private void writeLineItem(B2B b2B, JsonGenerator json, B2BInvItem li) {
        try {
            json.writeStartObject();
            if (b2B.isOriginal) {
                //b2b
                json.writeNumberField("num", li.slNo);
            } else {
                //b2ba
                json.writeNumberField("line_num", li.slNo);
            }

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
        }catch (Exception e){
            //log
        }
    }
}
