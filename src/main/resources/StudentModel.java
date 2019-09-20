import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentModel {
	@Id
	private int id;
	private String name;
	private String phno;
	private int marks;

	public StudentModel(int id, String name, String phno, int marks) {
		super();
		this.id = id;
		this.name = name;
		this.phno = phno;
		this.marks = marks;

	}

	public StudentModel() {
		super();

	}

	@Override
	public String toString() {
		return "StudentModel [id=" + id + ", name=" + name + ", phno=" + phno + ", marks=" + marks + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

}