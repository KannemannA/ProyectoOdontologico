package com.clinical;

import org.apache.log4j.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger= Logger.getLogger(GlobalExceptionHandler.class);
    public String handlerMultipart(MultipartException e, RedirectAttributes attributes){
        attributes.addFlashAttribute("message", e.getCause().getMessage());
        return "redirect:/index";
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> errores(Exception ex, WebRequest req){
        logger.error(ex.getMessage());
        return new ResponseEntity<>("ERROR: "+ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
