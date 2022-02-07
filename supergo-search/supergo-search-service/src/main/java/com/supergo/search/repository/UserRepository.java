package com.supergo.search.repository;

import com.supergo.search.entity.UserEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @Auther:xueruiheng
 * @Date:2022/2/7
 * @Description:com.supergo.search.repository
 * 需要继承于ElasticsearchRepository接口，需要两个泛型，第一个是当前repository操作的实体类，第二个是实体类主键的数据类型
 * @version:1.0
 */
public interface UserRepository extends ElasticsearchRepository<UserEntity,Integer> {

    List<UserEntity> findByName(String name);
}
