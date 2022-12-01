package com.haylion.common.repository.mapper;

import com.haylion.common.entity.entity.DictItemT;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author LaiXiaoPeng
 * @version 1.0
 * @date 2022/4/18 11:42
 */
public interface DictItemTMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DictItemT record);

    int insertSelective(DictItemT record);

    DictItemT selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DictItemT record);

    int updateByPrimaryKey(DictItemT record);

    int updateBatchSelective(List<DictItemT> list);

    int batchInsert(@Param("list") List<DictItemT> list);

    List<DictItemT> getAncestorsByLeftAndRight(@Param("left") Integer left, @Param("right") Integer right);

    void updateLeftForAdd(@Param("right") Integer right);

    void updateRightForAdd(@Param("right") Integer right);

    Integer count();

    void updateLeftForDelete(@Param("left") Integer left, @Param("right") Integer right);

    void updateRightForDelete(@Param("left") Integer left, @Param("right") Integer right);

    /**
     *逻辑删除左右值指定的节点树
     * @param left
     * @param right
     * @param deleteAt
     * @param deleteBy
     */
    void deleteSubTree(@Param("left") Integer left,
                       @Param("right") Integer right,
                       @Param("deleteAt") LocalDateTime deleteAt,
                       @Param("deleteBy") String deleteBy);

    List<DictItemT> getDictItemByLevel(@Param("level") Integer level);

    List<DictItemT> getDirectChildren(@Param("left") Integer left,
                                     @Param("right") Integer right,
                                     @Param("level") Integer level);

    DictItemT getRootDictItem();
    DictItemT selectById(@Param("id") Integer id);

//    List<CameraLocationDto> getCameraOnDictItemsByLevel(@Param("level") Integer level,
//                                                    @Param("left") Integer left,
//                                                    @Param("right") Integer right);

    List<Integer> getAllFamilyIdsByParentId(@Param("left") Integer left, @Param("right") Integer right);

    List<DictItemT> selectListByName(@Param("name") String name);

    List<DictItemT> getAllFamilyByParentId(@Param("left") Integer left, @Param("right") Integer right);
}