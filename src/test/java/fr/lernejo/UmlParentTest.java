package fr.lernejo;

import fr.lernejo.umlgrapher.GraphType;
import fr.lernejo.umlgrapher.UmlGraph;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UmlParentTest {
    @Test
    void empty_interface_with_relation_Parent() {
        Class<?>[] user_class = {fr.lernejo.Living.Animal.Ant.class,fr.lernejo.Living.Animal.Cat.class,fr.lernejo.Living.Plant.Tree.Alder.class};
        UmlGraph graph = new UmlGraph(user_class);
        String output = graph.as(GraphType.Mermaid);

        Assertions.assertThat(output).isEqualTo("""
            classDiagram
            class Alder
            class Animal {
                <<interface>>
            }
            class Ant
            class Cat
            class Living {
                <<interface>>
            }
            class Plant {
                <<interface>>
            }
            class Tree {
                <<interface>>
            }
            Tree <|.. Alder : implements
            Living <|-- Animal : extends
            Animal <|.. Ant : implements
            Animal <|.. Cat : implements
            Living <|-- Plant : extends
            Plant <|-- Tree : extends            
            """);
    }
}
