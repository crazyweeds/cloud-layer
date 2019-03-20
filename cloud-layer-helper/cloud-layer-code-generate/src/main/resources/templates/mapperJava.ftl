package ${packageName};

import org.apache.ibatis.annotations.Mapper;

/**
<#list beanComments as item>
 * ${item}
</#list>
 */
@Mapper
public interface ${className}Mapper extends BaseMapper<${className}> {



}
