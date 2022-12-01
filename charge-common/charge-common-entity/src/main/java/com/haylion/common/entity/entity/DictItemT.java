package com.haylion.common.entity.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author  LaiXiaoPeng
 * @date  2022/4/18 11:42
 * @version 1.0
 */

/**
 * 区域表
 * date: 2022-04-07 14:59
 * 采用左右值编码(前序遍历)平铺区域树状图
 * 1.查询某个节点所有的子节点
 * 1）所有子节点列表
 * select * from dict_item_t where left between #{left} and #{right} order by left asc;
 * 2) 直接子节点列表
 * select * from dict_item_t where left between #{left} and #{right} and level = #{level+1} order by left asc;
 * <p>
 * 2. 查询某个节点的父节点列表
 * 1）父节点列表
 * select * from dict_item_t where left<#{left} and right>#{right} order by left asc
 * 2)计算节点所属层级
 * select count(*) from dict_item_t where left<#{left} and right>#{right}
 * <p>
 * 3.某个节点下新增节点(遵循末尾添加原则)
 * 1）left,right值计算
 * left: 1.中所有子节点列表中max(right)
 * right:left+1
 * 2) 新增后其他节点left，right值变化:
 * update dict_item_t set left = left+2 where left>=#{right};
 * update dict_item_t set right= right+2 where right>=#{right};
 * <p>
 * 4.删除某个节点及其子节点
 * 1) 删除节点及其子节点
 * delete from dict_item_t where left>=#{left} and right<=#{right}
 * 2）其他节点left,right变化
 * update dict_item_t set left = left-(#{right}-#{left}+1) where left>#{left};
 * update dict_item_t set right = right-(#{right} - #{left} + 1) where right>#{right};
 */
@Data
@Accessors(chain = true)
public class DictItemT {
    /**
     * 区域表主键
     */
    private Integer id;

    /**
     * 区域名称
     */
    private String name;

    /**
     * 区域节点左值
     */
    private Integer left;

    /**
     * 区域节点右值
     */
    private Integer right;

    /**
     * 区域节点树所属层级
     */
    private Integer level;

    /**
     * 创建时间
     */
    private LocalDateTime createAt;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateAt;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 是否删除(0-否,1-是)
     */
    private Integer deleted;
}