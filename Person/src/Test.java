
public class Test {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Person taro = new Person();
		taro.name = "山田太郎";
		taro.age = 20;
		taro.phoneNumber = "090-0000-0000";
		taro.address = "神奈川県";

		System.out.println("名前：" + taro.name);
		System.out.println("年齢：" + taro.age);
		System.out.println("電話：" + taro.phoneNumber);
		System.out.println("住所：" + taro.address);

		taro.talk();
		taro.walk();
		taro.run();
		System.out.print("\n");

		Person masa = new Person();
		masa.name = "土門真道";
		masa.age = 25;
		masa.phoneNumber = "090-1111-1111";
		masa.address = "神奈川県";

		System.out.println("名前：" + masa.name);
		System.out.println("年齢：" + masa.age);
		System.out.println("電話：" + masa.phoneNumber);
		System.out.println("住所：" + masa.address);

		masa.talk();
		masa.walk();
		masa.run();
		System.out.print("\n");

		Person jiro = new Person();
		jiro.name = "木村次郎";
		jiro.age = 18;
		jiro.phoneNumber = "090-2222-2222";
		jiro.address = "沖縄県";

		System.out.println("名前：" + jiro.name);
		System.out.println("年齢：" + jiro.age);
		System.out.println("電話：" + jiro.phoneNumber);
		System.out.println("住所：" + jiro.address);

		jiro.talk();
		jiro.walk();
		jiro.run();
		System.out.print("\n");

		Person hana = new Person();
		hana.name = "鈴木花子";
		hana.age = 16;
		hana.phoneNumber = "090-3333-3333";
		hana.address = "東京都";

		System.out.println("名前：" + hana.name);
		System.out.println("年齢：" + hana.age);
		System.out.println("電話：" + hana.phoneNumber);
		System.out.println("住所：" + hana.address);

		hana.talk();
		hana.walk();
		hana.run();
		System.out.print("\n");

		Robot aibo = new Robot();
		Robot asimo = new Robot();
		Robot pepper = new Robot();
		Robot doraemon = new Robot();

	}

}