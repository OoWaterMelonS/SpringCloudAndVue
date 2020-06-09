package com.course.server.service;

import com.course.server.domain.Section;
import com.course.server.domain.SectionExample;
import com.course.server.dto.SectionDto;
import com.course.server.dto.PageDto;
import com.course.server.mapper.SectionMapper;
import com.course.server.util.CopyUtil;
import com.course.server.util.UuidUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SectionService {
@Resource
private SectionMapper sectionMapper;

public PageDto list(PageDto pageDto){
// 查第一页，查一条
// 注意：pageNum是从1开始的，不是从0开始的
PageHelper.startPage(pageDto.getPage(),pageDto.getSize());

SectionExample sectionExample = new SectionExample();
List<Section> sectionList = sectionMapper.selectByExample(sectionExample);
        PageInfo<Section> pageInfo = new PageInfo<>(sectionList);
                pageDto.setTotal(pageInfo.getTotal());
                List<SectionDto> sectionDtoList = new ArrayList<SectionDto>();
                                for ( int i = 0,length = sectionList.size(); i < length; i++){
                                SectionDto sectionDto = new SectionDto();
                                Section section = sectionList.get(i);
                                if(section!=null) {
                                BeanUtils.copyProperties(section, sectionDto);
                                sectionDtoList.add(sectionDto);
                                }
                                }
                                pageDto.setList(sectionList);
                                // 此处的pageDto是从前端拿到的  后端不返回，前端也能拿到这个对象
                                return pageDto;
                                }

                                public SectionDto save(SectionDto sectionDto) {
                                Section section = CopyUtil.copy(sectionDto,Section.class);
                                if(StringUtils.isEmpty(section.getId())){
                                this.insert(section);
                                }
                                else{
                                this.update(section);
                                }
                                return sectionDto;
                                }

                                private void insert(Section section) {
                                section.setId(UuidUtil.getShortUuid());

                                sectionMapper.insert(section);
                                }

                                private void update(Section section) {
                                sectionMapper.updateByPrimaryKey(section);
                                }

                                public void delete(String id) {
                                sectionMapper.deleteByPrimaryKey(id);
                                }
                                }