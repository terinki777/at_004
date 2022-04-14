package animals;
//травоядное
public class Herbivore extends Animal {
    private String name;
    private String voice;
    @Override
    public String getVoice(){
        return voice;
    }
    public String getName() {

        return name;
    }
}
