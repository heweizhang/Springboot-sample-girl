package com.david.reponsitory;

import com.david.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zhanghewei on 17/9/4.
 */
public interface GirlRepository extends JpaRepository<Girl,Integer>{

    //通过年龄来查询
    public List<Girl> findByAge(Integer age);
}
