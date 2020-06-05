package com.course.business.controller.admin;

import com.course.server.dto.ChapterDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.service.ChapterService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author EaApple
 * @2020/4/25 23:18
 * description：
 */
@RestController
@RequestMapping("/admin/chapter")
public class ChapterController {

    private static final Logger LOG = LoggerFactory.getLogger(ChapterController.class);

    @Resource
    private ChapterService chapterService;

    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto){
        // 此处考不考虑直接新建一个静态方法呢
        ResponseDto responseDto = new ResponseDto();
        // 直接就是使用的前端返回的dto 所以不必返回
        chapterService.list(pageDto);
        LOG.info("pageDto={}",pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }
    @PostMapping("/save")
    public ResponseDto save(@RequestBody ChapterDto chapterDto){
        ResponseDto responseDto = ResponseDto.getInstance();
        LOG.info("chapterDto:{}",chapterDto);
        chapterService.save(chapterDto);
        responseDto.setContent(chapterDto);
        return responseDto;
    }
    @DeleteMapping("/delete/{id}")
//    @RequestMapping("/delete/{id}/{name}")
//    public ResponseDto delete(@PathVariable String id,@PathVariable String name){
    public ResponseDto delete(@PathVariable String id){
        ResponseDto responseDto = ResponseDto.getInstance();
        LOG.info("id:{}",id);
        chapterService.delete(id);
        return responseDto;
    }
}
