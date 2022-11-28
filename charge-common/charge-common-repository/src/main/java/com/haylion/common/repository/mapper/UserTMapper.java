package com.haylion.common.repository.mapper;

import com.haylion.common.entity.dto.UserDetailDto;
import com.haylion.common.entity.entity.UserT;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @author liyu
 * date 2022/4/8 15:04
 * description
 */
@Mapper
public interface UserTMapper {
    int insert(UserT record);

    int insertSelective(UserT record);

    UserT selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserT record);

    int updateByPrimaryKey(UserT record);

    UserT selectByLowerUsername(@Param("username") String username);

    List<String> selectResourceCodeByUserId(@Param("userId") Integer userId);

    Set<String> selectRoleCodesByUserId(@Param("userId") Integer userId);

    /**
     * search one user
     * @param username
     * @param mobile
     * @param userType
     * @return
     */
    Optional<UserT> selectByLowerUsernameOrMobileWithUserType(@Param("username") String username,
                                                              @Param("mobile") String mobile,
                                                              @Param("userType") Integer userType);

    UserDetailDto getUserDetail(@Param("userId") Integer userId);

    List<UserDetailDto> selectList(@Param("name") String name,
                                   @Param("username") String username,
                                   @Param("card") String card,
                                   @Param("states") Integer[] states,
                                   @Param("mobile") String mobile,
                                   @Param("cId") Integer cId,
                                   @Param("dId") Integer dId,
                                   @Param("pId") Integer pId);

    Integer updatePassword(@Param("id") Integer id,
                           @Param("password") String password);

    Integer updatePasswordByMobile(@Param("mobile") String mobile, @Param("password") String password);

    boolean selectUserExitByPId(Integer pId);

    Set<Integer> selectIdsBySupplierCode(@Param("supplierCode") String supplierCode);
}