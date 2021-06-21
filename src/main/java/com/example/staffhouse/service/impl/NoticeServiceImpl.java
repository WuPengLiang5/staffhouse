package com.example.staffhouse.service.impl;

import com.example.staffhouse.dao.NoticeDao;
import com.example.staffhouse.dao.UserDao;
import com.example.staffhouse.entity.Notice;
import com.example.staffhouse.entity.NoticeDTO;
import com.example.staffhouse.entity.UserInfo;
import com.example.staffhouse.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeDao noticeDao;

    @Autowired
    private UserDao userDao;

    @Override
    public List<NoticeDTO> listNotice() {
        List<NoticeDTO> noticeDTOS = new ArrayList<>();
        List<Notice> notices = noticeDao.listNotice();
        for(int i=0;i<notices.size();i++){
            Notice notice=notices.get(i);
            System.out.println(notice);
            UserInfo userInfo = userDao.getUserInfoById(notice.getUserId());
            NoticeDTO noticeDTO = new NoticeDTO(notice.getId(),notice.getUserId(),
                    notice.getTitle(),notice.getContent(),notice.getCreateDate());
            noticeDTO.setUserName(userInfo.getUserName());
            noticeDTOS.add(noticeDTO);
        }

        return noticeDTOS;
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

    @Override
    public List<NoticeDTO> searchNotice(String title,String content) {
        List<NoticeDTO> noticeDTOS = new ArrayList<>();
        List<Notice> notices = noticeDao.searchNotice(title,content);
        for(int i=0;i<notices.size();i++){
            Notice newNotice=notices.get(i);
            UserInfo userInfo = userDao.getUserInfoById(newNotice.getUserId());
            NoticeDTO noticeDTO = new NoticeDTO(newNotice.getId(),newNotice.getUserId(),
                    newNotice.getTitle(),newNotice.getContent(),newNotice.getCreateDate());
            noticeDTO.setUserName(userInfo.getUserName());
            noticeDTOS.add(noticeDTO);
        }
        return noticeDTOS;
    }

    @Override
    public void deleteNoticeByQuery(Integer[] ids) {
        noticeDao.deleteNoticeByQuery(ids);
    }


}
