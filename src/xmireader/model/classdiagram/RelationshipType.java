package xmireader.model.classdiagram;

/**
 * Created by svitlanamoiseyenko on 3/14/17.
 */
public enum RelationshipType {
    ASSOC_NONE("none"),
    ASSOC_AGGREGATION("aggregate"),
    GENERALIZATION("generalization");

    private String typeValue;

    private RelationshipType(String type) {
        typeValue = type;
    }

    public static RelationshipType getType(String pType) {
        System.out.println("GramRelationsEnum getType");
        for (RelationshipType type: RelationshipType.values()) {
            if (type.getTypeValue().equals(pType)) {
                return type;
            }
        }
        return ASSOC_NONE;
        //throw new RuntimeException("UNKNOWN TYPE: " + pType);
    }

    public String getTypeValue() {
        return typeValue;
    }
}
