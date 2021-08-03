package com.hex.study.chain;

/**
 * @author hui.zhu
 */
public class CheckZDNone extends AbstractCheck {
    public CheckZDNone(CaseInfo caseInfo) {
        this.caseInfo = caseInfo;
    }

    protected boolean isCheck(String message) {
        if (!"16".equals(caseInfo.getCaseType())) {
            return true;
        }
        if ("01".equals(caseInfo.getInterbankType()) && !"123".equals(caseInfo.getRecvAccountNo())) {
            System.out.println("中登非担保账户校验：" + caseInfo.getCaseNo() + message);
            return false;
        } else if ("02".equals(caseInfo.getInterbankType()) && !"123".equals(caseInfo.getPayAccountNo())) {
            System.out.println("中登非担保账户校验：" + caseInfo.getCaseNo() + message);
            return false;
        }
        return true;
    }
}
