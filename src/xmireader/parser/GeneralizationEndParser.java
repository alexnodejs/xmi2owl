package xmireader.parser;

import org.w3c.dom.Node;
import xmireader.XMIConstants;
import xmireader.model.classdiagram.element.AssociationEnd;
import xmireader.model.classdiagram.element.Generalization;
import xmireader.model.classdiagram.element.GeneralizationEnd;
import xmireader.model.classdiagram.element.GeneralizationNodeType;

/**
 * Created by svitlanamoiseyenko on 3/15/17.
 */
public class GeneralizationEndParser extends GenericElementParser {

    private GeneralizationNodeType nodeType = GeneralizationNodeType.CHILD;

    public String getNodeName() {
        System.out.println("getNodeName: " + nodeType);
        return nodeType == GeneralizationNodeType.CHILD ?
                    XMIConstants.XMI_UML_GENERALIZATION_CHILD_NODE :
                    XMIConstants.XMI_UML_GENERALIZATION_PARENT_NODE;

        //return XMIConstants.XMI_UML_GENERALIZATION_PARENT_NODE;
    }

    public GeneralizationEndParser(GeneralizationNodeType nodeType) {
        this.nodeType = nodeType;
    }

    public GeneralizationEnd getElement(Node node)
    {
        System.out.println("GeneralizationEnd node: " + node);
        String idRef = getRelatedClassByNodeName(node, XMIConstants.XMI_UML_CLASS_NODE);
        System.out.println("GeneralizationEnd: " + idRef);
        boolean isSource = false;
        if (nodeType == GeneralizationNodeType.PARENT) {
            isSource = true;
        }

        return new GeneralizationEnd(idRef, isSource);
    }

    public Class getReturnedClass() {
        return Generalization.class;
    }
}
