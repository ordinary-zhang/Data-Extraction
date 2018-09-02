package cn.zhangyu.repository;

import cn.zhangyu.entity.ImsiEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ImsiRepository extends JpaRepository<ImsiEntity,Long> {
}
