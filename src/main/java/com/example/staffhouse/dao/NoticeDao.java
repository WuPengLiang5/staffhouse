package com.example.staffhouse.dao;

import com.example.staffhouse.entity.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value="NoticeDao")
public interface NoticeDao {

    List<Notice> listNotice();

    List<Notice> listNoticeByCreatDate();

    List<Notice> listNoticeByUserId();

    void saveNotice(Notice notice);

    void deleteNotice(Integer id);

    void updateNotice(Notice notice);

    Notice getNoticeById(Integer id);

}
