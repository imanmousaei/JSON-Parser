public class Student implements Comparable<Student> {
    private String name;
    private double GPA;

    Student(String name, double GPA) {
        this.name = name;
        this.GPA = GPA;
    }

    @Override
    public int compareTo(Student o) {
        if(this.GPA==o.GPA){
            return o.name.compareTo(this.name);
        }
        return (int)(this.GPA - o.GPA);
    }

    public void print(){
        System.out.println(name + " , " + GPA);
    }
}
