package net.smartgst.returns.gstr1.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import net.smartgst.returns.gstr1.serialize.FinancialPeriodSerialize;
import net.smartgst.returns.gstr1.serialize.GSTR1Serailizer;

import java.util.Date;
import java.util.List;

@JsonSerialize(using = GSTR1Serailizer.class)
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

    @JsonProperty("b2ba")
    public List<B2B> b2ba;
}
