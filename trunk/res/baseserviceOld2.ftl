${pojo.getPackageDeclaration()?replace("model", "model.service")}

// Generated ${date} by Hibernate Tools ${version}
// template by Csaba Tenkes<csaba.tenkes@brevissimus.eu>

<#assign classbody>
<#assign declarationName = pojo.importType(pojo.getDeclarationName())>
<#assign sessionFactoryName = pojo.importType(pojo.getDeclarationName())>
import ${pojo.getQualifiedDeclarationName()};

/**
 * Base${declarationName}Service for domain model class ${declarationName}.
 * @see ${pojo.getQualifiedDeclarationName()}
 * @author Hibernate Tools
 */
<#if ejb3>
@${pojo.importType("javax.ejb.Stateless")}
</#if>
public class Base${declarationName}Service {

    private static final ${pojo.importType("org.apache.commons.logging.Log")} log = ${pojo.importType("org.apache.commons.logging.LogFactory")}.getLog(Base${pojo.getDeclarationName()}Service.class);

    //placeholder class for service gen of later time
    
    
}
</#assign>

${pojo.generateImports()}
${classbody}