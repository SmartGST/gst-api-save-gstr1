package net.smartgst.returns.data;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import net.smartgst.returns.data.b2b.B2BInv;
import net.smartgst.returns.serialize.B2BSerializer;

import java.util.List;

/**
 * Created by gowthaman on 27/11/16.
 */
@JsonSerialize(using = B2BSerializer.class)
public class B2B {
    //for b2b is counter party , for b2ba is receiving Party
    public String partyGSTIN;

    public List<B2BInv> invoices;

    public boolean isOriginal;

}
