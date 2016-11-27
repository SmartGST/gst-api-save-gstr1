package net.smartgst.returns.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import net.smartgst.returns.serialize.FinancialPeriodSerialize;

import java.util.Date;
import java.util.List;

/**
 * Created by gowthaman on 27/11/16.
 */
public class GSTR1 {
    @JsonProperty("gstin")
    public String gstin;

    @JsonProperty("fp")
    @JsonSerialize(using = FinancialPeriodSerialize.class)
    public Date financialPeriod;

    @JsonProperty("gt")
    public double prevYearGrossTurnOver;

    @JsonProperty("b2b")
    public List<B2B> b2b;
}
