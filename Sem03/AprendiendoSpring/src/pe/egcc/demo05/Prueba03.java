package pe.egcc.demo05;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Prueba03 {
  
  public static void main(String[] args) {
    
    String contexto = "/pe/egcc/demo05/contexto.xml";
    BeanFactory beanFactory;
    beanFactory = new ClassPathXmlApplicationContext(contexto);
    
    AppController control;
    control = beanFactory.getBean(AppController.class);
    
    System.out.println("7 + 8 = " + control.sumar(7, 8));
    
  }
  
}