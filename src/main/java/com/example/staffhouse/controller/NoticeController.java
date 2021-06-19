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
    NoticeService noticeService;

    @RequestMapping("/listNotice")
    List<Notice> listNotice() {

        return noticeService.listNotice();
    }

    @RequestMapping("/listNoticeByCreatDate")
    List<Notice> listNoticeByCreatDate() {
        return noticeService.listNoticeByCreatDate();
    }

    @RequestMapping("/listNoticeByUserId")
    List<Notice> listNoticeByUserId() {
        return noticeService.listNoticeByUserId();
    }

    @RequestMapping("/saveNotice")
    void saveNotice(Notice notice) {
        noticeService.saveNotice(notice);
    }

    @RequestMapping("/deleteNotice")
    void deleteNotice(Integer id) {
        noticeService.deleteNotice(id);
    }

    @RequestMapping("/updateNotice")
    void updateNotice(Notice notice) {
        noticeService.updateNotice(notice);
    }

    @RequestMapping("/ getNoticeById")
    Notice getNoticeById(Integer id) {
        return noticeService.getNoticeById(id);
    }
}
