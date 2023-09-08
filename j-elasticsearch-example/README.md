服务版本：elasticsearch-7.17.12-windows-x86_64

elasticsearch.yml 配置：

```yaml
#集群名称
cluster.name: my-application
#本节点名称
node.name: node-1
#是否master节点
node.master: true
#是否存储数据
node.data: true
#跨域设置
http.cors.enabled: true
http.cors.allow-origin: "*"
#http端口
http.port: 9200
#java端口
transport.tcp.port: 9300
#可以访问es集群的ip  0.0.0.0表示不绑定
network.bind_host: 0.0.0.0
#es集群相互通信的ip  0.0.0.0默认本地网络搜索
network.publish_host: 0.0.0.0

#7.x配置
discovery.seed_hosts: ["127.0.0.1:9200"]
cluster.initial_master_nodes: ["node-1"]
```

