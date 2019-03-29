# SpringCloud
Cloud POC Repo

CloudClient connects with Kafka and register with Zookeeper.
CloudClient2 registers with Zookeeper. 
Exposes a service to list the instances and services registered with Zookeeper.

# Commands for Kafka
bin\windows\zookeeper-server-start.bat config/zookeeper.properties
bin\windows\kafka-server-start.sh config/server.properties
bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test-topic
bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092
