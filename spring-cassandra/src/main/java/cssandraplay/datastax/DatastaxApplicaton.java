package cssandraplay.datastax;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import cssandraplay.datastax.dao.ProductDao;
import cssandraplay.datastax.entity.Product;
import cssandraplay.datastax.mapper.InventoryMapper;
import cssandraplay.datastax.mapper.InventoryMapperBuilder;

import java.net.InetSocketAddress;
import java.util.UUID;

public class DatastaxApplicaton {
    public static void main(String[] args) {
//        testCqlQuery();
//        testMapper();
//        testDaoEquity();
        testReusingDaoWithDifferentTable();
//        queryTest();
    }

    private static void testCqlQuery() {
        try (CqlSession cqlSession = CqlSession.builder()
                .addContactPoint(new InetSocketAddress("127.0.0.1", 9042))
                .withLocalDatacenter("datacenter1")
                .build()) {

            ResultSet rs = cqlSession.execute("select * from springboot.person");
            Row one = rs.one();

            if (one == null) {
                return;
            }

            System.out.println(one.getString("id"));
            System.out.println(one.getString("firstname"));
            System.out.println(one.getString("lastname"));
        }
    }

//    private static void testMapper() {
//        try (CqlSession session = CqlSession.builder().build()) {
//            InventoryMapper inventoryMapper = new InventoryMapperBuilder(session).build();
//            ProductDao productDao = inventoryMapper.productDao(CqlIdentifier.fromCql("inventory"));
//            UUID id = UUID.randomUUID();
//            productDao.save(new Product(id, "test product"));
//            System.out.println(id);
//
//            Product product = productDao.findById(id);
//            System.out.println(product);
//
//            productDao.delete(product);
//            Product product2 = productDao.findById(id);
//            System.out.println(product2);
//        }
//    }
//
//    private static void testDaoEquity() {
//        try (CqlSession session = CqlSession.builder().build()) {
//            InventoryMapper inventoryMapper = new InventoryMapperBuilder(session).build();
//            ProductDao productDao1 = inventoryMapper.productDao(CqlIdentifier.fromCql("inventory"));
//            ProductDao productDao2 = inventoryMapper.productDao(CqlIdentifier.fromCql("inventory"));
//
//            if (productDao1 == productDao2) {
//                System.out.println("both productDao is same");
//            }
//        }
//    }
//
    private static void testReusingDaoWithDifferentTable() {
        try (CqlSession session = CqlSession.builder().build()) {
            InventoryMapper inventoryMapper = new InventoryMapperBuilder(session).build();
            ProductDao productDaoFromInventory2 = inventoryMapper.productDao("inventory", "product");
            ProductDao productDaoFromInventory3 = inventoryMapper.productDao("inventory", "my_table");

            Product byId = productDaoFromInventory2.findById(UUID.fromString("ed3b3c91-752e-460a-b7d3-24af85b55b6e"));
            System.out.println(byId);

            long count = productDaoFromInventory3.count();
            System.out.println(count);

            if (productDaoFromInventory3 == productDaoFromInventory2) {
                System.out.println("both productDao is same");
            }

            UUID uuid = UUID.randomUUID();
            productDaoFromInventory2.save(new Product(uuid, "test product 2222"));
            productDaoFromInventory3.save(new Product(UUID.randomUUID(), "test product 3333"));
        }
    }

//    private static void queryTest() {
//        try (CqlSession session = CqlSession.builder().build()) {
//            InventoryMapper inventoryMapper = new InventoryMapperBuilder(session).build();
//            ProductDao productDao = inventoryMapper.productDao("inventory", "my_table");
//            long count = productDao.count();
//            System.out.println(count);
//
//        }
//    }
}
