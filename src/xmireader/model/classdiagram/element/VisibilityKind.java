/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.model.classdiagram.element;

/**
 *
 * @author kane
 */
public enum VisibilityKind {
    PACKAGE,
    PRIVATE,
    PROTECTED,
    PUBLIC;


    public static VisibilityKind getVisibilityKind(String s){
        if(s.equals("package"))
            return PACKAGE;
        else if(s.equals("private"))
            return PRIVATE;
        else if(s.equals("protected"))
            return PROTECTED;
        else if(s.equals("public"))
            return PUBLIC;
        else
            throw new IllegalArgumentException(s+" Is not accepted visibility kind ");
    }
}
