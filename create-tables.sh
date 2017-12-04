
CREATE KEYSPACE IF NOT EXISTS test WITH REPLICATION = {'class' : 'NetworkTopologyStrategy','replication_factor' : 1};
  

CREATE TABLE orders (orderId text, prdId text, orderDesc text, orderQty int, PRIMARY KEY (uid) ) WITH compaction= { 'class': 'MemoryOnlyStrategy' } AND caching = {'keys':'NONE', 'rows_per_partition':'NONE'};
     
