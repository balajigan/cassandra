#!/bin/bash
sudo apt-get update
sudo apt-get install -y openjdk-8-jdk
export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64/
export PATH=$PATH:/usr/lib/jvm/java-8-openjdk-amd64/bin
mkdir /opt/dse
cd /opt/dse
curl -O -k https://storage.googleapis.com/test-bin-for-use/test-bin.tar.gz
tar -xvzf test-bin.tar.gz

