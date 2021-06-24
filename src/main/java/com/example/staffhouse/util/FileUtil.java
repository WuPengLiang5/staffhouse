package com.example.staffhouse.util;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {
    /**
     * 根据日期产生一个随机数
     * @return
     */
    public static String createRandomFileName(){
        String format = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        return format;
    }
    /**
     * 将文件写入磁盘
     * @throws IOException
     */
    public static void writeFileToDisc(String fileUrl, MultipartFile file) throws IOException{
        FileOutputStream fos = new FileOutputStream(new File(fileUrl));
        fos.write(file.getBytes());
        fos.flush();
        fos.close();
    }

    public static void main(String[] args) {
        System.out.println(FileUtil.createRandomFileName());
    }

    /**
     * 根据path得到图片的base64编码的字符串
     * @param userFacePath 图片路径
     * @return base64编码之后的字符串
     */
    public static String getImageStr(String userFacePath){
        FileInputStream fis = null;
        byte[] buf;
        try {
            fis = new FileInputStream(new File(userFacePath));
            buf = new byte[fis.available()];
            fis.read(buf);
            return Base64.encodeBase64String(buf);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally{
            try {
                fis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;


    }

    public static void WriteStringToFile(String token){
        FileOutputStream fos = null;
        try {
            String path = ResourceUtils.getURL("src/main/resources/static/tokenFile/").getPath()+"token.txt";
            System.out.println(path);
            fos = new FileOutputStream(path);
            fos.write(token.getBytes());//注意字符串编码
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String readTokenFile() throws IOException {
        String filePath=ResourceUtils.getURL("src/main/resources/static/tokenFile/").getPath()+"token.txt";
        StringBuffer sb = new StringBuffer();
        InputStream is = new FileInputStream(filePath);
        String line; // 用来保存每行读取的内容
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        line = reader.readLine(); // 读取第一行
        while (line != null) { // 如果 line 为空说明读完了
            sb.append(line); // 将读到的内容添加到 buffer 中
            sb.append("\n"); // 添加换行符
            line = reader.readLine(); // 读取下一行
        }
        reader.close();
        is.close();
        return sb.toString();
    }
}
