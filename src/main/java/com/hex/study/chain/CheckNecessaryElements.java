package com.hex.study.chain;

import org.apache.commons.lang3.StringUtils;

/**
 * @author hui.zhu
 */
public class CheckNecessaryElements extends AbstractCheck {
    public CheckNecessaryElements(CaseInfo caseInfo) {
        this.caseInfo = caseInfo;
    }
    protected boolean isCheck(String message) {
        if (StringUtils.isBlank(caseInfo.getCaseNo()) ||
                StringUtils.isBlank(caseInfo.getPayAccountNo()) ||
                StringUtils.isBlank(caseInfo.getRecvAccountNo())) {
            System.out.println("必要元素校验：" + caseInfo.getCaseNo() + message);
            return false;
        }
        return true;
    }
}
