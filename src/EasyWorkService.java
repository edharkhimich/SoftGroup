
@Service(name = "VerySuperEasyWorkService")
public class EasyWorkService {

    @Init
    public void initWork(){
        System.out.println("Init Work");
    }

    public void initWorkWithoutInit(){
        System.out.println("InitWorkWithoutInit");
    }
}
