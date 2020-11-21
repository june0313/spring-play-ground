package cssandraplay.datastax.dao;

import com.datastax.oss.driver.api.core.cql.BoundStatementBuilder;
import com.datastax.oss.driver.api.mapper.annotations.Insert;
import com.datastax.oss.driver.api.mapper.annotations.Select;
import com.datastax.oss.driver.api.mapper.annotations.SetEntity;

import java.util.UUID;

public interface BaseDao<T> {
    @Insert
    void save(T entity);

    @Select
    T findById(UUID id);

    @SetEntity
    void bind(T entity, BoundStatementBuilder builder);
}
