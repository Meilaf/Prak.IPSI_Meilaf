
import java.util.Vector;
import java.util.Enumeration;

public class Course {
    private String title;
    private Vector<CourseRecord> courseRecords;

    public Course() {
    courseRecords = new Vector<CourseRecord>();
}

public String getTitle() {
    return title;
}

    public void setTitle(String t) {
        title = t;
    }

    public void addCourseRecord(CourseRecord cr) {
        courseRecords.addElement(cr);
    }

    public Enumeration<CourseRecord> getCourseRecords() {
        return courseRecords.elements();
    }

    // Menampilkan semua mahasiswa
    public void printCourseStudents() {
        System.out.println("Daftar Mahasiswa: " + title);

        Enumeration<CourseRecord> records = getCourseRecords();

        while (records.hasMoreElements()) {
            CourseRecord cr = records.nextElement();

            if (cr.getStudent() != null) {
                System.out.println("- " + cr.getStudent().getName());
            }
        }
    }

    // Menampilkan mahasiswa dengan nilai rata-rata terbaik
    public void printBestStudent() {
        String bestName = "";
        double bestAverage = -1;

        Enumeration<CourseRecord> records = getCourseRecords();

        while (records.hasMoreElements()) {
            CourseRecord cr = records.nextElement();

            if (cr.getStudent() == null) {
                continue;
            }

            double total = 0;
            int count = 0;

            Enumeration<Assignment> assignments = cr.getAssignments();

            while (assignments.hasMoreElements()) {
                Assignment a = assignments.nextElement();

                try {
                    total += a.getMark();
                    count++;
                } catch (NotYetSetException e) {
                    // Nilai belum diisi, jadi dilewati
                }
            }

            if (count > 0) {
                double average = total / count;

                if (average > bestAverage) {
                    bestAverage = average;
                    bestName = cr.getStudent().getName();
                }
            }
        }

        if (bestName.isEmpty()) {
            System.out.println("Belum ada nilai mahasiswa.");
        } else {
            System.out.println("Mahasiswa terbaik: " + bestName);
            System.out.println("Nilai rata-rata: " + bestAverage);
        }
    }

    // Menampilkan mahasiswa yang layak mengikuti ujian akhir
    public void printFinalExamStudents() {
        System.out.println("Mahasiswa layak ujian akhir:");

        Enumeration<CourseRecord> records = getCourseRecords();
        boolean found = false;

        while (records.hasMoreElements()) {
            CourseRecord cr = records.nextElement();

            if (cr.getStudent() == null) {
                continue;
            }

            double total = 0;
            int count = 0;

            Enumeration<Assignment> assignments = cr.getAssignments();

            while (assignments.hasMoreElements()) {
                Assignment a = assignments.nextElement();

                try {
                    total += a.getMark();
                    count++;
                } catch (NotYetSetException e) {
                    // Nilai belum diisi, jadi dilewati
                }
            }

            if (count > 0) {
                double average = total / count;

                if (average >= 60) {
                    System.out.println(
                        "- " + cr.getStudent().getName()
                        + " (Rata-rata: " + average + ")"
                    );
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("Tidak ada mahasiswa yang memenuhi syarat.");
        }
    }
}
