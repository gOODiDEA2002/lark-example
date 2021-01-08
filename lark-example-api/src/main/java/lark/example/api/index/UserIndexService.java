package lark.example.api.index;

import lark.core.lang.BusinessException;
import lark.util.index.IndexService;
import lark.util.index.object.IndexDocument;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author andy
 */
@Service
public class UserIndexService {
    /**
     * 索引名称，一般为：项目名.模块名.索引名
     */
    private static final String INDEX_NAME = "lark.example.index.user";
    private static final int EXCEPTION_CODE = 10009;
    /**
     * 注入索引服务
     */
    @Autowired
    IndexService indexService;
    /**
     * 保存或修改用户文档
     *
     * @param user 用户信息
     */
    public void save( UserDocument user ) {
        IndexDocument<UserDocument> document = new IndexDocument<>();
        document.setId( String.valueOf( user.getId() ) );
        document.setData( user );
        try {
            indexService.save(INDEX_NAME, document);
        } catch (IOException e) {
            throw new BusinessException( EXCEPTION_CODE, "Failed to add user index", e );
        }
    }

    /**
     * 根据ID获取用户文档
     *
     * @param userId 用户 ID
     * @return 用户对象
     */
    public UserDocument getUser( int userId ) {
        try {
            UserDocument userEntity = indexService.get(INDEX_NAME, String.valueOf( userId ), UserDocument.class);
            return userEntity;
        } catch (IOException e) {
            throw new BusinessException( EXCEPTION_CODE, "Failed to get user index", e);
        }
    }

    /**
     * 根据姓名获取用户文档列表
     *
     * @param name 用户姓名
     * @return 用户集合
     */
    public List<UserDocument> getUsersByName(String name) {
        // 构建查询条件
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery()
                .must(QueryBuilders.matchPhraseQuery("name", name));
        // 构建查询生成器
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder().query(boolQueryBuilder);
        try {
            List<UserDocument> userEntityList = indexService.searchByQuery(INDEX_NAME, sourceBuilder, UserDocument.class);
            return userEntityList;
        } catch (IOException e) {
            throw new BusinessException( EXCEPTION_CODE, "Failed to get user index", e);
        }
    }

    /**
     * 根据用户I删除用户文档
     *
     * @param userId 用户 ID
     */
    public void deleteUser(int userId) {
        try {
            indexService.delete(INDEX_NAME, String.valueOf( userId ) );
        } catch (IOException e) {
            throw new BusinessException( EXCEPTION_CODE, "Failed to delete user index", e);
        }
    }
}
