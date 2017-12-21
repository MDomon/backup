
public class SmartPhone2 extends Phone implements MP3Player,NewFunction{
	public static void main(String[] args){
		Phone iPhone = new Phone();
		iPhone.play();
		iPhone.stop();
		iPhone.next();
		iPhone.back();
		iPhone.call();
		iPhone.mail();
		iPhone.photo();
		iPhone.internet();
	}
}
