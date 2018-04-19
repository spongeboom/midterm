class Data{	// Super class  Sub class의 필드를 전부 가지고 있다.
	int a,b,hakbun;	//	calc class의 연산을 위한 변수a,b	및 Introduction 클래스의 학번을 담는 변수
	String name,subject,phone,gender; // Introduction 클래스의 필드(이름,전공,전화번호,성별)
	int mul[] = new int[9];	// 구구단 클래스의 값을 담아줄 배열
	
	void setData(int n, int m){	//	calc 클래스에서 사용될 메서드 인자값으로 첫번째 값과 두번째 값을 받아서 변수 a,b 에 넣어준다.
		a = n;	
		b = m;
	}
	
	void setData(String n, String s, String p, String g, int h){ 
		//Introduction 클래스에서 호출되는 메서드 인자값으로 (이름,전공,학번,전화번호,성별,학번)을 받아준다.
		name = n;
		hakbun = h;
		subject = s;
		phone = p;
		gender = g;
	}
	
	int[] resultData(int t){	
		// 구구단의 연산의 결과를 배열에 담아주는 메서드 int형의 배열을 리턴해준다. 인자값으로 정수를 받아 그값을 이용해 for 문의 i값과 * 연산 그 값을 배열에 담고 return
		for(int i=0; i<mul.length; i++){
			mul[i] =  t * (i+1);
		}
		return mul;
	}
	
	void print(){
		//Super class 만 출력하는 메서
		System.out.println("Super class");
	}
}

class Calc extends Data{
	// Data class 상속 사칙연산 기능을 가진 클래스 
	public Calc() {
		//생성자 객체가 생성될때 "사칙연산" 출력
		System.out.println("사칙연산");
	}
	int plus(){
		//더한값을 정수값으로 리턴 
		return a+b; 
	}
	int minus(){ 
		// 뺄셈값을 정수으로 리턴 
		 return a-b;
	}
	int multification(){
		// 곱셈값을 정수형 리턴
		return a*b; 
	}
	int division(){
		// 나눈값을 정수형 리턴
		 return a/b;
	}
	void print(){
		// 메소드 오버라이딩 
		// 최종 적으로 메소드를 호출하여 리턴받은 값을 출력 변수 a,b 는 Data class 를 상속받았기 때문에 사용가능.
		
		System.out.println(a + "+" + b+ " = " + plus() + " 입니다.");
		System.out.println(a + "-" + b+ " = " + minus() + " 입니다.");
		System.out.println(a + "*" + b+ " = " + multification() + " 입니다.");
		System.out.println(a + "/" + b+ " = " + division() + " 입니다.");
		System.out.println();
	}
}

class Introduction extends Data{
	// 자기소개 클래스 Data class 상속 
	public Introduction(){
		// 객체 생성시 출력 
		System.out.println("자기소개");
	}
	
	void print(){
		// 메소드 오버라이딩 
		// 마찬가지로 Data class 를 상속받아서 subject,name,hakbun,gender,phone 변수들을 사용할수 있다.
		System.out.println("안녕하세요 저는 " + subject + hakbun +"학번" + name + " 입니다.");
		System.out.println("성별은 " + gender + "이고");
		System.out.println("핸드폰 번호는 " +phone +" 입니다.");
		System.out.println();
	}
}

class Multi extends Data{
	public Multi() {
		System.out.println("구구단");
	}
	void print(int res[], int t){
		// 인자 값으로 배열과 정수를 받는다 인자값으로 받은 배열을 for문을 이용해 0부터 res 배열의 길이 만큼 루프를 돌고 루프수만큼 출력해준다. 정수 t의 역할은 단순히 
		// 출력할때 보여지기 위함. 
		for(int i=0; i<res.length; i++)
			System.out.print( t+" * "+ (i+1) +" = "+res[i] + "\t");  
			System.out.println();		
	}
	
	void multify(){
		// 구구단 연산을 위해 resultData 메서드를 호출하여 인자값을 넣어준다 for문 이용 그값을 result[] 에 리턴받아 넣어준다.
		for(int i=1; i<=9; i++){
			int result[] = resultData(i);
			System.out.println(i + "단입니다."); //현재 진행하는 단을 출력 
			print(result, i); //print 메서드 호출 
		}
		
	}
}

public class Test {
	public static void main(String[] args) {
//		if(args.length == 0){ 
//		프롬프트로 인자값을 입력받기 만약 인자값이 없으면 값이 없습니다 출력 후 return 
//			System.out.println("값이 없습니다.");
//			return;
//		}

		Calc calc = new Calc(); // 계산기 객체 생성 
		calc.setData(2,2); // 계산기 객체의 setData 메서드 호출 (super class 의 메서드 사용)
		calc.print(); // print 메서드 호출 
		
		Introduction in = new Introduction(); // 자기소개 객체 생성 
//		in2.setData(args[0],args[1], args[2], args[3]); 프롬프트 값을 받아 setData 메서드의 인자값으로 넣어주기 
		in.setData("김성윤","임베디드응용전공", "010-1234-1234", "남자",201626009); // Super class 의 setData 메서드 호출 인자값을 직접 넣어준다.
		in.print(); // print 메서드 호출 
		
		Multi mul = new Multi(); // 구구단 객체 생성 
		mul.multify(); // multify 메서드 호출 연산 후 출력 multify 메서드 안에 print 메서드가 호출되어 있기때문에 출력이 가능 
	}
}
