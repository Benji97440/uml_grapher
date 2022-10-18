package fr.lernejo.umlgrapher;

public class UmlGraph {
    private final Class[] class_name;
    public UmlGraph(Class... class_name){
        this.class_name = class_name;
    }
    public String as(GraphType graphType){
        String chaine = "classDiagram\n";
        for (Class class_n : class_name) {
            switch (graphType) {
                case Mermaid:
                    chaine = chaine + "class " + class_n.getSimpleName() + " {\n";
                    if (class_n.isInterface()) {
                        chaine = chaine + "    <<interface>>\n";
                    }
                    chaine = chaine + "}\n";
                    break;
            }
        }
        return chaine;
    }
}
