### Rust 版本管理工具
rustup 是rust版本管理工具可以帮助我们安装不同版本的rust 编程需要的工具连，同时可以方便的进行不同版本 
之间的切换

## 安装rustup
```shell
curl https://sh.rustup.rs -sSf | sh
//加入系统 PATH 变量中
source $HOME/.cargo/env
```
## 卸载
```shell
rustup self uninstall
rustup 基本使用
rust 提供了不同版本nightly,stabel,beta
```
## 常用命令
#### 帮助
```shell
rustup -h
rust help <command> 来查看子命令的帮助。
```
#### 安装指定版本工具
```shell
rustup install 
或
rustup toolchain install
```
#### 进行版本切换
```shell
rustup default version 
```
####  配置默认工具链
```shell
 rustup default <toolchain>
 ```
#### 显示当前安装的工具链信息
```shell
rustup show 
```
#### 检查安装更新
```shell
rustup update 
```
#### 配置工具链
```shell
rustup toolchain [SUBCOMMAND] 
rustup toolchain install <toolchain> 安装工具链。
rustup toolchain uninstall <toolchain> 卸载工具链。
rustup toolchain link <toolchain-name> "<toolchain-path>" 设置自定义工具链。
其中标准的 <toolchain>具有如下的形式
`<channel>[-<date>][-<host>]`
<channel>       = stable|beta|nightly|<version>
<date>          = YYYY-MM-DD
<host>          = <target-triple>
如 stable-x86_64-pc-windows-msvc nightly-2017-7-25 1.18.0 等都是合法的toolchain名称。
 配置一个目录以及其子目录的默认工具链
rustup override [SUBCOMMAND] 
 --path <path> 指定目录或在某个目录下运行以下命令
rustup override set <toolchain> 设置该目录以及其子目录的默认工具链。
rustup override unset 取消目录以及其子目录的默认工具链。
使用 rustup override list 查看已设置的默认工具链。
```
#### 配置工具链的可用目标
```shell
rustup target [SUBCOMMAND] 
rustup target add <target> 安装目标。
rustup target remove <target> 卸载目标。
rustup target add --toolchain <toolchain> <target> 为特定工具链安装目标。
```
#### 配置 rustup 安装的组件
```shell
rustup component 
rustup component add <component> 安装组件
rustup component remove <component> 卸载组件
rustup component list 列出可用组件
```