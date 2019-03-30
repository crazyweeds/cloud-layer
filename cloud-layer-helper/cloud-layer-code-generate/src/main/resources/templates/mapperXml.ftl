<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="net.sirun.product.mapper.AppOperationLogMapper">

    <resultMap id="BaseResultMap" type="${packageName}.${className}">
        <#list fields as item>
            <#if item.isId>
                <id column="${item.columnName}" jdbcType="${item.jdbcType}" property="${item.property}"/>
            </#if>
            <#if !item.isId>
                <result column="${item.columnName}" jdbcType="${item.jdbcType}" property="${item.property}"/>
            </#if>
        </#list>
    </resultMap>

    <sql id="Base_Column_List">
<#list fields as item>
    <#if item.property?exists>
        ${item.property}
    </#if>
</#list>
    </sql>


</mapper>
