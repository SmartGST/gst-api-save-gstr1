package net.smartgst.returns.gstr1.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import net.smartgst.returns.gstr1.data.B2B;

import java.io.IOException;

/**
 * Created by gowthaman on 27/11/16.
 */
public class B2BSerializer extends BaseSerializer<B2B> {

    @Override
    public void serialize(B2B b2B, final JsonGenerator json, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        json.writeStartObject();

        json.writeStringField("ctin", b2B.partyGSTIN);
        writeInvoices(b2B, json);

        json.writeEndObject();
    }


}
