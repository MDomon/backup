
public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		//1.勇者を生成
		Hero h1 = new Hero();
		System.out.println(h1.getName());

		//2.フィールドに初期値をセット
		h1.setName("ミナト");
		h1.setHp(100);
		System.out.println("勇者" + h1.getName() + "を生み出しました。");

		Hero h2 = new Hero();
		h2.setName("アサカ");
		h2.setHp(100);

		Wizard w = new Wizard();
		w.setName("スガワラ");
		w.setHp(50);

		//3.勇者メソッドを呼び出してゆく
		h1.sit(5);
		h1.slip();
		h1.sit(25);
		h1.run();
System.out.print("\n");

		Matango m1 = new Matango('A');
		m1.setHp(50);

		Matango m2 = new Matango('B');
		m2.setHp(48);

		//冒険の始まり
		h1.slip();
		m1.run();
		m2.run();
		h1.run();
System.out.print("\n");

		Cleric c = new Cleric("ナルト");
		c.selfAid();
		c.pray(5);
		System.out.println(c.hp);
		System.out.println(c.mp);
		c.pray(5);
		System.out.println(c.mp);
System.out.print("\n");



		Wand wa = new Wand();
		wa.setName("firewand");
		wa.setPower(50);



		PoisonMatango pm1 = new PoisonMatango('A');
		Hero h = new Hero("loto");

		pm1.attack(h);
		System.out.println(h.getHp());
		pm1.attack(h);
		System.out.println(h.getHp());
		pm1.attack(h);
		System.out.println(h.getHp());
		pm1.attack(h);
		System.out.println(h.getHp());
		pm1.attack(h);
		System.out.println(h.getHp());
		pm1.attack(h);
		System.out.println(h.getHp());
		pm1.attack(h);
		System.out.println(h.getHp());

	}

}


