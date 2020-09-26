package com.study.annotation.config;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.util.Set;

public class MyTypeFilter implements TypeFilter {
    /**
     * 	 * @param metadataReader the metadata reader for the target class
     * 	 读取到目标类的信息
     * 	 * @param metadataReaderFactory a factory for obtaining metadata readers
     *  读取到工厂的信息
     * @param metadataReader
     * @param metadataReaderFactory
     * @return true 匹配成功 false 匹配失败
     * @throws IOException
     */
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前扫描类的注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前扫描的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        String className = classMetadata.getClassName();
        System.out.println("当前扫描类：->"+className);
        Set<String> annotationTypes = annotationMetadata.getAnnotationTypes();
        for (String annotationType : annotationTypes){
            System.out.println("注解类型"+annotationType);
            //过滤掉Controller注解 beanDefinitionName->org.springframework.stereotype.Controller
            if(annotationType.contains("Controller")){
                return true;
            }
        }
        return false;
    }
}
