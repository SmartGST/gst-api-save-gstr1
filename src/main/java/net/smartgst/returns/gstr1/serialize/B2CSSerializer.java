package net.smartgst.returns.gstr1.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import net.smartgst.returns.gstr1.data.B2CS;

import java.io.IOException;


public class B2CSSerializer extends BaseSerializer<B2CS> {
    @Override
    public void serialize(B2CS b2CS, JsonGenerator json, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        json.writeStartObject();

        json.writeFieldName("b2cs");

        json.writeStartArray();

        b2CS.items.forEach(li -> {
            try {

                json.writeStartObject();
                json.writeStringField("flag", li.taxPayerAction.getValue());
                json.writeStringField("chksum", li.checkSum);

                json.writeStringField("state_cd", li.stateCode);
                if (!b2CS.isOriginal) {
                    //b2csa amendment
                    json.writeStringField("osupst_cd", li.originalStateCode);
                    json.writeStringField("ohsn_sc", li.originalGoodsOrServiceCode);
                    json.writeStringField("oty", li.originalGoodsOrService.getValue());
                    json.writeStringField("omon", fpFormat.format(li.originalMonth));
                }
                json.writeStringField("ty", li.goodsOrService.getValue());
                json.writeStringField("hsn_sc", li.goodsOrServiceCode);
                json.writeNumberField("txval", li.taxableValue);

                json.writeNumberField("irt", li.igstRate);
                json.writeNumberField("iamt", li.igstAmt);

                json.writeNumberField("crt", li.cgstRate);
                json.writeNumberField("camt", li.cgstAmt);

                json.writeNumberField("srt", li.sgstRate);
                json.writeNumberField("samt", li.sgstAmt);

                json.writeStringField("pro_ass", li.provisionalAssessment ? "Y" : "N");

                json.writeEndObject();
            } catch (Exception e) {
                //log
            }
        });
        json.writeEndArray();

        json.writeEndObject();
    }
}
