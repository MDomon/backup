package model;

public class SiteEV {
	private int like;//いいねの数
	private int dislike;//いくないねの数

	public SiteEV(){
		like = 0 ;
		dislike = 0 ;
	}

	public int getLike(){
		return like;
	}
	public void setLike(int like){
		this.like = like;
	}
	public int getDislike(){
		return dislike;
	}
	public void setDislike(int dislike){
		this.dislike = dislike;
	}

}
