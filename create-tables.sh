
CREATE KEYSPACE IF NOT EXISTS test WITH REPLICATION = {'class' : 'SimpleStrategy','replication_factor' : 1};
CREATE KEYSPACE IF NOT EXISTS test WITH REPLICATION = {'class' : 'NetworkTopologyStrategy', 'Cassandra' : 3 };


CREATE TABLE test.orders (orderId text, prdId text, orderDesc text, orderQty int, PRIMARY KEY (orderId) ) WITH compaction= { 'class': 'MemoryOnlyStrategy' } AND caching = {'keys':'NONE', 'rows_per_partition':'NONE'};
CREATE TABLE test.orders2 (orderId text, orderDetails text, PRIMARY KEY (orderId) ) WITH compaction= { 'class': 'MemoryOnlyStrategy' } AND caching = {'keys':'NONE', 'rows_per_partition':'NONE'};
     
