package fr.lernejo.umlgrapher;

public class MermaidLiaison {
    private final String ChildClass;
    private final String ParentClass;
    private final String my_liason;

    public MermaidLiaison(Class ParentClass,Class ChildClass,String my_liason){
        this.ChildClass = ChildClass.getSimpleName();
        this.ParentClass = ParentClass.getSimpleName();
        this.my_liason = my_liason;
    }

    public String getChildClass(){
        return this.ChildClass;
    }

    public String getParentClass(){
        return this.ParentClass;
    }
    public String getMy_liason(){
        return this.my_liason;
    }

}
