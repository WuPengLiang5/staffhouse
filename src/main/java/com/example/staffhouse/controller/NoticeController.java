package com.example.staffhouse.controller;

import com.example.staffhouse.entity.Notice;
import com.example.staffhouse.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Provider;
import java.util.List;

@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/listNotice")
    public List<Notice> listNotice() {

        return noticeService.listNotice();
    }

    @RequestMapping("/listNoticeByCreatDate")
    public List<Notice> listNoticeByCreatDate() {
        return noticeService.listNoticeByCreatDate();
    }

    @RequestMapping("/listNoticeByUserId")
    public List<Notice> listNoticeByUserId() {
        return noticeService.listNoticeByUserId();
    }

    @RequestMapping("/saveNotice")
    public void saveNotice(Notice notice) {
        noticeService.saveNotice(notice);
    }

    @RequestMapping("/deleteNotice")
    public void deleteNotice(Integer id) {
        noticeService.deleteNotice(id);
    }

    @RequestMapping("/updateNotice")
    public void updateNotice(Notice notice) {
        noticeService.updateNotice(notice);
    }

    @RequestMapping("/ getNoticeById")
    public Notice getNoticeById(Integer id) {
        return noticeService.getNoticeById(id);
    }
}
