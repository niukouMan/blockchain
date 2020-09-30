# 以太坊钱包开发
## 相关资源
API文档
https://web3js.readthedocs.io/en/v1.2.0/
Remix
http://remix.ethereum.org/
ganache
https://www.trufflesuite.com/ganache

## web3j主要类
MnemonicCode
主要用于将二进制的种子与助记词之间转换。
byte[] toSeed(List<String> words, String passphrase)
使用PBKDF2函数将助记词推到出seed。使用mnemonic+passphrase作为盐，循环推导2048次，密钥长度64位。
byte[] toEntropy（List<String> words）
将助记词转换为原始的熵
List<String> toMnemonic(byte[] entropy)
将原始的熵转换为助记词
void check(List<String> words) throws MnemonicException
检查助记词是否有效
PBKDF2函数
PBKDF2(Password-Based Key Derivation Function)是一个用来导出密钥的函数，常用于生成加密的密码。
它的基本原理是通过一个伪随机函数（例如HMAC函数），把明文和一个盐值作为输入参数，然后重复进行运算，并最终产生密钥。
DK = PBKDF2(PRF, Password, Salt, c, dkLen)
PRF是一个伪随机函数，例如HASH_HMAC函数，它会输出长度为hLen的结果。
Password是用来生成密钥的原文密码。
Salt是一个加密用的盐值。
c是进行重复计算的次数。
dkLen是期望得到的密钥的长度。
DK是最后产生的密钥。
SecureRandom随机算法提供熵
SecureRandom类收集了一些随机事件，比如鼠标点击，键盘点击等等，
SecureRandom 使用这些随机事件作为种子。这意味着，种子是不可预测的。
Random默认使用系统当前时间的毫秒数作为种子，有规律可寻。
DeterministicSeed
主要用于保存HD钱包的种子，以简化加密。
DeterministicKeyChain
DeterministicKey

Numeric
numeric是web3j里提供的十六进制、大整数、字符串转化工具类

## 相关代码
### 节点部署
windows环境
...
linux环境
...
### 常见问题
#### Android添加:bitcoinj-core依赖后真机和模拟器无法安装apkAndroid添加:bitcoinj-core依赖后真机和模拟器无法安装apk
 // bitcoinj
implementation 'org.bitcoinj:bitcoinj-core:0.14.7'
解决办法：
参考：https://blog.csdn.net/wypeng2010/article/details/81290490?utm_source=blogxgwz1
如果你直接引用库之后，直接安装运行apk，会造成app崩溃，这是因为这个库里面有一个libscrypt.dylib，这个库是针对x86_64平台的，并且没有其他平台的这个库，所以在arm  cpu平台的手机app会崩溃，解决方案就是在gradle的android节点下，加上以下配置
packagingOptions {
    exclude 'META-INF/NOTICE.txt'
    exclude 'META-INF/LICENSE.txt'
    exclude 'META-INF/NOTICE'
    exclude 'META-INF/LICENSE'
    exclude 'META-INF/DEPENDENCIES'
    exclude 'lib/x86_64/darwin/libscrypt.dylib'
}
####  如何获取与某地址收发的所有交易记录？
方法1.本地扫描链上交易缓存在本地
方法2.使用ethscan API查询
https://etherscan.io/apis
http://api.etherscan.io/api?module=account&action=txlist&address=0xde0b295669a9fd93d5f28d9ec85e40f4cb697bae&startblock=0&endblock=99999999&sort=asc&apikey=YourApiKeyToken

http://api-cn.etherscan.com/api?module=account&action=txlist&address=0xde0b295669a9fd93d5f28d9ec85e40f4cb697bae&startblock=0&endblock=99999999&sort=asc&apikey=YourApiKeyToken
#### 私钥如何在客户端安全保存？
区中心化钱包的所有交易的不涉及到中心保存，所有的交易签名在app内完成私钥也由用户保存，私钥不会上传到平台服务器。所以app在发起交易的时候需要对交易进行签名，如何在app内安全保存私钥是个非常重要的问题，这里有两种思路来解决私钥保存的问题：
方式一：
创建钱包时让用户输入密码，使用用户密码作为加密密码把生成的助记词、私钥使用对称加密算法加密保存到数据库，需要使用助记词和密码的时候，再次让用户输入密码，与钱包密码比对是否正确，通过后在用此密码解密私钥，获取私钥原文。用来签名交易。
方式二：
在创建钱包的时候生成并保存keystore文件到本地，并使用户输入的密码作为加密密码。在需要使用私钥签名时，加载本地加密的keystore文件，并使用用户输入的钱包密码解密，然后推导出私钥去签名交易。



## 比特币钱包开发
## 相关资源
### 区块浏览器
主网：https://btc.com
测试网络：https://live.blockcypher.com/btc-testnet
#### btc水龙头
https://kuttler.eu/en/bitcoin/btc/faucet/
https://testnet-faucet.mempool.co/

