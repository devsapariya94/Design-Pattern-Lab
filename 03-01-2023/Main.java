import java.util.List;
import java.util.ArrayList;

class Industry {
    private String name;
    private List<Applicant> applicants;

    public Industry(String name) {
        this.name = name;
        this.applicants = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<Applicant> getApplicants() {
        return this.applicants;
    }

    public void addApplicant(Applicant applicant) {
        this.applicants.add(applicant);0
    }

    public void printApplicants(){
        System.out.println("Applicants for industry " + name + ":");
        for (Applicant applicant : applicants) {
            System.out.println(applicants.getName());
        }
    }

    public List<Applicant> printApplcantsWithExperienceMoreThan5Years(){
        System.out.println("Applicants for industry " + name + " having experience more than 5 years are: ");
        for (Applicant applicant : applicants) {
            if(applicants.getExperience()>=5){
                System.out.println(applicants.getName()+" -> Experience :"+applicants.getExperience());
            }
            
        }
    }
}

class Applicant {
    private String name;
    private int experience;

    public Applicant(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }
}

public class test{
    public static void main(String[] args) {
        Industry IT =new Industry("IT");
        Applicant a1=new Applicant("Shubham Patel", 5);
        IT.addApplicant(a1);
        Applicant a2=new Applicant("dev sapariya", 1);
        IT.addApplicant(a2);
        Applicant a3=new Applicant("soban", 10);
        IT.addApplicant(a3);

    }
}