package xmireader;

/* CVS $Id: $ */
 
import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.ontology.*;
 
/**
 * Vocabulary definitions from /home/kane/Dropbox/uml_class.owl 
 * @author Auto-generated by schemagen on 05 Jan 2010 10:47 
 */
public class UmlClass {
    /** <p>The ontology model that holds the vocabulary terms</p> */
    private static OntModel m_model = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM, null );
    
    /** <p>The namespace of the vocabulary as a string</p> */
    public static final String NS = "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#";
    
    /** <p>The namespace of the vocabulary as a string</p>
     *  @see #NS */
    public static String getURI() {return NS;}
    
    /** <p>The namespace of the vocabulary as a resource</p> */
    public static final Resource NAMESPACE = m_model.createResource( NS );
    
    public static final ObjectProperty belongsTo = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#belongsTo" );
    
    public static final ObjectProperty classLevelRelation = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#classLevelRelation" );
    
    public static final ObjectProperty classPropertiy = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#classPropertiy" );
    
    public static final ObjectProperty commentRelation = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#commentRelation" );
    
    public static final ObjectProperty componentRelation = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#componentRelation" );
    
    public static final ObjectProperty connectsTo = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#connectsTo" );
    
    public static final ObjectProperty constraints = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#constraints" );
    
    public static final ObjectProperty contains = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#contains" );
    
    public static final ObjectProperty dependsOn = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#dependsOn" );
    
    public static final ObjectProperty hasAggregateClass = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#hasAggregateClass" );
    
    public static final ObjectProperty hasAssociation = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#hasAssociation" );
    
    public static final ObjectProperty hasAttribute = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#hasAttribute" );
    
    public static final ObjectProperty hasComment = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#hasComment" );
    
    public static final ObjectProperty hasComposite = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#hasComposite" );
    
    public static final ObjectProperty hasConstraint = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#hasConstraint" );
    
    public static final ObjectProperty hasElement = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#hasElement" );
    
    public static final ObjectProperty hasInterface = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#hasInterface" );
    
    public static final ObjectProperty hasLowerBound = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#hasLowerBound" );
    
    public static final ObjectProperty hasMember = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#hasMember" );
    
    public static final ObjectProperty hasMethod = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#hasMethod" );
    
    public static final ObjectProperty hasModifier = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#hasModifier" );
    
    public static final ObjectProperty hasMultiplicityElement = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#hasMultiplicityElement" );
    
    public static final ObjectProperty hasRealization = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#hasRealization" );
    
    public static final ObjectProperty hasRelation = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#hasRelation" );
    
    public static final ObjectProperty hasRelationEnd = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#hasRelationEnd" );
    
    public static final ObjectProperty hasSource = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#hasSource" );
    
    public static final ObjectProperty hasStereotype = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#hasStereotype" );
    
    public static final ObjectProperty hasSubpackage = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#hasSubpackage" );
    
    public static final ObjectProperty hasTarget = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#hasTarget" );
    
    public static final ObjectProperty hasType = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#hasType" );
    
    public static final ObjectProperty hasUpperBound = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#hasUpperBound" );
    
    public static final ObjectProperty hasValueSpecification = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#hasValueSpecification" );
    
    public static final ObjectProperty instanceLevelRelation = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#instanceLevelRelation" );
    
    public static final ObjectProperty isAggregateOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#isAggregateOf" );
    
    public static final ObjectProperty isAttributeOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#isAttributeOf" );
    
    public static final ObjectProperty isCommentOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#isCommentOf" );
    
    public static final ObjectProperty isCompositeOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#isCompositeOf" );
    
    public static final ObjectProperty isConstraintOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#isConstraintOf" );
    
    public static final ObjectProperty isDependanceOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#isDependanceOf" );
    
    public static final ObjectProperty isInterfaceOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#isInterfaceOf" );
    
    public static final ObjectProperty isLowerBoundOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#isLowerBoundOf" );
    
    public static final ObjectProperty isMemberOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#isMemberOf" );
    
    public static final ObjectProperty isMethodOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#isMethodOf" );
    
    public static final ObjectProperty isModifierOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#isModifierOf" );
    
    public static final ObjectProperty isNavigable = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#isNavigable" );
    
    public static final ObjectProperty isOwnedByElement = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#isOwnedByElement" );
    
    public static final ObjectProperty isRealizationOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#isRealizationOf" );
    
    public static final ObjectProperty isRelationEndOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#isRelationEndOf" );
    
    public static final ObjectProperty isRelationOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#isRelationOf" );
    
    public static final ObjectProperty isSourceOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#isSourceOf" );
    
    public static final ObjectProperty isStereotypeOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#isStereotypeOf" );
    
    public static final ObjectProperty isSubclassOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#isSubclassOf" );
    
    public static final ObjectProperty isSubinterfaceOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#isSubinterfaceOf" );
    
    public static final ObjectProperty isSubpackageOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#isSubpackageOf" );
    
    public static final ObjectProperty isSuperclassOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#isSuperclassOf" );
    
    public static final ObjectProperty isSuperinterfaceOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#isSuperinterfaceOf" );
    
    public static final ObjectProperty isTargetOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#isTargetOf" );
    
    public static final ObjectProperty isTypeOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#isTypeOf" );
    
    public static final ObjectProperty isUpperBoundOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#isUpperBoundOf" );
    
    public static final ObjectProperty isValueSpecificationOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#isValueSpecificationOf" );
    
    public static final ObjectProperty memberProperty = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#memberProperty" );
    
    public static final ObjectProperty mergesPackage = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#mergesPackage" );
    
    public static final ObjectProperty modifierProperty = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#modifierProperty" );
    
    public static final ObjectProperty ownsElement = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#ownsElement" );
    
    public static final ObjectProperty packageProperty = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#packageProperty" );
    
    public static final ObjectProperty relatesElement = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#relatesElement" );
    
    public static final ObjectProperty typeProperty = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#typeProperty" );
    
    public static final DatatypeProperty isOrdered = m_model.createDatatypeProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#isOrdered" );
    
    public static final DatatypeProperty isUnique = m_model.createDatatypeProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#isUnique" );
    
    public static final DatatypeProperty lowerBound = m_model.createDatatypeProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#lowerBound" );
    
    public static final DatatypeProperty name = m_model.createDatatypeProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#name" );
    
    public static final DatatypeProperty upperBound = m_model.createDatatypeProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#upperBound" );
    
    public static final DatatypeProperty value = m_model.createDatatypeProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#value" );
    
    public static final DatatypeProperty visibilityKind = m_model.createDatatypeProperty( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#visibilityKind" );
    
    public static final OntClass Abstract = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#Abstract" );
    
    public static final OntClass Abstraction = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#Abstraction" );
    
    public static final OntClass Assembly = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#Assembly" );
    
    public static final OntClass Association = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#Association" );
    
    public static final OntClass Attribute = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#Attribute" );
    
    public static final OntClass Class = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#Class" );
    
    public static final OntClass ClassDiagram = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#ClassDiagram" );
    
    public static final OntClass Comment = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#Comment" );
    
    public static final OntClass Component = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#Component" );
    
    public static final OntClass ComponentDiagram = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#ComponentDiagram" );
    
    public static final OntClass ComponentInterface = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#ComponentInterface" );
    
    public static final OntClass ComponentRealization = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#ComponentRealization" );
    
    public static final OntClass ComponentSocket = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#ComponentSocket" );
    
    public static final OntClass Connector = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#Connector" );
    
    public static final OntClass Constraint = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#Constraint" );
    
    public static final OntClass Delegation = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#Delegation" );
    
    public static final OntClass Dependency = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#Dependency" );
    
    public static final OntClass DirectedRelationship = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#DirectedRelationship" );
    
    public static final OntClass Element = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#Element" );
    
    public static final OntClass ElementImport = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#ElementImport" );
    
    public static final OntClass Entity = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#Entity" );
    
    public static final OntClass Expression = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#Expression" );
    
    public static final OntClass Generalization = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#Generalization" );
    
    public static final OntClass In = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#In" );
    
    public static final OntClass Inout = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#Inout" );
    
    public static final OntClass InstanceSpecification = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#InstanceSpecification" );
    
    public static final OntClass Interface = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#Interface" );
    
    public static final OntClass LiteralBoolean = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#LiteralBoolean" );
    
    public static final OntClass LiteralInteger = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#LiteralInteger" );
    
    public static final OntClass LiteralNull = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#LiteralNull" );
    
    public static final OntClass LiteralSpecification = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#LiteralSpecification" );
    
    public static final OntClass LiteralString = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#LiteralString" );
    
    public static final OntClass LiteralUnlimitedNatural = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#LiteralUnlimitedNatural" );
    
    public static final OntClass Member = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#Member" );
    
    public static final OntClass Method = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#Method" );
    
    public static final OntClass Modifier = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#Modifier" );
    
    public static final OntClass MultiplicityElement = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#MultiplicityElement" );
    
    public static final OntClass OpaqueExpression = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#OpaqueExpression" );
    
    public static final OntClass Out = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#Out" );
    
    public static final OntClass Package = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#Package" );
    
    public static final OntClass PackageDiagram = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#PackageDiagram" );
    
    public static final OntClass PackageVis = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#PackageVis" );
    
    public static final OntClass ParameterDirectionKind = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#ParameterDirectionKind" );
    
    public static final OntClass Private = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#Private" );
    
    public static final OntClass Protected = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#Protected" );
    
    public static final OntClass Public = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#Public" );
    
    public static final OntClass Realization = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#Realization" );
    
    public static final OntClass RelationEnd = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#RelationEnd" );
    
    public static final OntClass Relationship = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#Relationship" );
    
    public static final OntClass Required = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#Required" );
    
    public static final OntClass Return = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#Return" );
    
    public static final OntClass Stereotype = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#Stereotype" );
    
    public static final OntClass Substitution = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#Substitution" );
    
    public static final OntClass Type = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#Type" );
    
    public static final OntClass Usage = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#Usage" );
    
    public static final OntClass ValueSpecification = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#ValueSpecification" );
    
    public static final OntClass VisibilityKind = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#VisibilityKind" );
    
    public static final OntClass packageImport = m_model.createClass( "http://www.semanticweb.org/ontologies/2009/10/uml_class.owl#packageImport" );
    
}