bitcoin-core RPC文档
http://cw.hubwiz.com/card/c/bitcoin-json-rpc-api/1/1/1/
fee费用
https://blog.csdn.net/wypeng2010/article/list/1
第三方节点API
https://www.blockchain.com/api
比特币第三方API大全原
https://cloud.tencent.com/developer/article/1423879

## 相关依赖
<!-- bitcoin-rpc-client -->
 <dependency>
     <groupId>wf.bitcoin</groupId>
     <artifactId>bitcoin-rpc-client</artifactId>
     <version>1.1.1</version>
 </dependency>

<!-- bitcoin-core  -->
<dependency>
     <groupId>org.bitcoinj</groupId>
     <artifactId>bitcoinj-core</artifactId>
     <version>0.15.8</version>
</dependency>

## 环境搭建环境搭建
https://blog.csdn.net/ZHENCONG_STAR/article/details/84622510
节点搭建
### windows环境windows环境
安装包下载地址：https://bitcoin.org/zh_CN/download
下载安装文件+压缩包，然后安装钱包文件后通过CMD命令行启动。
#### 启动启动
./bitcoin-qt.exe --server --testnet --rpcuser=root --rpcpassword=123456 --rpcport=8332 --rpcallowip=127.0.0.1

#### 选项：
--conf=<文件名> 指定配置文件（默认：bitcoin.conf）
--pid=<文件名> 指定 pid （进程 ID）文件（默认：bitcoind.pid）
--gen 生成比特币
--gen=0 不生成比特币
--min 启动时最小化
--splash 启动时显示启动屏幕（默认：1）
--datadir=<目录名> 指定数据目录
--dbcache=<n> 设置数据库缓存大小，单位为兆字节（MB）（默认：25）
--dblogsize=<n> 设置数据库磁盘日志大小，单位为兆字节（MB）（默认：100）
--timeout=<n> 设置连接超时，单位为毫秒
--proxy=<ip:端口> 通过 Socks4 代理链接
--dns addnode 允许查询 DNS 并连接
--port=<端口> 监听 <端口> 上的连接（默认：8333，测试网络 testnet：18333）
--maxconnections=<n> 最多维护 <n> 个节点连接（默认：125）
--addnode=<ip> 添加一个节点以供连接，并尝试保持与该节点的连接
--connect=<ip> 仅连接到这里指定的节点
--irc 使用 IRC（因特网中继聊天）查找节点（默认：0）
--listen 接受来自外部的连接（默认：1）
--dnsseed 使用 DNS 查找节点（默认：1）
--banscore=<n> 与行为异常节点断开连接的临界值（默认：100）
--bantime=<n> 重新允许行为异常节点连接所间隔的秒数（默认：86400）
--maxreceivebuffer=<n> 最大每连接接收缓存，<n>*1000 字节（默认：10000）
--maxsendbuffer=<n> 最大每连接发送缓存，<n>*1000 字节（默认：10000）
--upnp 使用全局即插即用（UPNP）映射监听端口（默认：0）
--detachdb 分离货币块和地址数据库。会增加客户端关闭时间（默认：0）
--paytxfee=<amt> 您发送的交易每 KB 字节的手续费
--testnet 使用测试网络
--debug 输出额外的调试信息
--logtimestamps 调试信息前添加时间戳
--printtoconsole 发送跟踪/调试信息到控制台而不是 debug.log 文件
--printtodebugger 发送跟踪/调试信息到调试器

--rpcuser=<用户名> JSON-RPC 连接使用的用户名
--rpcpassword=<密码> JSON-RPC 连接使用的密码
--rpcport=<port> JSON-RPC 连接所监听的 <端口>（默认：8332）
--rpcallowip=<ip> 允许来自指定 <ip> 地址的 JSON-RPC 连接
--rpcconnect=<ip> 发送命令到运行在 <ip> 地址的节点（默认：127.0.0.1）

--blocknotify=<命令> 当最好的货币块改变时执行命令（命令中的 %s 会被替换为货币块哈希值）
--upgradewallet 将钱包升级到最新的格式
--keypool=<n> 将密匙池的尺寸设置为 <n>（默认：100）
--rescan 重新扫描货币块链以查找钱包丢失的交易
--checkblocks=<n> 启动时检查多少货币块（默认：2500，0 表示全部）
--checklevel=<n> 货币块验证的级别（0-6，默认：1）

SSL 选项：
--rpcssl 使用 OpenSSL（https）JSON-RPC 连接
--rpcsslcertificatechainfile=<文件.cert> 服务器证书文件（默认：server.cert）
--rpcsslprivatekeyfile=<文件.pem> 服务器私匙文件（默认：server.pem）
--rpcsslciphers=<密码>可接受的密码（默认：TLSv1+HIGH:!SSLv2:!aNULL:!eNULL:!AH:!3DES:@STRENGTH）

