package fr.lernejo.umlgrapher;

import java.util.*;

public class UmlGraph {
    private final Class<?>[]  class_name;
    private final Set<UmlType> types = new TreeSet<>(Comparator
        .<UmlType, String>comparing(t->t.name())
        .thenComparing(t->t.packageName()));
    private Set<MermaidLiaison> liaisons = new TreeSet<>(Comparator
        .<MermaidLiaison, String>comparing(t->t.getChildClass())
        .thenComparing(t->t.getParentClass()));

    public UmlGraph(Class... class_name){

        this.class_name = class_name;
    }
    public String as(GraphType graphType) {
        List<Class> my_classList = null;
        for (Class class_n : class_name) {
            switch (graphType) {
                case Mermaid:
                    my_classList = new InternalGraphRepresentation(class_n).whats_your_relation();
                    for (Class i : my_classList) {
                        types.add(new UmlType(i));
                    }
                    break;
            }
        }
        return new MermaidFormatter(types).MyString() + new UmlRelation(types).allRelation(liaisons,types);//
    }
}
