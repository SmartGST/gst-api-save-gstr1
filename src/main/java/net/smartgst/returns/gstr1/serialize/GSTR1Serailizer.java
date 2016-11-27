package net.smartgst.returns.gstr1.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import net.smartgst.returns.gstr1.data.GSTR1;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created by gowthaman on 27/11/16.
 */
public class GSTR1Serailizer extends JsonSerializer<GSTR1> {
    @Override
    public void serialize(GSTR1 gstr1, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("gstin", gstr1.gstin);
        jsonGenerator.writeStringField("fp", new SimpleDateFormat("MMyyyy").format(gstr1.financialPeriod));
        jsonGenerator.writeNumberField("gt", gstr1.prevYearGrossTurnOver);
        jsonGenerator.writeObjectField("b2b", gstr1.b2b);
        jsonGenerator.writeEndObject();
    }
}
