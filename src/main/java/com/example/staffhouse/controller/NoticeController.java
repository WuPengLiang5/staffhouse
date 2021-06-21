package com.example.staffhouse.controller;

import com.example.staffhouse.entity.Notice;
import com.example.staffhouse.entity.NoticeDTO;
import com.example.staffhouse.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.security.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    /**
     *获取所有公告
     * @return
     */
    @RequestMapping("/listNotice")
    public List<NoticeDTO> listNotice() {
        return noticeService.listNotice();
    }

    /**
     * 获取所有公告根据日期排序
     * @return
     */
    @RequestMapping("/listNoticeByCreatDate")
    public List<Notice> listNoticeByCreatDate() {
        return noticeService.listNoticeByCreatDate();
    }

    /**
     * 获取所有公告根据公告人排序
     * @return
     */
    @RequestMapping("/listNoticeByUserId")
    public List<Notice> listNoticeByUserId() {
        return noticeService.listNoticeByUserId();
    }

    /**
     * 添加公告
     * @param notice
     */
    @RequestMapping("/saveNotice")
    public void saveNotice(@RequestBody Notice notice) {
        noticeService.saveNotice(notice);
    }

    /**
     * 根据公告id删除公告
     * @param id
     */
    @RequestMapping("/deleteNotice")
    public void deleteNotice(Integer id) {
        noticeService.deleteNotice(id);
    }

    /**
     * 更新公告
     * @param notice
     */
    @RequestMapping("/updateNotice")
    public void updateNotice(@RequestBody Notice notice) {
        noticeService.updateNotice(notice);
    }

    /**
     * 根据公告id获取公告
     * @param id
     * @return
     */
    @RequestMapping("/getNoticeById")
    public Notice getNoticeById(Integer id) {
        return noticeService.getNoticeById(id);
    }

    @RequestMapping("/searchNotice")
    public List<NoticeDTO> searchiNotice(@RequestBody Map<String,String> map) {
        String title=map.get("title");
        String content=map.get("content");
        return noticeService.searchNotice(title,content);
    }

    @RequestMapping("/deleteNoticeByQuery")
    public void deleteNoticeByQuery(@RequestBody Map<String,List<Integer>> map) {
        Integer[] list = map.get("ids").toArray(new Integer[0]);
        noticeService.deleteNoticeByQuery(list);
    }

}
