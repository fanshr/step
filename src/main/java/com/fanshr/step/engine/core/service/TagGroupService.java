package com.fanshr.step.engine.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fanshr.step.engine.core.domain.entity.TagGroup;
import com.fanshr.step.engine.core.domain.vo.TagGroupVo;

import java.util.List;

/**
 * <p>
 * 权限组表 服务类
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-10
 */
public interface TagGroupService extends IService<TagGroup> {

    List<TagGroupVo> listByTypeId(Integer typeId);

    TagGroupVo findTagById(Integer id);
}
