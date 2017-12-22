

public class HelloWorld {

	public static void main(String[] args) {

		// TODO 自動生成されたメソッド・スタブ

		System.out.println("HelloWorld!");

		double a = (double)10/3;
		System.out.println(a);


		int b = 10;
		System.out.println(++b);


		int number = 88;

		if(number <= 100){
			if(number < 20){
				System.out.println("未成年");
			}else if(number == 77){
				System.out.println("喜寿");
			}else if(number == 88){
				System.out.println("米寿");
			}else{
				System.out.println("成人");
			}
		}


		String[] name = {"田中","高橋","斉藤"};

		System.out.println(name[0]);


		System.out.println("\n");


		for(int i = 1; i <= 10; i++){
			if(i % 2 == 0){
				System.out.println(i + "\n");
			}
		}



		int c = 10;
		String d = c >= 0? "プラス":"マイナス";
		System.out.println(d);




		System.out.println("\n");


		int j = 10;
		while(j >= 1){
			System.out.println(j);
			j -= 3;
		}

		System.out.println("\n");
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Sample{
	public static void main(String args[])
	throws IOException{
		System.out.println("何番目の処理を飛ばしますか？(1～10)");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int res = Integer.parseInt(str);

		for(int i=1; i<=10; i++){
			if(i == res)
				continue;
			System.out.println(i + "何番目の処理です。");
		}
	}
}





