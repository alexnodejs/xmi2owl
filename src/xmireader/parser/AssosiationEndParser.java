package xmireader.parser;

import org.w3c.dom.Node;
import xmireader.XMIConstants;
import xmireader.model.classdiagram.element.AssociationEnd;
import xmireader.model.usecasediagram.element.OwnedEnd;


/**
 * Created by svitlanamoiseyenko on 3/14/17.
 */
public class AssosiationEndParser extends GenericElementParser {

    public String getNodeName() {
        return "UML:AssociationEnd";
    }

    public AssociationEnd getElement(Node node)
    {
        String name = getAttributeValue(node, "name");
        String id = getAttributeValue(node, XMIConstants.XMI_ID);
        String relatedClassId = getRelatedClassByNodeName(node, XMIConstants.XMI_UML_CLASS_NODE);
        String type = getAttributeValue(node, "aggregation");

        return new AssociationEnd(id, name, relatedClassId, type);
    }

    public Class getReturnedClass() {
        return AssociationEnd.class;
    }

}
