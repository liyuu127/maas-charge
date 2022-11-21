package com.haylion.charge.user.config;


import com.haylion.common.core.exception.ApplicationException;
import com.haylion.common.core.exception.SysStubInfo;
import com.haylion.common.core.model.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.haylion.common.core.exception.SysStubInfo.*;

/**
 * 全局的的异常拦截器（拦截所有的控制器）（带有@RequestMapping注解的方法上都会拦截）
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    //private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    //private static final String logExceptionFormat = "Capture Exception By GlobalExceptionHandler: requestUrl: %s Code: %s Detail: %s";
    private static final Map EMPTY_DATA = null;


    /**
     * 自定义异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(ApplicationException.class)
    public ResponseData ApplicationExceptionHandler(ApplicationException ex) {
        log.error("Exception for handle ", ex);
        var responseData = new ResponseData();
        responseData.setData(EMPTY_DATA);
        responseData.setCode(ex.getRetStub().getCode());
        responseData.setMsg(ex.getRetStub().getMsg());
        if (ex.getData() != null) {
            responseData.setData(ex.getData());
        }
        return responseData;
    }

    /**
     * 方法非法请求
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseData illegalArgumentExceptionHandler(IllegalArgumentException ex) {
        log.error("Exception for handle ", ex);
        var responseData = new ResponseData();
        responseData.setData(EMPTY_DATA);
        responseData.setCode(SysStubInfo.PARAMETER_TYPE_INVALID.getCode());
        responseData.setMsg(SysStubInfo.PARAMETER_TYPE_INVALID.getMsg());
        return responseData;
    }

    /**
     * 规约检查
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseData constraintViolationExceptionHandler(ConstraintViolationException ex) {
        log.error("Exception for handle ", ex);
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        StringBuilder stringBuilder = new StringBuilder();
        for (ConstraintViolation<?> item : violations) {
            stringBuilder.append("[").append(item.getMessage()).append("]");
        }
        String msg = stringBuilder.toString();
        log.error("ConstraintViolation msg is : " + msg);
        return new ResponseData(SysStubInfo.PARAMETER_TYPE_INVALID, msg);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseData methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
        log.error("Exception for handle ", ex);
        List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
        StringBuilder stringBuilder = new StringBuilder();
        for (ObjectError error : allErrors) {
            stringBuilder.append("[").append(error.getDefaultMessage()).append("]");
        }
        String msg = stringBuilder.toString();
        log.error("ArgumentNotValid  msg is : " + msg);
        return new ResponseData(SysStubInfo.PARAMETER_TYPE_INVALID, msg);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseData missingServletRequestParameterExceptionHandler(MissingServletRequestParameterException ex) {
        log.error("Exception for handle ", ex);
        String parameterName = ex.getParameterName();
        String parameterType = ex.getParameterType();
        String msg = ("parameter " + parameterName + " is null " + " , expect: " + parameterType);
        return new ResponseData(SysStubInfo.PARAMETER_IS_NULL, msg);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseData httpMediaTypeNotSupportedExceptionHandler(HttpMediaTypeNotSupportedException ex) {
        log.error("Exception for handle ", ex);
        String msg = ex.getContentType().getSubtype();
        return new ResponseData(SysStubInfo.CONTENT_TYPE_INVALID, msg);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseData httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException ex) {
        log.error("Exception for handle ", ex);
        String msg = ex.getMethod();
        return new ResponseData(SysStubInfo.METHOD_INVALID, msg);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseData noHandlerFoundExceptionHandler(NoHandlerFoundException ex) {
        log.error("Exception for handle ", ex);
        String msg = (ex.getHttpMethod() + " --> " + ex.getRequestURL());
        return new ResponseData(SysStubInfo.RESOURCE_INVALID, msg);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseData methodArgumentTypeMismatchExceptionExceptionHandler(MethodArgumentTypeMismatchException ex) {
        log.error("Exception for handle ", ex);
        String msg = ("parameter " + ex.getName() + " is not type of " + ex.getRequiredType().getSimpleName());
        return new ResponseData(SysStubInfo.PARAMETER_TYPE_INVALID, msg);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseData httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException ex) {
        log.error("Exception for handle ", ex);
        String msg = ex.getMessage();
        return new ResponseData(SysStubInfo.REQUEST_BODY_INVALID, msg);
    }

    @ExceptionHandler(BindException.class)
    public ResponseData bindExceptionHandler(BindException ex) {
        log.error("Exception for handle ", ex);
        BindingResult bindingResult = ex.getBindingResult();
        FieldError fieldError = bindingResult.getFieldError();
        String field = fieldError.getField();
        return new ResponseData(SysStubInfo.PARAMETER_TYPE_INVALID, field);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseData accessDeniedExceptionHandler(AccessDeniedException ex) {
        log.error("Exception for handle ", ex);
        return new ResponseData(AUTHORIZATION_DENIED);
    }
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseData usernameNotFoundExceptionHandler(UsernameNotFoundException ex) {
        log.error("Exception for handle ", ex);
        return new ResponseData(USER_NOT_FOUND);
    }

    @ExceptionHandler(PersistenceException.class)
    public ResponseData persistenceExceptionHandler(PersistenceException ex) {
        log.error("Exception for handle ", ex);
        String message = ex.getMessage();
        return new ResponseData(MYBATIS_QUERY_ERROR,message);
    }

    @ExceptionHandler(Exception.class)
    public ResponseData exceptionHandler(Exception ex) {
        log.error("Exception for handle ", ex);
        return new ResponseData(DEFAULT_FAIL);
    }
}