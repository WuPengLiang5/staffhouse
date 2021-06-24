package com.example.staffhouse.dao;

import com.example.staffhouse.entity.Document;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value="DocumentDao")
public interface DocumentDao {
    //保存文档
    int saveDocument (Document document);
    void deleteDocument (int id);
    //分页获取文档
    List<Document> getDocumentsByPage(Integer page);
    //获取所有文件数目
    int getAllDocumentsNumber();
    //获取文件存储路径
    String getDocumentPath(int id);
    //根据文档编号查询文档
    List<Document> getDocumentById(int id);
    //根据文档创建日期查询文档
    List<Document> getDocumentsByCreateDate(@Param("createDate") String createDate,@Param("page") int page);
    //根据创建日期获取数量
    int getDocumentsNumberByCreateDate(String createDate);
    //根据id和日期获取文档
    List<Document> getDocumentsByIdAndCreateDate(@Param("createDate")String createDate,@Param("id") int id,@Param("page") int page);
}
