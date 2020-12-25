package lark.example.service.dao;

import lark.db.sql.SqlQuery;
import lark.example.service.entity.TestObject;
import lark.example.service.entity.User;
import lark.util.db.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import static lark.db.sql.SqlHelper.f;

@Repository
public class TestDao {

    @Autowired
    @Qualifier("userSqlQuery")
    SqlQuery userSqlQuery;

    public TestObject getObject(int id) {
        User user = userSqlQuery.select("id", "name" )
                .from( "users" )
                .where( f( "id", id ) )
                .one( User.class );
        //
        TestObject object = new TestObject();
        if ( user != null ) {
            object.setId( user.getId() );
            object.setName( user.getName() );
        } else {
            object.setId(id);
            object.setName("noname");
            return object;
        }
        return object;
    }
}