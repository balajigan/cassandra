CREATE KEYSPACE IF NOT EXISTS test WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'};
CREATE TYPE IF NOT EXISTS test.order_line_items (
    product_id text,
    order_qty int,
    order_unit text
);
CREATE TABLE IF NOT EXISTS test.orders (
    order_id text PRIMARY KEY,
    deliver_by text,
    delivery_notes text,
    order_by text,
    order_customer_id text,
    order_date text,
    order_dc text,
    order_line_items frozen<list<frozen<order_line_items>>>,
    order_market text,
    order_source text,
    order_status text,
    order_taken_by text
)WITH compaction= { 'class': 'MemoryOnlyStrategy' }
     AND compression = {'sstable_compression' : ''}
     AND caching = {'keys':'NONE', 'rows_per_partition':'NONE'};


