import java.util.Scanner;
public class ScoreSort {
    static class Student{
        private String name;
        private int score;
        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int b = scanner.nextInt();
            Student[] students = new Student[n];
            for (int i = 0; i < n; i++) {
                students[i] = new Student(scanner.next(),scanner.nextInt());
            }
            if(b == 0){
                downSort(students);
            }else {
                upOrder(students,0,n - 1);
            }
            for (Student s: students) {
                System.out.println(s.name + " " + s.score);
            }
        }
    }
    public static void upOrder(Student[] students,int left,int right){
        if(left >= right){
            return;
        }
        int index = partition(students,left,right);
        upOrder(students,left,index - 1);
        upOrder(students,index +1,right);
    }

    private static int partition(Student[] students, int left, int right) {
        int baseVal = students[right].score;
        int i = left;
        int j = right;
        while (i <j){
            while (i <j && students[i].score <= baseVal){
                i++;
            }
            while (i <j && students[j].score >= baseVal){
                j--;
            }
            swap(students,i,j);
        }
        swap(students,i,right);
        return i;
    }

    private static void swap(Student[] students, int i, int j) {
        Student tmp = students[i];
        students[i] = students[j];
        students[j] = tmp;
    }

    public static void downSort(Student[] students){
        for (int i = 0; i < students.length; i++) {
            for(int j = students.length - 1; j >i; j--){
                if(students[j - 1].score < students[j].score){
                    Student tmp = students[j];
                    students[j] = students[j - 1];
                    students[j - 1] = tmp;
                }
            }
        }
    }
}
