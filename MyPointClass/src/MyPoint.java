
public class MyPoint {
	int x;
	int y;

	int getX(){
		System.out.println("X座標を得ました。");
		return x;
	}

	int getY(){
		System.out.println("Y座標を得ました。");
		return y;
	}

	void setX(int px){
		x = px;

	}

	void setY(int py){
		y = py;
	}
}

class MyPoint1{
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		MyPoint p1;
		p1 = new MyPoint();
		p1.setX(10);
		p1.setY(5);

		int px = p1.getX();
		int py = p1.getY();

		System.out.println("X座標は" +  px + "、Y座標は" + py + "でした。");
	}
}

