package com.icc.wallet.trx.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TrxCommandEnum {
//官方节点列表  https://cn.developers.tron.network/docs/%E5%AE%98%E6%96%B9%E5%85%AC%E5%85%B1%E8%8A%82%E7%82%B9
//    BASE_URL("https://api.trongrid.io/", "TRON官方主网节点"),
    BASE_TEST_URL("https://api.shasta.trongrid.io/", "TRON测试网节点"),
//    BASE_URL("http://18.136.206.52:8090/", "私有主网节点"),
    BASE_URL("http://18.141.195.45:8090/", "私有主网节点"),

    GET_BLOCK_BY_ID( "wallet/getblockbyid", "通过id获取区块信息"),
    GET_BLOCK_BY_NUM( "wallet/getblockbynum", "通过id获取区块信息"),
    GET_TRANSACTION_BY_ID( "wallet/gettransactionbyid", "通过id查询交易详情"),
    GET_TRANSACTION_INFO_BY_ID( "wallet/gettransactioninfobyid", "通过id查询交易详情"),
    GET_NOW_BLOCK( "wallet/getnowblock", "查询同步到完整节点的最新块"),
    GET_NODE_INFO( "wallet/getnodeinfo", "节点信息"),
    GRENERATE_ADDRESS( "wallet/generateaddress", "创建钱包地址"),
    VALIDATE_ADDRESS( "wallet/validateaddress", "验证地址格式是否正确"),
    GET_ACCOUNT( "wallet/getaccount", "余额"),
    BROADCAST( "wallet/broadcast", "广播交易"),
    BROADCAST_HEX( "wallet/broadcasthex", "广播hex交易"),
    TRIGGER_SMART_CONTRACT( "wallet/triggersmartcontract", "合约"),

    ;

    private String command;
    private String desc;
}
