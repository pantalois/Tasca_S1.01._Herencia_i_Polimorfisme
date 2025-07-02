package TascaS1_01.Exercici_1;


public class Soccer extends News{
    public String tournament;
    public String club;
    public String player;
    static int initialPrice;


    public Soccer(String headline, String text, int price, int points, String tournament, String club, String player){

        this.tournament = tournament;
        this.club = club;
        this.player = player;
    }
}