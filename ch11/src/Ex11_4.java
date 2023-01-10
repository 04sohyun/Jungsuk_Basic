import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex11_4 {
	static Queue q = new LinkedList();
	static final int MAX_SIZE=5;  //Queue에 최대 5개까지만 저장되도록 한다.

	public static void main(String[] args) {
		System.out.println("help를 입력하면 도움말을 볼 수 있습니다.");
		
		while(true) {
			System.out.println(">>");
			try {
				Scanner s = new Scanner(System.in);
				String input = s.nextLine().trim();
				
				if("".equals(input)) continue;
				
				if(input.equalsIgnoreCase("help")) {
					System.out.println(" help - 도움말을 보여줍니다.");
					System.out.println(" q 또는 Q - 프로그램을 종료합니다.");
					System.out.println(" history - 최근에 입력한 명령어를 "+MAX_SIZE+"개 보여줍니다.");
				}else if(input.equals("q")) {
					System.exit(0);
				}else if(input.equalsIgnoreCase("history")) {
					save(input);  //입력받은 명령어를 저장하고,
					
					LinkedList list = (LinkedList) q;  //LinkedList의 내용을 보여준다.
					for(int i=0;i<list.size();i++) {
						System.out.println((i+1)+"."+list.get(i));
					}
				}else {
					save(input);
					System.out.println(input);
				}
			}catch(Exception e) {
				System.out.println("입력오류입니다.");
			}
		}
	}
	public static void save(String input) {
		if(!"".equals(input)) q.offer(input);
		
		if(q.size()>MAX_SIZE) q.remove();
	}

}
