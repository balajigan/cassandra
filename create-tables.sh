

CREATE TABLE orders (
  orderId text,
  fname text,
  lname text,
  PRIMARY KEY (uid) 
) WITH compaction= { 'class': 'MemoryOnlyStrategy' }
     AND caching = {'keys':'NONE', 'rows_per_partition':'NONE'};
     
