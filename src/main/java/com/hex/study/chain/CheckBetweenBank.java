package com.hex.study.chain;

/**
 * @author hui.zhu
 */
public class CheckBetweenBank extends AbstractCheck {
    public CheckBetweenBank(CaseInfo caseInfo) {
        this.caseInfo = caseInfo;
    }

    protected boolean isCheck(String message) {
        if (!"04".equals(caseInfo.getCaseType())) {
            return true;
        }
        if (!"000".equals(caseInfo.getRecvAccountNo()) && "01".equals(caseInfo.getInterbankType())) {
            System.out.println("银行间指令资金账户校验：" + caseInfo.getCaseNo() + message);
            return false;
        } else if (!"000".equals(caseInfo.getPayAccountNo()) && "02".equals(caseInfo.getInterbankType())) {
            System.out.println("银行间指令资金账户校验：" + caseInfo.getCaseNo() + message);
            return false;
        }
        return true;
    }
}
