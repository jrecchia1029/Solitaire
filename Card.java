public class Card {
	int value;
	String suit;
	boolean red;
	boolean up;
	String code;
	
	public Card(int suit, int value){
		if (suit==0){
			this.suit="Hearts";
			this.red=true;
		}
		else if (suit==1){
			this.suit="Diamonds";
			this.red=true;
		}
		else if (suit==2){
			this.suit="Clubs";
			this.red=false;
		}
		else if (suit==3){
			this.suit="Spades";
			this.red=false;
		}
		this.value=value+1;
		up=false;
		code= value+" of "+ suit;
		
	}

	public void setUp(boolean b){
		up=b;
	}
	
	public String getCode(){
		return code;
	}
	
	public String toString(){
		if (up==true){
		return(value+" of "+suit);
		}
		else{
			return "X";
		}
	}
}