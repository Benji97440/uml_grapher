package fr.lernejo.umlgrapher;

import java.lang.reflect.Modifier;
import java.util.Set;

public class MermaidFormatter {
    private final Set<UmlType> types;

    MermaidFormatter(Set<UmlType> types){
        this.types = types;
    }

    public String MyString(){
        String chaine = "classDiagram\n";
        for(UmlType s: types){
            chaine +="class " + s.name();
            if(Modifier.isInterface(s.my_class().getModifiers())){
                chaine += " {\n    <<interface>>\n}";
            }
            chaine += "\n";
        }
        return chaine;
    }
}
