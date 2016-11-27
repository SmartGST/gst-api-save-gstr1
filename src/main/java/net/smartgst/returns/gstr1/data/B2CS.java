package net.smartgst.returns.gstr1.data;

import java.util.Date;
import java.util.List;

public class B2CS extends BaseData {
    public List<B2CSInvLineItem> items;

    public static class B2CSInvLineItem extends InvLineItem {
        public TaxPayerAction taxPayerAction;

        public String checkSum;
        public String stateCode;

        public String originalStateCode;
        public Date originalMonth;
        public GoodsService originalGoodsOrService;
        public String originalGoodsOrServiceCode;
        public  boolean provisionalAssessment;
    }
}
