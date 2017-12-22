import java.util.Random;

public class Cleric {
	String name;
	int hp;
	int mp;
	static final int maxHp = 50;
	static final int maxMp = 10;

	public Cleric(String name,int hp,int mp){
		this.name =name;
		this.hp = hp;
		this.mp = mp;
	}
	public Cleric(String name,int hp){
		this(name,hp,Cleric.maxMp);
	}

	public Cleric(String name){
		this(name,Cleric.maxHp);
	}

	public void selfAid(){
		System.out.println(this.name + "は、セルフエイドを唱えた！");
		this.mp -= 10;
		this.hp = maxHp;
		System.out.println("HPが最大値まで回復した！");
	}

	public int pray(int sec){
		System.out.println(this.name + "は、" + sec + "秒間点に祈った！");
		int recover = new Random().nextInt(3) + sec;
		int recoverActual = Math.min(maxMp -this.mp, recover);
		this.mp += recoverActual;
		System.out.println("MPが" + recoverActual + "回復した。");
		return recoverActual;
	}
}
