package com.hex.study.chain;

/**
 * @author hui.zhu
 */
public abstract class AbstractCheck {
    protected CaseInfo caseInfo;
    protected AbstractCheck nextCheck;

    public void setNextCheck(AbstractCheck abstractCheck) {
        this.nextCheck = abstractCheck;
    }

    public void check(boolean isCheck, String message) {
        if (!isCheck) {
            return;
        }
        boolean flag = isCheck(message);
        if (nextCheck != null) {
            nextCheck.check(flag, message);
        } else if (flag && nextCheck == null){
            System.out.println(caseInfo.getCaseNo() + "校验通过");
        }
    }
    abstract protected boolean isCheck(String message);
}
