
CREATE KEYSPACE IF NOT EXISTS test WITH REPLICATION = {'class' : 'SimpleStrategy','replication_factor' : 1};
  

CREATE TABLE test.orders (orderId text, prdId text, orderDesc text, orderQty int, PRIMARY KEY (uid) ) WITH compaction= { 'class': 'MemoryOnlyStrategy' } AND caching = {'keys':'NONE', 'rows_per_partition':'NONE'};
     
