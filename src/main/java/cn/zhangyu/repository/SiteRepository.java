package cn.zhangyu.repository;

import cn.zhangyu.entity.SiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteRepository extends JpaRepository<SiteEntity,String> {
}
