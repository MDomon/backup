
public class Matango {
	private int hp;
	final int level = 10;
	private char suffix;

	public Matango(char suffix){
		this.suffix = suffix;
	}

	public int getHp(){
		return this.hp;
	}
	public void setHp(int hp){
		this.hp = hp;
	}

	public char getSuffix(){
		return this.suffix;
	}
	public void setSuffix(char suffix){
		this.suffix = suffix;
	}

	public void attack(Hero h){
		System.out.println("キノコ" + this.suffix + "の攻撃！");
		System.out.println("10のダメージ！");
		h.setHp(h.getHp() - 10);
	}

	public void run(){
		System.out.println("お化けキノコ" + this.suffix + "は逃げ出した！");
	}
}
