
public class PoisonMatango extends Matango {
	private int poisonCount = 5;

	public PoisonMatango(char suffix){
		super(suffix);
	}

	public int getPoisonCount(){
		return this.poisonCount;
	}
	public void setPoisonCount(int poisonCount){
		this.poisonCount = poisonCount;
	}

	public void attack(Hero h){
		super.attack(h);
		if(this.poisonCount > 0){
			System.out.println("さら"
					+ "に毒の胞子をばらまいた。");
			int pdmg = (h.getHp() / 5);
			h.setHp(h.getHp() - pdmg);
			System.out.println(pdmg + "ポイントのダメージを与えた！");
			setPoisonCount(this.poisonCount - 1);
		}else{
			System.out.println("PoisonMatango" + getSuffix() + "の毒はもう尽きている・・・");
		}

	}

}