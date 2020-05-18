#### 创建incoming-only钱包
```$xslt
monero-wallet-cli --daemon-address monero-stagenet.exan.tech:38081  --trusted-daemon --generate-from-view-key=/root/.bitmonero/stagenet/deposit/watch_only_wallet   --subaddress-lookahead  2:50000
```
>参数说明：
>--generate-from-view-key arg   
//Generate incoming-only wallet from view key
// arg 是新生成的钱包路径
--subaddress-lookahead arg   
//Set subaddress lookahead sizes to <major>:<minor>
//cli 默认是 "look ahead" 200个subAddress, 如果需要钱包帮忙观察更多的子地址则需要指定此参数   
// 例如:  
>--subaddress-lookahead   5:10000   //表示5个子账户 每个账户 "look ahead" 10000个subaddress

创建过程中提示输入的
stand address：为需要创建观察钱包的标准地址,
viewkey：为需要创建观察钱包的viewkey

### 启动RPC服务
```$xslt
monero-wallet-rpc --daemon-address  monero-stagenet.exan.tech:38081 --trusted-daemon --wallet-file=/root/.bitmonero/stagenet/wallet_files/yqq_incoming_only --confirm-external-bind --rpc-bind-ip 0.0.0.0 --rpc-bind-port 38089  --password 123456 --disable-rpc-login --detach
```
> --wallet-file 指定为上一步创建的观察钱包文件路径，这样就可以RPC接口获取钱包的入账数据.