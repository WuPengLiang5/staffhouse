package com.example.staffhouse.service.impl;

import com.example.staffhouse.dao.NoticeDao;
import com.example.staffhouse.entity.Notice;
import com.example.staffhouse.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    NoticeDao noticeDao;

    @Override
    public List<Notice> listNotice() {
        return noticeDao.listNotice();
    }

    @Override
    public List<Notice> listNoticeByCreatDate() {
        return noticeDao.listNoticeByCreatDate();
    }

    @Override
    public List<Notice> listNoticeByUserId() {
        return noticeDao.listNoticeByUserId();
    }

    @Override
    public void saveNotice(Notice notice) {
        noticeDao.saveNotice(notice);
    }

    @Override
    public void deleteNotice(Integer id) {
        noticeDao.deleteNotice(id);
    }

    @Override
    public void updateNotice(Notice notice) {
        noticeDao.updateNotice(notice);
    }

    @Override
    public Notice getNoticeById(Integer id) {
        return noticeDao.getNoticeById(id);
    }
}
