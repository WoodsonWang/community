package com.woodson.community.controller;

import com.woodson.community.dto.FileDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FileController {
    @RequestMapping("/file/upload")
    public FileDTO upLoadFile(){
        FileDTO fileDTO = new FileDTO();
        fileDTO.setSuccess(1);
        fileDTO.setUrl("/images/logos/vi.png");
        return fileDTO;
    }
}
