package com.example.staffhouse.service;

import com.example.staffhouse.entity.Document;

import java.util.List;

public interface DocumentService {
    public Integer saveDocument(Document document);
    public List<Document> getDocumentsByPage(Integer page);
    public int getAllDocumentsNumber();
    public String getDocumentPath(int id);
    public List<Document> getDocumentById(int id);
    public List<Document> getDocumentsByCreateDate(String createDate,int page);
    public List<Document> getDocumentsByIdAndCreateDate(String createDate,int id,int page);
    public int getDocumentsNumberByCreateDate(String createDate);
}
