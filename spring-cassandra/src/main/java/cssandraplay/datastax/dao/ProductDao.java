package cssandraplay.datastax.dao;

import com.datastax.oss.driver.api.mapper.annotations.Dao;
import com.datastax.oss.driver.api.mapper.annotations.Delete;
import com.datastax.oss.driver.api.mapper.annotations.Query;
import cssandraplay.datastax.entity.Product;

@Dao
public interface ProductDao extends BaseDao<Product> {
    @Delete
    void delete(Product product);

    @Query("SELECT count(*) FROM ${keyspaceId}.${tableId}")
    long count();
}
