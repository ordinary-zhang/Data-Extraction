package cn.zhangyu.repository;

import cn.zhangyu.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by grace on 2018/9/2.
 */
public interface HotelRepository extends JpaRepository<HotelEntity,Long>{
}
