package com.ssafy.edu.vue.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WishProductDAO {

@Autowired
SqlSessionTemplate sqlSession;

}
