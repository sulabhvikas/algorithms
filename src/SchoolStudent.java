import java.io.Serializable;
import java.util.Comparator;

public class SchoolStudent {
    
    public static final 
        Comparator<SchoolStudent> BY_NAME = new ByNameComparator();
    public static final 
        Comparator<SchoolStudent> BY_ROLL_NUM = new ByRollNumComparator();
    public static final 
        Comparator<SchoolStudent> BY_STD = new BySTDComparator();
    public static final 
        Comparator<SchoolStudent> BY_SUBJECT = new BySubjectComparator();

    private SchoolStudent[] studentList = null;
    
    private String name;
    private int rollNumber;
    private int std;
    private String subject;    

    public SchoolStudent() {
        super();
    }
    
    public SchoolStudent(String n, int roll, int s, String sub) {
        super();
        this.name = n;
        this.rollNumber = roll;
        this.std = s;
        this.subject = sub;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int roll) {
        this.rollNumber = roll;
    }

    public int getStd() {
        return std;
    }

    public void setStd(int s) {
        this.std = s;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String sub) {
        this.subject = sub;
    }
    
    public SchoolStudent[] getStudentList() {
        return studentList;
    }

    public void setStudentList(SchoolStudent[] students) {
        studentList = students;
    }
    
    public static void sort(Object[] a, Comparator comparator) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && less(comparator, a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
    }
    
    private static boolean less(Comparator c, Object v, Object w) {
        return c.compare(v, w) < 0; 
    }
    
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    
    private static class ByNameComparator 
                    implements Comparator<SchoolStudent>, Serializable {
        @Override
        public int compare(SchoolStudent o1, SchoolStudent o2) {
            return o1.name.compareTo(o2.name);
        }
        
    }

    private static class BySTDComparator 
                    implements Comparator<SchoolStudent>, Serializable {
        @Override
        public int compare(SchoolStudent o1, SchoolStudent o2) {
            return o1.std - o2.std;
        }        
    }
    
    private static class ByRollNumComparator 
                    implements Comparator<SchoolStudent>, Serializable {
        @Override
        public int compare(SchoolStudent o1, SchoolStudent o2) {
            return o1.rollNumber - o2.rollNumber;
        }        
    }
    
    private static class BySubjectComparator 
                    implements Comparator<SchoolStudent>, Serializable {
        @Override
        public int compare(SchoolStudent o1, SchoolStudent o2) {
            return o1.subject.compareTo(o2.subject);
        }        
    }
    
    @Override
    public String toString() {
        return "SchoolStudent [name=" + name + ", rollNumber=" + rollNumber
                + ", std=" + std + ", subject=" + subject + "]";
    }
}
