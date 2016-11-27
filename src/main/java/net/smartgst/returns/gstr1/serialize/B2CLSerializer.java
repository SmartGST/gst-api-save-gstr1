package net.smartgst.returns.gstr1.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import net.smartgst.returns.gstr1.data.B2CL;

import java.io.IOException;

/**
 * Created by gowthaman on 27/11/16.
 */
public class B2CLSerializer extends BaseSerializer<B2CL> {
    @Override
    public void serialize(B2CL b2CL, JsonGenerator json, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        json.writeStartObject();

        json.writeStringField("state_cd", b2CL.stateCode);
        writeInvoices(b2CL, json);

        json.writeEndObject();
    }
}
