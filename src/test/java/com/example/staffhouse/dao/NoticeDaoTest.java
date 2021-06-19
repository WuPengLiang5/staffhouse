package com.example.staffhouse.dao;


import com.example.staffhouse.entity.Notice;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class NoticeDaoTest {

    @Autowired
    NoticeDao noticeDao;

    @Before
    public void beforeTest(){
        System.out.println("Before test.....");
    }

    @Test
    public void listNotice(){
        System.out.println("listNotice test start....");
        noticeDao.listNotice();
    }

    @Test
    public void listNoticeByCreatDate(){
        System.out.println("listNoticeByCreatDate test start....");
        noticeDao.listNoticeByCreatDate();
    }

    @Test
    public void listNoticeById(){
        System.out.println("listNoticeById test start....");
        noticeDao.listNoticeByUserId();
    }

    @Test
    public void saveNotice(){
        System.out.println("saveNotice test start....");
        Notice notice = new Notice(9999,1,"标题","内容","2021-05-09");
        noticeDao.saveNotice(notice);
    }

    @Test
    public void getNoticeById(){
        System.out.println("getNoticeById test start....");
        Notice notice = noticeDao.getNoticeById(9999);
        System.out.println(notice.getTitle());
        System.out.println(notice.getContent());
        System.out.println(notice.getUserId());
        System.out.println(notice.getCreateDate());
        System.out.println(notice.getId());
    }

    @Test
    public void updateNotice(){
        System.out.println("updateNotice test start....");
        Notice notice = new Notice(9999,1,"标题","java lala dai","2021-05-09");
        noticeDao.updateNotice(notice);
    }

    @Test
    public void deleteNotice(){
        System.out.println("deleteNotice test start....");
        noticeDao.deleteNotice(9999);
    }
}
