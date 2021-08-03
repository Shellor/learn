package com.hex.study.chain;

/**
 * @author hui.zhu
 */
public class CheckAccountName extends AbstractCheck {
    public CheckAccountName(CaseInfo caseInfo) {
        this.caseInfo = caseInfo;
    }

    protected boolean isCheck(String message) {
        if (!"测试".equals(caseInfo.getPayAccountName())) {
            System.out.println("收付款户名校验：" + caseInfo.getCaseNo() + message);
            return false;
        }
        if ("01".equals(caseInfo.getTransMarket()) && !"测试".equals(caseInfo.getRecvAccountName())) {
            System.out.println("收付款户名校验：" + caseInfo.getCaseNo() + message);
            return false;
        }
        return true;
    }
}
