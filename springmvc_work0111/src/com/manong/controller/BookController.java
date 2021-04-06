package com.manong.controller;

import com.manong.entity.WBook;
import com.manong.service.BookService;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import jdk.nashorn.internal.ir.ReturnNode;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

/**
 * Description:
 *
 * @Author SQB
 * @Date 2021/1/11 16:02
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    //��ѯ�����鼮
    @RequestMapping("queAllBook")
    public String queAllBook(ModelMap map){
        List<WBook> wBooks = bookService.queAllBook();
        map.put("blist",wBooks);
        return "forward:queAllCate";
    }

    //����鼮
    @RequestMapping("addBook")
    public String addBook(WBook wBook,MultipartFile files, HttpSession session){

        //�õ��ļ����Ʋ��ĳ�ʱ���
        String filename = files.getOriginalFilename();
        String oldname = filename.substring(0, filename.lastIndexOf("."));
        String newname = filename.replace(oldname, System.currentTimeMillis() + "");

        //�õ�����Ŀ���ļ���ַ
        String realPath = session.getServletContext().getRealPath("/WEB-INF/upload/");

        try {
            //���ļ��ϴ�ָ��·��
            files.transferTo(new File(realPath+newname));
        } catch (Exception e) {
            e.printStackTrace();
        }
        wBook.setBpicname(filename);
        wBook.setBpictime(newname);
        bookService.addBook(wBook);

        return "redirect:queAllBook";
    }

    //�ļ�����
    @RequestMapping("download")
    public ResponseEntity download(String oldname,String newname,HttpSession session){
        //�ҵ������ļ�����·��
        String path = session.getServletContext().getRealPath("/WEB-INF/upload/"+newname);

        try {
            //��ȡpath·������ȡ���ֽ�����
            byte[] bytes = FileUtils.readFileToByteArray(new File(path));

            //ͷ����Ϣָ�����صķ�ʽ���������ļ�����
            HttpHeaders headers = new HttpHeaders();

            String oldfilename = new String(oldname.getBytes("UTF-8"), "ISO8859-1");
            //ָ�����ص��ļ���
            headers.setContentDispositionFormData("attechment",oldfilename);

            return new ResponseEntity(bytes,headers, HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    //����id��ɾ��
    @RequestMapping("delBook")
    @ResponseBody
    public String delBook(int id){
        int i = bookService.delBook(id);
        if (i==1){
            return "success";
        }
      return "error";
    }


}
