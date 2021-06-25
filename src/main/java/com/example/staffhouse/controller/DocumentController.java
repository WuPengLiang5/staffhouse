package com.example.staffhouse.controller;

import com.example.staffhouse.Vo.SysResult;
import com.example.staffhouse.entity.Document;
import com.example.staffhouse.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.print.Doc;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/document")
public class DocumentController {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    @Autowired
    private DocumentService documentService;
    /**
     * 上传文件
     */
    @PostMapping("/uploadFile")
    public SysResult uploadFile(MultipartFile file) throws FileNotFoundException {
        String originName = file.getOriginalFilename();
        if (!originName.endsWith(".docx")){
             return SysResult.fail("文件类型错误");
        }
        String format = sdf.format(new Date());
        String realPath = ResourceUtils.getURL("src/main/resources/static/document/" + format).getPath();
        File folder = new File(realPath);
        if (!folder.exists()){
            folder.mkdirs();
        }
        try{
            file.transferTo(new File(folder,originName));
            String url = folder+"\\"+originName;
            Map<String, String> data = new HashMap<>();
            data.put("path",url);
            data.put("createDate",format);
            return SysResult.success("上传成功",data);
        }catch (IOException e){
            return SysResult.fail("上传失败");
        }
    }
    /**
     * 保存文件内容
     */
    @PostMapping("/saveDocument")
    public SysResult saveDocument(@RequestBody Document document){
        Integer key = documentService.saveDocument(document);
        if(key==0){
            return SysResult.fail("文件添加失败");
        }
        return SysResult.success("文件添加成功",key);

    }
    /**
     * 通过页面获取文件
     */
    @GetMapping("/getDocumentsByPage")
    public SysResult getDocumentsByPage(@RequestParam(value = "page") Integer page){
        page = (page -1) * 8;
        int number = documentService.getAllDocumentsNumber();
        List<Document> documents = documentService.getDocumentsByPage(page);
        Map<String, Object> data = new HashMap<>();
        data.put("number",number);
        data.put("documents",documents);
        return SysResult.success("获取成功",data);
    }
    /**
     * 下载文件
     */
    @RequestMapping("/downloadFile")
    public SysResult fileDownLoad(HttpServletResponse response, @RequestParam("id") int id) throws UnsupportedEncodingException {
        String path = documentService.getDocumentPath(id);
        String filename = path.substring(path.lastIndexOf("\\")+1);
        File file = new File(path);
        if(!file.exists()){
            return SysResult.fail("下载文件不存在");
        }
        response.reset();
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("utf-8");
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition",  URLEncoder.encode(filename,"UTF-8") );

        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));) {
            byte[] buff = new byte[1024];
            OutputStream os  = response.getOutputStream();
            int i = 0;
            while ((i = bis.read(buff)) != -1) {
                os.write(buff, 0, i);
                os.flush();
            }
        } catch (IOException e) {
            return SysResult.fail("下载失败");
        }
        return null;
    }
    /**
     * 通过id获取文件
     */
    @GetMapping("/checkDocumentById")
    public SysResult checkDocumentById(@RequestParam("id") int id){
        List<Document> document = documentService.getDocumentById(id);
        if (document==null){
            return SysResult.fail("查询失败！");
        }else {
            Map<String, Object> data = new HashMap<>();

            data.put("document",document);
            return SysResult.success("获取成功",data);
        }
    }
    /**
     * 通过日期获取文件
     */
    @GetMapping("/checkDocumentsByCreateDate")
    public SysResult checkDocumentsByCreateDate(@RequestParam("createDate") String createDate,@RequestParam(value = "page") int page){
        page = (page -1) * 8;
        int number = documentService.getDocumentsNumberByCreateDate(createDate);
        List<Document> documents = documentService.getDocumentsByCreateDate(createDate,page);
        Map<String, Object> data = new HashMap<>();
        data.put("number",number);
        data.put("documents",documents);
        return SysResult.success("获取成功",data);
    }
    /**
     * 通过日期和id获取文件
     */
    @GetMapping("/checkDocumentsByIdAndCreateDate")
    public SysResult checkDocumentsByIdAndCreateDate(@RequestParam("createDate") String createDate,@RequestParam("id") int id,@RequestParam("page") int page){
        page = (page-1)*8;
        List<Document> documents = documentService.getDocumentsByIdAndCreateDate(createDate,id,page);
        Map<String, Object> data = new HashMap<>();
        data.put("number",documents.size());
        data.put("documents",documents);
        return SysResult.success("获取成功",data);
    }
}
