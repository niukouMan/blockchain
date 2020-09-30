#polkadot波卡
>波卡就像一个插排，这个插排具有XCMP数据传递协议，使得插入插排的区块链之间可以进行数据跨链、资产跨链、互相操作，这即是波卡的跨链可组合性。

###交易费用:
Polkadot使用基于权重的费用模型，而不是天然气计量模型。因此，在执行交易之前会收取费用；支付费用后，节点将执行交易。

Polkadot中继链上的费用是基于以下三个参数计算的：
每字节收费（也称为“长度收费”）
体重费
小费（可选）

Polkadot中的块具有最大长度（以字节为单位）和最大权重限制。

###地址
####地址格式：
地址格式为SS58,SS58是比特币对Base-58-check的修改，并做了一些小的修改。该格式包含一个地址类型前缀，用于将地址标识为属于特定网络。
>例如：
Polkadot地址始终以数字1开头
通用基材地址以5开头

#### 地址的创建：
```$xslt
subkey工具
polkadot.js
```
生成帐户（地址）时，仅生成一个密钥即可访问。该帐户尚不存在。为此，它需要存在的存款：0.001666666667 KSM（在Kusama上）或1 DOT（在Polkadot主网上）。

#### 地址访问：
帐户低于现有存款会导致该帐户被收取。该帐户将从该区块链的状态中删除，以节省空间以及该地址中的所有资金。您不会失去对收割地址的访问权限-只要您拥有私钥或恢复短语，您仍然可以使用该地址-但它需要充值另一个现有存量才能与链进行交互。

###账户：
代理账户
多签账户

polkadot:
Polkadot是具有可扩展安全性和互操作性协议的异构多链。
>互操作性（Interoperability ）
又称互用性，是指不同的计算机系统、网络、操作系统和应用程序一起工作并共享信息的能力。

#### 中继链:
中继链是Polkadot的中央链。中继链由少量交易类型组成，其中包括与治理机制进行交互，平行链拍卖以及参与NPoS的方式。

#### 平行链：
整个Polkadot网络上发生的大多数计算都将委派给处理各种用例的特定并行链实现。Polkadot对平行链的功能没有任何限制，除了它们必须能够生成可以由分配给平行链的验证者进行验证的证据外。

#### 共享安全：（集合安全性）
不需要转接桥的平行链都让波卡负责记账了，所有平行链共同享受波卡的安全性，只要专注于你的区块链的应用部分就行了。
波卡通胀的dot就是为了激励波卡的中继链节点，维护全网的共识。
波卡如何维持自身及平行链的安全？  https://www.jinse.com/blockchain/718230.html

#### NPOS 提名权益证明
存在两个角色。
验证人:可以认为就是做节点的矿工，任何人对维护波卡的网络感兴趣，都可以申请作验证人节点。
提名人:可以认为就是持有DOT的散户，作为提名人，你可以用DOT投票给你信任的验证人节点，把DOT质押在这个验证人节点，获得利息。(DOT并没有转给验证人，只是质押在波卡网络，验证人无权动用质押的DOT)

####验证人和提名人的收益:
市场调节
自我升级

###链上治理
####三个角色：理事会、技术委员会、DOT的持有者

####- 理事会
负责起草和制定议案，也负责否决一些危险或者毫无意义的议案。DOT的持有者也可以提出议案，经过理事会的审核，可以加速议案进入公投阶段或者过滤掉危险的议案。
任期一年，任何DOT的持有者都可以参与竞选
####- DOT持有者
一旦理事会添加了议案公投，DOT的持有者可以使用DOT投票进行表决了。
####- 技术委员会
当议案公投表决通过后，就需要技术委员会进行执行了。
<br/><br/><br/>
####收集者：
收集者通过收集用户的平行链交易并为验证者提供状态转换证明来维护平行链。
整理者通过将平行链交易聚合到平行链区块中并基于这些区块为验证者生成状态转换证明来维护平行链。他们还监视网络并向验证者证明不良行为。

####区块：
块哈希是指头上的哈希，外部哈希是指编码的外部哈希。
提取区块作者：
块作者被编码在该块的共识日志中。要提取，您需要解码日志

####散列算法:
polkadot中使用Blake2哈希算法，blake2被认为是一种非常快速的加密哈希函数，也用于加密货币 Zcash中。
####密钥对和签名:
Polkadot使用Schnorrkel / Ristretto x25519（“ sr25519”）作为其密钥派生和签名算法。Schnorr签名带来了一些明显的好处。一方面，它效率更高，但仍保留相同的功能集和安全性假设。

###编解码器SCALE
Polkadot encodes block and transaction data using the SCALE codec.
SCALE编解码器是一种轻量级，高效的二进制序列化和反序列化编解码器。
它旨在在资源受限的执行上下文（如Substrate运行时）中对数据进行高性能，无拷贝的编码和解码。substrate的区块和交易数据使用SCALE编解码

####ED(existential deposit)
Polkadot使用存留存款（ED）来防止灰尘帐户膨胀。如果帐户的余额降到ED以下，该帐户将被收款，即从存储中完全删除并重置nonce。Polkadot的ED是1 DOT，而Kusama的ED是0.01 KSM。
同样，如果您将价值低于ED的转账发送到新帐户，则该交易将失败。保管钱包的最小余额应大于ED，以保证账户不被回收。
http://www.xdxzb.com/post/7064.html

