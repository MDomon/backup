
public class Wizard {
	private String name;
	private int hp;
	private int mp;
	private Wand wand;

	public String getName(){
		if(name == null){
			throw new IllegalArgumentException("名前を入力してください。");
		}
		if(name.length() < 3){
			throw new IllegalArgumentException("3文字以上の名前を入力してください。");
		}

		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}

	public int getHp(){
		return this.hp;
	}
	public void setHp(int hp){
		if(hp < 0){
			this.hp = 0;
		}


		this.hp = hp;
	}

	public int getMp(){
		return this.mp;
	}
	public void setMp(int mp){
		if(mp < 0){
			throw new IllegalArgumentException("MPはマイナスにできません。");
		}

		this.mp = mp;
	}

	public Wand getWand(){
		return this.wand;
	}
	public void setWand(Wand wand){
		if(wand == null || name.length() < 3

				){
			throw new IllegalArgumentException("杖の名前を入力してください。");
		}

		this.wand = wand;
	}



	void heal(Hero h){
		int basePoint = 10;
		int recovPoint = (int)(basePoint * this.wand.getPower());

		h.setHp(h.getHp() + recovPoint);
		System.out.println(h.getName() + "のHPを" + recovPoint + "回復した！");
	}
}
