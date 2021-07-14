package com.example.demo.spring.beans.factory.xml;

import cn.hutool.core.util.XmlUtil;
import com.example.demo.spring.beans.BeanReference;
import com.example.demo.spring.beans.PropertyValue;
import com.example.demo.spring.beans.PropertyValues;
import com.example.demo.spring.beans.core.io.Resource;
import com.example.demo.spring.beans.core.io.ResourceLoader;
import com.example.demo.spring.beans.factory.BeanDefinition;
import com.example.demo.spring.beans.factory.BeanDefinitionRegistry;
import com.example.demo.spring.beans.support.AbstractBeanDefinitionReader;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;

public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws Exception {
        InputStream inputStream = resource.getInputStream();
        doLoadBeanDefinitons(inputStream);
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws Exception {
        for (Resource resource:resources)
        {
            loadBeanDefinitions(resource);
        }

    }

    @Override
    public void loadBeanDefinitions(String location) throws Exception {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }

    /**
     * 解析配置文件，生成BeanDefinition,并进行注册
     * @param inputStream
     */
    protected void doLoadBeanDefinitons(InputStream inputStream) throws Exception {
        Document document = XmlUtil.readXML(inputStream);
        Element rootElement = document.getDocumentElement();
        NodeList nodeList = rootElement.getChildNodes();
        for(int i = 0 ; i < nodeList.getLength(); i++)
        {
            Node node = nodeList.item(i);

            // 如果不是Element类型，则退出此处循环
            if(!(node instanceof Element))
            {
                continue;
            }

            // 如果不是bean节点，则退出此处循环
            if (!"bean".equals(node.getNodeName()))
            {
                continue;
            }
            //解析bean节点
            Element beanEle = (Element)node;
            String id = beanEle.getAttribute("id");
            String name = beanEle.getAttribute("name");
            String className = beanEle.getAttribute("class");

            // id 的优先级大于name
            String beanName = StringUtils.isNotEmpty(id)?id:name;

            Class<?> beanClass = Class.forName(className);
            BeanDefinition beanDefinition = new BeanDefinition(beanClass);

            //解析property
            PropertyValues propertyValues = doParseProperty(beanEle);
            if (!CollectionUtils.isEmpty(propertyValues.getPropertyValueList()))
            {
                beanDefinition.setPropertyValues(propertyValues);
            }
            getRegistry().registerBeanDefinition(beanName, beanDefinition);
        }

    }

    private PropertyValues doParseProperty(Element element)
    {
        PropertyValues propertyValues = new PropertyValues();
        NodeList propertyNodeList = element.getChildNodes();
        if (propertyNodeList.getLength() == 0)
        {
            return propertyValues;
        }
        PropertyValue propertyValue;
        for(int i = 0 ; i < propertyNodeList.getLength(); i++)
        {
            Node node = propertyNodeList.item(i);
            // 如果不是Element类型，则退出此处循环
            if(!(node instanceof Element))
            {
                continue;
            }

            // 如果不是bean节点，则退出此处循环
            if (!"property".equals(node.getNodeName()))
            {
                continue;
            }

            //解析property节点
            propertyValue = new PropertyValue();
            Element propertyEle = (Element)node;
            String propertyName = propertyEle.getAttribute("name");
            propertyValue.setName(propertyName);
            String value = propertyEle.getAttribute("value");
            String ref = propertyEle.getAttribute("ref");
            if (StringUtils.isNotEmpty(value))
            {
                propertyValue.setValue(value);
            }
            else if (StringUtils.isNotEmpty(ref))
            {
                BeanReference reference = new BeanReference();
                reference.setBeanName(ref);
                propertyValue.setValue(reference);
            }
            propertyValues.addPropertyValue(propertyValue);
        }
        return propertyValues;
    }
}
