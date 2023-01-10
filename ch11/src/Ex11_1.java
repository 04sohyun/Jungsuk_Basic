import java.util.*;

public class Ex11_1 {

	public static void main(String[] args) {
		//기본 길이(용량,capacity)가 10인 ArrayList를 생성 
		ArrayList list1 = new ArrayList(10);
		//ArrayList에는 객체만 저장가능 
		//autoboxing에 의해 기본형이 참조형으로 자동변환 
		list1.add(5);
		//list1.add(new Integer(5));
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(new Integer(3));
		
		ArrayList list2 = new ArrayList(list1.subList(1, 4));//1<=x<4
		print(list1, list2);
		
		//Collection은 인터페이스, Collections는 유틸 클래스 
		Collections.sort(list1);   //list1과 list2를 정렬한다.
		Collections.sort(list2);  // Collection.sort(List l)
		print(list1, list2);
		
		//list1이 list2의 모든 요소를 포함하는 지 확인 
		System.out.println("list1.containsAll(list2):"+list1.containsAll(list2));
		
		list2.add("B");
		list2.add("C");
		list2.add(3,"A");
		print(list1, list2);
		
		list2.set(3, "AA");
		print(list1,list2);

		list1.add(0,"1"); //"1"은 String 1이고 1은 Integer
		//indexOf()는 지정된 객체의 위치를 알려준다.
		System.out.println("index="+list1.indexOf("1"));
		print(list1,list2);
//		list1.remove(1);  //index가 1인 객체를 삭제
		list1.remove(new Integer(1));//1을 삭제 
		print(list1,list2);
		
		
		//list1에서 list2와 겹치는 부분만 남기고 나머지는 삭제한다.
		System.out.println("list1.retainAll(list2):"+list1.retainAll(list2));
		print(list1, list2);
		
		//list2에서 list1에 포함된 객체들을 삭제한다.
		for(int i=list2.size()-1;i>=0;i--) {
			if(list1.contains(list2.get(i)))
				list2.remove(i);
		}
		print(list1, list2);
	}//main의 끝 
	
	static void print(ArrayList list1, ArrayList list2) {
		System.out.println("list1:"+list1);
		System.out.println("list2:"+list2);
		System.out.println();
	}

}