###Balance:
账户余额信息存储在AccountData中，Polkadot首要处理两种类型的余额：free balance和reserved balance
reserved balance
保存余额是指某项事务预留的资金，仍归于账户持有人，但不能运用
锁仓（locks）是对自在余额的一种笼统，它暂时无法开销，只能用作某些特定意图。
几个锁仓能够在同一个帐户上操作，但它们是堆叠的而不是相加的。例如，一个账户能够有 200 DOTs 的自在余额，上面有两个锁仓：150 DOTs 用于转账，100 DOTs 用于保存备用。
帐户不能进行导致自在余额低于 150 DOTs 的转账，但却能够经过跟保存余额相关的操作，导致自在账户低于150但高于100 DOTs。

###Extrinsics
https://baijiahao.baidu.com/s?id=1672544033809391973&wfr=spider&for=pc
polkadot中交易都称之为extrinsic
####1.内涵要素 Inherents
未被证明为真，但验证人根据某种合理性的办法对其达成了共同的信息。
Inherents 是未签名的信息，仅由出块者插入到区块中。它们不会被散布在网络上，也不存储在交易队列中。
####2.签名的交易 Signed Transactions
交易需要包含签名信息，而且需要支付费用才能将交易发送到链上。
包含发出交易的帐户的签名，并且需要付费才能将交易包括在链中。因为可以在执行之前识别出在链上包括已签名交易的价值，所以可以在网络上垃圾交易风险较低的节点之间的散布这些交易。
签名交易符合以太坊或比特币交易的概念。
####3.未签名的交易 Unsigned Transactions
由于交易未签名，因此无需支付任何费用。因此，交易队列缺乏防止垃圾交易的经济逻辑。未签名的交易也缺乏随机数，使得重放保护变得困难。

签名扩展:
SignedExtension 是一种特征（trait），通过它可以使用其他数据或逻辑来扩展交易。

####Extrinsics有效期
外部元素可以有效期限，也能够是永久存在的。交易负载包含一个区块号和一个区块哈希检查点，交易从改检查点开端有用，以及一个有效期，
外部元素能够是有期限的，也能够是不朽的。买卖负载包括一个区块号和一个区块哈希查看点，买卖从该查看点开端有用，以及一个有用期（在某些当地也称为 「era」），该有用期表明买卖有用的查看点之后的区块数。假如此有用性窗口内的区块中未包括外部项，则将从买卖行列中丢掉它。
链只存储有限数量的从前区块哈希作为引证。你能够从链状况或元数据中查询这个名为 BlockHashCount 的参数。该参数在 genesis 设置为 2400 个区块（大约 4 小时）。假如有用期大于存储在链上的块的数量，那么只需有一个要查看的块（即有用期的最小值和块哈希计数），买卖才有用。
运用 genesis 哈希将块查看点设置为零，有用期为零将使买卖不朽。

###三种共识：NPOS, BABE, GRANDPA
https://news.huoxing24.com/20200904211232308052.html
https://www.huoxing24.com/search/polkadot

###MetaData
每条链的Runtime都会有这条链Runtime的metadata这个metadata就是Runtime的元信息，包含有那些模块，每个模块下有什么存储，有哪些方法可以调用，所以Polkadot UI就是解析这个metadata，然后根据metadata的信息展示

###节点启动模式
存档模式：非存档模式下Polkadot/Substrate节点将仅保留最后256个块的状态（修剪）。

-----------------------polkadot对接---------------------------------
## 节点安装
https://wiki.polkadot.network/docs/en/maintain-sync
https://wiki.polkadot.network/docs/en/maintain-wss
https://wiki.polkadot.network/docs/en/build-node-management

## 开发文档
substrate:
https://substrate.dev/docs/en/
polkadot-js:
https://polkadot.js.org/api/start/
substrate-api-sidecar
https://github.com/paritytech/substrate-api-sidecar

##java库
 https://github.com/emeraldpay/polkaj
 https://github.com/talfco/clb-polkadot-java-types 
 https://github.com/polkadot-java/api

账户：
https://wiki.polkadot.network/docs/en/learn-account-generation
地址格式：
https://github.com/paritytech/substrate/wiki/External-Address-Format-(SS58)
https://github.com/paritytech/substrate/wiki/Suggestions-for-Key-Derivation-Paths

bip44：
https://github.com/satoshilabs/slips/blob/master/slip-0044.md
dot：354
钱包插件：
https://chrome.google.com/webstore/detail/polkadot%7Bjs%7D-extension/mopnmbcafieddcagagdcbnhejhlodfdd

交易签名广播
https://wiki.polkadot.network/docs/en/build-transaction-construction#submitting-a-signed-payload
交易费用：
https://substrate.dev/docs/en/knowledgebase/runtime/fees
https://wiki.polkadot.network/docs/en/learn-transaction-fees#docsNav
Polkadot Protocol Information:
https://wiki.polkadot.network/docs/en/build-protocol-info#existential-deposit
Polkadot中的加密签名库 Schnorrkel:
chainLink:
https://github.com/smartcontractkit/chainlink-polkadot
https://www.bilibili.com/video/BV1V7411K72C
交易状态确认问题：
https://polkadot.js.org/api/start/api.tx.subs.html

实用指南：地址、事件与外部元素等
https://www.chainnews.com/articles/936935889529.htm

https://github.com/talfco/clb-polkadot-java-types

polkadot注释版
https://github.com/blockchain-analysis-study/my-polkadot

polkaj-rpc
https://github.com/emeraldpay/polkaj/blob/master/docs/ref-01-api-commands.adoc#author_submitExtrinsic

浏览器api
https://documenter.getpostman.com/view/1618960/TVCe1oRU?version=latest#88410563-50d8-4dc2-8323-f0edafc6e718
https://polkadot.subscan.io/

polkadot.js api
https://polkadot.js.org/api/start/api.tx.html


##相关博文
https://www.zhihu.com/people/lester123
http://www.bfttiao.com/keji/bftt2940362.html


