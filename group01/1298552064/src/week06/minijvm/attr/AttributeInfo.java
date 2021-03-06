package week06.minijvm.attr;

public abstract class AttributeInfo {
	public static final String CODE = "Code";
	public static final String CONSTANT_VALUE = "ConstantValue";
	public static final String EXCEPTIONS = "Exceptions";
	public static final String LINE_NUMBER_TABLE = "LineNumberTable";
	public static final String LOCAL_VARIABLE_TABLE = "LocalVariableTable";
	public static final String STACK_MAP_TABLE = "StackMapTable";

	int attrNameIndex;
	int attrLen;

	public AttributeInfo(int attrNameIndex, int attrLen) {
		this.attrNameIndex = attrNameIndex;
		this.attrLen = attrLen;
	}

}
