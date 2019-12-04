package com.wirk.demo.hello.design.proxy.dynamic;

import com.wirk.demo.hello.design.proxy.Landord;
import com.wirk.demo.hello.design.proxy.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * @author : Mao LuDong
 * @date : Created in 22:38 2019/12/3
 */
public class DynamicAgent implements InvocationHandler {

  private Landord landord;

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("谁要出租！");
    Object obj =  method.invoke(landord, args);
    System.out.println("房子漏水，找修理工！");
    return obj;
  }

  public Person bind(Landord landord) {
    this.landord = landord;
    return (Person) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
        new Class[]{Person.class}, this);
  }
}
