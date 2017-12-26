
public class Book extends TangibleAsset{
	//フィールド
	private String isbn;

	//コンストラクタ
	public Book(String name,int price,String color,String isbn){
		super(name,price,color);
		this.isbn = isbn;
	}

	//ゲッター
	public String getIsbn(){
		return this.isbn;
	}
}
