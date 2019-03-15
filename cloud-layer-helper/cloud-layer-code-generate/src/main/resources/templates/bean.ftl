package ${packageName};

<#if otherImports?exists><#list otherImports as item>
import ${item}
</#list></#if>

/**
<#list beanComments as item>
 * ${item}
</#list>
 */
<#list classAnnotations as item>
${item}
</#list>
public class ${className} implements Serializable {

    private static final long serialVersionUID = ${uid};

<#list fields as item>
    <#if item.comment?exists>
    /**
     * ${item.comment}
     */
    </#if>
    <#if item.annotations?exists>
        <#list item.annotations as annotation>
    ${annotation}
        </#list>
    </#if>
    <#if item.property?exists>
    private ${item.javaType} ${item.property};

    </#if>
</#list>

}
