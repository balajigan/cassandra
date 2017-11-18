# cassandra

sudo su -

sudo apt-get update

sudo apt-get install git-core -y

git clone https://github.com/balajigan/cassandra.git

## Step1: Instal JDK:

sudo apt-get install -y openjdk-8-jdk

export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64/

export PATH=$PATH:/usr/lib/jvm/java-8-openjdk-amd64/bin

## Step2: Install & Start cassandra

cd /opt

mkdir cassandra

cd cassandra

curl -O -k http://apache.claz.org/cassandra/3.11.1/apache-cassandra-3.11.1-bin.tar.gz

tar -xvzf apache-cassandra-3.11.1-bin.tar.gz

bin/cassandra -R
