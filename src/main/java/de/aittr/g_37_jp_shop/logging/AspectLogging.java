package de.aittr.g_37_jp_shop.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// AspectJ framework
@Aspect
@Component
public class AspectLogging {

    private Logger logger = LoggerFactory.getLogger(AspectLogging.class);

    @Pointcut("execution(* de.aittr.g_37_jp_shop.service.ProductServiceImpl.save(..))")
    public void saveProduct() {}

    @Before("saveProduct()")
    public void beforeSavingProduct(JoinPoint joinPoint) {
        // Advice (адвайс) - тот код, который и будет внедряться в основной код,
        // используя правило, описанное в @Pointcut

        Object[] args = joinPoint.getArgs();
        logger.info("Method save of the class ProductServiceImpl called with parameter {}", args[0]);
    }

    @After("saveProduct()")
    public void afterSavingProduct() {
        logger.info("Method save of the class ProductServiceImpl finished its work");
    }

    @Pointcut("execution(* de.aittr.g_37_jp_shop.service.ProductServiceImpl.getById(..))")
    public void getProductById() {}

//    @AfterReturning("getProductById()")
//    public void afterReturningProductById() {
//        logger.info("Method getById of the class ProductServiceImpl successfully returned product");
//    }

    @AfterReturning(pointcut = "getProductById()", returning = "result")
    public void afterReturningProductById(Object result) {
        logger.info("Method getById of the class ProductServiceImpl successfully returned product {}", result);
    }

    @AfterThrowing(pointcut = "getProductById()", throwing = "e")
    public void afterThrowingAnExceptionWhileGettingProductById(Exception e) {
        logger.warn("Method getById of the class ProductServiceImpl threw an exception while getting product: " +
                "message - {}", e.getMessage());
    }
}