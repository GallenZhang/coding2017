package week11.basic;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryHeap {
	
	static class OOMObject{
		@SuppressWarnings("unused")
		private byte[] bytes = new byte[1024 * 1024];
	}
	
	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<OutOfMemoryHeap.OOMObject>();
		while(true){
			list.add(new OOMObject());
		}
	}
}
