package com.hex.study.chain;

/**
 * @author hui.zhu
 */
public class ChainDemo {
    public static void main(String[] args) {
        CaseInfo caseInfo = new CaseInfo();
        caseInfo.setCaseNo("123456");
        caseInfo.setCaseType("01");
        checkCaseInfo(caseInfo);//不过

        caseInfo.setPayAccountNo("123");
        caseInfo.setRecvAccountNo("1234");
        caseInfo.setTransMarket("01");
        caseInfo.setPayAccountName("测试1");
        checkCaseInfo(caseInfo);//不过

        caseInfo.setPayAccountName("测试");
        caseInfo.setRecvAccountName("测试01");
        checkCaseInfo(caseInfo);//不过

        caseInfo.setTransMarket("02");
        checkCaseInfo(caseInfo);//过

        caseInfo.setCaseType("04");
        checkCaseInfo(caseInfo);//过

        caseInfo.setInterbankType("01");
        checkCaseInfo(caseInfo);//不过

        caseInfo.setRecvAccountNo("000");
        checkCaseInfo(caseInfo);//过

        caseInfo.setInterbankType("02");
        checkCaseInfo(caseInfo);//不过

        caseInfo.setPayAccountNo("000");
        checkCaseInfo(caseInfo);//过

        caseInfo.setCaseType("16");
        checkCaseInfo(caseInfo);//不过

        caseInfo.setPayAccountNo("123");
        checkCaseInfo(caseInfo);//过

        caseInfo.setInterbankType("01");
        checkCaseInfo(caseInfo);//不过

        caseInfo.setRecvAccountNo("123");
        checkCaseInfo(caseInfo);//过
    }

    private static AbstractCheck getCheck (CaseInfo caseInfo) {
        AbstractCheck necessary = new CheckNecessaryElements(caseInfo);
        AbstractCheck account = new CheckAccountName(caseInfo);
        AbstractCheck betweenBank = new CheckBetweenBank(caseInfo);
        AbstractCheck zdNone = new CheckZDNone(caseInfo);

        necessary.setNextCheck(account);
        account.setNextCheck(betweenBank);
        betweenBank.setNextCheck(zdNone);
        return necessary;
    }

    private static void checkCaseInfo(CaseInfo caseInfo) {
        AbstractCheck check = getCheck(caseInfo);
        check.check(true, "校验不通过");
    }
}
