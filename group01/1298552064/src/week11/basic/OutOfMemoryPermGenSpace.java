package week11.basic;


public class OutOfMemoryPermGenSpace {
	public static void main(String[] args) {
		String str = "OutOfMemoryPermGenSpace";
		while(true){
			str = str + str;
			//在常量池中查找是否有该字符串，有就返回引用，没有的话加入常量池，返回引用	
			str.intern();
		}
	}
}
