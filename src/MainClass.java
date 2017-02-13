import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainClass {

    public static void main(String[] args) {
        loadService(EasyWorkService.class);
        loadService(HardWorkService.class);
        loadService(String.class);
    }


    static void loadService(Class<?> service){
        if(service.isAnnotationPresent(Service.class)){
            Service s = service.getAnnotation(Service.class);
            System.out.println("Annotation name is " + s.name());
            Method[] methods = service.getMethods();
            for(Method method : methods){
            if(service.isAnnotationPresent(Init.class)){

            }

            }
        } else System.out.println("Sorry. " + service.getName() + ".class don't use annotation @Service");
    }
}

