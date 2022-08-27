# Algorithms Fourth Edition Reading Notes

本 repo 是我读算法（第4版）的读书笔记


本项目使用 maven 来管理，目录结构为：

```
src
└── main
    ├── java
    │   ├── algs4                  - algs4 提供的标准库
    │   └── kang
    │       │── section_11model    - 每章的代码、习题解答、读书笔记
    │       │── ...
    │       └── section_15uf       - 每章的代码、习题解答、读书笔记
    └── resources                  - algs4 提供的测试数据
```

以 BinarySearch 为例，如何使用该 repo。

首先确保你的机器上已经安装好 [java](https://www.java.com/) 和 [maven](https://maven.apache.org/).

在创建 maven 项目时，我机器上的 Java JDK 为 `openjdk version "18.0.2.1" 2022-08-18`，故使用此项目请确保你的 Java 版本为 18。

环境安装好之后，使用 `mvn compile` 来编译 `src/` 目录下的文件

```bash
mvn compile
```

maven 会将编辑好的 `*.class` 以包名为目录放在 `target/classes/` 目录下，同样会将 `resources/` 中的文件编译到 `target/classes` 目录下。

所以要测试 BinarySearch，先进入 `target/classes`，紧接着调用 `BinarySearch.class` 即可：

```bash
cd target/classes
java kang.chapter1_1.BinarySearch tinyW.txt < tinyT.txt
```

## 有用的资料

* Algorithms Fourth Edition 官网：https://algs4.cs.princeton.edu/ 在这里你可以找到关于 algs4 的一切
* 官方示例代码：https://github.com/kevin-wayne/algs4
* 官方提供的测试数据：https://algs4.cs.princeton.edu/code/algs4.data.zip
