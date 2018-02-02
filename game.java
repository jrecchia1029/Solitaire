import java.util.ArrayList;

import java.util.LinkedList;

import java.util.Random;

import java.util.Scanner;





public class Game {
	LinkedList<Card> stack1=new LinkedList();
	LinkedList<Card> stack2=new LinkedList();
	LinkedList<Card> stack3=new LinkedList();
	LinkedList<Card> stack4=new LinkedList();
	LinkedList<Card> stack5=new LinkedList();
	LinkedList<Card> stack6=new LinkedList();
	LinkedList<Card> stack7=new LinkedList();
	LinkedList<Card> stack8=new LinkedList();
	LinkedList<Card> stack9=new LinkedList();
	LinkedList<Card> stack10=new LinkedList();
	LinkedList<Card> stack11=new LinkedList();
	LinkedList<Card> drawn=new LinkedList();
	ArrayList<Card> deck=new ArrayList();
	LinkedList[] stacks={stack1, stack2, stack3, stack4, stack5, stack6, stack7, stack8, stack9, stack10, stack11, drawn};
	int cardsLeft;
	int points;

	public Game(){
		cardsLeft=deck.size();
	}

	public void drawCard(){
		int tempSize=deck.size();
		if (tempSize>=3){
			for (int i=0; i<3;i++){
				drawn.add(deck.get(deck.size()-1));
				deck.remove(deck.size()-1);
			}
			cardsLeft=cardsLeft-3;
		}
		else{
			for (int i=0; i<tempSize;i++){
				drawn.add(deck.get(deck.size()-1));
				deck.remove(deck.size()-1);
			}
			cardsLeft=cardsLeft-deck.size();
		}
		points--;
	}

	public void deckSwap(){
		int tempSize=drawn.size();
		for (int i=0; i<tempSize;i++){
			deck.add(drawn.get(drawn.size()-1));
			drawn.remove(drawn.size()-1);
		}
	}

	public boolean checkWin(){
		if (stack8.size()<1 || stack9.size()<1 || stack10.size()<1 || stack11.size()<1 ){
			return false;
		}
		else if (stack8.get(stack8.size()-1).value==13 && stack9.get(stack9.size()-1).value==13 && stack10.get(stack10.size()-1).value==13 && stack11.get(stack11.size()-1).value==13){
			return true;
		}
		else{
			return false;
		}
	}

	public int largestList(){
		int s1 =stack1.size();
		int s2 =stack2.size();
		int s3 =stack3.size();
		int s4 =stack4.size();
		int s5 =stack5.size();
		int s6 =stack6.size();
		int s7 =stack7.size();
		int s8 =drawn.size();
		int [] numbers= {s1,s2,s3,s4,s5,s6,s7,s8};

		int largest=numbers[0];
		int pos=0;
		int size=numbers.length;
		while (pos<size){
			if (numbers[pos]>largest){
				largest=numbers[pos];
			}
			pos++;
		}
		return largest;
	}

	public int largestList2(){
		int s1 =stack1.size();
		int s2 =stack2.size();
		int s3 =stack3.size();
		int s4 =stack4.size();
		int s5 =stack5.size();
		int s6 =stack6.size();
		int s7 =stack7.size();
		int [] numbers= {s1,s2,s3,s4,s5,s6,s7};
		int largest=numbers[0];
		int pos=0;
		int size=numbers.length;
		while (pos<size){
			if (numbers[pos]>largest){
				largest=numbers[pos];
			}
			pos++;
		}
		return largest;
	}

	public boolean moveCheck(Card a, Card b, LinkedList stack){
		if (stack.size()==0 && a.value==1&&(stack==stack8 || stack==stack9 || stack== stack10 || stack== stack11)){
			return true;
		}
		else if (stack.size()==0 && a.value==13&&(stack!=stack8 || stack!=stack9 || stack!= stack10 || stack!= stack11|| stack!=drawn)){
			return true;
		} 
		else if (b.value-a.value==1 && a.red!=b.red && (stack!=stack8 || stack!=stack9 || stack!= stack10 || stack!= stack11 || stack!=drawn)){
			return true;
		}
		else if (a.suit==b.suit && a.value-b.value==1 && (stack==stack8 || stack==stack9 || stack== stack10 || stack== stack11)){
			return true;
		}
		else {
			return false;
		}
	}

