public class Person{

	private String name = null;
	private int age = 0;
	private String address = null;
	private String job = null;

	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}

	public int getAge(){
		return this.age;
	}
	public void setAge(int age){
		this.age = age;
	}

	public String getAddress(){
		return this.address;
	}
	public void setAddress(String address){
		this.address = address;
	}

	public String getJob(){
		return this.job;
	}
	public void setJob(String job){
		this.job = job;
	}


	/*
	private String name = null;
	private int age = 0;

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}

	public Person(String name,int age){
		setName(name);
		this.age = age;
	}
	*/
}





/*
public class Person {
	public String name = null;
	public int age = 0;
	public String phoneNumber = null;
	public String address = null;

	public void talk(){
		System.out.println(this.name + "が話す。");
	}

	public void walk(){
		System.out.println(this.name + "が歩く。");
	}

	public void run(){
		System.out.println(this.name + "が走る。");
	}
}
*/
/*
public class Person{
	//---- フィールドの設定 ----
	public String name =null;
	public int age = 0;


	// ---- メソッドの設定 ----
	//コンストラクタ①
	public Person(){}

	//コンストラクタ②
	public Person(String name,int age){
		this.name = name;
		this.age = age;
	}
	//コンストラクタ③
	public Person(String name){
		this.name = name;
		this.age = 0;
	}

	//コンストラクタ④
	public Person(int age){
		this.name = "名前なし";
		this.age = age;
		}

	//コンストラクタ⑤
	public Person(int age,String name){
		this.age = age;
		this.name = name;
	}
}
*/