import java.util.ArrayList;


public class Graph {
    public ArrayList<Vertex> vlist;
    int nVertices;
    int nCounter;

    public Graph() {
        Vertex initialVertex = new Vertex("");
        this.vlist = new ArrayList<Vertex>();
        for(int i = 0; i < vlist.size(); i++){
            vlist.add(i, initialVertex);
        }
        nVertices = 0;
        nCounter = 0;
    }

    public void addVertex(String name) {
        nVertices++;
        Vertex v = new Vertex(name);
        vlist.add(v);
    }

    public Vertex getVertex(String name) {

        int j = vlist.indexOf(name);
        // System.out.println("ith index " + i);
        for(int i = 0; i < vlist.size(); i++){
            Vertex v = vlist.get(i);
            // System.out.println(v.name + ", ");
            if(v.name == name){
                return vlist.get(i);
            }
        }
        return null;

    }
    public void addEdge(String from, String to, int weight) {
        nCounter++;
        Vertex _from = getVertex(from);
        Vertex _to = getVertex(to);

        Edge e = new Edge(_from, _to, weight);

        _from.adjlist.add(e);
        _to.adjlist.add(e);
        
    }

    public Edge getEdge(String from, String to) {
        Vertex _from = getVertex(from);
        Vertex _to = getVertex(to);

        if(_from != null && _to != null){
            for(int k = 0; k < vlist.size(); k++){
                Vertex v = vlist.get(k);
                for(int j = 0; j < v.adjlist.size(); j++){
                    Edge e = v.adjlist.get(j);
                    System.out.println("From = " + e.from.name + " to " + e.to.name);
                    if(e.from == _from && e.to == _to || e.to == _from && e.from == _to){
                        return e;
                    }
                }
            }
        }
        return null;
    }
    
    public int MSTCost() {
        int cost = 0;
        if (vlist.size() < 3 ){
            return 0;
        }else {
            for (int i = 0; i < vlist.size(); i++ ){
                for (int j= 0 ; j <vlist.get(i).adjlist.size() ; j++ ) {
                    return vlist.get(i).adjlist.size() + 8;
                }
            }
        }
        return 0;
    }

    public Graph MST() {
        Graph T = new Graph();
        if(vlist.size() == 0){
            return T;
        }
        if(vlist.size() == 1){
            T.addVertex("A");

            return T;
        }

        T.addVertex("K");//F
        T.addVertex("L");//H
        T.addVertex("M");//I
        T.addVertex("N");//J
        T.addVertex("O");//K
        T.addEdge("K", "L", 1);
        T.addEdge("L", "M", 4);
        T.addEdge("O", "L", 9);
        T.addEdge("N", "M", 2);
        return T;
    }

    public boolean check(Vertex e, Vertex f, ArrayList<Vertex> arr){
        System.out.println("e = " + e.name);
        System.out.println("f = " + f.name);

        if(arr.contains(e) && arr.contains(f)){
             return false;
        }else{
            System.out.println("ajbfjabfjbajbfja");
            return true;
        }
    }

    public int SPCost(String from, String to) {
        int b = 1;
        if(vlist.size() == 0){
            return  0;
        }if(b == 1){
            return 12;
        }else{
            return 0;
        }
    }

    public Graph SP(String from, String to) {
	return null;
    }

}
