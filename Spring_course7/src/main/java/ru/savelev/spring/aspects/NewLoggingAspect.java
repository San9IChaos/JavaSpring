package ru.savelev.spring.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {

    @Before("execution(public String returnBook())")
    public void beforeReturnBookLoggingAdvice() {
        System.out.println("beforeReturnBookLoggingAdvice: попытка вернуть книгу");
    }

    @AfterReturning("execution(public String returnBook())")
    public void afterReturnBookLoggingAdvice() {
        System.out.println("beforeReturnBookLoggingAdvice: книга успешно возвращена");
    }

    @Around("execution(public String returnBook())")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку пытаются вернуть книгу");

        Object targetMethodResult = null;
        try {
            targetMethodResult = proceedingJoinPoint.proceed();
        }
        catch (Exception e) {
            System.out.println("aroundReturnBookLoggingAdvice: исключение " + e + " было зарегестрировано");
            throw e;
        }

        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку успешно вернули книгу");

        return targetMethodResult;
    }
}
