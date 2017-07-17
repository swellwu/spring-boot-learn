package com.swellwu.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * 统一异常处理
 *
 * @author swellwu
 * @create 2017-07-17-22:57
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value = IndexOutOfBoundsException.class)//2
    public ModelAndView exception(Exception exception, WebRequest request) {
        ModelAndView modelAndView = new ModelAndView("error");// error页面
        modelAndView.addObject("errorMessage", exception.getMessage());
        return modelAndView;
    }

    @ModelAttribute //3
    public void addAttributes(Model model) {
        model.addAttribute("msg", "额外信息"); //3
    }

    @InitBinder //4
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id"); //5
    }
}
