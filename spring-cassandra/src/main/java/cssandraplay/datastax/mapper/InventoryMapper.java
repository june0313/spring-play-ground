package cssandraplay.datastax.mapper;

import com.datastax.oss.driver.api.mapper.annotations.DaoFactory;
import com.datastax.oss.driver.api.mapper.annotations.DaoKeyspace;
import com.datastax.oss.driver.api.mapper.annotations.DaoTable;
import com.datastax.oss.driver.api.mapper.annotations.Mapper;
import cssandraplay.datastax.dao.ProductDao;

/**
 * Mapper provides DAO instances.
 */
@Mapper
public interface InventoryMapper {
    @DaoFactory
    ProductDao productDao(@DaoKeyspace String keyspace, @DaoTable String table);
}
