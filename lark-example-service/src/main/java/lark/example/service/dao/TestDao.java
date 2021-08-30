package lark.example.service.dao;

import lark.db.DatabaseService;
import lark.db.jsd.Database;
import lark.example.service.entity.TestDO;
import lark.example.service.entity.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static lark.db.jsd.Shortcut.f;

@Repository
public class TestDao {

    @Autowired
    DatabaseService databaseService;

    public TestDO getObject(int id) {
        Database userSqlQuery = databaseService.get( "user_master" );
        String name = null;
        UserDO user = userSqlQuery.select("id", "name" )
                .from( "users" )
                .where( f( "name", name ).and( f( "id", id ) ))
                .result().one( UserDO.class );
        //
        name = "123";
        UserDO user2 = userSqlQuery.select("id", "name" )
                .from( "users" )
                .where( f( "name", name ).and( f( "id", id ) ))
                .result().one( UserDO.class );
        //
        TestDO object = new TestDO();
        if ( user != null ) {
            object.setId( user.getId() );
            object.setName( user.getName() );
        } else {
            object.setId(id);
            object.setName("noname");
        }
        object.setDescription( "中国");
        return object;
    }
}