package com.clinical.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class ArchivoService {

    public String test(MultipartFile file, RedirectAttributes attributes){
        if(file==null|| file.isEmpty()){
            attributes.addFlashAttribute("message", "por favor seleccione una imagen");
            return "redirect:status";
        }
        return "w";
    }
}