	public boolean specialMoveCheck(Card a, Card b, LinkedList stack){
		if ((stack==stack8 || stack==stack9 || stack== stack10 || stack== stack11) && a.suit==b.suit && a.value-b.value==1){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean moveCheck(Card a, LinkedList stack){
		if (stack.size()<=0 && a.value == 1 && (stack==(stack8) || stack==(stack9) || stack==(stack10) || stack==(stack11))){
			return true;
		}
		else if (stack.size()<=0 && a.value==13 && stack!=stack8 && stack!=(stack9) && stack!=(stack10) && stack!=(stack11) && stack!=(drawn)){	
			return true;
		} 
		else {
			return false;
		}
	}

	public void move(){
		try{
			Scanner x = new  Scanner(System.in);
			System.out.println("What would you like to do? (move card or draw)");
			String move = x.next();
			if (move.equalsIgnoreCase("move")){
				System.out.println("Enter the card you would like to move");
				Scanner  in= new  Scanner(System.in);
				String card = in.nextLine();
				System.out.println(card);
				System.out.println("Enter the stack you'd like to move the card to");
				Scanner  in2= new  Scanner(System.in);
				int stack = in2.nextInt();
				while (stack>11){
					System.out.println("Please enter another number");
					Scanner  x1= new  Scanner(System.in);
					stack = in2.nextInt();
				}
				//	System.out.print("Largest List :"+largestList());
				for (int i=0; i<largestList();i++){
					for (int j=0; j<stacks.length;j++){
						if (i<stacks[j].size()){
							//	System.out.println("Card: "+ card);
							//	System.out.println("Card object toString: "+ stacks[j].get(i));
							if ((stacks[j].get(i)).toString().equalsIgnoreCase(card)){
								//	System.out.println(stacks[stack-1].size());
								System.out.println("toString of stacks[j].get(i) " + stacks[j].get(i).toString());
								if (stacks[stack-1].size()>0){
									//	System.out.println(moveCheck((Card)stacks[j].get(i), (Card)stacks[stack-1].get(stacks[stack-1].size()-1),stacks[stack-1]));
									if (moveCheck((Card)stacks[j].get(i), (Card)stacks[stack-1].get(stacks[stack-1].size()-1),stacks[stack-1])==true){
										//	System.out.println(stacks[j].get(i)+": Index in list is " + i);
										//	System.out.println("Size of list is "+ stacks[j].size());
										if (i!=stacks[j].size()-1){
											int tempSize=stacks[j].size();
											for (int q=i; q<tempSize; q++){
												Card tempCard=(Card) stacks[j].get(i);
												if (moveCheck(tempCard, (Card)stacks[stack-1].get(stacks[stack-1].size()-1),stacks[stack-1])==true){
													stacks[stack-1].add(tempCard);
													stacks[j].remove(i);
													points+=2;
												}
											}
										}
										else{
											stacks[stack-1].add(stacks[j].get(i));
											stacks[j].remove(i);
											points+=2;
											if (stacks[j]==drawn){
												cardsLeft--;
											}
										}
									}
								}
								else{
									//	System.out.println(moveCheck((Card)stacks[j].get(i),stacks[stack-1]));
									if (moveCheck((Card)stacks[j].get(i),stacks[stack-1])==true){
										if (i!=stacks[j].size()-1){
											Card tempCard=(Card) stacks[j].get(i);
											stacks[stack-1].add(tempCard);
											stacks[j].remove(i);
											int tempSize=stacks[j].size();
											for (int q=i; q<tempSize; q++){
												Card tempCard2=(Card) stacks[j].get(i);
												if (moveCheck(tempCard2,(Card)stacks[stack-1].get(stacks[stack-1].size()-1), stacks[stack-1])==true){
													stacks[stack-1].add(tempCard2);
													stacks[j].remove(i);
													points+=2;
												}
											}
										}
										else{
											stacks[stack-1].add(stacks[j].get(i));
											stacks[j].remove(i);
											points+=2;
										}
									}
								}
							}
						}
					}
				}
			}
			else if (move.equalsIgnoreCase("d") || move.equalsIgnoreCase("dr") || move.equalsIgnoreCase("dra")  || move.equalsIgnoreCase("draw")){
				if (deck.size()==0){
					this.deckSwap();
					cardsLeft=deck.size();
				}
				this.drawCard();
			}
			else if (move.equalsIgnoreCase("a")){
				this.auto();
			}
			else if (move.equalsIgnoreCase("find")){
				this.findCard();
			}
			else if (move.equalsIgnoreCase("m")){
				this.getCard();
			}
			else if (move.equalsIgnoreCase("l")){
				this.autoMove();
			}
			else if (move.equalsIgnoreCase("p")){
				this.printStack();
			}
		}catch(Exception e){
		}
	}

	public void playGame(){
		LinkedList<Card> tempDeck=new LinkedList();
		for (int i =0; i<4; i++){
			for (int j=0; j<13; j++){
				Card c= new Card(i,j);
				tempDeck.add(c);
			}
		}
		//	System.out.println(tempDeck);
		Random rgen = new Random();
		int amount1=0;
		for (int i=0; i<52; i++) {
			int randomPosition = rgen.nextInt(52-amount1);
			deck.add(tempDeck.get(randomPosition));
			tempDeck.remove(tempDeck.get(randomPosition));
			amount1++;
		}
		//	System.out.println(tempDeck);
		//	System.out.println(deck);
		int amount=0;
		Random x=new Random();
		for (int i=0; i<7; i++){
			for (int j=0; j<=i; j++){
				int z=x.nextInt(52-amount);
				//	 System.out.println("z : "+ z);
				stacks[i].add(deck.get(z));
				deck.remove(z);
				amount++;
			}
			((Card) stacks[i].get(stacks[i].size()-1)).setUp(true);
		}
		for (int i=0; i<deck.size(); i++){
			((Card)deck.get(i)).up=true;
		}
		while (this.checkWin()==false){
			this.updateCards();
			System.out.println("________________________________________________________________________________________________________________________________________________________________________\n");
			System.out.println("                                                                                                                                                                "+ points+"\n");
			this.toString();
			this.move();
		}
		this.toString();
		System.out.println("WINNER WINNER! CHICKEN DINNER!");
	}

	public void updateCards(){
		for (int i=0; i<largestList();i++){
			for (int j=0; j<7;j++){
				if (i<stacks[j].size()){
					if(((Card)stacks[j].get(i)).up==false && i==stacks[j].size()-1){
						((Card)stacks[j].get(i)).up=true;
					}
				}
			}
		}
		//	System.out.println(deck.size()+" "+deck);
		//	System.out.println(drawn.size()+" "+drawn);
	}

	public String toString(){
		System.out.print("["+deck.size()+"] \t\t");
		if (drawn.size()>0){
			System.out.print(drawn.get(drawn.size()-1)+"\t\t\t");
		}
		else{
			System.out.print(drawn+"\t\t\t");
		}
		if (stack8.size()>0){
			System.out.print("(8) "+stack8.get(stack8.size()-1)+"\t\t\t");
		}
		else{
			System.out.print("(8) []"+"\t\t\t");
		}
		if (stack9.size()>0){
			System.out.print("(9) " +stack9.get(stack9.size()-1)+"\t\t\t");
		}
		else{
			System.out.print("(9) []"+"\t\t\t");
		}
		if (stack10.size()>0){
			System.out.print("(10) "+stack10.get(stack10.size()-1)+"\t\t\t");
		}
		else{
			System.out.print("(10) []"+"\t\t\t");
		}
		if (stack11.size()>0){
			System.out.print("(11) " +stack11.get(stack11.size()-1)+"\n");
		}
		else{
			System.out.print("(11) []"+"\n");
		}
		System.out.println("\n");
		System.out.println("      (1)\t\t       (2)\t\t       (3)\t\t       (4)\t\t       (5)\t\t       (6)\t\t       (7)");
		for (int i =0; i<largestList2(); i++){
			for (int j=0; j<7; j++){
				if (i<stacks[j].size()){
					if (stacks[j].get(i).toString().length()==1){
						System.out.print("|\t"+stacks[j].get(i)+"\t\t|");
					}
					else{
						System.out.print("|\t"+stacks[j].get(i)+"\t|");
					}
				}
				else{
					System.out.printf("|\t\t\t|");
				}
			}
			System.out.println("");
		}
		return ("");
	}


	public void auto(){
		//	try{
		System.out.println("Which stack is the card you want to move in?");
		Scanner in=new Scanner(System.in);
		int stack=in.nextInt();
		Card card= (Card) stacks[stack-1].get(stacks[stack-1].size()-1);
		for (int i=7; i<11; i++){
			if (card.value==1 && (moveCheck(card,stacks[i]))==true){
				stacks[i].add(card);
				//	System.out.println(card+ " added to top");
				stacks[stack-1].remove(card);
				//	System.out.println(card + " removed from stack "+ stack);
				//	System.out.println(stacks[stack-1]);
				break;
			}
			else if (specialMoveCheck(card, (Card)stacks[i].get(stacks[i].size()-1), stacks[i])==true){
				stacks[i].add(card);
				//	System.out.println(card+ " added to top");
				stacks[stack-1].remove(card);
				//	System.out.println(card + " removed from stack "+ stack);
				//	System.out.println(stacks[stack-1]);
				break;
			}
		}
		//	}catch(Exception e){

		//	}
	}

	public void findCard(){
		Scanner in = new Scanner(System.in);
		System.out.println("Which card would you like to find?");
		String card=in.nextLine();
		boolean flag=false;
		String tempCardCode;
		for (int i =0; i<largestList2(); i++){
			for (int j=0; j<stacks.length; j++){
				if (i<stacks[j].size()){
					tempCardCode = ((Card)stacks[j].get(i)).value + " of " + translateSuit(((Card)stacks[j].get(i)).code);
					if (tempCardCode.equalsIgnoreCase(card)){
						System.out.println("The " + card+" is card "+ i +" in stack "+(j+1));
						flag=true;
					}
				}	
			}
		}
		if (flag==false){
			System.out.println(card+" could not be found");
		}
	}

	public void getCard(){
		Scanner in = new Scanner(System.in);
		System.out.println("Which stack is the card in?");
		int column = in.nextInt()-1;
		String card="";
		for (int i=0; i<stacks[column].size(); i++){
			if (((Card)stacks[column].get(i)).up == true && column!=11){
				card = (((Card)stacks[column].get(i)).value + " of " + translateSuit(((Card)stacks[column].get(i)).code));
				//System.out.println(card);
				break;
			}
			else if ((((Card)stacks[column].get(i)).up == true)){
				card = (((Card)stacks[column].get(i)).value + " of " + translateSuit(((Card)stacks[column].get(i)).code));
			}
		}
		System.out.println("Enter the stack you'd like to move the card to");
		Scanner  in2= new  Scanner(System.in);
		int stack = in2.nextInt();
		while (stack>11){
			System.out.println("Please enter another number");
			Scanner  x1= new  Scanner(System.in);
			stack = in2.nextInt();
		}
		//	System.out.print("Largest List :"+largestList());
		for (int i=0; i<largestList();i++){
			for (int j=0; j<stacks.length;j++){
				if (i<stacks[j].size()){
					//	System.out.println("Card: "+ card);
					//	System.out.println("Card object toString: "+ stacks[j].get(i));
					//System.out.println((stacks[j].get(i)).toString());
					if ((stacks[j].get(i)).toString().equalsIgnoreCase(card)){
						//	System.out.println(stacks[stack-1].size());
						//System.out.println("toString of stacks[j].get(i) " + stacks[j].get(i).toString());
						Card selectedCard = (Card) (stacks[j].get(i));
						//System.out.println(selectedCard.value + " of " + selectedCard.suit);
						if (stacks[stack-1].size()>0){
							//	System.out.println(moveCheck((Card)stacks[j].get(i), (Card)stacks[stack-1].get(stacks[stack-1].size()-1),stacks[stack-1]));
							if (moveCheck((Card)stacks[j].get(i), (Card)stacks[stack-1].get(stacks[stack-1].size()-1),stacks[stack-1])==true){
								//	System.out.println(stacks[j].get(i)+": Index in list is " + i);
								//	System.out.println("Size of list is "+ stacks[j].size());
								if (i!=stacks[j].size()-1){
									int tempSize=stacks[j].size();
									for (int q=i; q<tempSize; q++){
										Card tempCard=(Card) stacks[j].get(i);
										if (moveCheck(tempCard, (Card)stacks[stack-1].get(stacks[stack-1].size()-1),stacks[stack-1])==true){
											stacks[stack-1].add(tempCard);
											stacks[j].remove(i);
											points+=2;
										}
									}
								}
								else{
									stacks[stack-1].add(stacks[j].get(i));
									stacks[j].remove(i);
									points+=2;
									if (stacks[j]==drawn){
										cardsLeft--;
									}
								}
							}
						}
						else{
							System.out.println(moveCheck((Card)stacks[j].get(i),stacks[stack-1]));
							if (moveCheck((Card)stacks[j].get(i), stacks[stack-1])==true){
								if (i!=stacks[j].size()-1){
									Card tempCard=(Card) stacks[j].get(i);
									stacks[stack-1].add(tempCard);
									stacks[j].remove(i);
									int tempSize=stacks[j].size();
									for (int q=i; q<tempSize; q++){
										Card tempCard2=(Card) stacks[j].get(i);
										if (moveCheck(tempCard2,(Card)stacks[stack-1].get(stacks[stack-1].size()-1), stacks[stack-1])==true){
											stacks[stack-1].add(tempCard2);
											stacks[j].remove(i);
											points+=2;
										}
									}
								}
								else{
									stacks[stack-1].add(stacks[j].get(i));
									stacks[j].remove(i);
									points+=2;
								}
							}
							else{
								System.out.println("Error moving cards");
							}
						}
					}
				}
			}
		}
	}

	public String translateSuit(String code){
		String suit;
		String suitCode = Character.toString(code.charAt(code.length()-1));
		if (suitCode.equalsIgnoreCase("0")){
			suit="Hearts";
		}
		else if (suitCode.equalsIgnoreCase("1")){
			suit="Diamonds";
		}
		else if (suitCode.equalsIgnoreCase("2")){
			suit="Clubs";
		}
		else{
			suit="Spades";
		}
		return suit;
	}
	
	public void printStack(){
		
		System.out.println("Size of stacks: " + stacks.length);
		System.out.println(drawn);
	}

	public LinkedList<Pair> ListMoves(){
		LinkedList<Pair> moves = new LinkedList<Pair>();
		Card srcCard;
		Card destCard;
		System.out.println("Possible Moves:");
		for (int j=0; j<stacks.length; j++){ //cycle through source stacks
			//System.out.println(j + " of " + (stacks.length-1));
			for (int i=0; i<largestList();i++){
				//				System.out.println(largestList());
				if (j == 7 || j==8 || j==9 || j==10 || j==11){
					if (stacks[j].size()<=0){
						//System.out.println("hit");
						break;
					}
				}
				if (i<stacks[j].size()){ //keep index within range of stack
					//					System.out.println(i + " < " + stacks[j].size());
					//System.out.println(j + " : " + (stacks.length-1));
					if (j != (stacks.length-1)){
						srcCard = (Card) stacks[j].get(i);
						//System.out.println(srcCard.toString());
					}else{		
						srcCard = (Card) stacks[j].get(stacks[j].size()-1);
						//System.out.println(srcCard.toString());
					}	
					if (srcCard.up){
						for (int k = 0; k < stacks.length-1; k++){ //cycle through destination stacks
							int destStack = k;
							if (stacks[k].size()>0){
								destCard = (Card) stacks[k].get(stacks[k].size()-1);
								if (moveCheck(srcCard, destCard, stacks[k])){
									Pair pair= new Pair(srcCard, k);
									moves.add(pair);
									//System.out.println(srcCard.toString() + " to " + destCard.toString() + " in stack " + (k+1));
								}
							}
							else{
								if (moveCheck(srcCard, stacks[k])){
									//System.out.println(srcCard.toString() + " to stack " + (k+1));
									Pair pair= new Pair(srcCard, k);
									moves.add(pair);
								}
							}
							//System.out.println("Src: " + srcCard);
							//System.out.println("DestStack: " + (k+1));
						}
						break;
					}
				}	
			}
		}
		System.out.println("Possible Moves: " + moves.toString());
		return moves;
	}
	
	public LinkedList<Pair> filterMoves(LinkedList<Pair> moves){
		LinkedList<Pair> filteredMoves = new LinkedList<Pair>();
		String srcCard;
		int dstStack;
		String tempValue;
//		for (int i=0; i<moves.size(); i++){
//			srcCard = moves.get(i).getLeft().toString();
//			dstStack = (int) moves.get(i).getRight();
//			tempValue = moves.get(i).getLeft().toString().split(" ")[0];
//			System.out.println(tempValue + " vs 1");
//			if (tempValue.equals('1')){
//				System.out.println("hi");
//				if (dstStack!=7 && dstStack!=8 && dstStack!=9 && dstStack!=10){
//					filteredMoves.add(moves.get(i));
//				}
//			}
//			else if (!srcCard.substring(0, 2).equals("1")){
//				filteredMoves.add(moves.get(i));
//			}
//		}
//		System.out.println("Filtered Moves: " + filteredMoves.toString());
		return moves;
	}
	
	public void autoMove(){
		LinkedList<Pair> allMoves = ListMoves();
		LinkedList<Pair> filteredMoves = filterMoves(allMoves);
	}
}
