package net.lyh.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@WebServlet("/fileUpload")
@MultipartConfig//文件上传都要用这个注解
public class FileUploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("username");
        Part part = req.getPart("img");
        String originalName = part.getName();
        String header = part.getHeader("content-disposition");
        String realFileName = header.substring(header.indexOf("filename=") + 10,header.length()-1);
        System.out.println(realFileName);
        InputStream is=part.getInputStream();
        String dir = this.getServletContext().getRealPath("/file");
        File dirFile=new File(dir);
        //如果目录不存在则创建
        if(!dirFile.exists()){
            dirFile.mkdirs();
        }

        String uuName=UUID.randomUUID()+realFileName;
        File file=new File(dir,uuName );
        FileOutputStream fos=new FileOutputStream(file);
        byte[] bs=new byte[1024];
        int len;
        while ((len=is.read(bs))!=-1){
            fos.write(bs,0,len);
        }
        is.close();
        fos.close();
        req.getRequestDispatcher("/file/"+realFileName).forward(req,resp);
    }
}
