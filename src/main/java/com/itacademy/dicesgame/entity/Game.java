package com.itacademy.dicesgame.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="game")
public class Game implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int dice_value1;
    private int dice_value2;

    private boolean win;

    private Long player_id;

    public Game(Long player_id) {
        this.player_id = player_id;
    }

    public int getDice_value1() {
        return dice_value1;
    }

    public void setDice_value1(int dice_value1) {
        this.dice_value1 = dice_value1;
    }

    public int getDice_value2() {
        return dice_value2;
    }

    public void setDice_value2(int dice_value2) {
        this.dice_value2 = dice_value2;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public Long getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(Long player_id) {
        this.player_id = player_id;
    }

    public void rollDices(){
        this.dice_value1 = getRandomBetweenOneAndSix();
        this.dice_value2 = getRandomBetweenOneAndSix();
        calculateResult();
    }

    public void calculateResult(){
        if(this.dice_value1 + this.dice_value2 == 7){
            this.win = true;
        } else{
            this.win = false;
        }
    }

    public int getRandomBetweenOneAndSix(){
        int random = (int) Math.floor(Math.random() * 6 + 1);
        return random;
    }
}
