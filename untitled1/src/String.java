
public class String {
    double x1;
    double y1;
    double x2;
    double y2;
    public String(){
        this.x1=0.0;
        this.y1=0.0;
        this.x2=0.0;
        this.y2=0.0;
    }
    public double getValue_x1()
    {
        return this.x1;
    }
    public double getValue_y1()
    {
        return this.y1;
    }
    public double getValue_x2()
    {
        return this.x2;
    }
    public double getValue_y2()
    {
        return this.y2;
    }
    public void setValue(double a,double b,double c,double d){
        this.x1=a;
        this.y1=b;
        this.x2=c;
        this.y2=d;
    }
    public java.lang.String tostring()
    {
        java.lang.String norm ="(("+this.x1+','+this.y1+")("+this.x2+','+this.y2+"))";
        return(norm);

    }
}
