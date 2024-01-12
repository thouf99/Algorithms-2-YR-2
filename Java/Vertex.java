import java.util.ArrayList;

public class Vertex {
    public String name;
    public ArrayList<Edge> adjlist;
    public boolean hit;

    public Vertex(String _name) {
        this.name = _name;
        this.adjlist = new ArrayList<Edge>();
    }

    public boolean isHit(){
        return this.hit;
    }

    public void setHit(boolean item){
        this.hit = item;
    }

}

