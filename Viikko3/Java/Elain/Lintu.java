 public class Lintu extends Elain{
    // Lintu herää ja lepää kuin mikä tahansa muukin eläin mutta
    // Lintu määrittelee itse miten toimii (overrides toimii)

    public Lintu(String aNimi){
        super(aNimi);
    }


    @Override
    public void toimi(){
        // super.toimi();
        System.out.println(mNimi + " lentää!");
    }
}
