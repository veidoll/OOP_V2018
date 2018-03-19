package no.hiof.larseknu.game;

import java.util.ArrayList;
import java.util.Random;

public class PlayerCharacter
{
    public int health;
    public String name;
    public String nickName;
    public boolean isNoob;
    public ArrayList<String> weapons;

    public PlayerCharacter()
    {
        name = generateName();

        isNoob = true;

        createStartingWeapons();
    }



    public void sleep()
    {
        Random random = new Random();

        int healthIncrease = random.nextInt(100);

        health += healthIncrease;
    }

    public void takeDamage(int damage)
    {
        health = Math.max(1, health -= damage);
    }

    private String generateName()
    {
        String[] names = new String[]
        {
            "Danieth",
            "Derick",
            "Shalnorr",
            "G'Toth'lop",
            "Boldrakteethtop"
        };

        return names[new Random().nextInt(names.length)];
    }

    private void createStartingWeapons()
    {
        ArrayList<String> startingWeapons = new ArrayList<>();

        startingWeapons.add("Long Bow");
        startingWeapons.add("Short Bow");
        startingWeapons.add("Short Sword");
        //startingWeapons.add("Long Bow");
        //startingWeapons.add("Staff Of Wonder");

        weapons = startingWeapons;

    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        if (nickName.equals("Penis"))
            throw new ProfanityException();
        else
            this.nickName = nickName;
    }

    public boolean isNoob() {
        return isNoob;
    }

    public void setNoob(boolean noob) {
        isNoob = noob;
    }

    public ArrayList<String> getWeapons() {
        return weapons;
    }
}
