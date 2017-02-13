

@Service(name = "VeryHardWorkService")
public class HardWorkService {

    @Init
    public void hardWork(){
        try {
            System.out.println("Hard Work");
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
