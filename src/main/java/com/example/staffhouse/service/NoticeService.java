package com.example.staffhouse.service;

import com.example.staffhouse.entity.Notice;
import com.example.staffhouse.entity.NoticeDTO;

import java.util.List;

public interface NoticeService {

    public List<NoticeDTO> listNotice();

    public List<Notice> listNoticeByCreatDate();

    public List<Notice> listNoticeByUserId();

    public void saveNotice(Notice notice);

    public void deleteNotice(Integer id);

    public void updateNotice(Notice notice);

    public Notice getNoticeById(Integer id);

    List<NoticeDTO> searchNotice(String title,String content);
}
