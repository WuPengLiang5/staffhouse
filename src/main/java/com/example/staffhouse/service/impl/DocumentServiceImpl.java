package com.example.staffhouse.service.impl;

import com.example.staffhouse.dao.DocumentDao;
import com.example.staffhouse.entity.Document;
import com.example.staffhouse.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentDao documentDao;

    //保存文件
    @Override
    public Integer saveDocument(Document document) {
        return documentDao.saveDocument(document);
    }
    //分页获取文档
    @Override
    public List<Document> getDocumentsByPage(Integer page){
        return documentDao.getDocumentsByPage(page);
    }

    //获取所有文件数量
    @Override
    public int getAllDocumentsNumber(){
        return documentDao.getAllDocumentsNumber();
    };
    //获取文件路径
    @Override
    public String getDocumentPath(int id){
        return documentDao.getDocumentPath(id);
    }

    @Override
    public List<Document> getDocumentById(int id) {
        return documentDao.getDocumentById(id);
    }

    @Override
    public List<Document> getDocumentsByCreateDate(String createDate,int page) {
        return documentDao.getDocumentsByCreateDate(createDate,page);
    }

    @Override
    public List<Document> getDocumentsByIdAndCreateDate(String createDate, int id, int page) {
        return documentDao.getDocumentsByIdAndCreateDate(createDate,id,page);
    }

    @Override
    public int getDocumentsNumberByCreateDate(String createDate) {
        return documentDao.getDocumentsNumberByCreateDate(createDate);
    }


}
