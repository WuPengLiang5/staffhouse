package com.example.staffhouse.service;

import com.example.staffhouse.entity.Notice;

import java.util.List;

public interface NoticeService {

    public List<Notice> listNotice();

    public List<Notice> listNoticeByCreatDate();

    public List<Notice> listNoticeByUserId();

    public void saveNotice(Notice notice);

    public void deleteNotice(Integer id);

    public void updateNotice(Notice notice);

    public Notice getNoticeById(Integer id);
}
