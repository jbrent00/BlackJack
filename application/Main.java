package application;




import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Main extends Application {
	// ImageView for the back of a card
	ImageView backOfCard = new ImageView("/application/PNG-cards-1.3/back.png");
	// Card ImageViews held in an array (Holds all cards in order ace-king, clubs->diamonds->hearts->spades
	ImageView[] picturesOfCards = {new ImageView("/application/PNG-cards-1.3/ace_of_clubs.png"), 
		new ImageView("/application/PNG-cards-1.3/2_of_clubs.png"),
		new ImageView("/application/PNG-cards-1.3/3_of_clubs.png"), new ImageView("/application/PNG-cards-1.3/4_of_clubs.png"),
		new ImageView("/application/PNG-cards-1.3/5_of_clubs.png"), new ImageView("/application/PNG-cards-1.3/6_of_clubs.png"),
		new ImageView("/application/PNG-cards-1.3/7_of_clubs.png"), new ImageView("/application/PNG-cards-1.3/8_of_clubs.png"),
		new ImageView("/application/PNG-cards-1.3/9_of_clubs.png"), new ImageView("/application/PNG-cards-1.3/10_of_clubs.png"),
		new ImageView("/application/PNG-cards-1.3/jack_of_clubs.png"),
		new ImageView("/application/PNG-cards-1.3/queen_of_clubs.png"), new ImageView("/application/PNG-cards-1.3/king_of_clubs.png"),
		new ImageView("/application/PNG-cards-1.3/ace_of_diamonds.png"), new ImageView("/application/PNG-cards-1.3/2_of_diamonds.png"),
		new ImageView("/application/PNG-cards-1.3/3_of_diamonds.png"), new ImageView("/application/PNG-cards-1.3/4_of_diamonds.png"),
		new ImageView("/application/PNG-cards-1.3/5_of_diamonds.png"), new ImageView("/application/PNG-cards-1.3/6_of_diamonds.png"),
		new ImageView("/application/PNG-cards-1.3/7_of_diamonds.png"), new ImageView("/application/PNG-cards-1.3/8_of_diamonds.png"),
		new ImageView("/application/PNG-cards-1.3/9_of_diamonds.png"), new ImageView("/application/PNG-cards-1.3/10_of_diamonds.png"),
		new ImageView("/application/PNG-cards-1.3/jack_of_diamonds.png"), new ImageView("/application/PNG-cards-1.3/queen_of_diamonds.png"),
		new ImageView("/application/PNG-cards-1.3/king_of_diamonds.png"), new ImageView("/application/PNG-cards-1.3/ace_of_hearts.png"),
		new ImageView("/application/PNG-cards-1.3/2_of_hearts.png"), new ImageView("/application/PNG-cards-1.3/3_of_hearts.png"),
		new ImageView("/application/PNG-cards-1.3/4_of_hearts.png"), new ImageView("/application/PNG-cards-1.3/5_of_hearts.png"),
		new ImageView("/application/PNG-cards-1.3/6_of_hearts.png"), new ImageView("/application/PNG-cards-1.3/7_of_hearts.png"),
		new ImageView("/application/PNG-cards-1.3/8_of_hearts.png"), new ImageView("/application/PNG-cards-1.3/9_of_hearts.png"),
		new ImageView("/application/PNG-cards-1.3/10_of_hearts.png"), new ImageView("/application/PNG-cards-1.3/jack_of_hearts.png"),
		new ImageView("/application/PNG-cards-1.3/queen_of_hearts.png"), new ImageView("/application/PNG-cards-1.3/king_of_hearts.png"),
		new ImageView("/application/PNG-cards-1.3/ace_of_spades.png"), new ImageView("/application/PNG-cards-1.3/2_of_spades.png"),
		new ImageView("/application/PNG-cards-1.3/3_of_spades.png"), new ImageView("/application/PNG-cards-1.3/4_of_spades.png"), 
		new ImageView("/application/PNG-cards-1.3/5_of_spades.png"), new ImageView("/application/PNG-cards-1.3/6_of_spades.png"),
		new ImageView("/application/PNG-cards-1.3/7_of_spades.png"), new ImageView("/application/PNG-cards-1.3/8_of_spades.png"),
		new ImageView("/application/PNG-cards-1.3/9_of_spades.png"), new ImageView("/application/PNG-cards-1.3/10_of_spades.png"),
		new ImageView("/application/PNG-cards-1.3/jack_of_spades.png"), new ImageView("/application/PNG-cards-1.3/queen_of_spades.png"),
		new ImageView("/application/PNG-cards-1.3/king_of_spades.png")};
	// Create labels and buttons to display wins and losses, hit or stay, dealer and player total
	Label winsLabel = new Label ("Wins: ");
	Label winsNumber = new Label("0");
	Label lossesLabel = new Label ("Losses: ");
	Label lossesNumber = new Label("0");
	Label tiesLabel = new Label ("Ties: ");
	Label tiesNumber = new Label ("0");
	Button hit = new Button("Hit");
	Button stay = new Button("Stay");
	Button clear = new Button("Clear the Table");
	Label dealerTotal = new Label("Dealer: ");
	Label dealerTotalNumber = new Label("0");
	Label playerTotal = new Label("Player: ");
	Label playerTotalNumber = new Label("0");
	// Create Labels, TextFields, and Button to allow the user to enter how many decks to play with/shuffle, show first card
	Label showFirstCard = new Label("Do you want\nto show the\ndealer's first card?\nEnter true or false: ");
	TextField tfShowFirstCard = new TextField();
	
	Label toShuffle = new Label ("Do you want\nthe deck\nshuffled?\nEnter true\nor false: ");
	
	TextField tfToShuffle = new TextField();
	Button btStart = new Button("Start!");
	// Initial Deck, will be changed based on user input in startTheGame method
	Deck deck = new Deck();
	// Player and dealer objects
	Dealer dealer = new Dealer();
	Player player1 = new Player();
	GridPane gridPane = new GridPane();
	// Data fields for wins, losses, players total, dealers total
	int wins, losses, ties, playersTotal, dealersTotal = 0;
	Deck nonShuffledDeck = new Deck(1, false); // 1 deck, not shuffled, same order as ImageView array
	int index = 0; // Index of card that matches
	boolean dealerFirstCardUp; // Whether dealers first card is up or down
	boolean originalValueFirstCardUp; // value of first card up first entered to start the game
	boolean playerIsDoneHitting; // Boolean to indicate the players score is >= 21
	boolean isShuffled; // Whether deck is shuffled
	
	@Override
	public void start(Stage primaryStage) {
			// Create Rectangle for green background and add to StackPane
			Rectangle background = new Rectangle();
			background.setFill(Color.DARKGREEN);
			StackPane stackPane = new StackPane();
			stackPane.getChildren().add(background);
			// Make the background the size of the stackPane (whole application)
			background.widthProperty().bind(stackPane.widthProperty());
			background.heightProperty().bind(stackPane.heightProperty());
			
			// Create a BorderPane that will go on top of the Green Background
			BorderPane borderPane = new BorderPane();
			
			// Add Labels Dealer, Player, Totals, Wins and Losses to the top of the BorderPane
			HBox hbox = new HBox(20);
			hbox.setAlignment(Pos.CENTER);
			hbox.setMargin(dealerTotal, new Insets(20, 0, 0, 0));
			hbox.setMargin(dealerTotalNumber, new Insets(20, 0, 0, 0));
			hbox.setMargin(playerTotal, new Insets(20, 0, 0, 0));
			hbox.setMargin(playerTotalNumber, new Insets(20, 0, 0, 0));
			hbox.setMargin(winsLabel, new Insets(20, 0, 0, 0));
			hbox.setMargin(winsNumber, new Insets(20, 0, 0, 0));
			hbox.setMargin(lossesLabel, new Insets(20, 0, 0, 0));
			hbox.setMargin(lossesNumber, new Insets(20, 0, 0, 0));
			hbox.setMargin(tiesLabel, new Insets(20, 0, 0, 0));
			hbox.setMargin(tiesNumber, new Insets(20, 0, 0, 0));
			
			winsLabel.setFont(new Font("Arial", 30));
			dealerTotal.setFont(new Font("Arial", 30));
			dealerTotalNumber.setFont(new Font("Arial",30));
			playerTotal.setFont(new Font("Arial", 30));
			playerTotalNumber.setFont(new Font("Arial", 30));
			dealerTotal.setTextFill(Color.WHITE);
			dealerTotalNumber.setTextFill(Color.WHITE);
			playerTotal.setTextFill(Color.WHITE);
			playerTotalNumber.setTextFill(Color.WHITE);
			winsLabel.setTextFill(Color.WHITE);
			winsNumber.setFont(new Font("Arial", 30));
			winsNumber.setTextFill(Color.WHITE);
			lossesLabel.setFont(new Font("Arial", 30));
			lossesLabel.setTextFill(Color.WHITE);
			lossesNumber.setFont(new Font("Arial", 30));
			lossesNumber.setTextFill(Color.WHITE);
			tiesLabel.setFont(new Font("Arial", 30));
			tiesLabel.setTextFill(Color.WHITE);
			tiesNumber.setFont(new Font("Arial", 30));
			tiesNumber.setTextFill(Color.WHITE);
			hbox.getChildren().addAll(dealerTotal, dealerTotalNumber, playerTotal, playerTotalNumber,
					winsLabel, winsNumber, lossesLabel, lossesNumber, tiesLabel, tiesNumber);
			borderPane.setTop(hbox);
			
			// Add Clear Table, Hit, and Stay buttons to the bottom of the BorderPane
			HBox buttonHbox = new HBox(20);
			buttonHbox.getChildren().addAll(hit, stay, clear);
			borderPane.setBottom(buttonHbox);
			buttonHbox.setAlignment(Pos.CENTER);
			buttonHbox.setMargin(hit, new Insets(0, 0, 20, 0));
			buttonHbox.setMargin(stay, new Insets(0, 0, 20, 0));
			buttonHbox.setMargin(clear, new Insets(0, 0, 20, 0));
			hit.setDisable(true);
			stay.setDisable(true);
			clear.setDisable(true);
			
			// Add Labels, TextFields, and Button to VBox for numDecks, shuffled, and process event. Add to borderPane
			VBox vbox = new VBox(5);
			vbox.getChildren().addAll(toShuffle, tfToShuffle, 
					showFirstCard, tfShowFirstCard, btStart);
			borderPane.setRight(vbox);
			vbox.setAlignment(Pos.CENTER);
			toShuffle.setFont(new Font("Arial", 15));
			showFirstCard.setFont(new Font("Arial", 15));
			toShuffle.setTextFill(Color.WHITE);
			showFirstCard.setTextFill(Color.WHITE);
			vbox.setMargin(tfToShuffle, new Insets(0, 10, 0, 0));
			vbox.setMargin(tfShowFirstCard, new Insets(0, 10, 0, 0));
				// Change fitHeight and fitWidth of all ImageView cards
				for (int i = 0; i < picturesOfCards.length; i++) {
					picturesOfCards[i].setFitHeight(200);
					picturesOfCards[i].setFitWidth(100);
				}
			backOfCard.setFitHeight(200);
			backOfCard.setFitWidth(100);
			// Settings for gridPane to hold two rows of cards for dealer and player
			gridPane.setAlignment(Pos.CENTER);
			gridPane.setPadding(new Insets(10, 10, 100, 20));
			gridPane.setHgap(5.5);
			gridPane.setVgap(50);
			
		
			
			
			
			//Add GridPane to the BorderPane
			borderPane.setLeft(gridPane);
			
			// Add the BorderPane to the StackPane
			stackPane.getChildren().add(borderPane);
			borderPane.prefWidthProperty().bind(stackPane.widthProperty());
			borderPane.prefHeightProperty().bind(stackPane.heightProperty());
			
			
			// ACTION EVENT FOR PRESSING START BUTTON
			btStart.setOnAction(e -> startTheGame()); 
			
			// ACTION EVENT FOR PRESSING HIT BUTTON
			hit.setOnAction(e -> hit());
			
			// ACTION EVENT FOR PRESSING STAY BUTTON
			stay.setOnAction(e -> stay());
			
			// ACTION EVENT FOR PRESSING CLEAR BUTTON
			clear.setOnAction(e -> clearTheTable());
			
			// Adds StackPane to the scene, set scene to primaryStage, show primaryStage
			Scene scene = new Scene(stackPane, 1000, 650);
			// Bind pane to scene size
			stackPane.prefHeightProperty().bind(scene.heightProperty());
			stackPane.prefWidthProperty().bind(scene.widthProperty());
			primaryStage.setScene(scene);
			primaryStage.setTitle("BlackJack");
			primaryStage.setResizable(false);
			primaryStage.show();
			
			
			
	}
	
	// Method for start button, starts the game
	private void startTheGame() {
		// Update deck object based on the input, deal 2 cards to dealer and player, display
		
		isShuffled = Boolean.parseBoolean(tfToShuffle.getText());
		dealerFirstCardUp = Boolean.parseBoolean(tfShowFirstCard.getText()); // Update showFirstCard
		originalValueFirstCardUp = dealerFirstCardUp;
		if (isShuffled || !isShuffled) 
			this.deck = new Deck(1, isShuffled);
		
		// Deal two cards each from the deck to the player and dealer's hands
		dealTwoCards();
		index = 0; // Set index back to 0
		// Display the dealers hand. If the input is true, shows the dealers 1st card as well.  
		if (dealerFirstCardUp) {
			for (int i = 0; i < dealer.getHand().getSizeOfHand(); i++) {
				for (int j = 0; j < nonShuffledDeck.getSizeOfDeck(); j++) { // If the ranks and suit match, update the index
					if (dealer.getHand().getCardFromHand(i).getRank() == nonShuffledDeck.getDeck().get(j).getRank()
							&& dealer.getHand().getCardFromHand(i).getSuit() == nonShuffledDeck.getDeck().get(j).getSuit()) {
						gridPane.add(picturesOfCards[j], index, 0);
						index++;
					}
				}
			}
		}	
		else {
			gridPane.add(backOfCard, 0, 0);
			for (int i = 1; i < dealer.getHand().getSizeOfHand(); i++) {
				for (int j = 0; j < nonShuffledDeck.getSizeOfDeck(); j++) { // If the ranks and suit match, update the index
					if (dealer.getHand().getCardFromHand(i).getRank() == nonShuffledDeck.getDeck().get(j).getRank()
							&& dealer.getHand().getCardFromHand(i).getSuit() == nonShuffledDeck.getDeck().get(j).getSuit()) {
						gridPane.add(picturesOfCards[j], (index + 1), 0);
						index++;
					}
				}
			}
		}
		index = 0; // Set index back to 0
		// Third, print the player's cards on the second row
		for (int i = 0; i < player1.getHand().getSizeOfHand(); i++) {
			for (int j = 0; j < nonShuffledDeck.getSizeOfDeck(); j++) { // If the ranks and suit match, update the index
				if (player1.getHand().getCardFromHand(i).getRank() == nonShuffledDeck.getDeck().get(j).getRank()
						&& player1.getHand().getCardFromHand(i).getSuit() == nonShuffledDeck.getDeck().get(j).getSuit()) {
					gridPane.add(picturesOfCards[j], index, 1);
					index++;
				}
			}
		}
		index = 0; // Set index back to 0
		// Display the cards on the screen
		
		
		
		
		/* If the player has BlackJack at the beginning of the game, do not allow them to hit.
		 * Deal cards to the dealer. See who wins. Update wins/losses. Clear cards from hands and
		 * add back to the deck **/
		if (player1.hasBlackJack()) {
			dealer.hitOrStand(deck);
			// Print cards on the screen
			printCardsOnGridPane();
			
			// Update the scores displayed on screen of the Dealer and Player
			dealerTotalNumber.setText(Integer.toString(dealer.getHand().calculateTotal()));
			playerTotalNumber.setText("21");
			if (dealer.getHand().calculateTotal() < 21 || dealer.getHand().calculateTotal() > 21) {
				wins++;
				winsNumber.setText(Integer.toString(wins));
			}
			if (dealer.getHand().calculateTotal() == 21) {
				ties++;
				tiesNumber.setText(Integer.toString(ties));
			}
			clear.setDisable(false); // Only able to click clear button if they have blackjack
			hit.setDisable(true);
			stay.setDisable(true);
		}
		else {	// If the Player doesn't have BlackJack immediately, update the player and dealer totals
			updatePlayerAndDealerTotalScores();
			
			hit.setDisable(false);
			stay.setDisable(false);
		}
		// Disable the start button, do not want user to hit it more than once	
		btStart.setDisable(true);
		
	}
	
	// Method updates the total scores of the dealer and player displayed on the screen
	public void updatePlayerAndDealerTotalScores() {
		if (dealerFirstCardUp) { // If their first card is up, display total of entire hand
			dealerTotalNumber.setText(Integer.toString(dealer.getHand().calculateTotal()));
			playerTotalNumber.setText(Integer.toString(player1.getHand().calculateTotal()));
		}	
		else { // If first card is down, display total of the cards that are up
			
			if (dealer.getHand().getCardFromHand(1).getRank() > 10) { // Ranks 1, 11, 12, 13 are ace, jack, king, queen
				dealerTotalNumber.setText("10");
				playerTotalNumber.setText(Integer.toString(player1.getHand().calculateTotal()));
			}
			else if (dealer.getHand().getCardFromHand(1).getRank() == 1) {
				dealerTotalNumber.setText("11");
				playerTotalNumber.setText(Integer.toString(player1.getHand().calculateTotal()));
			}
			else {
				dealerTotalNumber.setText(Integer.toString(dealer.getHand().getCardFromHand(1).getRank()));
				playerTotalNumber.setText(Integer.toString(player1.getHand().calculateTotal()));
			}
		}
	}
			
	
	// Player hits
	public void hit() {
		if (player1.getHand().calculateTotal() < 21) { // Only allow this method to execute if player's hand < 21
			player1.getHand().takeCard(deck); // Takes a card from the deck, adds to players hand
			printCardsOnGridPane(); // Clear old ImageViews, print the new ImageViews of cards on screen
			updatePlayerAndDealerTotalScores(); // Update the scores displayed after the player hits
			// If the player has 21 or higher, disable hit and stay button, automatically hit for dealer
			if (player1.getHand().calculateTotal() >= 21) {
				hit.setDisable(true); // Disable hit button
				stay.setDisable(true); // Disable stay button
				dealer.hitOrStand(deck); // Dealer will hit
				dealerFirstCardUp = true; // We want to show the first card here at the end of the round
				printCardsOnGridPane(); // Display the updated cards on gridPane
				dealerFirstCardUp = originalValueFirstCardUp;
				dealerTotalNumber.setText(Integer.toString(dealer.getHand().calculateTotal())); // Update dealer score on screen
				winOrLose(); // Update Win/Losses/Ties
				clear.setDisable(false);
			}	
		}
	}
	
	// Method to stay for the player
	public void stay() {
		// Automatically hit for the dealer now 
		dealer.hitOrStand(deck); // Dealer will hit
		dealerFirstCardUp = true; // We want to show the first card here at the end of the round
		printCardsOnGridPane(); // Display the updated cards on gridPane
		dealerFirstCardUp = originalValueFirstCardUp;
		dealerTotalNumber.setText(Integer.toString(dealer.getHand().calculateTotal())); // Update dealer score on screen
		winOrLose(); // Update Win/Losses/Ties
		stay.setDisable(true); // want to disable the button after you click it once
		hit.setDisable(true); // want to disable the hit button after you click stay
		clear.setDisable(false);
	}
	
	// Method for Clear button
	public void clearTheTable() {
		// Add the cards in the hands back to the deck
		player1.getHand().addHandToDeck(deck);
		dealer.getHand().addHandToDeck(deck);
		// Clear the player and dealers hands
		player1.getHand().removeCards();
		dealer.getHand().removeCards();
		// If the user entered to shuffle the deck, re-shuffle the deck
		if (isShuffled)
			deck.shuffleDeck();
		
		// Now, we need to deal cards to the player and dealer, perform hits for dealer if player has BlackJack
		dealTwoCards();
		dealerFirstCardUp = originalValueFirstCardUp; // Set it back to the original value 
		printCardsOnGridPane(); // Display cards 
		
			/* Code below is the same as start button, besides disabling start button **/
		if (player1.hasBlackJack()) {
			dealer.hitOrStand(deck);
			// Print cards on the screen
			dealerFirstCardUp = true;
			printCardsOnGridPane();
			dealerFirstCardUp = originalValueFirstCardUp;
			// Update the scores displayed on screen of the Dealer and Player
			dealerTotalNumber.setText(Integer.toString(dealer.getHand().calculateTotal()));
			playerTotalNumber.setText("21");
			if (dealer.getHand().calculateTotal() < 21 || dealer.getHand().calculateTotal() > 21) {
				wins++;
				winsNumber.setText(Integer.toString(wins));
			}
			if (dealer.getHand().calculateTotal() == 21) {
				ties++;
				tiesNumber.setText(Integer.toString(ties));
			}
			hit.setDisable(true);
			stay.setDisable(true);
			clear.setDisable(false);
		}
		else {	// If the Player doesn't have BlackJack immediately, update the player and dealer totals
			updatePlayerAndDealerTotalScores();
			hit.setDisable(false);
			stay.setDisable(false);
			clear.setDisable(true);
		}
		
	}
	
	// Method clears the old ImageViews and displays the ImageViews of the dealer and player's card on the gridPane
	public void printCardsOnGridPane() {
		// First, clear the gridPane
		gridPane.getChildren().clear();
		// Second, print the dealer's cards on the first row
		index = 0; // Set index back to 0
		
		// ArrayList to store the indexes of dealers cards. Needed for duplicate ImageViews. Implementing Later
		
		
		// Display the dealers hand. If the input is true, shows the dealers 1st card as well.  
		if (dealerFirstCardUp) {
			for (int i = 0; i < dealer.getHand().getSizeOfHand(); i++) {
				for (int j = 0; j < nonShuffledDeck.getSizeOfDeck(); j++) { // If the ranks and suit match, update the index
					if (dealer.getHand().getCardFromHand(i).getRank() == nonShuffledDeck.getDeck().get(j).getRank()
							&& dealer.getHand().getCardFromHand(i).getSuit() == nonShuffledDeck.getDeck().get(j).getSuit()) {
						gridPane.add(picturesOfCards[j], index, 0);
						index++;
						
					}
				}
			}
		}	
		else {
			gridPane.add(backOfCard, 0, 0);
			for (int i = 1; i < dealer.getHand().getSizeOfHand(); i++) {
				for (int j = 0; j < nonShuffledDeck.getSizeOfDeck(); j++) { // If the ranks and suit match, update the index
					if (dealer.getHand().getCardFromHand(i).getRank() == nonShuffledDeck.getDeck().get(j).getRank()
							&& dealer.getHand().getCardFromHand(i).getSuit() == nonShuffledDeck.getDeck().get(j).getSuit()) {
						gridPane.add(picturesOfCards[j], (index + 1), 0);
						index++;
					}
				}
			}
		}
		index = 0; // Set index back to 0
		// Third, print the player's cards on the second row
		for (int i = 0; i < player1.getHand().getSizeOfHand(); i++) {
			for (int j = 0; j < nonShuffledDeck.getSizeOfDeck(); j++) { // If the ranks and suit match, update the index
				if (player1.getHand().getCardFromHand(i).getRank() == nonShuffledDeck.getDeck().get(j).getRank()
						&& player1.getHand().getCardFromHand(i).getSuit() == nonShuffledDeck.getDeck().get(j).getSuit()) {
					// Check if the dealer/player have any same exact cards, will throw exception if they do because two identical ImageView objects
					
					gridPane.add(picturesOfCards[j], index, 1);
					index++;
				}
			}
		}
		index = 0; // Set index back to 0
	}
	
	// Method determines who won the game, and updates the wins and losses based on this determination
	public void winOrLose() {
		if (player1.getHand().calculateTotal() < dealer.getHand().calculateTotal() && 
				dealer.getHand().calculateTotal() <= 21) { // Dealer has higher score than player, didn't bust
					losses++;
					lossesNumber.setText(Integer.toString(losses));
			}	
			else if (player1.getHand().calculateTotal() > 21 && dealer.getHand().calculateTotal() <= 21) { // Player busted, dealer under 22
				losses++;
				lossesNumber.setText(Integer.toString(losses));
			}
			else if (dealer.getHand().calculateTotal() < player1.getHand().calculateTotal() && 
					player1.getHand().calculateTotal() <= 21) { // Player has higher score than dealer, didn't bust
				wins++;	
				winsNumber.setText(Integer.toString(wins));
			}	
			else if (dealer.getHand().calculateTotal() > 21 && player1.getHand().calculateTotal() <= 21) {
					// Dealer busted, player under 22
				wins++;
				winsNumber.setText(Integer.toString(wins));
			} 														
			else if (player1.getHand().calculateTotal() == dealer.getHand().calculateTotal() &&
					player1.getHand().calculateTotal() <= 21) { // Player and dealer have same score, didn't bust
				ties++;
				tiesNumber.setText(Integer.toString(ties));

			}
			else {   // Dealer and player both busted
				ties++;	
				tiesNumber.setText(Integer.toString(ties));

			}	
	}
	
	// Deals two cards to start the game 
	public void dealTwoCards() {
		player1.getHand().takeCard(deck);
		dealer.getHand().takeCard(deck);
		player1.getHand().takeCard(deck);
		dealer.getHand().takeCard(deck);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}

