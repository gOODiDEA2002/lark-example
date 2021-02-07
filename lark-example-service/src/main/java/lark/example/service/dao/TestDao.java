package lark.example.service.dao;

import lark.db.DatabaseService;
import lark.db.sql.SqlQuery;
import lark.example.service.entity.TestDO;
import lark.example.service.entity.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import static lark.db.sql.SqlHelper.f;

@Repository
public class TestDao {

    @Autowired
    DatabaseService databaseService;

    public TestDO getObject(int id) {
        SqlQuery userSqlQuery = databaseService.get( "user_master" );
        UserDO user = userSqlQuery.select("id", "name" )
                .from( "users" )
                .where( f( "id", id ) )
                .one( UserDO.class );
        //
        TestDO object = new TestDO();
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