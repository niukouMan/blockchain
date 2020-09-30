package com.icc.wallet.trx.enums;

/**
 * 波场TRX和TRC10交易三种合约
 */
public enum ContractType {
    Transfer_Contract("TransferContract", "系统合同类型"),
    Transfer_Asset_Contract("TransferAssetContract", "系统合同类型"),
    Trigger_Smart_contract("TriggerSmartContract", "智能合约类型");
//    Freeze_Balance_Contract("FreezeBalanceContract", " 冻结trx获取资源");

    private String type;
    private String desc;

    ContractType(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static ContractType change2Type(String type) {
        for (ContractType contractType : ContractType.values()) {
            if (contractType.getType().equals(type)) {
                return contractType;
            }
        }
        return null;
    }
}
