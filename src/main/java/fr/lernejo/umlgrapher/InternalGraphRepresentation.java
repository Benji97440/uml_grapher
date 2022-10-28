package fr.lernejo.umlgrapher;

import java.util.List;
import java.util.Set;

public class InternalGraphRepresentation {
    private final Class myclass;

    InternalGraphRepresentation(Class myclass){
        this.myclass = myclass;
    }
    public List<Class> recursive_relation(List<Class> recursiveList,Class... otherClasses){
        for(Class i : otherClasses){
            recursiveList.add(i);
            ChildProcess childProcess = new ChildProcess(i);

            recursiveList = recursive_Child(recursiveList, childProcess.getChild());
            recursiveList = recursive_Parent(recursiveList,i.getInterfaces());
        }
        return recursiveList;
    }
    public List<Class> recursive_Parent(List<Class> recursiveList, Class... otherClasses){
        for(Class i : otherClasses){
            if(!recursiveList.contains(i)) {
                recursiveList.add(i);
                recursiveList = recursive_relation(recursiveList,i.getInterfaces());
            }
        }
        return recursiveList;
    }
    public List<Class> recursive_Child(List<Class> recursiveList, Set<Class<?>> all_child){
        for(Class j :all_child) {
            if (!recursiveList.contains(j)) {
                recursiveList.add(j);
                recursiveList = recursive_relation(recursiveList, j);
            }
        }
        return recursiveList;
    }

    public List<Class> whats_your_relation(List<Class> myList){
        myList = recursive_relation(myList,this.myclass);
        return myList;
    }
}
