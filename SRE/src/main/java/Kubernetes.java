
/**
 Kubernetes主要由以下几个核心组件组成：

 etcd保存了整个集群的状态；
 apiserver提供了资源操作的唯一入口，并提供认证、授权、访问控制、API注册和发现等机制；
 controller manager负责维护集群的状态，比如故障检测、自动扩展、滚动更新等；
 scheduler负责资源的调度，按照预定的调度策略将Pod调度到相应的机器上；
 kubelet负责维持容器的生命周期，同时也负责Volume（CVI）和网络（CNI）的管理；kubelet 是在每个 Node 节点上运行的主要 “节点代理”。它可以使用以下之一向 apiserver 注册： 主机名（hostname）；覆盖主机名的参数；某云驱动的特定逻辑。
 kubelet 是基于 PodSpec 来工作的。每个 PodSpec 是一个描述 Pod 的 YAML 或 JSON 对象。
 Container runtime负责镜像管理以及Pod和容器的真正运行（CRI: Container Runtime Interface）；
 kube-proxy负责为Service提供cluster内部的服务发现和负载均衡；
 除了核心组件，还有一些推荐的add-ons（扩展）：

 kube-dns负责为整个集群提供DNS服务
 Ingress Controller为服务提供外网入口
 Heapster提供资源监控
 Dashboard提供GUI
 Federation提供跨可用区的集群
 Fluentd-elasticsearch提供集群日志采集、存储与查询
 * */

/**
 * kubectl run, create, get
 *
 * 初始化容器和SideCar容器的作用和区别
 * init Container：提前做准备的
 * sideCar：提供各种辅助assist功能
 * 在pod前的准备工作中使用Init Containers，是在pods 容器启动前工作的容器
 *
 * 实现方式也是添加容器来增强pod中应用，边车最经典的应用就是日志跟踪。
 * 在容器化的环境中最标准的做法是标准输出日志到一个中心化的收集器中用于分析和管理。但是很多老的应用是将日志写入文件，而更改日志输出有时候是一件困难的事。
 *
 *
 * */
public class Kubernetes {
}
