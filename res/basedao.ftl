
${pojo.getPackageDeclaration()?replace("model", "model.dao")}

// Generated ${date} by Hibernate Tools ${version}
// template by Csaba Tenkes<csaba.tenkes@brevissimus.eu>

<#assign classbody>
<#assign declarationName = pojo.importType(pojo.getDeclarationName())>
<#assign sessionFactoryName = pojo.importType(pojo.getDeclarationName())>
<#assign modelClassName = pojo.importType(pojo.qualifiedDeclarationName)>
import ${pojo.getQualifiedDeclarationName()};

/**
 * BaseDAO for domain model class ${declarationName}.
 * @see ${pojo.getQualifiedDeclarationName()}
 * @author Hibernate Tools
 */
<#if ejb3>
@${pojo.importType("javax.ejb.Stateless")}
</#if>
public class Base${declarationName}DAO {
	
    private static final ${pojo.importType("org.apache.commons.logging.Log")} log = ${pojo.importType("org.apache.commons.logging.LogFactory")}.getLog(Base${pojo.getDeclarationName()}DAO.class);

<#if ejb3>
    @${pojo.importType("javax.persistence.PersistenceContext")} private ${pojo.importType("javax.persistence.EntityManager")} entityManager;
    
    public void persist(${declarationName} transientInstance) {
        log.debug("persisting ${declarationName} instance");
        try {
            entityManager.persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void remove(${declarationName} persistentInstance) {
        log.debug("removing ${declarationName} instance");
        try {
            entityManager.remove(persistentInstance);
            log.debug("remove successful");
        }
        catch (RuntimeException re) {
            log.error("remove failed", re);
            throw re;
        }
    }
    
    public ${declarationName} merge(${declarationName} detachedInstance) {
        log.debug("merging ${declarationName} instance");
        try {
            ${declarationName} result = entityManager.merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
<#if clazz.identifierProperty?has_content>    
    public ${declarationName} findById( ${pojo.getJavaTypeName(clazz.identifierProperty, jdk5)} id) {
        log.debug("getting ${declarationName} instance with id: " + id);
        try {
            ${declarationName} instance = entityManager.find(${pojo.getDeclarationName()}.class, id);
            log.debug("get successful");
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
</#if>
<#else>        
    /**
     * Persisting <Code>${declarationName}</Code>.
     * @param transientInstance 
     * @param session
     * @throws HibernateException           
     */
    public void persist(${declarationName} transientInstance, ${pojo.importType("org.hibernate.Session")} session) throws ${pojo.importType("org.hibernate.HibernateException")} {
        log.debug("persisting ${declarationName} instance");
        session.persist(transientInstance);
        log.debug("persist successful");
    }
    
    /**
     * Save <Code>${declarationName}</Code>.
     * @param instance
     * @param session      
     * @throws HibernateException     
     */
    public void attachDirty(${declarationName} instance, ${pojo.importType("org.hibernate.Session")} session) throws ${pojo.importType("org.hibernate.HibernateException")} {
        log.debug("attaching dirty ${declarationName} instance");
        session.saveOrUpdate(instance);
        log.debug("attach successful");
    }
    
    /**
     * Unlock <Code>${declarationName}</Code>.
     * @param instance  
     * @param session 
     * @throws HibernateException     
     */
    public void attachClean(${declarationName} instance, ${pojo.importType("org.hibernate.Session")} session) throws ${pojo.importType("org.hibernate.HibernateException")} {
        log.debug("attaching clean ${declarationName} instance");
        session.lock(instance, ${pojo.importType("org.hibernate.LockMode")}.NONE);
        log.debug("attach successful");
    }
	
    /**
     * Delete <Code>${declarationName}</Code>.
     * @param persistentInstance
     * @param session 
     * @throws HibernateException     
     */
    public void delete(${declarationName} persistentInstance, ${pojo.importType("org.hibernate.Session")} session) throws ${pojo.importType("org.hibernate.HibernateException")} {
        log.debug("deleting ${declarationName} instance");
        session.delete(persistentInstance);
        log.debug("delete successful");
    }
    
    /**
     * Merge <Code>${declarationName}</Code>.
     * @param detachedInstance
     * @param session 
     * @throws HibernateException     
     * @return ${declarationName}
     */
    public ${declarationName} merge(${declarationName} detachedInstance, ${pojo.importType("org.hibernate.Session")} session) throws ${pojo.importType("org.hibernate.HibernateException")} {
        log.debug("merging ${declarationName} instance");
        ${declarationName} result = (${declarationName}) session.merge(detachedInstance);
        log.debug("merge successful");
        return result;
     }
    
<#if clazz.identifierProperty?has_content>
    /**
     * <Code>${declarationName}</Code> getById.
     * @param id
     * @param session 
     * @throws HibernateException     
     * @return ${declarationName}
     */
	public ${declarationName} getById( ${pojo.importType(c2j.getJavaTypeName(clazz.identifierProperty, jdk5))} id, ${pojo.importType("org.hibernate.Session")} session) throws ${pojo.importType("org.hibernate.HibernateException")} {
        log.debug("getting ${declarationName} instance with id: " + id);
        ${declarationName} instance = (${declarationName}) session.get("${clazz.entityName}", id);
        if (instance == null) {
            log.debug("get successful, no instance found");
        } else {
            log.debug("get successful, instance found");
        }
        return instance;
    }
</#if>
    
<#if clazz.hasNaturalId()>
    /**
     * <Code>${declarationName}</Code> getByNaturalId.
     * @param id
     * @param session 
     * @throws HibernateException     
     * @return
     */
    public ${declarationName} getByNaturalId(${c2j.asNaturalIdParameterList(clazz)}, ${pojo.importType("org.hibernate.Session")} session) throws ${pojo.importType("org.hibernate.HibernateException")} {
        log.debug("getting ${declarationName} instance by natural id");
        ${declarationName} instance = (${declarationName}) session.createCriteria("${clazz.entityName}")
<#if jdk5>
                                    .add( ${pojo.staticImport("org.hibernate.criterion.Restrictions", "naturalId")}()
<#else>
                                    .add( ${pojo.importType("org.hibernate.criterion.Restrictions")}.naturalId()
</#if>                    
<#foreach property in pojo.getAllPropertiesIterator()>
<#if property.isNaturalIdentifier()>
                                    .set("${property.name}", ${property.name})
</#if>
</#foreach>
                  ).uniqueResult();
        if (instance == null) {
            log.debug("get successful, no instance found");
        } else {
            log.debug("get successful, instance found");
        }
        return instance;
    }
</#if>    

<#foreach queryName in cfg.namedQueries.keySet()>
<#if queryName.startsWith(clazz.entityName + ".")>
<#assign methname = c2j.unqualify(queryName)>
<#assign params = cfg.namedQueries.get(queryName).parameterTypes>
<#assign argList = c2j.asFinderArgumentList(params, pojo)>
<#if jdk5 && methname.startsWith("find")>
    public ${pojo.importType("java.util.List")}<${declarationName}> ${methname}(${argList}) {
<#elseif methname.startsWith("count")>
    public int ${methname}(${argList}) {
<#else>
    public ${pojo.importType("java.util.List")} ${methname}(${argList}) {
</#if>
        ${pojo.importType("org.hibernate.Query")} query = sessionFactory.getCurrentSession()
                .getNamedQuery("${queryName}");
<#foreach param in params.keySet()>
<#if param.equals("maxResults")>
		query.setMaxResults(maxResults);
<#elseif param.equals("firstResult")>
        query.setFirstResult(firstResult);
<#else>
        query.setParameter("${param}", ${param});
</#if>
</#foreach>
<#if jdk5 && methname.startsWith("find")>
        return (List<${declarationName}>) query.list();
<#elseif methname.startsWith("count")>
        return ( (Integer) query.uniqueResult() ).intValue();
<#else>
        return query.list();
</#if>
    }
</#if>
</#foreach></#if>
}
</#assign>

${pojo.generateImports()}
${classbody}