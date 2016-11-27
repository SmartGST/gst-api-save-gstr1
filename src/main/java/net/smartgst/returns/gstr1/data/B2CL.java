package net.smartgst.returns.gstr1.data;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import net.smartgst.returns.gstr1.serialize.B2CLSerializer;

@JsonSerialize(using = B2CLSerializer.class)
public class B2CL extends BaseData {
    public String stateCode;

}
