#!/bin/bash

# Step1: Instal JDK:
sudo apt-get install -y openjdk-8-jdk
export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64/
export PATH=$PATH:/usr/lib/jvm/java-8-openjdk-amd64/bin

## Step2: Install & Start cassandra
mkdir /opt/cassandra
cd /opt/cassandra
curl -O -k http://apache.claz.org/cassandra/3.11.1/apache-cassandra-3.11.1-bin.tar.gz
tar -xvzf apache-cassandra-3.11.1-bin.tar.gz
# start cassandra
apache-cassandra-3.11.1/bin/cassandra -R

