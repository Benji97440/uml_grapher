package fr.lernejo.umlgrapher;

import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ConfigurationBuilder;

import java.util.List;
import java.util.Set;

public class ChildProcess {
    private final Class myclass;
    private final Reflections reflections;

    public ChildProcess(Class myclass){
        this.myclass = myclass;
        this.reflections = new Reflections((new ConfigurationBuilder()
            .forPackage("")
            .forPackage("", myclass.getClassLoader())
        ));
    }
    public Set<Class<?>> getChild(){
        Set<Class<?>> subTypes = reflections.get(
            Scanners.SubTypes
                .get(myclass)
                .asClass(this.getClass().getClassLoader(), myclass.getClassLoader())
        );
        return subTypes;
    }
}
