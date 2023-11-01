package org.example.spring.security.exception;



import lombok.Data;


/**
 * ClassName: ServiceException
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/10/20 18:00
 */
@Data
public class ServiceException extends RuntimeException{
    private Integer code;
    private String msg;

    public ServiceException(Integer code,String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public ServiceException(String msg){
        super(msg);
        this.code = 500;
        this.msg = msg;
    }

}