### 相关问题及示例代码
####  获取BTC的余额 和 UTXO列表获取BTC的余额 和 UTXO列表
直接使用btc节点的rpc服务是很难查出某个地址的余额的，因为btc的utxo机制，想通过rpc服务查余额，就只能先把地址导入节点，节点扫描整个区块，维护本地utxo列表，然后才能查询余额，这需要耗费一定的时间，所以这个方式根本不适合查询余额。最终只能自己搭建一个btc的区块链浏览器，来解决这个问题（同时也解决了获取utxo列表和查询历史记录的问题）。使用的比较广的btc浏览器应该是insight-api，它的代码是开源的，并且提供接口，github地址：
https://github.com/bitpay/insight-api
https://www.blockchain.com/api
他提供的接口，足以满足你的需求。
//账户余额
public BigDecimal getBalance(String address, String contract) {
    boolean mainNet = false;
    String host = mainNet ? "blockchain.info" : "testnet.blockchain.info";
    String url = "https://" + host + "/balance?active=" + address;
    OkHttpClient client = new OkHttpClient();
    String response = null;
    try {
        response = client.newCall(new Request.Builder().url(url).build()).execute().body().string();
    } catch (IOException e) {
        e.printStackTrace();
    }
    Map<String, Map<String, Object>> result = JSONObject.parseObject(response, Map.class);
    Map<String, Object> balanceMap = result.get(address);
    BigDecimal finalBalance = BigDecimal.valueOf((double) balanceMap.get("final_balance"));
    BigDecimal balance = finalBalance.divide(new BigDecimal(100000000));
    return balance;
}

方式二：通过钱包rpc调用钱包节点计算


bitcoin core中Account和Address的区别？
Account就是一个address集合，一个account可以对应多个address，每次调用getnewaddress都会忘对应的account中增加一个新地址。查询指定address下的金额可以通过getreceivedbyaddress

btc获取UTXO方式
比特币节点和钱包一体，很方便，但是如果想做到钱包和节点分离，对于地址的utxo就是一件有点小麻烦的事情，因为前提是私钥不能导入到节点。
 使用第三方的节点，比如bitpay, toshi等，他们在内部做了索引，跟踪了utxo，这个办法最方便，但是有个缺点就是他们有可能会断更，比如toshi
 使用观察地址，把地址导入作为观察地址，一样可以获取这个地址的utxo，这个办法也有一个小缺点，就是无法快速切换节点，换到新的节点，需要重新导入所有地址
 自己跟踪地址的交易，监听这个地址的所有交易，然后计算这个地址的utxo，这个方法的缺点是旧的地址无法获取，在不依赖其他服务的情况下需要人工操作将交易录入，另外一旦监听漏过了某个交易，也是同样的问题
Coin单位转换


## EOS钱包开发
https://blog.csdn.net/wypeng2010/article/details/85113370

## 相关资源
## 项目依赖
参考：https://github.com/wypeng2012/EOSForJava
https://github.com/espritblock/eos4j
Maven
<dependency>
  <groupId>party.52it</groupId>
  <artifactId>EOSForJava</artifactId>
  <version>1.0.0</version>
</dependency>
Gradle
//compile 'party.52it:EOSForJava:1.0.0'
implementation 'party.52it:EOSForJava:1.0.0'

