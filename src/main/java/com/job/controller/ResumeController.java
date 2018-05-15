package com.job.controller;

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfFormField;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.job.entity.ResumeEntity;
import jdk.nashorn.internal.objects.annotations.Constructor;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;

/**
 * @author lindazhong
 * @date 2018/4/21 18:12
 */
@Controller()
@RequestMapping("/resume")
public class ResumeController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/make")
    public String  makeResume(ResumeEntity resumeEntity, HttpServletResponse response) throws IOException {
        if (resumeEntity.getName() == null || resumeEntity.getName().equals("")) {
            return "download";
        }
        System.out.println(resumeEntity);
        File f = new File(".");
        String absolutePath = f.getAbsolutePath();
        File file = new File(absolutePath + "/uploads/template.pdf");
        // 模板地址
        String filePath = file.getPath();
        File toFile = new File(absolutePath + "/uploads");
        // 填完信息后生成新的模板地址
        String toFilePath = toFile.getPath()+"/resume.pdf";
        PdfDocument pdfDoc = new PdfDocument(new PdfReader(filePath), new PdfWriter(toFilePath));
        PdfAcroForm pdfAcroForm = PdfAcroForm.getAcroForm(pdfDoc, true);
        Map<String, PdfFormField> formFields = pdfAcroForm.getFormFields();
        formFields.forEach((key, value) -> {
            System.out.println(key + ", " + value);
        });
        pdfAcroForm.getField("awardExperience").setValue(resumeEntity.getAwardExperience());
        pdfAcroForm.getField("partTimeExperience").setValue(resumeEntity.getPartTimeExperience());
        pdfAcroForm.getField("workExperience").setValue(resumeEntity.getWorkExperience());
        pdfAcroForm.getField("selfDescription").setValue(resumeEntity.getSelfDescription());
        pdfAcroForm.getField("name").setValue(resumeEntity.getName());
        pdfAcroForm.getField("birth").setValue(resumeEntity.getBirth());
        pdfAcroForm.getField("gender").setValue(resumeEntity.getGender());
        pdfAcroForm.getField("notion").setValue(resumeEntity.getNotion());
//        pdfAcroForm.getField("photo").setValue(resumeEntity.getPhoto().toString());
        pdfAcroForm.getField("phoneNumber").setValue(resumeEntity.getPhoneNumber());
        pdfAcroForm.getField("university").setValue(resumeEntity.getUniversity());
        pdfAcroForm.getField("profession").setValue(resumeEntity.getProfession());
        pdfAcroForm.getField("province").setValue(resumeEntity.getProvince());
        pdfAcroForm.getField("jobDirection").setValue(resumeEntity.getJobDirection());
        pdfAcroForm.getField("email").setValue(resumeEntity.getEmail());
        pdfAcroForm.flattenFields();
        pdfDoc.close();


        //下载简历pdf
        File downloadFile = new File(toFilePath);
        response.setContentType("application/force-download");
        response.setHeader("Content-Disposition", "attachment;fileName=resume.pdf");
        byte[] buffer = new byte[1024];
        FileInputStream fis = null; //文件输入流
        BufferedInputStream bis = null;
        OutputStream os = null; //输出流
        try {
            fis = new FileInputStream(downloadFile);
            bis = new BufferedInputStream(fis);
            os = response.getOutputStream();
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer);
                i = bis.read(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            bis.close();
            fis.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "download";
    }

}
