package com.googol24.spring.config;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 模拟一个Spring容器的控制反转功能(从XML配置中读取Bean配置，再通过反射来获取实例化对象，方便扩展与解耦)
 */
public class ClassPathXmlApplicationContext implements BeanFactory {

    private Map<String, Object> beans = new HashMap<>();

    public ClassPathXmlApplicationContext() {
        try {
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(this.getClass().getClassLoader().getResourceAsStream("beans.xml"));
            Element root = document.getRootElement();
            List list = root.getChildren("bean");

            for (int i = 0; i < list.size(); i++) {
                Element element = (Element) list.get(i);
                String id = element.getAttributeValue("id");
                String clazz = element.getAttributeValue("class");
                Object o = Class.forName(clazz).newInstance();
                beans.put(id, o);

                for (Element propertyElement : element.getChildren("property")) {

                    String propertyName = propertyElement.getAttributeValue("name");// userDAO
                    String propertyBean = propertyElement.getAttributeValue("bean");// u

                    Object beanObj = beans.get(propertyBean);// com.googol24.spring.dao.UserDAOOracleImpl

                    String methodName = "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);// setUserDAO

                    Method method = o.getClass().getMethod(
                            methodName,
                            beanObj.getClass().getInterfaces()[0]
                    );

                    method.invoke(o, beanObj);
                }
            }
        } catch (JDOMException e) {
            System.out.println("DOM Exception：" + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception:" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found：" + e.getMessage());
        } catch (InstantiationException e) {
            System.out.println("Instance Error：" + e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.println("Access Error：" + e.getMessage());
        } catch (NoSuchMethodException e) {
            System.out.println("No such Method Error：" + e.getMessage());
        } catch (InvocationTargetException e) {
            System.out.println("Invocation Target Error：" + e.getMessage());
        }
    }

    @Override
    public Object getBean(String name) {
        return beans.get(name);
    }
}
