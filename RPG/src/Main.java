
public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		//1.勇者を生成
		Hero h1 = new Hero();
		System.out.println(h1.name);

		//2.フィールドに初期値をセット
		h1.name = "ミナト";
		h1.hp = 100;
		System.out.println("勇者" + h1.name + "を生み出しました。");

		Hero h2 = new Hero();
		h2.name = "アサカ";
		h2.hp = 100;

		Wizard w = new Wizard();
		w.name = "スガワラ";
		w.hp = 50;

		//3.勇者メソッドを呼び出してゆく
		h1.sit(5);
		h1.slip();
		h1.sit(25);
		h1.run();
System.out.print("\n");

		Matango m1 = new Matango();
		m1.hp = 50;
		m1.suffix = 'A';

		Matango m2 = new Matango();
		m2.hp = 48;
		m2.suffix = 'B';

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

		w.heal(h1);
		w.heal(h2);
		w.heal(h2);

	}

}
