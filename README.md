# Graph Java Application

- **Name:** Marlon Enrique Avila Madrid
- **Account Number:** 20211021353
- **Classname:** Algorithms and Data Structures

## Requirements

- Investigue y desarrolle un programa usando Proyectos de Eclipse y Java 17 que aplique los conocimientos de esta asignatura, incluyendo el conocimiento de Algoritmos, Estructuras de Datos y A/D/POO (interfaces, herencia, clases, polimorfismo, serialización, etc).  En su entregable debe incluir un AOO mediante un archivo readme.md el cual debe contener un análisis propio donde usted describe extensivamente los componentes que ha diseñado y que debe crear para resolver el sistema; debe incluir un proyecto de Eclipse con todo el código fuente, e incluir un archivo .jar del proyecto exportado como un ejecutable de Java. Incluya en su código comentarios de javadoc.

- Haga un programa de consola que simule una Consola/Terminal donde se reciben instrucciones de texto por parte del usuario. El sistema deberá gestionar un Grafo mediante Mapas, permitiendo crear vértices, crear aristas, listar vértices, listar las aristas de un vértice y confirmar cuántas y cuáles rutas existen para llegar desde un vértice origen hacia un vértice destino.

- Su sistema debe contener un mensaje de bienvenida el cual se puede invocar en cualquier momento usando el comando "help". Su mensaje de bienvenida debe ser original y debe describir al usuario de qué se trata el sistema y cómo usarlo. Se debe incluir un comando exit que finaliza el sistema.

- Su programa debe ser capaz de ser autónomo y seguir funcionando aunque el usuario ingrese comandos incorrectos. Su programa deberá poder recodar todas las acciones del usuario mediante un archivo DATASTORAGE.AAAA, donde en lugar de la extensión AAAA hará uso de las iniciales de su nombre en mayúscula usando 4 caracteres obligatoriamente. Si usted posee únicamente 3 nombres use un caracter adicional de alguno de sus nombres para completar el caracter faltante.

- Incluya en la carpeta Evidencias, screenshots que muestran evidencias del funcionamiento de su sistema. Los screenshots deben ser de pantalla completa incluyendo todo su escritorio de Linux.

## Planteamiento

Primero analicemos exactamente que ocupa la clase Main y que funciones ejecutará.

### Class Main

Gestion de Grafos mediante mapas

`` Viewed abstractly, a graph G is simply a set V of vertices and a collection E
of pairs of vertices from V, called edges. Thus, a graph is a way of representing
connections or relationships between pairs of objects from some setV. Incidentally,
some books use different terminology for graphs and refer to what we call vertices
as nodes and what we call edges as arcs. We use the terms “vertices” and “edges.”
Edges in a graph are either directed or undirected. An edge (u,v) is said to
be directed from u to v if the pair (u,v) is ordered, with u preceding v. An edge
(u,v) is said to be undirected if the pair (u,v) is not ordered. Undirected edges are
sometimes denoted with set notation, as {u,v}, but for simplicity we use the pair
notation (u,v), noting that in the undirected case (u,v) is the same as (v,u). Graphs
are typically visualized by drawing the vertices as ovals or rectangles and the edges
as segments or curves connecting pairs of ovals and rectangles. The following are
some examples of directed and undirected graphs.
 ``

Funciones a ejecutar:

- Crear Vertices.
- Crear Aristas.
- Listar Vertices.
- Listar Aristas de un Vertice.
- Confirmar cuantas y cuales rutas existen para llegar desde un vertice origen hacia un vertice destino.

Comandos a ejecutar:

- **help**: Muestra un mensaje de bienvenida.
- **exit**: Finaliza el sistema.
- **cls**: Limpia la consola.
- **add vertex A**: Crea un vertice.
- **add edge A B**: Crea una arista.
- **list vertex**: Lista los vertices.
- **list edge A**: Lista las aristas de un vertice.
- **path A B**: Lista todas las aristas.

### Class Graph

Este contendra un mapa con los vertices y aristas del grafo.

Las keys serán los vertices y los values serán las edges.

Los edges serán un LinkedList de vertices. Por el momento usaremos strings y no una clase Vertex.

