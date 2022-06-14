package com.fanshr.step.engine.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fanshr.step.engine.core.domain.dto.TagDto;
import com.fanshr.step.engine.core.domain.entity.GroupTag;
import com.fanshr.step.engine.core.domain.entity.Tag;
import com.fanshr.step.engine.core.domain.entity.TagGroup;
import com.fanshr.step.engine.core.domain.vo.TagGroupVo;
import com.fanshr.step.engine.core.dao.GroupTagMapper;
import com.fanshr.step.engine.core.dao.TagGroupMapper;
import com.fanshr.step.engine.core.dao.TagMapper;
import com.fanshr.step.engine.core.service.TagGroupService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 权限组表 服务实现类
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-10
 */
@Service
public class TagGroupServiceImpl extends ServiceImpl<TagGroupMapper, TagGroup> implements TagGroupService {

    @Autowired
    private GroupTagMapper groupTagMapper;
    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<TagGroupVo> listByTypeId(Integer typeId) {

        // 获取指定体系下的标签组
        List<TagGroup> tagGroupList = baseMapper.selectList(new LambdaQueryWrapper<TagGroup>().eq(TagGroup::getTypeId,
                typeId).orderByAsc(TagGroup::getDisplay));
        List<Integer> tagGroupIdList = tagGroupList.stream().map(TagGroup::getId).collect(Collectors.toList());

        List<GroupTag> groupTagList =
                groupTagMapper.selectList(new LambdaQueryWrapper<GroupTag>().in(GroupTag::getGroupId, tagGroupIdList));

        //  获取所有组相关的标签
        List<Integer> tagIdList = groupTagList.stream().map(GroupTag::getTagId).collect(Collectors.toList());

        List<Tag> tagList = tagMapper.selectBatchIds(tagIdList);

        List<TagDto> tagDtoList = tagList.stream().map(item -> {
            TagDto tagDto = new TagDto();
            BeanUtils.copyProperties(item, tagDto);
            return tagDto;
        }).collect(Collectors.toList());


        Map<Integer, Integer> groupTagMap = groupTagList.stream().collect(Collectors.toMap(GroupTag::getTagId,
                GroupTag::getGroupId));

        List<TagGroupVo> tagGroupVoList = tagGroupList.stream().map(item -> {
            TagGroupVo tagGroupVo = new TagGroupVo();
            BeanUtils.copyProperties(item, tagGroupVo);
            List<TagDto> subTagList =
                    tagDtoList.stream().filter(tag -> groupTagMap.get(tag.getId()).equals(tagGroupVo.getId())).collect(Collectors.toList());
            tagGroupVo.setTagDtoList(subTagList);


            return tagGroupVo;
        }).collect(Collectors.toList());

        return tagGroupVoList;
    }

    @Override
    public TagGroupVo findTagById(Integer id) {
        TagGroup tagGroup = this.baseMapper.selectById(id);

        TagGroupVo tagGroupVo = new TagGroupVo();
        if (tagGroup != null) {

            BeanUtils.copyProperties(tagGroup, tagGroupVo);

            List<GroupTag> groupTagList =
                    groupTagMapper.selectList(new LambdaQueryWrapper<GroupTag>().eq(GroupTag::getGroupId, id)
                            .orderByAsc(GroupTag::getDisplay));
            List<Integer> tagIdList = groupTagList.stream().map((item -> {
                return item.getTagId();

            })).collect(Collectors.toList());

            List<Tag> tagList = tagMapper.selectBatchIds(tagIdList);

            List<TagDto> tagDtoList = tagList.stream().map(item -> {
                TagDto tagDto = new TagDto();
                BeanUtils.copyProperties(item, tagDto);
                return tagDto;
            }).collect(Collectors.toList());

            tagGroupVo.setTagDtoList(tagDtoList);
            return tagGroupVo;


        }
        return tagGroupVo;
    }


}
