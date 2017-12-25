
public class Hero {
	private String name;
	private int hp;
	static int money;

	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}

	public int getHp(){
		return this.hp;
	}
	public void setHp(int hp){
		this.hp = hp;

		if(this.hp < 0){
			this.hp = 0;
			System.out.println("勇者は死んでしまった・・・");
		}
	}


	public Hero(String name){
		this.name = name;
		this.hp = 100;
	}
	public Hero(){
		this("ダミー");
	}




	void attack(){

	}
	void run(){
		System.out.println(this.name + "は、逃げ出した！");
		System.out.println("GAMEOVER");
		System.out.println("最終HPは" + this.hp + "でした。");
	}
	void sit(int sec){
		this.hp += sec;
		System.out.println(this.name + "は、" + sec + "秒座った！");
		System.out.println("hpが" + sec + "ポイント回復した！");
	}
	void slip(){
		this.hp -= 5;
		System.out.println(this.name + "は、転んだ！");
		System.out.println("5 のダメージ！");
	}
	void sleep(){
		this.hp = 100;
		System.out.println(this.name + "は、眠って回復した！");
	}
}
