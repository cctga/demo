package com.wirk.demo.mapper;

import com.wirk.demo.model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author : Mao LuDong
 * @date : Created in 14:01 2019/11/18
 */
@Mapper
public interface UserMapper {
  UserModel findByNameAndPwd(@Param("name") String name, @Param("pwd") String pwd);
}
