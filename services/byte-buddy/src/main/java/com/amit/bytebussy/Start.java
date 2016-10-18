package com.amit.bytebussy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.NamingStrategy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;

import java.lang.instrument.Instrumentation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.function.*;

/**
 * Created by amit on 11/10/16.
 */
public class Start {


    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Start s = new Start();
        s.addAttribute();
    }

    public void createClass(){
        DynamicType.Unloaded<?> dynamicClass = new ByteBuddy().subclass(Object.class).make();
        System.out.println(dynamicClass.getClass());
        System.out.println(dynamicClass.hasAliveLoadedTypeInitializers());
        System.out.println(dynamicClass.getTypeDescription());

        Class<?> loadedClasss = dynamicClass.load(getClass().getClassLoader()).getLoaded();

        DynamicType.Unloaded<?> dynamicType = new ByteBuddy()

                .subclass(Object.class)
                .name("com.amit.bytebussy.Start")
                .make();
        System.out.println(dynamicType.getTypeDescription());
        System.out.println(dynamicType.hasAliveLoadedTypeInitializers());

        DynamicType.Unloaded<?>dynamicWithCustomNameSpace = new  ByteBuddy().with(new NamingStrategy.AbstractBase(){

            protected String name(TypeDescription superClass) {
                return "custom.namespace"+superClass.getSimpleName();
            }
        }).subclass(Object.class).make();
        System.out.println(dynamicWithCustomNameSpace.getTypeDescription());
    }

    public void test() throws IllegalAccessException, InstantiationException {
        Class<?> dynamicClass = new ByteBuddy().
                                subclass(Object.class).
                                 method(ElementMatchers.named("toString")).intercept(FixedValue.value("Hi"))
                .make().load(getClass().getClassLoader()).getLoaded();
        System.out.println(dynamicClass.newInstance().toString());;
        System.out.println(dynamicClass.getClass());
        System.out.println(dynamicClass.getClassLoader());
        System.out.println(dynamicClass.getCanonicalName());
        System.out.println(dynamicClass.isAnonymousClass());
    }

    public void mockFunctionalClass() throws IllegalAccessException, InstantiationException {
        Class<? extends Function> dynamicClass= new ByteBuddy().subclass(Function.class).
                method(ElementMatchers.named("apply")).intercept(MethodDelegation.to(new GreetingInterceptor())).make().
                load(getClass().getClassLoader()).getLoaded();

        System.out.println(dynamicClass.newInstance().apply("heheheh"));;
    }


    public void changeExestingClass(){


        for (Method m :Foo.class.getDeclaredMethods()){
            System.out.println(m.getName());
        }
        System.out.println("AFTER REDEFINING");
        ByteBuddyAgent.install();
        Foo foo = new Foo();
        new ByteBuddy()
                .redefine(Bar.class)
                .name(Foo.class.getName())
                .make()
                .load(Foo.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());
        System.out.println(foo.m());
        for (Method m :Foo.class.getDeclaredMethods()){
            System.out.println(m.getName());
        }


    }

    public void addAttribute(){
        ByteBuddyAgent.install();
        System.out.println();
        System.out.println("after manipulation");
        TypePool typePool = TypePool.Default.ofClassPath();
        new ByteBuddy()
                .redefine(typePool.describe("com.amit.bytebussy.Poo").resolve(), // do not use 'Bar.class'
                        ClassFileLocator.ForClassLoader.ofClassPath())
                .defineField("qux", String.class) // we learn more about defining fields later
                .make()
                .load(ClassLoader.getSystemClassLoader());
        System.out.println(Poo.class.getDeclaredFields().length);
        for (Field f :Poo.class.getDeclaredFields()){
            System.out.println(f.getName());
        }
    }
}
