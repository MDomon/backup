
public class Wand {
	private String name;
	private double power;

	public String getName(){
		return this.name;
	}
	public void setName(String name){
		if(name == null){
			throw new IllegalArgumentException("名前を入力してください。");
		}
		if(name.length() < 3){
			throw new IllegalArgumentException("3文字以上の名前を入力してください。");
		}

		this.name = name;
	}

	public double getPower(){
		return this.power;
	}
	public void setPower(double power){
		if(power < 0.5 || power > 100){
			throw new IllegalArgumentException("魔力は0.5以上100以下で入力してください。");
		}

		this.power = power;
	}

}