`` A graph G is a pair (V,E), where V is a set of vertices and E is a set of edges, formed by pairs of vertices from V. The set V is called the vertex set of G, and E is called the edge set of G. The number of vertices in V is called the order of G, and the number of edges in E is called the size of G. ``

Esta clase tendría los siguientes métodos:

| Method | Return Value |
| ------ | ------ |
| addVertex(V vertex) | void |
| addEdge(V vertex1, V vertex2) | void |
| removeVertex(V vertex) | void |
| listVertex() | void |
| listEdge(V vertex) | void |
| path(V vertex1, V vertex2) | void |

#### Método Path

`` A path in a graph G is a sequence of vertices v1, v2, . . . , vn such that (vi,vi+1) is an edge in G for all i = 1, 2, . . . , n − 1. The length of a path is the number of edges in the path. A path is simple if all the vertices in the path are distinct. A cycle in a graph G is a path of length at least 1 in which the first and last vertices are the same. A graph is acyclic if it has no cycles. ``

Para evitar que el método path se vuelva recursivo, usaremos un método auxiliar que nos permita recorrer el grafo y encontrar el camino más corto entre dos vertices.

Por los momentos usaremos un linked list para almacenar los vertices que ya han sido visitados y tambien usaremos un linked list para almacenar los caminos posibles entre dos vertices.

#### Método Auxiliar

`` A graph G is connected if there is a path from every vertex to every other vertex in G. A graph G is strongly connected if there is a path from every vertex to every other vertex in G, and there is also a path from every vertex to every other vertex in the reverse direction. ``

Para encontrar el camino más corto entre dos vertices, usaremos el algoritmo de Dijkstra.

`` Dijkstra’s algorithm is a method for finding the shortest path between two vertices in a graph. The algorithm works only for graphs with nonnegative edge weights. The algorithm maintains a set S of vertices whose final shortest-path weights from the source s have already been determined. The algorithm repeatedly selects the vertex u ∈ V − S with the minimum shortest-path estimate, adds u to S, and relaxes all edges leaving u. The algorithm maintains the following loop invariant: At the start of each iteration of the while loop, the set S contains the vertices whose final shortest-path weights from the source s have already been determined. ``

Para implementar el algoritmo de Dijkstra, usaremos una cola de prioridad, la cual nos permitirá ordenar los vertices por su peso.

`` A priority queue is a queue in which each element is assigned a priority and elements are removed from the queue according to their priority. ``

Para implementar la cola de prioridad, usaremos una clase Priority Queue, la cual nos permitirá ordenar los vertices por su peso.

`` A priority queue is a queue in which each element is assigned a priority and elements are removed from the queue according to their priority. ``




### Class JSON

Empezamos con la clase JSON, la cuál sera la encargada de guardar los vertices y aristas en un archivo JSON.

Por los momentos usaremos el paquete Map, el cual nos permite crear un mapa de objetos, en este caso, un mapa de vertices y aristas.





### ...

### Class Map

`` A map is an abstract data type that stores associations between keys and values, or key/value pairs. The association between a key and a value is called a map entry. The keys in a map are all unique, but the values may not be. The keys are used to find the associated values, so they must be comparable. The values can be any type.``

Partiendo de esto podemos decir que la clase Mapa es la encargada de gestionar los vertices y aristas del grafo. Pensemos primero que funciones o métodos debe tener esta clase.

Según lo esperado, la clase Mapa debe tener los siguientes métodos:

| Method | Return Value |
| ------ | ------ |
| isEmpty() | boolean |
| put(K key, V value) | V |
| get(K key) | V |
| remove(K key) | V |
| size() | int |
| keySet() | Set< K > |
| values() | Collection< V > |

Para crear la clase Mapa, primero debemos crear la Value Class, la cual será la encargada de almacenar los valores de los vertices y aristas.

### Class Value

`` A value class is a class whose main purpose is to hold data. Value classes are final, immutable, and have no identity. They are final because they are not designed to be extended. They are immutable because they have no setter methods. They have no identity because two value objects with the same values are considered equal.``

La clase Value debe tener los siguientes métodos:

| Method | Return Value |
| ------ | ------ |
| getValue() | V |
| setValue(V value) | void |

Y tendrá los siguientes atributos:

| Attribute | Type |
| ------ | ------ |
| value | V |


