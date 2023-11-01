package org.example.spring.security.exception;


import org.example.spring.security.uitl.ResultUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ClassName: Ex
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/10/20 17:59
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResultUtil<Void> error(Exception e){
        return ResultUtil.fail(e.getMessage());
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public ResultUtil<Void> serviceException(ServiceException e){
        return ResultUtil.fail(e.getCode(),e.getMsg());
    }
}


