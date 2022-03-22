package homework;

public  class Edge  {
    private int cost, nod1, nod2;

    Edge(Integer nod1, Integer nod2, Integer cost){
        this.nod1 = nod1;
        this.nod2 = nod2;
        this.cost = cost;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getNod1() {
        return nod1;
    }

    public void setNod1(Integer nod1) {
        this.nod1 = nod1;
    }

    public Integer getNod2() {
        return nod2;
    }

    public void setNod2(Integer nod2) {
        this.nod2 = nod2;
    }



    public String toString(){
        return "Muchia  " + Integer.toString(this.nod1) +" " + Integer.toString(this.nod2)+" cu costul : " + Integer.toString(this.cost);
    }

}