## 相关钱包及开源
http://blog.eosdata.io/index.php/eoswallet
EOS开发指南
http://blog.eosdata.io/index.php/allpost/
https://chaindesk.cn/witbook/2/18
## EOS节点列表
官方文档
https://eos.readthedocs.io/zh_CN/latest/#eos
示例代码
System.out.println("============= 自定义数据签名 ===============");
		String sign = Ecc.sign(pk,"is京東價as看到可可是是是@#￥%……&*（CVBNM《d ");
		System.out.println("sign :" + sign + " \n ");
		
		System.out.println("============= 转账数据序列化 ===============");
		String data = Ecc.parseTransferData("fromaccount", "toaccount", "10.0020 SYS", "测试123abcdo./,./!@##$%");
		System.out.println("seriz data :" + data);
		System.out.println("transfer eq eosjs seriz " + data.equals(eosjs_transfer_seriz)+" \n ");

		System.out.println("============= 创建账户数据序列化 ===============");
		String data1 = Ecc.parseAccountData("eosio", "espritbloc1.","EOS8eAX54cJtAngV2V22WZhRCW7e4sTAZz1mC5U22vp8mAGuFdMXx","EOS8FPooohZiiCAYXahWCQRxgXXzUbS2gNELAeYCUgGdDMbd2FHQT");
		System.out.println("seriz data :" + data1);
		System.out.println("account eq eosjs seriz " + data1.equals(eosjs_account_seriz));

		
		System.out.println("\n******************* Ecc End *******************\n\n\n");
		
		System.out.println("******************* Rpc Start *******************\n");
		
		Rpc rpc = new Rpc("http://47.106.221.171:8888");
		
		System.out.println("============= 转账 ===============");
		try {
			Transaction t1 = rpc.transfer("5KQwrPbwdL6PhXujxW37FSSQZ1JiwsST4cqQzDeyXtP79zkvFD3","espritblocke", "inita","initb", "12.2821 MSP", "");
			System.out.println("转账成功 = " + t1.getTransactionId()+" \n ");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		System.out.println("============= 创建账户并且抵押 ===============");
		try {	
			Transaction t2 = rpc.createAccount("5KQwrPbwdL6PhXujxW37FSSQZ1JiwsST4cqQzDeyXtP79zkvFD3","eosio","ccccc..bbbbb", "EOS8eAX54cJtAngV2V22WZhRCW7e4sTAZz1mC5U22vp8mAGuFdMXx","EOS8eAX54cJtAngV2V22WZhRCW7e4sTAZz1mC5U22vp8mAGuFdMXx", 8192l, "0.01 SYS","0.01 SYS", 0l);
			System.out.println("创建成功 = " + t2.getTransactionId()+" \n ");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("============= 创建账户不抵押 ===============");
		try {	
			Transaction t3 = rpc.createAccount("5KQwrPbwdL6PhXujxW37FSSQZ1JiwsST4cqQzDeyXtP79zkvFD3","eosio","bbbb..54321", "EOS8eAX54cJtAngV2V22WZhRCW7e4sTAZz1mC5U22vp8mAGuFdMXx","EOS8eAX54cJtAngV2V22WZhRCW7e4sTAZz1mC5U22vp8mAGuFdMXx", 8192l);
			System.out.println("创建成功 = " + t3.getTransactionId()+" \n ");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		System.out.println("============= 代理投票 ===============");
		try {
			List<String> produces = new ArrayList<>();
			produces.add("pppppeeeeooo");
			produces.add("mdddssssddds");
			produces.add("mdjddjddddds");
			rpc.voteproducer("5KQwrPbwdL6PhXujxW37FSSQZ1JiwsST4cqQzDeyXtP79zkvFD3", "epskdkdsddss","iuewjdkslsdc",produces);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("============= 关闭余额为0的token ===============");
		try {
			rpc.close("5KQwrPbwdL6PhXujxW37FSSQZ1JiwsST4cqQzDeyXtP79zkvFD3", "合约账户", "关闭账户", "0.0000 IPOS");
		}catch(ApiException e) {
			e.printStackTrace();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("\n******************* Rpc End *******************");

离线签名
public static void testOfflineCreate() {
		Rpc rpc = new Rpc("http://47.106.221.171:8888");
		// 获取离线签名参数
		SignParam params = rpc.getOfflineSignParams(60l);
		// 离线签名
		OfflineSign sign = new OfflineSign();
		// 交易信息
		String content = "";
		try {
			content = sign.createAccount(params, "5KQwrPbwdL6PhXujxW37FSSQZ1JiwsST4cqQzDeyXtP79zkvFD3", "eeeeeeeeeeee",
					"555555555551", "EOS6MRyAjQq8ud7hVNYcfnVPJqcVpscN5So8BhtHuGYqET5GDW5CV",
					"EOS6MRyAjQq8ud7hVNYcfnVPJqcVpscN5So8BhtHuGYqET5GDW5CV", 8000l);
			System.out.println(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 广播交易
		try {
			Transaction tx = rpc.pushTransaction(content);
			System.out.println(tx.getTransactionId());
		} catch (ApiException ex) {
			System.out.println(ex.getError().getCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testOfflineTransfer() {
		Rpc rpc = new Rpc("http://47.106.221.171:8888");
		// 获取离线签名参数
		SignParam params = rpc.getOfflineSignParams(60l);
		// 离线签名
		OfflineSign sign = new OfflineSign();
		// 交易信息
		String content = "";
		try {
			content = sign.transfer(params, "5KQwrPbwdL6PhXujxW37FSSQZ1JiwsST4cqQzDeyXtP79zkvFD3", "eosio.token",
					"eeeeeeeeeeee", "555555555551", "372.0993 EOS", "test");
			System.out.println(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 广播交易
		try {
			Transaction tx = rpc.pushTransaction(content);
			System.out.println(tx.getTransactionId());
		} catch (ApiException ex) {
			System.out.println(ex.getError().getCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

参考：
https://blog.csdn.net/Day_Day_No_Bug/article/details/102518550?depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-8&utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-8