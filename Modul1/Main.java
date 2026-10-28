
public class Main {
    public static void main(String[] args) {
        try {
            Student student1 = new Student();
            student1.setName("Andi");

            Student student2 = new Student();
            student2.setName("Siti");

    
            Assignment a1 = new Assignment();
            a1.setMark(85);

            Assignment a2 = new Assignment();
            a2.setMark(90);

            Assignment a3 = new Assignment();
            a3.setMark(75);

            CourseRecord cr1 = new CourseRecord();
            cr1.setStudent(student1);
            cr1.addAssignment(a1);
            cr1.addAssignment(a2);

            CourseRecord cr2 = new CourseRecord();
            cr2.setStudent(student2);
            cr2.addAssignment(a3);

 
            Course course = new Course();
            course.setTitle("Pemrograman Berorientasi Objek");
            course.addCourseRecord(cr1);
            course.addCourseRecord(cr2);

            // 5. Menguji method-method pada Course
            System.out.println("=== DAFTAR MAHASISWA ===");
            course.printCourseStudents();

            System.out.println("\n=== MAHASISWA TERBAIK ===");
            course.printBestStudent();

            System.out.println("\n=== MAHASISWA LAYAK UJIAN AKHIR ===");
            course.printFinalExamStudents();

        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
