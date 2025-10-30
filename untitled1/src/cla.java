public class cla {
    private double x;
    private double y;
    public cla(){
        this.x=0.0;
        this.y=0.0;
    }
    public double getValue_x()
    {
        return this.x;
    }
    public double getValue_y()
    {
        return this.y;
    }
    public void setValue(double x,double y){
        this.x=x;
        this.y=y;
    }
    public int Quand()
    {
        if(this.x>0){if(this.y>0){return 1;} else{return 4;}}
        else if(this.x<0){if(this.y>0){return 2;} else{return 4;}}
        else{return 0;}
    }
    public double mhatt(double x, double y)
    {
        double mat;
        mat=Math.abs(x-this.x)+Math.abs(y-this.y);
        return mat;
    }

}
