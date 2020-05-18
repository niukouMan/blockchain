## 同步全节点
monero的github地址: https://github.com/monero-project

cd ~/downloads

将 monero-linux-x64-v0.15.0.1.tar.bz2 解压到 ~/downloads 目录下
```shell script
tar -xjvf monero-linux-x64-v0.15.0.1.tar.bz2  
mkdir /root/.bitmonero/
```

将配置文件拷贝过去
```$xslt
cp bitmonero.conf  /root/.bitmonero/
```

在 /etc/profile 中添加
```
export PATH=$PATH:/root/downloads/monero-x86_64-linux-gnu-v0.15.0.1
```
使配置生效
```$xslt
source /etc/profile
```
bitmonero.conf内容
```$xslt
data-dir=/data/monero
log-file=/data/monero_main.log
log-level=1
rpc-bind-port=18081
rpc-bind-ip=0.0.0.0
confirm-external-bind=true
show-time-stats=1
```
/**  
 Configuration for monerod
 Syntax: any command line option may be specified as 'clioptionname=value'.
         Boolean options such as 'no-igd' are specified as 'no-igd=1'.
 See 'monerod --help' for all available options.
*/

## 后台启动
```$xslt
DNS_PUBLIC=tcp://8.8.8.8 monerod  --config-file=/root/.bitmonero/bitmonero.conf --detach
```
如果一直没有发现peer节点, 可以使用
```$xslt
DNS_PUBLIC=tcp://8.8.8.8 monerod --config-file=/root/.bitmonero/bitmonero.conf --detach --seed-node=node.supportxmr.com
```
查看日志
```$xslt
tail -f 300  /data/monero_main.log
```
使用另外终端, 测试 rpc接口
```$xslt
curl -X POST http://127.0.0.1:18081/json_rpc -H 'Content-Type: application/json'  -d '{"jsonrpc":"2.0","id":"0","method":"get_info","params":""}' 
```
