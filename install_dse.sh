#!/bin/bash
sudo apt-get update
sudo apt-get install -y openjdk-8-jdk
export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64/
export PATH=$PATH:/usr/lib/jvm/java-8-openjdk-amd64/bin
mkdir /opt/dse
cd /opt/dse
curl -O -k http://apache.claz.org/cassandra/3.11.1/apache-cassandra-3.11.1-bin.tar.gz
tar -xvzf apache-cassandra-3.11.1-bin.tar.gz
apache-cassandra-3.11.1/bin/cassandra -R &
