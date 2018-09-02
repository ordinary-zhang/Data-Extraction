package cn.zhangyu.repository;

import cn.zhangyu.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by grace on 2018/9/2.
 */
public interface PersonRepository extends JpaRepository<PersonEntity,Long>{
}
