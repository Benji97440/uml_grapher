package fr.lernejo.umlgrapher;

import java.util.concurrent.Callable;

public class UmlType {
    private final Class my_class;
    private final String name;
    private final String packageName;
    UmlType(Class my_class ){
        this.my_class = my_class;
        this.name = my_class.getSimpleName();
        this.packageName = my_class.getPackageName();
    }
    public Class my_class(){ return this.my_class;}
    public String name() {
        return this.name;
    }

    public String packageName() {
        return this.packageName;
    }
}
