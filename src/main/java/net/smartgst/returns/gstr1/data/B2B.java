package net.smartgst.returns.gstr1.data;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import net.smartgst.returns.gstr1.serialize.B2BSerializer;

import java.util.List;

@JsonSerialize(using = B2BSerializer.class)
public class B2B extends BaseData {
    //for b2b is counter party , for b2ba is receiving Party
    public String partyGSTIN;

}
