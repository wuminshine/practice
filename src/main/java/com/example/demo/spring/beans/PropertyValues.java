package com.example.demo.spring.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * bean属性配置集合
 */
public class PropertyValues {
    private List<PropertyValue> propertyValueList = new ArrayList<>();

    public List<PropertyValue> getPropertyValueList() {
        return propertyValueList;
    }

    public void setPropertyValueList(List<PropertyValue> propertyValueList) {
        this.propertyValueList = propertyValueList;
    }

    /**
     * 添加bean的属性配置
     * @param propertyValue
     */
    public void addPropertyValue(PropertyValue propertyValue)
    {
        propertyValueList.add(propertyValue);
    }

    /**
     * 获取bean的属性配置
     * @param name
     * @return
     */
    public PropertyValue getPropertyValue(String name)
    {
        for (PropertyValue propertyValue:propertyValueList) {
            if (name.equals(propertyValue.getName()))
            {
                return propertyValue;
            }
        }
        return null;
    }
}
