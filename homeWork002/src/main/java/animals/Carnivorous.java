package animals;
//плотоядное
public abstract class Carnivorous extends Animal {
    private String name;
    private String voice;
    @Override
    public String getVoice(){
        return voice;
    }

    public String getName(){
        return name;
    }
}
