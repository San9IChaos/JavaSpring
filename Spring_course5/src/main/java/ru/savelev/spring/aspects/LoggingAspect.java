package ru.savelev.spring.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.savelev.spring.models.Book;

@Component
@Aspect
@Order(10)
public class LoggingAspect {

//    @Pointcut("execution(* ru.savelev.spring.models.UniLibrary.*(..))")
//    private void allMethodsFromUniLibrary() {}
//
//    @Pointcut("execution(* ru.savelev.spring.models.UniLibrary.returnMagazine())")
//    private void returnMagazineFromUniLibrary() {}
//
//    @Pointcut("allMethodsFromUniLibrary() && !returnMagazineFromUniLibrary()")
//    private void allMethodsExceptReturnMagazineFromUniLibrary() {}
//
//    @Before("allMethodsExceptReturnMagazineFromUniLibrary()")
//    public void beforeAllMethodsExceptReturnMagazineAdvice() {
//        System.out.println("beforeAllMethodsExceptReturnMagazineAdvice: Log #10");
//    }
//    @Pointcut("execution(* ru.savelev.spring.models.UniLibrary.get*())")
//    private void allGetMethodsFromUniLibrary() {}
//
//    @Pointcut("execution(* ru.savelev.spring.models.UniLibrary.return*())")
//    private void allReturnMethodsFromUniLibrary() {}
//
//    @Pointcut("allGetMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary()")
//    private void allGetAndReturnMethodsFromUniLibrary() {}
//
//    @Before("allGetMethodsFromUniLibrary()")
//    public void beforeGetLoggingAdvice() {
//        System.out.println("beforeGetLoggingAdvice: writing Log #1");
//    }
//
//    @Before("allReturnMethodsFromUniLibrary()")
//    public void beforeReturnLoggingAdvice() {
//        System.out.println("beforeReturnLoggingAdvice: writing Log #2");
//    }
//
//    @Before("allGetAndReturnMethodsFromUniLibrary()")
//    public void beforeGetAndReturnLoggingAdvice() {
//        System.out.println("beforeGetAndReturnLoggingAdvice: writing Log #3");
//
//    }


    @Before("ru.savelev.spring.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature = " + methodSignature);
        System.out.println("methodSignature.getMethod() = " + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType() = " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName() = " + methodSignature.getName());

        if(methodSignature.getName().equals("addBook")) {
            Object[] arguments = joinPoint.getArgs();
            for(Object obj:arguments) {
                if(obj instanceof Book) {
                    Book myBook = (Book) obj;
                    System.out.println("Информация о книге: название - " + myBook.getName() + ", автор - " +
                            myBook.getAuthor() + ", год издания - " + myBook.getYearOfPublication());
                } else if (obj instanceof String) {
                    System.out.println("Книгу в библиотеку добавляет " + obj);
                }
            }
        }

        System.out.println("beforeGetBookAdvice: логирование попытки получить книгу или журнал");
        System.out.println("-----------------------------------------------");
    }

}
